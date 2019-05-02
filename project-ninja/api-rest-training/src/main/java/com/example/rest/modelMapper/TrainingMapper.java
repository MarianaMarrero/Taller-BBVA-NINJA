package com.example.rest.modelMapper;

import com.example.rest.dao.entity.Training;
import com.example.rest.dto.TrainingDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainingMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public List<TrainingDTO> convertAllTrainingEntityToDTO(final List<Training> trainings) {
        final java.lang.reflect.Type targetListType = new TypeToken<List<TrainingDTO>>() {
        }.getType();
        return modelMapper.map(trainings, targetListType);
    }

}
