package models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Routine {
    private String routineName;
    private String frequency;
    private String dataType;
    private String type;
    private String difficulty;
    private String description;
    private String tags;
}
