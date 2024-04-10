package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.login.Dao.LoginDao;
import com.login.model.Login;

@Service
public class LoginServiceImp implements LoginServiceinf {
	
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<Login> LoginInfo() {
		// TODO Auto-generated method stub
		return loginDao.findAll();
	}

	@Override
	public Optional<Login> getCustomer(long CustomerId) {
		// TODO Auto-generated method stub
		Optional<Login>entity2=loginDao.findById(CustomerId);
		return entity2;
	}

	@Override
	public Login addCustomer(Login login) {
loginDao.save(login);
		
		return login;
	}

	@Override
	public Login updateCustomer(Login login, long Id) {
		// TODO Auto-generated method stub
		Login entity1=loginDao.findById(Id)
				.orElseThrow();
		
		
			
		entity1.setEmail(login.getEmail());
		entity1.setPassword(login.getPassword());
		entity1.setFirstName(login.getFirstName());
		entity1.setLastName(login.getLastName());
		
		entity1.setPhoneNumber(login.getPhoneNumber());
		
		
		return loginDao.save(entity1);
	}

	@Override
	public void deleteLogin(long customerId) {
		// TODO Auto-generated method stub
		Login entity1=loginDao.getReferenceById(customerId);
		loginDao.delete(entity1);
		
	}

	@Override
	public boolean verifyLoginDetails(String email, String password) {
	    Optional<Login> optionalLogin = loginDao.findByEmail(email);
	    if (optionalLogin.isPresent()) {
	        Login login = optionalLogin.get();
	        // Here you would typically use a secure password hashing algorithm and compare
	        // the hashed password stored in the database with the hashed password provided
	        // by the user. For simplicity, we're assuming plain text passwords for demonstration.
	        return login.getPassword().equals(password);
	    }
	    return false;
	}

}
