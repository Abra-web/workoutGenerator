package workout;

public class WorkoutInfo {
    public String name;
    public String area;
    public String specificArea;
    public String colour;
    public String timeAdded;
    // public String itemNeeded;
    public String barType;

    public WorkoutInfo(String name, String area, String specificArea, String colour, String timeAdded, String barType) {
        this.name = name;
        this.area = area;
        this.specificArea = specificArea;
        this.colour = colour;
        this.timeAdded = timeAdded;
        this.barType = barType;
    }

    @Override
    public String toString() {
        return "WorkoutInfo{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", barType='" + barType + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getSpecificArea() {
        return specificArea;
    }

    public String getColour() {
        return colour;
    }

    public String getTimeAdded() {
        return timeAdded;
    }

    public String getBarType() {
        return barType;
    }
}
