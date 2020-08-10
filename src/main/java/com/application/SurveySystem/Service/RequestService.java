package com.application.SurveySystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.SurveySystem.Model.Requests;
import com.application.SurveySystem.Model.Token;
import com.application.SurveySystem.Model.Users;
import com.application.SurveySystem.Repository.RequestRepository;
import com.application.SurveySystem.Repository.TokenRepository;
import com.application.SurveySystem.Repository.UserRepository;

@Service
public class RequestService {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private TokenRepository tokenrepository;
	
	@Autowired
	private RequestRepository requestrepository;
	
	@Autowired
	private UserService userservice;
	
	
//	public boolean addQuestion(Requests request, String token) {
//		boolean authenticatedUser = userservice.authToken(token);
//		
//		if(authenticatedUser) {
//			Token tokenObject = tokenrepository.findByToken(token);
//			Users user = userrepository.findByToken(tokenObject);
//			Requests req = new Requests(user, request.getQuestion(), request.getAnswer());
//			requestrepository.save(req);
//			return true;
//		}
//		return false;
//	}
}