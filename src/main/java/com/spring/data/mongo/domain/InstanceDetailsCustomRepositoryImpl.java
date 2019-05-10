package com.spring.data.mongo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

/**
 * 
 * @author akshay.ghaisas
 *
 */
@Service
public class InstanceDetailsCustomRepositoryImpl implements InstanceDetailsCustomRepository {

	@Autowired
	private InstanceDetailsRepository instanceDetailsRepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public int updateInstanceStatus(String instanceName, String status) {

		Query query = new Query(Criteria.where("instanceName").is(instanceName));
		Update update = new Update();

		update.set("status", status);

		UpdateResult result = this.mongoTemplate.updateFirst(query, update, InstanceDetails.class);

		if (result != null)
			return (int) result.getMatchedCount();
		else
			return 0;
	}

	@Override
	public InstanceDetails getInstanceDetails(String instanceName) {

		InstanceDetails instanceDetails = this.instanceDetailsRepo.findByInstanceName(instanceName);
		return instanceDetails;
	}

	@Override
	public InstanceDetails addNewInstance(InstanceDetailsVO instanceDetailsVO) {

		InstanceDetails detailes = transforInstanceDetailsVOTOEntity(instanceDetailsVO);
		this.instanceDetailsRepo.save(detailes);
		return detailes;
	}

	private InstanceDetails transforInstanceDetailsVOTOEntity(InstanceDetailsVO detailsVO) {

		InstanceDetails details = new InstanceDetails();

		details.setInstanceName(detailsVO.getInstanceName());
		details.setStatus(detailsVO.getStatus());
		details.setRegistered(details.isRegistered());

		return details;
	}

}
