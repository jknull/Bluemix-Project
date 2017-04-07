package protectedarea.bigdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import protectedarea.bigdata.model.WeatherCondition;

public interface WeatherMongoRepository extends MongoRepository<WeatherCondition, String>{}