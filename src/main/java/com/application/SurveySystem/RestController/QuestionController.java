package com.application.SurveySystem.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.SurveySystem.Model.Users;
import com.application.SurveySystem.Repository.UserRepository;

@RestController
public class QuestionController {

	@Autowired
	private UserRepository userrepository;
	
	
	@PostMapping(path= "/askQuestion/{questionurl}", consumes = "application/json", produces = "application/json")
    public ResponseEntity postUsers(@PathVariable("questionurl") String questionurl) {
		
		
//		Users savedUser = userservice.saveUser(user);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
