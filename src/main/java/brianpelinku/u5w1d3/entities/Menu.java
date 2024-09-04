package brianpelinku.u5w1d3.entities;

import java.util.List;

public class Menu {
    private List<Pizza> pizze;
    private List<Topping> toppings;
    private List<Bevande> bevande;

    public Menu(List<Pizza> pizze, List<Topping> toppings, List<Bevande> bevande) {
        this.pizze = pizze;
        this.toppings = toppings;
        this.bevande = bevande;
    }

    public void printMenu() {
        System.out.println("******* MENU *******");
        System.out.println(" == Pizze == ");
        pizze.forEach(System.out::println);
        System.out.println(" == Topping == ");
        toppings.forEach(System.out::println);
        System.out.println(" == Bevande == ");
        bevande.forEach(System.out::println);
    }

}
