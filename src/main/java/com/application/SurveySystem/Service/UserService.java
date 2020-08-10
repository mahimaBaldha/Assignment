package com.application.SurveySystem.Service;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.SurveySystem.Model.Requests;
import com.application.SurveySystem.Model.Token;
import com.application.SurveySystem.Model.Users;
import com.application.SurveySystem.Repository.TokenRepository;
import com.application.SurveySystem.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private TokenRepository tokenrepository;
	
	public Users saveUser(Users user) {
		List<Users> allUsers =  userrepository.findAll();
		
		if(! allUsers.contains(user)) {
			return userrepository.save(user);
		}
		return user;
	}
	
	public Token setToken(Users user) {
		return tokenrepository.save(new Token(user));
	}
	
	public Token getToken(Users user) {
		Token token = tokenrepository.findByUser(user);
		return token;
	}
	
	public boolean authToken(String requestTokenHeader) {
		if(requestTokenHeader.contains("Bearer ")) {
			requestTokenHeader = requestTokenHeader.replace("Bearer ", "");
		}
		Token token = tokenrepository.findByToken(requestTokenHeader);
		if(token == null)
			return false;
		return true;
	}

	public List<Users> getAllUsers() {
		return userrepository.findAll();
	}

	
	
}
