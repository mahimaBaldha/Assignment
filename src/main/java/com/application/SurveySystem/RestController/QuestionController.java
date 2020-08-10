package com.application.SurveySystem.RestController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.application.SurveySystem.Model.Output;
import com.application.SurveySystem.Model.Requests;
import com.application.SurveySystem.Model.Users;
import com.application.SurveySystem.Repository.UserRepository;
import com.application.SurveySystem.Service.RequestService;
import com.application.SurveySystem.Service.UserService;

@RestController
public class QuestionController {
	static Output op = new Output();

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RequestService requestservice;
	
	@PostMapping(path= "/isAuthenticatedUser/{questionurl}", consumes = "application/json", produces = "application/json")
    public ResponseEntity isAuthenticated(@PathVariable("questionurl") String questionurl, @RequestHeader("x-auth-token") String token) {
		
		boolean authenticatedUser = userservice.authToken(token);
		
		if(!authenticatedUser) {
			op.setError(false);
			op.setMessage("success");
			op.setData(false);
		}
		op.setError(false);
		op.setMessage("success");
		op.setData(true);
		
		return new ResponseEntity<Output>(op, HttpStatus.OK);
    }
	
//	@PostMapping(path= "/addResponse", consumes = "application/json", produces = "application/json")
//    public ResponseEntity saveResponse(@RequestBody Requests request, @RequestHeader("x-auth-token") String token) {
//		
//		boolean authenticatedUser = userservice.authToken(token);
//		
//		if(!authenticatedUser) {
//			op.setError(true);
//			op.setMessage("Not success");
//			op.setData(HttpStatus.UNAUTHORIZED);
//		}
//		
//		boolean answer = requestservice.addQuestion(request, token);
//		op.setError(false);
//		op.setMessage("success");
//		op.setData(answer);
//		
//		return new ResponseEntity<Output>(op, HttpStatus.OK);
//    }
	
}
