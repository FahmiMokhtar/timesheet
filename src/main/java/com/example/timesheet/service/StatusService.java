package com.example.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.model.Status;
import com.example.timesheet.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	 private StatusRepository jtm;
	
	public List<Status> findAll() {

	       return jtm.findAll();
	    }
	    
	    public Status saveStatus (Status Status) {
	    	return jtm.save(Status);
	    }
	    
	    public Status getStatus (Long id) {
	    	Optional<Status> Status = jtm.findById(id);
	    	if (Status.isPresent()) return Status.get();
	    	
	    	else return null;
	    }
	    
	    public Status updateStatus (Status _Status, Long id) {
	    	Optional<Status> Status = jtm.findById(id);
	    	if (Status.isPresent()) {
	    		Status.get().setDescription(_Status.getDescription());
	    		
	    		Status updateStatus = jtm.save(Status.get());
	    		return updateStatus;
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public boolean deleteStatus (Long id) {
	    	Optional<Status> Status = jtm.findById(id);
	    	
	    	if (Status.isPresent()) {
	    		jtm.delete(Status.get());
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	
}
