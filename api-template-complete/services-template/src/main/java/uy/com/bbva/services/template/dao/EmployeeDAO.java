package uy.com.bbva.services.template.dao;

import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Employee;

import java.util.Optional;

public interface EmployeeDAO {

    Employee findEmployeeById(final Long id) throws ServiceException;
}
