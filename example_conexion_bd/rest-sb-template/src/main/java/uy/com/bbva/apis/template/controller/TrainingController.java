package uy.com.bbva.apis.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.model.Training;
import uy.com.bbva.services.template.service.TrainingService;
import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService service;

    @Autowired
    private LogUtils logger;

    /*********************Ejemplo conexión a base de datos *********************/
    @GetMapping("employees/{employeeId}")
    public List<Training> getTrainingsByEmployee(@PathVariable final long employeeId)
            throws ServiceException {

/*****************Ejemplo para utilizar logDebug****************************/
        logger.logDebug(this.getClass().getName(), "Call business service", "Internal message");
        return service.getTrainingsByEmployee(employeeId);
    }
}
