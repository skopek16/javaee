package bskopinski.ug.javaee.bean;


import java.time.LocalDate;
import java.util.Date;

public class NewsLetter {

    private String name;
    private LocalDate dataOd;
    private LocalDate dataDo;
    private String czestotliwosc;

    private String tematyka;

    public NewsLetter(String name, LocalDate dataOd, LocalDate dataDo, String czestotliwosc, String tematyka) {
        this.name = name;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.czestotliwosc = czestotliwosc;
        this.tematyka = tematyka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataOd() {
        return dataOd;
    }

    public void setDataOd(LocalDate dataOd) {
        this.dataOd = dataOd;
    }

    public LocalDate getDataDo() {
        return dataDo;
    }

    public void setDataDo(LocalDate dataDo) {
        this.dataDo = dataDo;
    }

    public String getCzestotliwosc() {
        return czestotliwosc;
    }

    public void setCzestotliwosc(String czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public String getTematyka() {
        return tematyka;
    }

    public void setTematyka(String tematyka) {
        this.tematyka = tematyka;
    }

}
