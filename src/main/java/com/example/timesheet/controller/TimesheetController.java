package com.example.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.timesheet.exception.ResourceNotFoundException;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.service.TimesheetService;

@RestController
@RequestMapping("/api/timesheet")
public class TimesheetController {

	@Autowired
	private TimesheetService timesheetService;
	
	@GetMapping
	public Iterable findAll() {
		return timesheetService.findAll();
	}
	
	@GetMapping("/searchtask")
	public Iterable findTask(@RequestParam String keyword) {
		return timesheetService.findAllTask(keyword);
	}
	
	
	@GetMapping("/{id}")
	public Timesheet getTimesheetById(@PathVariable(value = "id") Long timesheetId) {
		Timesheet timesheet = timesheetService.getTimesheet(timesheetId);
		if (timesheet != null) return timesheet;
		else throw(new ResourceNotFoundException("Timesheet", "id", timesheetId));
	}
	
    @PostMapping
    public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
		return timesheetService.saveTimesheet(timesheet);
	}
    
    @PutMapping("/{id}")
	public Timesheet updateTimesheet(@PathVariable(value = "id") Long id, @RequestBody Timesheet timesheetDetail) {
    	Timesheet timesheet = timesheetService.updateTimesheet(timesheetDetail, id);
    	if (timesheet != null) return timesheet;
    	else throw(new ResourceNotFoundException("Timesheet", "id", id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimesheet(@PathVariable(value = "id") Long timesheetId) {
    	if (timesheetService.deleteTimesheet(timesheetId)) return ResponseEntity.ok().build();
    	else throw(new ResourceNotFoundException("Timesheet", "id", timesheetId));
    }
	
}
