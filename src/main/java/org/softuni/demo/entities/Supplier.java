package org.softuni.demo.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;

    @Column(name = "is_imported")
    private Boolean isImported;

    @OneToMany(mappedBy = "supplierId")
    private Set<Part> parts;

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImported() {
        return isImported;
    }

    public void setImported(Boolean imported) {
        isImported = imported;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
