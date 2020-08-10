package com.application.SurveySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.SurveySystem.Model.Token;
import com.application.SurveySystem.Model.Users;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
	public Token findByUser(Users user);
	public Token findByToken(String token);
}
