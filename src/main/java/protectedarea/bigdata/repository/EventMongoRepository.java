package protectedarea.bigdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import protectedarea.bigdata.model.Event;

public interface EventMongoRepository extends MongoRepository<Event, String>{}