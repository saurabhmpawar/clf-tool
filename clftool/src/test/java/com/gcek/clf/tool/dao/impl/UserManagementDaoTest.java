package com.gcek.clf.tool.dao.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.gcek.clf.tool.dao.UserManagementDao;
import com.gcek.clf.tool.model.User;
import com.gcek.clf.tool.utility.BusinessException;

public class UserManagementDaoTest {

	@Test
	public void adduserTest() {
		System.out.println("shree");

		UserManagementDao u = new UserManagementDaoImpl();

		User user = new User("pavanpawarqa@gmail.com", "saurabh", "pawar", "admin", "admin");
		try {
			user.setModifiedBy("saurabh");
			u.addUser(user);

		} catch (BusinessException e) {

			e.printStackTrace();
		}

	}

	@Ignore
	@Test
	public void listUsersTest() {

		UserManagementDao u = new UserManagementDaoImpl();

		try {
			System.out.println(u.getAllUsers().toString());

		} catch (BusinessException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void isValidUserTest() {
		UserManagementDao u = new UserManagementDaoImpl();
		try {

			boolean b = u.isValidUser("saurabhpawar1396@gmail.com", "admin");

			Assert.assertTrue(b);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
