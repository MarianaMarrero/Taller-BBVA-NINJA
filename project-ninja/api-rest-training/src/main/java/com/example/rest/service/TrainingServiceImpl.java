package com.example.rest.service;

import com.example.rest.dao.TrainingDAO;
import com.example.rest.dao.entity.Training;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService{

    @Resource
    private TrainingDAO trainingDAO;

    @Override
    public List<Training> getTraining(){

         return trainingDAO.getTraining();

    }

}
