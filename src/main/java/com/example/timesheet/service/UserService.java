package com.example.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.model.User;
import com.example.timesheet.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	 private UserRepository jtm;
	 
	 public List<User> findAll() {

	       return jtm.findAll();
	    }
	    
	    public User saveUser (User User) {
	    	return jtm.save(User);
	    }
	    
	    public User getUser (Long id) {
	    	Optional<User> User = jtm.findById(id);
	    	if (User.isPresent()) return User.get();
	    	
	    	else return null;
	    }
	    
	    public User updateUser (User _User, Long id) {
	    	Optional<User> User = jtm.findById(id);
	    	if (User.isPresent()) {
	    		User.get().setName(_User.getName());
	    		
	    		User updateUser = jtm.save(User.get());
	    		return updateUser;
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public boolean deleteUser (Long id) {
	    	Optional<User> User = jtm.findById(id);
	    	
	    	if (User.isPresent()) {
	    		jtm.delete(User.get());
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
}
