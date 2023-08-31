package com.example.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.model.User;

public interface UserRepository extends JpaRepository<User, Long>   {

}
