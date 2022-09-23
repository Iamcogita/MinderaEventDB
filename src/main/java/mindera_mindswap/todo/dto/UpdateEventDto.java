package mindera_mindswap.todo.dto;

import lombok.Data;

import java.lang.annotation.Inherited;

@Data
public class UpdateEventDto{

    private String id;
    private String state;
}
