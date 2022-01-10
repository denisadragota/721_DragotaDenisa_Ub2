package View;
import Controller.Controller;
import Model.Produkt;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    private Controller controller;
    public View(Controller controller) {
        this.controller = controller;
    }
    /**
     * Mainloop function for Console Application
     */
    public void Run() {
        Scanner scanner = new Scanner(System.in);
        int continueLoop =1;
        while(continueLoop==1){
            System.out.println("1.Add Produkt\n2.Update Produkt\n3.Delete Produkt\n4.Add Bestellung\n5.Update Bestellung\n6.Delete Bestellung\n7.Sort Bestellung\n8.Filter Bestellung\n9.Exit\n");
            String produktName;
            Float produktPreis;
            Long produktId;
            String input =scanner.next();
            System.out.println(input);

                switch (input) {
                    case "1":
                        System.out.println("Give Produkt Name");
                        produktName = scanner.next();
                        System.out.println("Give Produkt Id");
                        produktId = Long.parseLong(scanner.next());
                        System.out.println("Give Produkt Preis");
                        produktPreis = Float.parseFloat(scanner.next());
                        Produkt newProdukt = new Produkt(produktId, produktName, produktPreis);
                        controller.addProdukt(newProdukt);
                        break;
                    case "2":
                        System.out.println("Give Produkt Id");
                        produktId = Long.parseLong(scanner.next());
                        System.out.println("Give New Produkt Name");
                        produktName = scanner.next();
                        System.out.println("Give New Produkt Preis");
                        produktPreis = Float.parseFloat(scanner.next());
                        Produkt updateProdukt = new Produkt(produktId, produktName, produktPreis);
                        controller.updateProdukt(updateProdukt);
                        break;
                    case "3":
                        System.out.println("Give Produkt Id");
                        produktId = Long.parseLong(scanner.next());

                        controller.deleteProdukt(produktId);
                        break;

                    case "4":
                        break;

                    case "5":

                        break;

                    case "6":

                        break;

                    case "7":
                        System.out.println("Sort Bestellungen");
                        System.out.println(controller.sortBestellungenNachGesamtpreis());
                        break;

                    case "8":
                        System.out.println("Give Produkt Id zu Filter nach: ");
                        produktId=Long.parseLong(scanner.next());
                        System.out.println(controller.filterBestellungenNachProdukt(produktId));
                        break;

                    case "9":
                        continueLoop=0;
                        break;
                    default:
                }
                System.out.println("Success");

        }
    }
}

