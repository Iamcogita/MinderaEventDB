package mindera_mindswap.todo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private Boolean done;
    public Task(String name) {
        this.name = name;
        this.done = false;
    }
}
