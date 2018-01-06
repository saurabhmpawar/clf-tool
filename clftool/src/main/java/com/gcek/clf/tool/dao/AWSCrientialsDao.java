package com.gcek.clf.tool.dao;

import com.gcek.clf.tool.model.AWScridentials;
import com.gcek.clf.tool.utility.BusinessException;

public interface AWSCrientialsDao {

	/**
	 * save credentials
	 * 
	 * @param awScridentials
	 * @throws BusinessException
	 */
	public void addCridentails(AWScridentials awScridentials) throws BusinessException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AWScridentials getCridentials(int id) throws BusinessException;

	/**
	 * 
	 * @param awScridentials
	 * @throws BusinessException
	 */
	public void updateCridentails(AWScridentials awScridentials) throws BusinessException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AWScridentials deleteCridentials(int id) throws BusinessException;

}
