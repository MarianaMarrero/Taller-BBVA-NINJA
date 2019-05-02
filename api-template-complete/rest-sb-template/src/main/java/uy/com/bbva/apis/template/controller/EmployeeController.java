package uy.com.bbva.apis.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.model.Training;
import uy.com.bbva.services.template.service.EmployeeService;
import uy.com.bbva.services.template.service.TrainingService;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Value("${api.header.request-id}")
    private String requestId;

    @Value("${api.header.canal-id}")
    private String canalId;

    @Value("${api.header.user-id}")
    private String userId;

    @Autowired
    private LogUtils logger;

    @Autowired
    private TrainingService service;

    @GetMapping("/{employeeId}/belts")
    public String getBeltByEmployee(@PathVariable final Long employeeId, @RequestHeader("requestId") String requestId, @RequestHeader("channel") String channel, @RequestHeader("userId") String userId) throws ServiceException {

            return employeeService.getBeltEmployee(employeeId, requestId, channel, userId);

    }


    @GetMapping("{employeeId}/trainings")
    public List<Training> getTrainingsByEmployee(@PathVariable final long employeeId)
            throws ServiceException {

        logger.logDebug(this.getClass().getName(), "Call business service", "Internal message");

        return service.getTrainingsByEmployee(employeeId);
    }

}
