package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AgentDao;
import com.model.Policy;
import com.utility.DBConnection;

public class AgentDaoImpl implements AgentDao {

	@Override
	public boolean save(Policy policy) throws SQLException {
		Connection con = DBConnection.dbConnect();

		String sql = "INSERT INTO policy (policy_id, name, premium, rate_of_interest) "
		+ "VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policy.getPolicyId());
		pstmt.setString(2, policy.getName());
		pstmt.setDouble(3, policy.getPremium());
		pstmt.setDouble(4, policy.getRateOfInterest());

		int status = pstmt.executeUpdate();
		DBConnection.dbClose();

		if (status == 0)
			return false;
		else
			return true;
	}

	@Override
	public Policy findPolicy(int policyId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from policy where policy_id=? and is_active=true";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			Policy policy = new Policy();

			policy.setPolicyId(rst.getInt("policy_id"));
			policy.setName(rst.getString("name"));
			policy.setPremium(rst.getDouble("premium"));
			policy.setRateOfInterest(rst.getDouble("rate_of_interest"));

			DBConnection.dbClose();
			return policy;
		} else {
			DBConnection.dbClose();
			return null;
		}
	}

	@Override
	public List<Policy> findAllPolicy() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from policy where is_active=true";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		List<Policy> list = new ArrayList<>();

		while (rst.next() == true) {
			String name = rst.getString("name");
			int policyId = rst.getInt("policy_id");
			double premium = rst.getDouble("premium");
			double rate_of_interest = rst.getDouble("rate_of_interest");
			Policy policy = new Policy(policyId, name, premium, rate_of_interest);

			list.add(policy);
		}

		pstmt.executeQuery();
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean updatePolicy(Policy updatedPolicy) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update policy set premium=? , rate_of_interest=? where policy_id =?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setDouble(1, updatedPolicy.getPremium());
		pstmt.setDouble(2, updatedPolicy.getRateOfInterest());
		pstmt.setInt(3, updatedPolicy.getPolicyId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		
		if (status == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean softDeletePolicy(int policyId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update policy set is_active=false where policy_id =?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, policyId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();

		if (status == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean findOnePolicy(int policyId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select policy_id from policy where policy_id=? and is_active=true ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);

		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();
		return status;
	}

}
