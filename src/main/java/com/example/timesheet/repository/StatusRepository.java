package com.example.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.model.Status;

public interface StatusRepository extends JpaRepository <Status, Long> {

}
