package Model;

public class Produkt {
    private Long id;
    private String name;
    private float preis;

    public Produkt(Long id, String name, float preis) {
        this.id = id;
        this.name = name;
        this.preis = preis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }
}
