package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Potion;

@Repository
public interface PotionDAO extends JpaRepository<Potion, Integer>{

}
