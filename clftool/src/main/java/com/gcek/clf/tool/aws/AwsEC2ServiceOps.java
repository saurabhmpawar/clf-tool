package com.gcek.clf.tool.aws;

import java.util.List;

import com.amazonaws.services.ec2.model.Address;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Snapshot;
import com.amazonaws.services.ec2.model.Volume;
import com.gcek.clf.tool.model.MySecurityGroup;
import com.gcek.clf.tool.utility.BusinessException;

public interface AwsEC2ServiceOps {

	public List<MySecurityGroup> getSecurityGroups() throws BusinessException;

	public List<Address> getPublicIp() throws BusinessException;

	public List<Volume> getEbsInfo() throws BusinessException;

	public List<Snapshot> getAllSnapshot() throws BusinessException;

	public List<Instance> getAllEc2Instances() throws BusinessException;

}
