package brianpelinku.u5w1d3.configurations;

import brianpelinku.u5w1d3.entities.*;
import brianpelinku.u5w1d3.enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class PizzaConfig {

    // toppings
    @Bean
    public Topping pomodoto() {
        return new Topping("Pomodoro", 100, 0);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 100, 0);
    }

    @Bean
    public Topping salsiccia() {
        return new Topping("salsiccia", 100, 2.5);
    }

    @Bean
    public Topping salamePiccante() {
        return new Topping("Salame piccante", 100, 2);
    }

    @Bean
    public Topping mozzarellaBufala() {
        return new Topping("Mozzarella di bufala", 100, 3.5);

    }

    @Bean
    public Topping prosciuttoCrudo() {
        return new Topping("Prosciutto crudo", 100, 2.5);
    }

    // pizze
    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargherita() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        return new Pizza("Pizza Margherita", toppingList);
    }

    @Bean(name = "pizza_prosciutto")
    public Pizza pizzaProsciutto() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(prosciuttoCrudo());
        return new Pizza("Pizza col prosciutto crudo", toppingList);
    }

    @Bean(name = "pizza_piccantina")
    public Pizza pizzaPiccantina() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(salamePiccante());
        return new Pizza("Pizza Piccantina", toppingList);
    }

    @Bean(name = "pizza_diavolina")
    public Pizza pizzaDiavolina() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(salamePiccante());
        toppingList.add(salsiccia());
        return new Pizza("Pizza Diavolina", toppingList);
    }

    @Bean(name = "pizza_bufalotta")
    public Pizza pizzaBufalotta() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarellaBufala());
        toppingList.add(pomodoto());
        toppingList.add(prosciuttoCrudo());
        return new Pizza("Pizza Bufalotta", toppingList);
    }

    // bevande
    @Bean(name = "acqua_naturale")
    public Bevande acquaNat() {
        return new Bevande("Acqua naturale", 0, 2);
    }

    @Bean(name = "acqua_frizzante")
    public Bevande acquaNFriz() {
        return new Bevande("Acqua frizzante", 0, 2);
    }

    @Bean(name = "coca_cola")
    public Bevande cocaCola() {
        return new Bevande("Cocacola", 0, 4);
    }

    @Bean(name = "birra")
    public Bevande birra() {
        return new Bevande("Birra", 0, 4.5);
    }

    @Bean(name = "vino")
    public Bevande vino() {
        return new Bevande("vino", 0, 5);
    }

    @Bean
    public Menu menu() {
        List<Pizza> pizze = new ArrayList<>();
        List<Bevande> bevande = new ArrayList<>();
        List<Topping> toppings = new ArrayList<>();

        pizze.add(pizzaMargherita());
        pizze.add(pizzaBufalotta());
        pizze.add(pizzaProsciutto());
        pizze.add(pizzaDiavolina());
        pizze.add(pizzaPiccantina());

        toppings.add(pomodoto());
        toppings.add(mozzarella());
        toppings.add(mozzarellaBufala());
        toppings.add(prosciuttoCrudo());
        toppings.add(salsiccia());
        toppings.add(salamePiccante());

        bevande.add(acquaNat());
        bevande.add(acquaNFriz());
        bevande.add(cocaCola());
        bevande.add(birra());
        bevande.add(vino());

        return new Menu(pizze, toppings, bevande);
    }

    @Bean(name = "tavolo1")
    @Primary
    Tavolo getTavolo1(@Value("${prezzo.coperto}") double prezzoCoperto){
        return new Tavolo(1,10, StatoTavolo.LIBERO,prezzoCoperto);
    }

    @Bean(name = "tavolo2")
    Tavolo getTavolo2(@Value("${prezzo.coperto}") double prezzoCoperto){
        return new Tavolo(2, 6, StatoTavolo.LIBERO, prezzoCoperto);
    }

    /*@Bean
    Ordine ordine1(){
        List<Pizza> pizzeOrdinate = new ArrayList<>();
        List<Bevande> bevande = new ArrayList<>();

        pizzeOrdinate.add(pizzaPiccantina());
        pizzeOrdinate.add(pizzaPiccantina());
        pizzeOrdinate.add(pizzaDiavolina());

        bevande.add(vino());
        bevande.add(birra());
        bevande.add(acquaNFriz());

        return new Ordine(3, getTavolo1(2));
    }*/
    /*@Bean
    private double getCostoCoperto(@Value("${prezzo.coperto}")double costoCoperto, int numCoperti){
        double tot;
        tot = costoCoperto * numCoperti;
        return tot;
    }*/


    /*@Bean
    private Ordine ordineTavolo1(){
        List<Pizza> pizzeOrdinate = new ArrayList<>();
        List<Bevande> bevandeOrdinate = new ArrayList<>();

        pizzeOrdinate.add(pizzaMargherita());
        pizzeOrdinate.add(pizzaProsciutto());
        pizzeOrdinate.add(pizzaPiccantina());

        bevandeOrdinate.add(birra());
        bevandeOrdinate.add(birra());
        bevandeOrdinate.add(acquaNFriz());

        //double totCoperto = getCostoCoperto(Double.parseDouble("prezzo.coperto"), 3);

        return new Ordine(pizzeOrdinate,bevandeOrdinate, 3);

    }*/

}
