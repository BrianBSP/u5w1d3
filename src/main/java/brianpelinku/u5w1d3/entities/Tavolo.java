package brianpelinku.u5w1d3.entities;

import brianpelinku.u5w1d3.enums.StatoTavolo;

public class Tavolo {
    private int numTavolo;
    private int maxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;

    public Tavolo(int numTavolo, int maxCoperti, StatoTavolo statoTavolo, double costoCoperto) {
        this.numTavolo = numTavolo;
        this.maxCoperti = maxCoperti;
        this.statoTavolo = statoTavolo;
        this.costoCoperto = costoCoperto;
    }

    public int getNumTavolo() {
        return numTavolo;
    }

    public void setNumTavolo(int numTavolo) {
        this.numTavolo = numTavolo;
    }

    public int getMaxCoperti() {
        return maxCoperti;
    }

    public void setMaxCoperti(int maxCoperti) {
        this.maxCoperti = maxCoperti;
    }

    public StatoTavolo getStatoTavolo() {
        return statoTavolo;
    }

    public void setStatoTavolo(StatoTavolo statoTavolo) {
        this.statoTavolo = statoTavolo;
    }

    public double getCostoCoperto() {
        return costoCoperto;
    }

    public void setCostoCoperto(double costoCoperto) {
        this.costoCoperto = costoCoperto;
    }

    public void printTavolo(){
        System.out.println("****** TAVOLO ******");
        System.out.println("Numero tavolo: " + this.numTavolo);
        System.out.println("Numero massimo di coperti: " + this.maxCoperti);
        System.out.println("Occupato/Libero " + this.statoTavolo);
    }
}
