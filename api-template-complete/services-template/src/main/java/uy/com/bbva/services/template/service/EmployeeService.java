package uy.com.bbva.services.template.service;

import uy.com.bbva.services.commons.exceptions.ServiceException;


public interface EmployeeService {


    String getBeltEmployee(final Long id, final String requestId, final String channel, final String userId) throws ServiceException;
}
