package com.infy.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.infy.configuration.SpringConfig;
import com.infy.dto.DesktopDTO;
import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;
import com.infy.service.InfyDASystemServiceImpl;

public class UserInterface {
	
	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 

		public static void main(String[] args) throws Exception {
			addNewTrainee();
			//getAllocationDetails();
		
		}

		public static void addNewTrainee() throws Exception{
			Environment environment=null;
			ApplicationContext applicationContext =null;
			try{
				applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
				environment=applicationContext.getEnvironment();
				InfyDASystemServiceImpl infyDASystemServiceImpl=applicationContext.getBean(InfyDASystemServiceImpl.class);
				TraineeDTO trainee=new TraineeDTO();
				trainee.setId(1008);
				trainee.setName("Aaditya");
				trainee.setPhoneNo("90405");
				DesktopDTO desktop=new DesktopDTO();
				desktop.setMachineName("MYSGEC1111112D");
				desktop.setMake("Dell");
				trainee.setDesktop(desktop);
				Integer data=infyDASystemServiceImpl.addNewTrainee(trainee);
				LOGGER.info(environment.getProperty("UserInterface.TRAINEE_ADDED_SUCCESS")+data);
			}catch(InfyDASystemException exception){
				LOGGER.error(environment.getProperty(exception.getMessage()));
			}

		}

		public static void getAllocationDetails() throws Exception{
			Environment environment=null;
			ApplicationContext applicationContext =null;
			try{
				applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
				environment=applicationContext.getEnvironment();
				InfyDASystemServiceImpl infyDASystemServiceImpl=applicationContext.getBean(InfyDASystemServiceImpl.class);
				TraineeDTO trainee1=infyDASystemServiceImpl.getAllocationDetails(1001);
				if(trainee1!=null){
					LOGGER.info(trainee1);
				}
	
			}catch(InfyDASystemException exception){
				LOGGER.error(environment.getProperty(exception.getMessage()));
			}
		}

	}
