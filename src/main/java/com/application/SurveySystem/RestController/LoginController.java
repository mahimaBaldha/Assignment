package com.application.SurveySystem.RestController;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.SurveySystem.Model.Output;
import com.application.SurveySystem.Model.Token;
import com.application.SurveySystem.Model.Users;
import com.application.SurveySystem.Repository.UserRepository;
import com.application.SurveySystem.Service.UserService;

@EnableAutoConfiguration
@RestController
public class LoginController {
	static Output op = new Output();
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/getallUsers")
    public ResponseEntity<?> getAllUsers() {
		List<Users> user1 = userservice.getAllUsers();
		return new ResponseEntity<List>(user1, HttpStatus.OK);
    }
	
	@PostMapping(path= "/addUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postUsers(@RequestBody Users user) {
		
		Users savedUser = userservice.addUser(user);
		return new ResponseEntity<Users>(savedUser, HttpStatus.OK);
    }
	
	@GetMapping("/")
    public ResponseEntity<?> getUsers() {
		List<Users> user1 = userservice.getAllUsers();
		return new ResponseEntity<List>(user1, HttpStatus.OK);
    }
	
	
//	@GetMapping(path="/auth")
//	public boolean authh(@RequestHeader("x-auth-token") String token,HttpServletRequest request) {
//		return userservice.authToken(token);
//	}
	
	@PostMapping(path= "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> loginPage(@RequestBody Users user,HttpServletRequest request) {
		
		Optional<Users> user1 = userrepository.findById(user.getId());
		
		if(!user1.isPresent()) {
			op.setError(true);
			op.setMessage("not success");
			op.setData("User doesn't exist");
			return new ResponseEntity<Output>(op, HttpStatus.NOT_FOUND);
		}
		
		if (! user.getPassword().equals(user1.get().getPassword())) {
			op.setError(true);
			op.setMessage("not success");
			op.setData("Invalid password");
			return new ResponseEntity<Output>(op, HttpStatus.NOT_FOUND);
		}
		Token token = userservice.getToken(user1.get());
		
		op.setError(false);
		op.setMessage("success");
		op.setData(token);
		return new ResponseEntity<Output>(op, HttpStatus.OK);
		
	}
}
 