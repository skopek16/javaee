package bskopinski.ug.javaee.bean;

import java.time.LocalDate;
import java.util.Objects;

public class AirConditioner {
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirConditioner that = (AirConditioner) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(dateProduction, that.dateProduction) &&
                Objects.equals(price, that.price) &&
                Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateProduction, price, producer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private LocalDate dateProduction;
    private Double price;
    private String producer;
    private Integer quantity;

    public AirConditioner(Integer id,String name, LocalDate dateProduction, Double price, String producer, Integer quantity) {
        this.id = id;
        this.name = name;
        this.dateProduction = dateProduction;
        this.price = price;
        this.producer = producer;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(LocalDate dateProduction) {
        this.dateProduction = dateProduction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
