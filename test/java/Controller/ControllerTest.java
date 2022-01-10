package Controller;

import Model.Bestellung;
import Model.Produkt;
import Repository.BestellungRepository;
import Repository.ProduktRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Produkt p1;
    Produkt p2;
    Produkt p3;

    Bestellung b1;
    Bestellung b2;

    ProduktRepository produktRepository;
    BestellungRepository bestellungRepository;
    Controller controller;

    @BeforeEach
    void setup(){
        p1=new Produkt(1L,"Pc",200);
        p2=new Produkt(2L,"Tastatur",100);
        p3=new Produkt(3L,"Mouse",50);

        List<Produkt> produkte1 = new ArrayList<>();
        produkte1.add(p2);
        produkte1.add(p3);

        List<Produkt> produkte2 = new ArrayList<>();
        produkte1.add(p1);
        b1=new Bestellung(1L,1,"Cluj",produkte1,150);
        b2=new Bestellung(2L, 2,"Medias",produkte2,200);

        produktRepository=new ProduktRepository();
        produktRepository.save(p1);
        produktRepository.save(p2);
        produktRepository.save(p3);

        bestellungRepository=new BestellungRepository();
        bestellungRepository.save(b1);
        bestellungRepository.save(b2);

        controller= new Controller(produktRepository, bestellungRepository);
    }

    public void testSortBestellungenNachGesamtpreis(){
        //hochste preis hat Bestellung b2
        assertEquals(b2, controller.sortBestellungenNachGesamtpreis().get(0));
    }

    public void testFilterBestellungenNachProdukt(){
        //nur b1 hat p2
        Bestellung[] bestellungs = new Bestellung[1];
        bestellungs[0]=b1;
        assertArrayEquals(bestellungs,controller.filterBestellungenNachProdukt(p2.getId()).toArray());
    }



}