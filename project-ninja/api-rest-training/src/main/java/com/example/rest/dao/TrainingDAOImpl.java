package com.example.rest.dao;

import com.example.rest.dao.entity.Training;
import com.example.rest.dao.repository.TrainingRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TrainingDAOImpl implements TrainingDAO {

    @Resource
    private TrainingRepository trainingRepository;

    @Override
    public List<Training> getTraining(){

        return trainingRepository.findAll();
    }

}
