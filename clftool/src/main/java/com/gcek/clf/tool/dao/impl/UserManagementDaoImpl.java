package com.gcek.clf.tool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.UserManagementDao;
import com.gcek.clf.tool.model.User;
import com.gcek.clf.tool.utility.BusinessException;
import com.gcek.clf.tool.utility.CommonUtility;
import com.gcek.clf.tool.utility.DBConnect;

public class UserManagementDaoImpl implements UserManagementDao {
	static final Logger logger = Logger.getLogger(UserManagementDaoImpl.class);

	@Override
	public void addUser(User user) throws BusinessException {
		// TODO open connction

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into user (emailid,firstName,lastName,password,createdOn,modifiedBy,modifiedOn) value(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, user.getEmailid());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			ps.setDate(5, CommonUtility.sqlDateConversion(new Date()));
			ps.setString(6, user.getModifiedBy());
			ps.setDate(7, CommonUtility.sqlDateConversion(new Date()));

			ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while adding user", e);
			throw new BusinessException("Error While Adding User", e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("Error while adding account", e);

			}
		}

		// TODO insert into

	}

	@Override
	public void modifyUser(User user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByUserId(int userId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() throws BusinessException {

		List<User> userList = new ArrayList<>();

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				User user = new User();
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailid(rs.getString("emailid"));
				userList.add(user);

			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				con.close();

				if (null != ps)
					ps.close();
			} catch (SQLException e) {
				logger.error("Error while adding account", e);

			}
		}

		return userList;

	}

	@Override
	public boolean isValidUser(String userName, String password) throws BusinessException {
		
		logger.debug("---inside Logindao---");

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user where emailid=? and password=?";
		PreparedStatement ps ;
		try {

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				con.close();
				return true;
			}

		} catch (SQLException e) {
			logger.error("Error At Login service ", e);

			try {

				con.close();
			} catch (SQLException e1) {
				logger.error("Error while closing connection ", e1);
			}

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("Error while adding account", e);

			}
		}

		return false;
	}

}
