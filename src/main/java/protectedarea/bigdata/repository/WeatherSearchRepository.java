package protectedarea.bigdata.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import protectedarea.bigdata.model.WeatherCondition;

@Repository
public class WeatherSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<WeatherCondition> searchWeatherCondition(String type, float lat, float lon) {
		Query q = new Query();
		q.addCriteria(Criteria.where("type").is(type));
		q.addCriteria(new Criteria().andOperator(Criteria.where("lat").lt(lat+0.5),
				Criteria.where("lat").gt(lat-0.5),
				Criteria.where("lon").lt(lon+0.5),
				Criteria.where("lon").gt(lon-0.5)));
		return mongoTemplate.find(q, WeatherCondition.class);
	}
	
}
