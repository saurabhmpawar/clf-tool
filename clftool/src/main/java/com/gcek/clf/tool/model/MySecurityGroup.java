package com.gcek.clf.tool.model;

import com.amazonaws.services.ec2.model.SecurityGroup;

public class MySecurityGroup extends SecurityGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "MySecurityGroup [color=" + color + ", getOwnerId()=" + getOwnerId() + ", getGroupName()="
				+ getGroupName() + ", getGroupId()=" + getGroupId() + ", getDescription()=" + getDescription()
				+ ", getIpPermissions()=" + getIpPermissions() + ", getIpPermissionsEgress()="
				+ getIpPermissionsEgress() + ", getVpcId()=" + getVpcId() + ", getTags()=" + getTags() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
