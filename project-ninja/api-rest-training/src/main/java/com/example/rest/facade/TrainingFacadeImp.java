package com.example.rest.facade;
import com.example.rest.dao.entity.Training;
import com.example.rest.dto.TrainingDTO;
import com.example.rest.modelMapper.TrainingMapper;
import com.example.rest.service.TrainingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TrainingFacadeImp implements TrainingFacade {

    @Resource
    private TrainingService trainingService;

    @Resource
    private TrainingMapper trainingMapper;


    @Override
    public List<TrainingDTO> getTrainings(){

        final List<Training> trainings = trainingService.getTraining();

        return trainingMapper.convertAllTrainingEntityToDTO(trainings);
    }





}
