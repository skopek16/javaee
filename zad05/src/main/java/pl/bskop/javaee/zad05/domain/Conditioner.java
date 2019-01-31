package pl.bskop.javaee.zad05.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class Conditioner {

    private String model;
    private double capacity;
    private int fans;


    public Conditioner(String model,  double capacity, int fans) {
        this.model = model;
        this.capacity = capacity;
        this.fans = fans;
    }

    public Conditioner() {
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }


}
