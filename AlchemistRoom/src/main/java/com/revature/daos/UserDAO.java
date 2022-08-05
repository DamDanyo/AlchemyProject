package com.revature.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.AlchemistUser;

@Repository
public interface UserDAO extends JpaRepository<AlchemistUser, Integer> {
	
	

	public Optional<AlchemistUser> findByUsernameAndPassword(String username, String password);
	
}
