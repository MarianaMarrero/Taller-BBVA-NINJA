package uy.com.bbva.apis.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Training;
import uy.com.bbva.services.template.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService service;


/****************************************************************************/
    /*******************  Ejemplo conexión al servicio REST*********************/
    @GetMapping()
    public List<Training> getAllTrainings(@RequestHeader("requestId") String   requestId, @RequestHeader("channel") String channel, @RequestHeader("userId") String userId)
            throws ServiceException {

        return service.getAllTrainings(requestId, channel, userId);
    }

}
