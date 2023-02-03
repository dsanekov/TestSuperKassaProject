package main.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ObjectDTO {
    private String current;
    private int number;

    public ObjectDTO(String current, int number) {
        this.current = current;
        this.number = number;
    }
    public ObjectDTO(){}
}
