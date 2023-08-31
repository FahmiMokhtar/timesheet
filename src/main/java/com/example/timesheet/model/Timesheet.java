package com.example.timesheet.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="TIMESHEET")
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String project;
	
	private String task;
	
	private Date datefrom;
	
	private Date dateto;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="userid", nullable=true)
	private User user;
    
    @Transient
    private Long userid;
    

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="statusid", nullable=true)
	private Status status;
    
    @Transient
    private Long statusid;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
}
