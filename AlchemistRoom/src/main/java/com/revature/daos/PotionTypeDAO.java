package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.PotionType;


@Repository //We want this Interface to be a Spring Bean
public interface PotionTypeDAO extends JpaRepository<PotionType, Integer>{

	
	
}