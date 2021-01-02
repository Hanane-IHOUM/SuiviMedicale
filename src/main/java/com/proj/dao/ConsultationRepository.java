package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.Consultation;


public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
