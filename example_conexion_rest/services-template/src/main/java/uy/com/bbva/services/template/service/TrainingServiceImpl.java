
package uy.com.bbva.services.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.connection.ConnectionApiRest;
import uy.com.bbva.services.template.model.Training;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private ConnectionApiRest connectionApiRestTraining;

    @Override
    public List<Training> getAllTrainings(final String requestId, final String channel, final String userId) throws ServiceException {

        return connectionApiRestTraining.getAllTraining(requestId, channel, userId);
    }
}
