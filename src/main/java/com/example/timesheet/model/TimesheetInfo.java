package com.example.timesheet.model;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;

@NamedStoredProcedureQuery(
		  name="search_task",
		  procedureName="search_task",
		  resultClasses = { TimesheetInfo.class },
		  parameters={
		    @StoredProcedureParameter(name="keyword", type=String.class, mode=ParameterMode.IN)
		  })
@Entity
@SqlResultSetMapping(name = "TimesheetInfo", classes = @ConstructorResult(targetClass = TimesheetInfo.class, columns = { 
		@ColumnResult(name = "id", type = Long.class),
        @ColumnResult(name = "project", type = String.class),
        @ColumnResult(name = "task", type = String.class),
        @ColumnResult(name = "assignto", type = String.class),
        @ColumnResult(name = "from", type = String.class),
        @ColumnResult(name = "to", type = String.class),
        @ColumnResult(name = "status", type = String.class)
}))
public class TimesheetInfo implements Serializable {
	private static final long serialVersionUID = 8924498080330267621L;
	@Id
	private Long id;
	
	private String project;
	
	private String task;
	
	private String assignto;
	
	private String from;
	
	private String to;
	
	private String status;
	
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

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAssignto() {
		return assignto;
	}

	public void setAssignto(String assignto) {
		this.assignto = assignto;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
