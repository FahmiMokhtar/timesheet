package com.example.timesheet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.example.timesheet.model.TimesheetInfo;

public class TimesheetInfoRepositoryImpl implements TimesheetInfoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TimesheetInfo> findAllTask(String keyword) {
		StoredProcedureQuery spQuery = entityManager.createNamedStoredProcedureQuery("search_task")
				  .setParameter("keyword", keyword);
		List<TimesheetInfo> timesheetList = spQuery.getResultList();
		
		return timesheetList;
	}

}
