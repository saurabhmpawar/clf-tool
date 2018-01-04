package com.gcek.clf.tool.dao;

import java.util.List;

import com.gcek.clf.tool.model.User;
import com.gcek.clf.tool.utility.BusinessException;

/**
 * 
 * @author saurabh.Pawar
 *
 */
public interface UserManagementDao {

	/**
	 * add new user in database
	 * 
	 * @param user
	 * @throws BusinessException
	 */
	public void addUser(User user) throws BusinessException;

	/**
	 * Modify user
	 * 
	 * @param user
	 * @throws BusinessException
	 */
	public void modifyUser(User user) throws BusinessException;

	/**
	 * Get user by user id
	 * 
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public User getUserByUserId(int userId) throws BusinessException;

	/**
	 * delete user
	 * 
	 * @param userId
	 * @throws BusinessException
	 */

	public void deleteUser(int userId) throws BusinessException;

	/**
	 * Get all user list
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<User> getAllUsers() throws BusinessException;

	/**
	 * validate user with database
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public boolean isValidUser(String userName, String password) throws BusinessException;

	
	
	//private int getRoleByUserName(String userName);
	
	
}