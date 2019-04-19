package org.softuni.demo.services;

import org.softuni.demo.models.binding.CreateAndShowPartBindingModel;
import org.softuni.demo.models.binding.EditPartBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface PartService {
    List<CreateAndShowPartBindingModel> getAll();

    CreateAndShowPartBindingModel createPart(CreateAndShowPartBindingModel part);

    EditPartBindingModel editPart(Long id, EditPartBindingModel part);

    CreateAndShowPartBindingModel getPartById(Long id);

    void deletePart(Long id);

    boolean exists(Long id);
}
