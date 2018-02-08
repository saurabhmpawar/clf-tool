package com.gcek.clf.tool.aws;

import java.util.List;

import com.gcek.clf.tool.model.MyBucket;
import com.gcek.clf.tool.utility.BusinessException;

public interface AwsS3ServiceOps {
	/**
	 * List all buckets
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<MyBucket> listAccountBuckets() throws BusinessException;
}
