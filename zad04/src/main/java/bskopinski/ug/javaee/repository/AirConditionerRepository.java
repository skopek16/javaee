package bskopinski.ug.javaee.repository;

import bskopinski.ug.javaee.bean.AirConditioner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirConditionerRepository {
    private Integer id = 0;

    public Integer getId() {
        return ++id;
    }

    private List<AirConditioner> airConditioners = new ArrayList<>();

    {
        airConditioners.add(new AirConditioner(0, "Basic Conditioner", LocalDate.now(), 399.99, "Samsung", 10));
    }

    public List<AirConditioner> getAirConditioners() {
        return airConditioners;
    }

    public void addAirConditioner(AirConditioner airConditioner) {
        airConditioners.add(airConditioner);

    }

    public AirConditioner findById(Integer id) {
        for (AirConditioner airConditioner :  airConditioners) {
            if (airConditioner.getId().equals(id)) {
                return airConditioner;
            }
        }
        return null;

    }
}
