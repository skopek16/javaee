package bskopinski.ug.javaee.repository;

import bskopinski.ug.javaee.bean.AirConditioner;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private List<AirConditioner> cart = new ArrayList<>();


    public List<AirConditioner> getCart() {
        return cart;
    }

    public void addAirConditioner(AirConditioner airConditioner) {
        cart.add(airConditioner);
    }

    public AirConditioner findById(Integer id) {
        for (AirConditioner airConditioner : cart) {
            if (airConditioner.getId().equals(id)) {
                return airConditioner;
            }
        }
        return null;

    }

}
