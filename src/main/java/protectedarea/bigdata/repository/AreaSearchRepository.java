package protectedarea.bigdata.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import protectedarea.bigdata.model.Area;

@Repository
public class AreaSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Area> searchArea(String text) {
		Query q = new Query();
		q.addCriteria(Criteria.where("NAME").is(text));
		return mongoTemplate.find(q, Area.class);
	}
	
}
