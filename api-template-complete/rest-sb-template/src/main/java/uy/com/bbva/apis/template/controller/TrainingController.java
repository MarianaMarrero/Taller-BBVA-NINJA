package uy.com.bbva.apis.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.model.Training;
import uy.com.bbva.services.template.service.TrainingService;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService service;

    @Autowired
    private LogUtils logger;


    @GetMapping()
    public List<Training> getAllTrainings(@RequestHeader("requestId") String requestId, @RequestHeader("channel") String channel, @RequestHeader("userId") String userId)
            throws ServiceException {

        return service.getAllTrainings(requestId,channel, userId);
    }

    @GetMapping("/employees/{employeeId}")
    public List<Training> getTrainingsByEmployee(@PathVariable final long employeeId)
            throws ServiceException {

        logger.logDebug(this.getClass().getName(), "Call business service", "Internal message");

        return service.getTrainingsByEmployee(employeeId);
    }

}
