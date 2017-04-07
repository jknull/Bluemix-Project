package protectedarea.bigdata.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import protectedarea.bigdata.model.Event;

@Repository
public class EventSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Event> searchEvent(String text, float lat, float lon) {
		Query q = new Query();
		q.addCriteria(Criteria.where("STATE").is(text));
		q.addCriteria(new Criteria().andOperator(Criteria.where("BEGIN_LAT").lt(lat+1),
				Criteria.where("BEGIN_LAT").gt(lat-1),
				Criteria.where("BEGIN_LON").lt(lon+1),
				Criteria.where("BEGIN_LON").gt(lon-1)));
		return mongoTemplate.find(q, Event.class);
	}
	
}
