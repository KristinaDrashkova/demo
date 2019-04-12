package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowSupplierBindingModel {
    private Long id;

    private String name;

    private Integer parts;

    public ShowSupplierBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParts() {
        return parts;
    }

    public void setParts(Integer parts) {
        this.parts = parts;
    }
}
