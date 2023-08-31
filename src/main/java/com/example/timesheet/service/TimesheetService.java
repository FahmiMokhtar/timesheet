package com.example.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.TimesheetInfo;
import com.example.timesheet.repository.StatusRepository;
import com.example.timesheet.repository.TimesheetRepository;
import com.example.timesheet.repository.UserRepository;

@Service
public class TimesheetService {
	
	@Autowired
	private TimesheetRepository jtm;
	
	@Autowired
	private UserRepository utm;
	
	@Autowired
	private StatusRepository stm;
	
	public List<Timesheet> findAll() {

		return jtm.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<TimesheetInfo> findAllTask(String keyword){
		List<TimesheetInfo> timesheetList = jtm.findAllTask(keyword);
		
		return timesheetList;
	}
	
	public Timesheet saveTimesheet(Timesheet _timesheet) {
		Optional<Timesheet> timesheet = utm.findById(_timesheet.getUserid()).map(user -> {
			_timesheet.setUser(user);
			Optional<Timesheet> __timesheet = stm.findById(_timesheet.getStatusid()).map(status -> {
				_timesheet.setStatus(status);
				return _timesheet;
			});
			if (__timesheet.isPresent()) 
				return jtm.save(__timesheet.get());
			else
				return jtm.save(_timesheet);
		});
		
		if (timesheet.isPresent()) {
			return timesheet.get();
		}
		else return null;
	}
	
	public Timesheet updateTimesheet(Timesheet _timesheet, Long timesheetId) {
		Optional<Timesheet> timesheet = jtm.findById(timesheetId);
		if (timesheet.isPresent()) {
			return saveTimesheet(_timesheet);
		} 
		else return null;
	}
	
	public Timesheet getTimesheet (Long id) {
    	Optional<Timesheet> timesheet = jtm.findById(id);
    	if (timesheet.isPresent()) {
    		Timesheet z = timesheet.get();
    		z.setUserid(z.getUser().getId());
    		z.setStatusid(z.getStatus().getId());
    		
    		return z;
    	}
    	
    	else return null;
    }
	
	public boolean deleteTimesheet (Long id) {
    	Optional<Timesheet> timesheet = jtm.findById(id);
    	
    	if (timesheet.isPresent()) {
    		jtm.delete(timesheet.get());
    		return true;
    	} else {
    		return false;
    	}
    }

}
