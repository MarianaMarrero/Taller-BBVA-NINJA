package uy.com.bbva.services.template.service;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Training;
import java.util.List;

public interface TrainingService {

    List<Training> getTrainingsByEmployee(final Long id) throws ServiceException;
}