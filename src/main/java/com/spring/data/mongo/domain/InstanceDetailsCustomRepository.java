package com.spring.data.mongo.domain;

/**
 * 
 * @author akshay.ghaisas
 *
 */
public interface InstanceDetailsCustomRepository {
	
	public int updateInstanceStatus(String instanceName, String status);
	
	public InstanceDetails getInstanceDetails(String instanceName); 
	
	public InstanceDetails addNewInstance(InstanceDetailsVO instanceDetails);

}
