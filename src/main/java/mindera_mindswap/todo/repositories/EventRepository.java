package mindera_mindswap.todo.repositories;

import mindera_mindswap.todo.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
