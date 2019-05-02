package uy.com.bbva.services.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.com.bbva.services.commons.exceptions.BusinessException;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.connection.ConnectionApiSoap;
import uy.com.bbva.services.template.dao.EmployeeDAO;
import uy.com.bbva.services.template.model.Employee;
import uy.com.bbva.services.template.model.Training;

import java.util.*;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private BeltService beltService;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ConnectionApiSoap connectionApiSoap;

    @Autowired
    private LogUtils logger;

    @Override
    public String getBeltEmployee(final Long id, final String requestId, final String channel,
            final String userId) throws ServiceException {

        Employee employee = findEmployee(id);

        if (employee.getId() == null) {

            throw new BusinessException("No existe el empleado",
                    "No existe el empleado con el id ingresado", "404",
                    new NoSuchElementException());

        } else {
            /************************** Connection database *****************************/
            final List<Training> trainingsByEmployee = trainingService.getTrainingsByEmployee(id);

            /*************************** Connection a Api Rest ***************************/
            final Long pointsByEmployee = getTrainingPointsByEmployee(trainingsByEmployee,
                    requestId, channel, userId);

            /*************************** Connection a Api Soap ***************************/
            final String nameBelt = getNameBeltToEmployee(beltService.getBelts(), pointsByEmployee);

            return "Los puntos del empleado " + id + " son: " + pointsByEmployee
                    + ". Eres cinturon: " + nameBelt + "!!!";

        }
    }


    private Long getTrainingPointsByEmployee(final List<Training> trainingsByEmployee,
            final String requestId, final String channel, final String userId) throws ServiceException {

        final List<Training> allTraining = trainingService.getAllTrainings(requestId, channel,
                userId);
        Long count = Long.valueOf(0);

        for (final Training trainingByEmployee : trainingsByEmployee) {
            for (final Training training : allTraining) {
                if (trainingByEmployee.getName().equals(training.getName())) {
                    count = count + training.getPoints();
                }
            }
        }
        return count;
    }



    private String getNameBeltToEmployee(final Map treeMap, final Long pointsEmployee) {
        final Map mapBelt = treeMap;
        final Iterator iterator = mapBelt.keySet().iterator();
        String belt = "";
        while (iterator.hasNext()) {
            final Object key = iterator.next();
            if (pointsEmployee.compareTo((Long) key) == 0
                    || pointsEmployee.compareTo((Long) key) == 1) {
                belt = (String) treeMap.get(key);
            }
        }
        return belt;
    }

    private Employee findEmployee(final Long employeeId) throws ServiceException {
        final Employee employee = employeeDAO.findEmployeeById(employeeId);
        return employee;
    }

}
