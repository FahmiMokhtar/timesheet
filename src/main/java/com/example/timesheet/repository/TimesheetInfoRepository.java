package com.example.timesheet.repository;

import java.util.List;

import com.example.timesheet.model.TimesheetInfo;

public interface TimesheetInfoRepository {
	
	List<TimesheetInfo> findAllTask(String keyword);

}
