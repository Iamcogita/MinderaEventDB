package mindera_mindswap.todo.dto;

import lombok.Data;
import mindera_mindswap.todo.models.ITask;

@Data
public class UpdateTaskDto implements ITask {

    private String id;
    private boolean done;
}
