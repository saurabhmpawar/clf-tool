package com.gcek.clf.tool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.AWSCrientialsDao;
import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.model.Constants;
import com.gcek.clf.tool.utility.AESEncryption;
import com.gcek.clf.tool.utility.BusinessException;
import com.gcek.clf.tool.utility.DBConnect;
import com.gcek.clf.tool.utility.XXXXConverterUtil;

public class AWScridentialsDaoImpl implements AWSCrientialsDao {
	static final Logger logger = Logger.getLogger(AWScridentialsDaoImpl.class);

	@Override
	public void addCridentails(AWScridentials awScridentials) throws BusinessException {

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into cft_setting (id,setting_key,setting_value) value(?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, Constants.AWS_KEY_ID);
			ps.setString(2, Constants.ACCESS_KEY);
			ps.setString(3, AESEncryption.encrypt(awScridentials.getAccessKey()));

			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.AWS_KEY_ID);
			ps.setString(2, Constants.SECRET_KEY);
			ps.setString(3, AESEncryption.encrypt(awScridentials.getSecretKey()));
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.AWS_KEY_ID);
			ps.setString(2, Constants.SECERT_KEY_XXX);
			ps.setString(3, XXXXConverterUtil.generateXXXX(awScridentials.getSecretKey()));
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.AWS_KEY_ID);
			ps.setString(2, Constants.ACCESS_KEY_XXX);
			ps.setString(3, XXXXConverterUtil.generateXXXX(awScridentials.getAccessKey()));
			ps.addBatch();

			int[] results = ps.executeBatch();
			logger.info("date saved successfully " + results);
			con.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while adding cf_setting", e);
			throw new BusinessException("Error While Adding cft_setting", e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("Error while adding cft_setting ", e);

			}
		}

	}

	@Override
	public AWScridentials getCridentials(int id) throws BusinessException {

		AWScridentials awScridentials = new AWScridentials();

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from cft_setting where id= " + id;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(Constants.SETTING_KEY).equals(Constants.ACCESS_KEY)) {
					awScridentials.setAccessKey(rs.getString(Constants.SETTING_VALUE));
				}
				if (rs.getString(Constants.SETTING_KEY).equals(Constants.SECRET_KEY)) {
					awScridentials.setSecretKey(rs.getString(Constants.SETTING_VALUE));
				}
			}

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
		return awScridentials;
	}

	@Override
	public void updateCridentails(AWScridentials awScridentials) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public AWScridentials deleteCridentials(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
