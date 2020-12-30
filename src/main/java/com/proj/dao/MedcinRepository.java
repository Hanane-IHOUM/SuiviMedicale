package com.proj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entities.Medcin;

public interface MedcinRepository extends JpaRepository<Medcin, Long>{

	@Query("select m from Medcin m where m.cin like :x")
	public List<Medcin> chercher(@Param("x")String mc);
}
