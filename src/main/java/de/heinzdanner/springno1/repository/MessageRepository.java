package de.heinzdanner.springno1.repository;

import de.heinzdanner.springno1.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}