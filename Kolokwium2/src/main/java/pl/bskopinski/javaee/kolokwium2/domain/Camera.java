package pl.bskopinski.javaee.kolokwium2.domain;

public class Camera {
    private String name;
    private String date;

    private String color;
    private String extras;

    public Camera(String name, String date, String color, String extras) {
        this.name = name;
        this.date = date;

        this.color = color;
        this.extras = extras;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
