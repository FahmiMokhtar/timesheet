package com.example.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.model.Timesheet;

public interface TimesheetRepository extends JpaRepository <Timesheet, Long>, TimesheetInfoRepository {

}
