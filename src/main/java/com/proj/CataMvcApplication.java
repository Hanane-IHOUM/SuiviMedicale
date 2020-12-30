package com.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.proj.dao.PatientRepository;
import com.proj.entities.Patient;

@SpringBootApplication
public class CataMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvcApplication.class, args);
		
		//PatientRepository patientRepository = ctx.getBean(PatientRepository.class);
		
		/*patientRepository.save(new Patient("IHOUM","Hanane","JB500021","O+"));
		patientRepository.save(new Patient("TOURI","Amine","AA505675","A-"));
		patientRepository.save(new Patient("ELGOURCH","Mouna","GY578095","AB+"));
		patientRepository.save(new Patient("ELBARG","Laila","BX589486","B+"));*/
	}

}
