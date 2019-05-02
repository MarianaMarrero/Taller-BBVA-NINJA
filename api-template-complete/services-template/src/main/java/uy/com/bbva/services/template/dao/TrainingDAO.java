package uy.com.bbva.services.template.dao;


import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Training;
import java.util.List;

public interface TrainingDAO {
    List<Training> getTrainingsByEmployee(final Long id) throws ServiceException;
}
