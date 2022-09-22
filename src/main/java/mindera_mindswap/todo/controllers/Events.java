package mindera_mindswap.todo.controllers;

import mindera_mindswap.todo.dto.CreateTaskDto;
import mindera_mindswap.todo.dto.DeleteTaskDto;
import mindera_mindswap.todo.dto.UpdateTaskDto;
import mindera_mindswap.todo.models.Event;
import mindera_mindswap.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class Events {

    private final TaskService taskService;

    @Autowired
    public Events(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Event> list(){
       return taskService.list();
    }

    @PostMapping
    public Event create(@RequestBody CreateTaskDto createTaskDto){
        Event task = new Event(createTaskDto.getName());
        return taskService.save(task);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteTaskDto deleteTaskDto){
        taskService.delete(deleteTaskDto);
    }

    @PutMapping
    public Event update(@RequestBody UpdateTaskDto updateTaskDto) throws Exception {
        return taskService.update(updateTaskDto);
    }

    @DeleteMapping("/clear")
    public void clear(){taskService.clearAll();}

}
