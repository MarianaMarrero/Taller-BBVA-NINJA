package com.example.rest.controller;

import com.example.rest.dto.TrainingDTO;
import com.example.rest.facade.TrainingFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/trainings")
public class TrainingController {

    @Resource
    private TrainingFacade trainingFacade;

    @GetMapping
    public List<TrainingDTO> getTrainings(){

        return trainingFacade.getTrainings();

    }
}
