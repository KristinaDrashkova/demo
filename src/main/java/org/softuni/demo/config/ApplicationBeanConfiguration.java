package org.softuni.demo.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.softuni.demo.entities.Customer;
import org.softuni.demo.entities.Sale;
import org.softuni.demo.entities.Supplier;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.models.binding.ShowSupplierBindingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        modelMapper.createTypeMap(Customer.class, ShowCustomerByIdBindingModel.class).setConverter(customerConverter);

        return modelMapper;
    }

}
