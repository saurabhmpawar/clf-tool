package com.gcek.clf.tool.aws;

import java.util.List;

import com.amazonaws.services.ec2.model.Vpc;
import com.gcek.clf.tool.utility.BusinessException;

public interface AwsVPCServiceOps {

	
	public List<Vpc> getVpcs() throws BusinessException;
	
}
