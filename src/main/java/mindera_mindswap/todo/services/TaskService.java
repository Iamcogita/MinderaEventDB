package mindera_mindswap.todo.services;

import mindera_mindswap.todo.dto.UpdateTaskDto;
import mindera_mindswap.todo.models.ITask;
import mindera_mindswap.todo.models.Task;
import mindera_mindswap.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task){
       return taskRepository.save(task);
    }

    public List<Task> list(){
        return taskRepository.findAll();
    }

    public Task update(UpdateTaskDto updateTaskDto) throws Exception{
        Optional<Task> task = taskRepository.findById(updateTaskDto.getId());
        if(!task.isPresent()){throw new ChangeSetPersister.NotFoundException();}
        task.get().setDone(updateTaskDto.isDone());
        return taskRepository.save(task.get());
    }

    public void delete(ITask task){
        taskRepository.deleteById(task.getId());
    }

    public void clearAll(){taskRepository.deleteAll();}
}
