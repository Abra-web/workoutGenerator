package workout_vol2;

public class workout_info_vol2 {
    public String name;
    public String area;
    public String specificArea;
    public String colour;
    public String barType;

    public workout_info_vol2(String name, String area, String specificArea, String colour, String barType) {
        this.name = name;
        this.area = area;
        this.specificArea = specificArea;
        this.colour = colour;
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

    public String getBarType() {
        return barType;
    }
}
