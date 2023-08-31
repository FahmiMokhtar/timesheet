package com.example.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.timesheet.exception.ResourceNotFoundException;
import com.example.timesheet.model.Status;
import com.example.timesheet.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@GetMapping
	public Iterable findAll() {
		return statusService.findAll();
	}
	
	@GetMapping("/{id}")
	public Status getStatusById(@PathVariable(value = "id") Long statusId) {
		Status status = statusService.getStatus(statusId);
		if (status != null) return status;
		else throw(new ResourceNotFoundException("Status", "id", statusId));
	}
	
}
