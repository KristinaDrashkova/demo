package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Part;
import org.softuni.demo.models.binding.CreateAndShowPartBindingModel;
import org.softuni.demo.models.binding.EditPartBindingModel;
import org.softuni.demo.repositories.PartRepository;
import org.softuni.demo.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CreateAndShowPartBindingModel> getAll() {
        Type listType = new TypeToken<List<CreateAndShowPartBindingModel>>() {
        }.getType();

        return modelMapper.map(partRepository.findAll(), listType);
    }

    @Override
    public CreateAndShowPartBindingModel createPart(CreateAndShowPartBindingModel part) {
        Part partToSave = modelMapper.map(part, Part.class);
        partToSave.setQuantity(partToSave.getQuantity() == null ? 1 : partToSave.getQuantity());

        return modelMapper.map(partRepository.save(partToSave), CreateAndShowPartBindingModel.class);
    }

    @Override
    public EditPartBindingModel editPart(Long id, EditPartBindingModel part) {
        Part partToEdit = partRepository.findById(id);
        partToEdit.setPrice(part.getPrice() != null ? part.getPrice() : partToEdit.getPrice());
        partToEdit.setQuantity(part.getQuantity() != null ? part.getQuantity() : partToEdit.getQuantity());

        return modelMapper.map(partRepository.save(partToEdit), EditPartBindingModel.class);
    }

    @Override
    public CreateAndShowPartBindingModel getPartById(Long id) {
        return modelMapper.map(partRepository.findById(id), CreateAndShowPartBindingModel.class);
    }

    @Override
    public void deletePart(Long id) {
        Part part = partRepository.findById(id);
        partRepository.delete(part);
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }
}
