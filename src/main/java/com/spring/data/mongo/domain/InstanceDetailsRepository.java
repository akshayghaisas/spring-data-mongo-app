package com.spring.data.mongo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author akshay.ghaisas
 *
 */
@Repository
public interface InstanceDetailsRepository extends CrudRepository<InstanceDetails, Long>{
	
	public InstanceDetails findByInstanceName(String instanceName);

}
