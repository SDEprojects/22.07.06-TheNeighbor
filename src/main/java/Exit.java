public class Exit {

    private String name;
    private String direction;
    private String description;
    private String  leadsTo;

    public Exit() {
    }

    public Exit(String name, String direction, String description, String leadsTo) {
        this.name = name;
        this.direction = direction;
        this.description = description;
        this.leadsTo = leadsTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLeadsTo() {
        return leadsTo;
    }

    public void setLeadsTo(String leadsTo) {
        this.leadsTo = leadsTo;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", description='" + description + '\'' +
                ", leadsTo='" + leadsTo + '\'' +
                '}';
    }
}
