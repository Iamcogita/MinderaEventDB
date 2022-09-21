package mindera_mindswap.todo.repositories;

import mindera_mindswap.todo.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task , String> {
}
