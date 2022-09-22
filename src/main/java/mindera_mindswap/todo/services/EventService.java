package mindera_mindswap.todo.services;

import mindera_mindswap.todo.dto.UpdateEventDto;
import mindera_mindswap.todo.models.Event;
import mindera_mindswap.todo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event e){
       return eventRepository.save(e);
    }

    public List<Event> list(){
        return eventRepository.findAll();
    }

    public Event update(UpdateEventDto Dto) throws Exception{
        Optional<Event> event = eventRepository.findById(Dto.getId());
        if(!event.isPresent()){throw new ChangeSetPersister.NotFoundException();}
        event.get().setDone(Dto.isDone());
        return eventRepository.save(event.get());
    }

}
