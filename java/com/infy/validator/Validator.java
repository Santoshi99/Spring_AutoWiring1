package com.infy.validator;


import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;


public class Validator {

	public static void validate(TraineeDTO trainee) throws InfyDASystemException {
	      
		if(!validateTraineePhoneNo(trainee.getPhoneNo())) {
			throw new InfyDASystemException("Validator.INVALID_DETAILS");
		}
           
	}

	public static Boolean validateTraineePhoneNo(String phoneNo) throws InfyDASystemException {
		
		String regex = "[789](\\d+){9}";
		if(phoneNo.matches(regex)) {
			return true;
		}
		return false;
	}
}

