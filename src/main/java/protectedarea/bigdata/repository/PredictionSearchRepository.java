package protectedarea.bigdata.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import protectedarea.bigdata.model.Area;
import protectedarea.bigdata.model.Prediction;

@Repository
public class PredictionSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Prediction> searchPrediction(String text) {
		Query q = new Query();
		q.addCriteria(Criteria.where("NAME").is(text));		
		return mongoTemplate.find(q, Prediction.class);
	}
	
}
