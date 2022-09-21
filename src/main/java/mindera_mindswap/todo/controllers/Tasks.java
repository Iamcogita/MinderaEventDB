package mindera_mindswap.todo.controllers;

import mindera_mindswap.todo.dto.CreateTaskDto;
import mindera_mindswap.todo.dto.DeleteTaskDto;
import mindera_mindswap.todo.dto.UpdateTaskDto;
import mindera_mindswap.todo.models.Task;
import mindera_mindswap.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class Tasks {

    private final TaskService taskService;

    @Autowired
    public Tasks(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> list(){
       return taskService.list();
    }

    @PostMapping
    public Task create(@RequestBody CreateTaskDto createTaskDto){
        Task task = new Task(createTaskDto.getName());
        return taskService.save(task);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteTaskDto deleteTaskDto){
        taskService.delete(deleteTaskDto);
    }

    @PutMapping
    public Task update(@RequestBody UpdateTaskDto updateTaskDto) throws Exception {
        return taskService.update(updateTaskDto);
    }

    @DeleteMapping("/clear")
    public void clear(){taskService.clearAll();}

}
