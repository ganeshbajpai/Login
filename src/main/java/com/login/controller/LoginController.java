package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.login.model.Login;
import com.login.service.LoginServiceinf;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	LoginServiceinf logininf;
	
	@GetMapping("/loginDetails")
	public List<Login> getLoginInfo(){
		return logininf.LoginInfo();
		
		}
	@PostMapping("/addLoginDetails")
	public Login addCustomer(@RequestBody Login login){
		
		return logininf.addCustomer(login);
	}
	
	@PostMapping("/verifyLoginDetails")
    public ResponseEntity<String> verifyLogin(@RequestBody Login login) {
        boolean verified =  logininf.verifyLoginDetails(login.getEmail(), login.getPassword());
        if (verified) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
	
	
	
}
