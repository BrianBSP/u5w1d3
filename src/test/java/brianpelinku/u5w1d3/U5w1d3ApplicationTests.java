package brianpelinku.u5w1d3;

import brianpelinku.u5w1d3.entities.Pizza;
import brianpelinku.u5w1d3.entities.Tavolo;
import brianpelinku.u5w1d3.entities.Topping;
import brianpelinku.u5w1d3.enums.StatoTavolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5w1d3ApplicationTests {

	@BeforeEach
	void beforeEach(){
		System.out.println("BEFORE EACH");
	}

	@AfterEach
	void afterEach(){
		System.out.println("BEFORE EACH");
	}

	@BeforeAll
    static void beforeAll(){
		System.out.println("BEFORE ALL");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("AFTER ALL");
	}

	// verifica creazione pizza
	@Test
	void testCreazionePizza(){
		Topping mozzarella = new Topping("mozzarella", 200, 2);
		Topping pomodoro = new Topping("pomodoro", 200, 1.5);

		Pizza pizza = new Pizza("Pizza Margherita", Arrays.asList(mozzarella, pomodoro));

		assertEquals("Pizza Margherita", pizza.getNome());
		assertEquals(1600, pizza.getKcal());
		assertEquals(8, pizza.getPrezzo());
	}

	// verifica creazione tavolo
	@Test
	void testCreaTavolo(){
		Tavolo tavolo1 = new Tavolo(1, 10, StatoTavolo.LIBERO, 2);

		assertEquals(1, tavolo1.getNumTavolo());
		assertEquals(10, tavolo1.getMaxCoperti());
		assertEquals(StatoTavolo.LIBERO, tavolo1.getStatoTavolo());
		assertEquals(2, tavolo1.getCostoCoperto());
	}

	// verifica cambio stato tavolo
	@Test
	void testCambioStatoTavolo(){
		Tavolo tavolo = new Tavolo(2,5,StatoTavolo.LIBERO,2.5);

		assertEquals(StatoTavolo.LIBERO, tavolo.getStatoTavolo());

		tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
		assertEquals(StatoTavolo.OCCUPATO, tavolo.getStatoTavolo());
	}

	// verifica calcolo kcal pizza
	@ParameterizedTest
	@CsvSource({"mozzarella,pomodoro,1600"})
	void testCalcoloKcal(String topping1, String topping2, int kCal){
		Topping t1 = new Topping(topping1, 200,2);
		Topping t2 = new Topping(topping2, 200, 3);

		Pizza pizza =new Pizza("Pizza Test", Arrays.asList(t1,t2));
		assertEquals(kCal, pizza.getKcal());
	}

	// verifica calcolo prezzo pizza
	@ParameterizedTest
	@CsvSource({"mozzarella,pomodoro,8"})
	void testCalcoloPrezzo(String topping1, String topping2, double prezzo){
		Topping t1 = new Topping(topping1, 200,2);
		Topping t2 = new Topping(topping2, 200, 1.5);

		Pizza pizza =new Pizza("Pizza Test", Arrays.asList(t1,t2));
		assertEquals(prezzo, pizza.getPrezzo());
	}




}
