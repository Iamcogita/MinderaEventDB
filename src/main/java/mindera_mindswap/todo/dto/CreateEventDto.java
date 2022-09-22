package mindera_mindswap.todo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateEventDto {
    private String title;
    private String type;
    private Date date;
    private String startingTime;
}
