package org.softuni.demo.services;

import org.softuni.demo.entities.Part;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface PartService {
    List<Part> getAll();

    boolean createPart();

    boolean editPart();
}
