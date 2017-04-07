package protectedarea.bigdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import protectedarea.bigdata.model.Prediction;

public interface PredictionMongoRepository extends MongoRepository<Prediction, String>{}
