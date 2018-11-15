package bskopinski.ug.javaee.repository;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.bean.NewsLetter;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    private List<AirConditioner> newsletterList = new ArrayList<>();


    public List<AirConditioner> getNewsletter() {
        return newsletterList;
    }

    public void addNewsletter(NewsLetter newsletter) {
        newsletterList.add(newsletter);
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
