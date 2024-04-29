package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Policy;

public interface AgentDao {
	boolean save(Policy policy) throws SQLException;

	Policy findPolicy(int policyId) throws SQLException;

	List<Policy> findAllPolicy() throws SQLException;

	boolean updatePolicy(Policy updatedPolicy) throws SQLException;

	boolean softDeletePolicy(int policyId) throws SQLException;
	
	boolean findOnePolicy(int policyId)throws SQLException;
}
