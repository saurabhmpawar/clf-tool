package com.gcek.clf.tool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gcek.clf.tool.dao.SmtpSettingDao;
import com.gcek.clf.tool.model.Constants;
import com.gcek.clf.tool.model.SmtpSetting;
import com.gcek.clf.tool.utility.AESEncryption;
import com.gcek.clf.tool.utility.BusinessException;
import com.gcek.clf.tool.utility.DBConnect;

public class SmtpSettingDaoImpl implements SmtpSettingDao {

	static final Logger logger = Logger.getLogger(SmtpSettingDaoImpl.class);

	@Override
	public void createSmtpSetting(SmtpSetting smtpSetting) throws BusinessException {

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into cft_setting (id,setting_key,setting_value) value(?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_NAME);
			ps.setString(3, smtpSetting.getSmtpName());

			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_PASSWORD);
			ps.setString(3, AESEncryption.encrypt(smtpSetting.getSmtpPassword()));
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_PORT);
			ps.setString(3, smtpSetting.getSmtpPort());
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_SENDER_SMAIL);
			ps.setString(3, smtpSetting.getSmtpSenderEmail());
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_SSL);
			ps.setString(3, smtpSetting.getSmtpSsl());
			ps.addBatch();

			ps.clearParameters();
			ps.setInt(1, Constants.SMTP_ID);
			ps.setString(2, Constants.SMTP_URL);
			ps.setString(3, smtpSetting.getSmtpUrl());
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
	public List<SmtpSetting> getAllSmtp() throws BusinessException {
		// TODO Auto-generated method stub
		logger.info("----inside getallsmtp----");

		List<SmtpSetting> smtpList = new ArrayList<>();

		// TODO open connction

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from cft_setting where id = 1";

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				SmtpSetting smtp = new SmtpSetting();
				String key = rs.getString("setting_key");
				if (key.equalsIgnoreCase(Constants.SMTP_URL)) {
					smtp.setSmtpUrl(rs.getString("setting_value"));
				}
				if (key.equalsIgnoreCase(Constants.SMTP_NAME)) {
					smtp.setSmtpName(rs.getString("setting_value"));
				}

				smtpList.add(smtp);
			}

			logger.info("----inside getallsmtp-db exit---");
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

		return smtpList;
	}

}
