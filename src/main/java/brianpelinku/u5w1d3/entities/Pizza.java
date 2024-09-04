package brianpelinku.u5w1d3.entities;

import lombok.Setter;

import java.util.List;

public class Pizza {
    @Setter
    private String nome;
    private double kcal;
    private double prezzo;
    @Setter
    private List<Topping> listaTopping;

    // costruttori
    public Pizza() {
    }

    public Pizza(String nome, List<Topping> listaTopping) {
        this.nome = nome;
        this.kcal = setKcal(listaTopping);
        this.prezzo = setPrezzo(listaTopping);
        this.listaTopping = listaTopping;
    }

    // getter e setter
    public String getNome() {
        return nome;
    }

    public double getKcal() {
        return kcal;
    }

    public int setKcal(List<Topping> listaTopping) {
        int tot = 1200;
        if (listaTopping != null) {
            for (Topping topping : listaTopping) {
                tot += topping.getKcal();
            }
        }
        return tot;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double setPrezzo(List<Topping> listaTopping) {
        double tot = 4.5;
        if (listaTopping != null) {
            for (Topping topping : listaTopping) {
                tot += topping.getPrezzo();
            }
        }
        return tot;
    }

    public List<Topping> getListaTopping() {
        return listaTopping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nome='" + nome + '\'' +
                ", kcal=" + kcal +
                ", prezzo=" + prezzo +
                ", listaTopping=" + listaTopping/*.stream().map(Object::toString).toList()*/ +
                '}';
    }
}
