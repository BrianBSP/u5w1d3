package brianpelinku.u5w1d3.entities;

import brianpelinku.u5w1d3.enums.StatoOrdinazione;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordine {
    private int numeroOrdine;
    private List<Pizza> pizzeOrdinate;
    private List<Bevande> bevandeOrdinate;
    private int numCopertiOrdine;
    private Tavolo numTavolo;
    private LocalTime oraOrdinazione;
    private StatoOrdinazione statoOrdinazione;
    private double costoCoperto;
    private double totImportoOrdine;

    public Ordine(int numCopertiOrdine, Tavolo numTavolo){
        Random random = new Random();
        if (numTavolo.getMaxCoperti()<=numCopertiOrdine) throw new RuntimeException("Numero coperti eccessivo.");
        this.numeroOrdine = random.nextInt(1000,10000);
        this.statoOrdinazione = StatoOrdinazione.IN_CORSO;
        this.numCopertiOrdine= numCopertiOrdine;
        this.oraOrdinazione =LocalTime.now();
        this.pizzeOrdinate = new ArrayList<>();
        this.bevandeOrdinate = new ArrayList<>();
    }

    public void aggiungiPizza(Pizza pizza){
        this.pizzeOrdinate.add(pizza);
    }

    public void aggiungiBevanda(Bevande bevande){
        this.bevandeOrdinate.add(bevande);
    }

    public double getTotale(/*@Value("${prezzo.coperto}")double prezzoCop*/){
        double totPizze = this.pizzeOrdinate.stream().mapToDouble(Pizza::getPrezzo).sum();
        double totBevande = this.bevandeOrdinate.stream().mapToDouble(Bevande::getPrezzo).sum();
        //double costoCoperto = prezzoCop * this.numCopertiOrdine;
        return totPizze + totBevande /*+ costoCoperto*/;
    }


    public void printOrdine() {
        System.out.println("\n****** ORDINE ******");
        System.out.println("Numero Ordine: " + this.numeroOrdine);
        System.out.println("Ora Ordinazione: " +this.oraOrdinazione);
        System.out.println("Numero Tavolo: " + this.numTavolo);
        System.out.println("Numero di Coperti: " + this.numCopertiOrdine);
        System.out.println("Pizze Ordinate: ");
        pizzeOrdinate.forEach(System.out::println);
        System.out.println("Bevande Ordinate: " + this.bevandeOrdinate);
        bevandeOrdinate.forEach(System.out::println);
        System.out.println("Totale Coperto: " + this.costoCoperto);
        System.out.println("======== TOTALE ========");
        System.out.println("======== "+ this.getTotale() +" ========");

    }

}
