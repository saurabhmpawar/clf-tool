package com.gcek.clf.tool.aws;

import java.util.List;

import com.amazonaws.services.s3.model.Bucket;
import com.gcek.clf.tool.utility.BusinessException;

public interface AwsS3ServiceOps {
	/**
	 * List all buckets
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Bucket> listAccountBuckets() throws BusinessException;
}
