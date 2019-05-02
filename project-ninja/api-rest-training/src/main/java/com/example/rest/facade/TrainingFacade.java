package com.example.rest.facade;

import com.example.rest.dto.TrainingDTO;
import java.util.List;

public interface TrainingFacade {

    List<TrainingDTO> getTrainings();
}
