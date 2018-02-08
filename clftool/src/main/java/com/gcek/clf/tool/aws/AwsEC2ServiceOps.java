package com.gcek.clf.tool.aws;

import java.util.List;

import com.gcek.clf.tool.model.MySecurityGroup;
import com.gcek.clf.tool.utility.BusinessException;

public interface AwsEC2ServiceOps {

	public List<MySecurityGroup> getSecurityGroups() throws BusinessException;

}
