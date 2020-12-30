package com.proj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entities.Consultation;


public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

		

	//@Query("select c from Consultation c where c.patient_id like :x")
	//public List<Consultation> chercher(@Param("x")String idPatient);

}
