package protectedarea.bigdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import protectedarea.bigdata.model.Area;

public interface AreaMongoRepository extends MongoRepository<Area, String>{}