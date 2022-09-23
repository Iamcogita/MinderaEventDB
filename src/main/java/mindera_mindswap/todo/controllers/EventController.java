package mindera_mindswap.todo.controllers;

import mindera_mindswap.todo.dto.CreateEventDto;
import mindera_mindswap.todo.dto.UpdateEventDto;
import mindera_mindswap.todo.models.Event;
import mindera_mindswap.todo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> list(){
       return eventService.list();
    }

    @PostMapping
    public Event create(@RequestBody CreateEventDto Dto){
        Event event = new Event(Dto.getTitle() , Dto.getType(), Dto.getDate(), Dto.getStartingTime());
        return eventService.save(event);
    }

    @PutMapping
    public Event update(@RequestBody UpdateEventDto Dto) throws Exception {
        return eventService.update(Dto);
    }


}
