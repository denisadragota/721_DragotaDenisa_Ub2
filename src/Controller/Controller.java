package Controller;

import Model.Bestellung;
import Model.Produkt;
import Repository.BestellungRepository;
import Repository.ICrudRepository;
import Repository.ProduktRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private ProduktRepository produktRepository;
    private BestellungRepository bestellungRepository;

    public Controller(ProduktRepository produktRepository, BestellungRepository bestellungRepository) {
        this.produktRepository = produktRepository;
        this.bestellungRepository = bestellungRepository;
    }

    public Produkt addProdukt(Produkt obj){
        return this.produktRepository.save(obj);
    }

    public Produkt updateProdukt(Produkt obj){
        return this.produktRepository.update(obj);
    }

    public Produkt deleteProdukt(Long id){
        return this.produktRepository.delete(id);
    }

    public Bestellung addBestellung(Bestellung obj){
        return this.bestellungRepository.save(obj);
    }
    public Bestellung updateBestellung(Bestellung obj){
        return this.bestellungRepository.update(obj);
    }
    public Bestellung deleteBestellung(Long id){
        return this.bestellungRepository.delete(id);
    }

    public List<Bestellung> sortBestellungenNachGesamtpreis(){
        return this.bestellungRepository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Bestellung::getGesamtPreis).reversed())
                .collect(Collectors.toList());
    }

    public List<Bestellung> filterBestellungenNachProdukt(Long id){
        return this.bestellungRepository.findAll()
                .stream()
                .filter(bestellung -> bestellung.getProdukte().contains(this.findProdukt(id)))
                .collect(Collectors.toList());
    }

    private Produkt findProdukt(Long id){
        return this.produktRepository.findOne(id);
    }
}
