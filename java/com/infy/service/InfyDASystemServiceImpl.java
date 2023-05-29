package com.infy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;
import com.infy.repository.InfyDASystemRepository;
import com.infy.validator.Validator;


@Service(value = "infyDASystemService")
public class InfyDASystemServiceImpl implements InfyDASystemService {

	@Autowired
	private InfyDASystemRepository  infyDARepository;
	
	public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException {
		TraineeDTO trainee;
		try {
			trainee =	infyDARepository.getAllocationDetails(traineeId);
			if(trainee ==null) {
				throw new InfyDASystemException("Service.NO_DETAILS_FOUND");
			}
		}
		catch(InfyDASystemException e) {
			LogFactory.getLog(this.getClass()).error(e);
			throw e;
		}
		
		return trainee;
	}

	public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException {
		Integer newtrainee;
		try {
	    Validator.validate(trainee);
	    newtrainee = infyDARepository.addNewTrainee(trainee);
		}
		catch(InfyDASystemException e) {
			Log LOGGER = LogFactory.getLog(this.getClass());
			LOGGER.error(e.getMessage(),e);
			throw e;
		}
		
		
		return newtrainee;
	}

	
}
