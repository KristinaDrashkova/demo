package org.softuni.demo.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.softuni.demo.entities.Car;
import org.softuni.demo.entities.Customer;
import org.softuni.demo.entities.Part;
import org.softuni.demo.entities.Sale;
import org.softuni.demo.entities.Supplier;
import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.models.binding.ShowSupplierBindingModel;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.stream.Collectors;

/**
 * @author kristina.drashkova
 */
@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PropertyMap<Supplier, ShowSupplierBindingModel> supplierMap = new PropertyMap<Supplier, ShowSupplierBindingModel>() {
            protected void configure() {
                map().setParts(source.getParts().size());
            }
        };

        modelMapper.addMappings(supplierMap);

        Converter<Customer, ShowCustomerByIdBindingModel> customerConverter = context -> {
            ShowCustomerByIdBindingModel customer = new ShowCustomerByIdBindingModel();
            customer.setName(context.getSource().getName());
            customer.setCarsBought((long) context.getSource().getSales().size());
            customer.setTotalMoneySpent(context.getSource().getSales().stream().mapToDouble(Sale::getDiscount).sum());

            return customer;
        };

        Converter<Car, CreateAndShowCarBindingModel> carConverter = context -> {
            CreateAndShowCarBindingModel car = new CreateAndShowCarBindingModel();
            car.setMake(context.getSource().getMake());
            car.setModel(context.getSource().getModel());
            car.setTravelledDistance(context.getSource().getTravelledDistance());
            car.setParts(context.getSource().getParts().stream().mapToLong(Part::getId).boxed().collect(Collectors.toSet()));

            return car;
        };

        modelMapper.createTypeMap(Customer.class, ShowCustomerByIdBindingModel.class).setConverter(customerConverter);
        modelMapper.createTypeMap(Car.class, CreateAndShowCarBindingModel.class).setConverter(carConverter);

        return modelMapper;
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/carDb?createDatabaseIfNotExist=true&useSSL=false");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("1234");
        return dataSourceBuilder.build();
    }
}
