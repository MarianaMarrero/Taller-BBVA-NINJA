package uy.com.bbva.services.template.service;

import uy.com.bbva.services.commons.exceptions.ServiceException;

import java.util.Map;

public interface BeltService {
    Map<Long, String> getBelts() throws ServiceException;
}
