package com.application.SurveySystem.RestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.application.SurveySystem.Model.Output;
import com.application.SurveySystem.Model.Requests;
import com.application.SurveySystem.Service.RequestService;
import com.application.SurveySystem.Service.UserService;

@RestController
public class RequestController {
	static Output output = new Output();
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RequestService requestservice;
	
	@PostMapping(path= "/isAuthenticatedUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> isAuthenticated(@RequestHeader("x-auth-token") String token) {
		
		boolean authenticatedUser = userservice.authToken(token);
		
		output.setError(false);
		output.setMessage("success");
		output.setData(authenticatedUser);
		
		return new ResponseEntity<Output>(output, HttpStatus.OK);
    }
	
	@PostMapping(path= "/addResponse", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveResponse(@RequestBody Requests request, @RequestHeader("x-auth-token") String token) {
		
		System.out.println(request);
		boolean authenticatedUser = userservice.authToken(token);
		
		if(!authenticatedUser) {
			output.setError(true);
			output.setMessage("Not success");
			output.setData(HttpStatus.UNAUTHORIZED);
		}
		
		boolean answer = requestservice.addRequest(request, token);
		output.setError(false);
		output.setMessage("success");
		output.setData(answer);
		
		return new ResponseEntity<Output>(output, HttpStatus.OK);
    }
	
	@GetMapping("/getallRequests")
    public ResponseEntity<?> getUsers() {
		List<Requests> user1 = requestservice.getAllRequests();
		return new ResponseEntity<List>(user1, HttpStatus.OK);
    }
}
