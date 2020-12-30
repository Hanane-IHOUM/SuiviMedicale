package com.proj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query("select p from Patient p where p.cin like :x")
	public List<Patient> chercher(@Param("x")String mc);
}
