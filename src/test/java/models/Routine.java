package models;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Routine {
    private String routineName;
    private String frequency;
    private String dataType;
    private String type;
    private String difficulty;
    private String tags;
    private String description;
}
