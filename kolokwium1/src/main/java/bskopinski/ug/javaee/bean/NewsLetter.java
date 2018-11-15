package bskopinski.ug.javaee.bean;


import java.util.Date;

public class NewsLetter {

    private String name;
    private Date dataOd;
    private Date dataDo;
    private String czestotliwosc;

    private String tematyka;

    public NewsLetter(String name, Date dataOd, Date dataDo, String czestotliwosc, String tematyka) {
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

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
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
