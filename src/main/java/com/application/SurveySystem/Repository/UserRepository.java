package com.application.SurveySystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.SurveySystem.Model.Token;
import com.application.SurveySystem.Model.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{

	public Optional<Users> findById(String id);
	
//	public Users findByToken(Token token);
}
