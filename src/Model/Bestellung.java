package Model;

import java.util.List;

public class Bestellung {

    private Long id;
    private int bestellnr;
    private String adresse;
    private List<Produkt> produkte;

    public Bestellung(Long id, int bestellnr, String adresse, List<Produkt> produkte) {
        this.id = id;
        this.bestellnr = bestellnr;
        this.adresse = adresse;
        this.produkte = produkte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public void setProdukte(List<Produkt> produkte) {
        this.produkte = produkte;
    }
}
