package org.softuni.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kristina.drashkova
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "will_to_live")
    private Integer willToLive;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWillToLive() {
        return willToLive;
    }

    public void setWillToLive(Integer willToLive) {
        this.willToLive = willToLive;
    }

    @Override
    public String toString() {
        return String.format("[%s]. %s - [%d]", this.getId(), this.getName(), this.getWillToLive());
    }
}
