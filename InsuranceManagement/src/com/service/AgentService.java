package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.AgentDao;
import com.daoImpl.AgentDaoImpl;
import com.exception.PolicyNotFoundException;
import com.model.Policy;

public class AgentService {

	AgentDao agentDao = new AgentDaoImpl();

	public boolean insert(Policy policy) throws SQLException {
		return agentDao.save(policy);
	}

	public List<Policy> getAllPolicies() throws SQLException {
		return agentDao.findAllPolicy();
	}

	public Policy findPolicy(int policyId) throws SQLException, PolicyNotFoundException {
		boolean isExist = agentDao.findOnePolicy(policyId);

		if (!isExist)
			throw new PolicyNotFoundException("Invalid Policy Id");

		return agentDao.findPolicy(policyId);
	}

	public boolean updatePolicy(Policy pol) throws SQLException, PolicyNotFoundException {
		boolean isExist = agentDao.findOnePolicy(pol.getPolicyId());

		if (!isExist)
			throw new PolicyNotFoundException("Invalid Policy Id");
		return agentDao.updatePolicy(pol);
	}

	public boolean deletePolicy(int pId) throws SQLException, PolicyNotFoundException {
		boolean isExist = agentDao.findOnePolicy(pId);

		if (!isExist)
			throw new PolicyNotFoundException("Invalid Policy Id");	
		return agentDao.softDeletePolicy(pId);
	}

}
