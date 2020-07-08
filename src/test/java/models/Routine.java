package models;

public class Routine {
    String routineName;
    String frequency;
    String dataType;
    String type;
    String difficulty;
    String description;
    String tags;

    public Routine(String routineName, String frequency, String dataType, String type, String difficulty, String description, String tags) {
        this.routineName = routineName;
        this.frequency = frequency;
        this.dataType = dataType;
        this.type = type;
        this.difficulty = difficulty;
        this.description = description;
        this.tags = tags;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


}
