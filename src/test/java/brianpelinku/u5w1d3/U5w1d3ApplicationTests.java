package brianpelinku.u5w1d3;

import brianpelinku.u5w1d3.entities.Pizza;
import brianpelinku.u5w1d3.entities.Tavolo;
import brianpelinku.u5w1d3.entities.Topping;
import brianpelinku.u5w1d3.enums.StatoTavolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5w1d3ApplicationTests {
	private static AnnotationConfigApplicationContext context;



	/*@BeforeEach
	void beforeEach(){
		System.out.println("BEFORE EACH");
	}

	@AfterEach
	void afterEach(){
		System.out.println("BEFORE EACH");
	}*/

	@BeforeAll
    static void beforeAll(){
		System.out.println("BEFORE ALL");
		context = new AnnotationConfigApplicationContext(U5w1d3Application.class);
	}

	@AfterAll
	static void afterAll(){
		System.out.println("AFTER ALL");
	}

	// verifica creazione pizza margherita
	@Test
	void testPizzaMargherita(){
		Pizza pizzaMargherita = (Pizza) context.getBean("pizza_margherita");
		assertEquals("Pizza Margherita", pizzaMargherita.getNome());
	}

	// verifica creazione tavolo
	@Test
	void testCreaTavolo(){
		Tavolo tavolo1 = (Tavolo) context.getBean("tavolo1");

		assertEquals(1, tavolo1.getNumTavolo());
		assertEquals(10, tavolo1.getMaxCoperti());
		assertEquals(StatoTavolo.LIBERO, tavolo1.getStatoTavolo());
		assertEquals(2.5, tavolo1.getCostoCoperto());
	}

	// verifica cambio stato tavolo
	@Test
	void testCambioStatoTavolo(){
		Tavolo tavolo = (Tavolo) context.getBean("tavolo1");

		assertEquals(StatoTavolo.LIBERO, tavolo.getStatoTavolo());

		tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
		assertEquals(StatoTavolo.OCCUPATO, tavolo.getStatoTavolo());
	}

	// verifica calcolo kcal pizza
	@ParameterizedTest
	@CsvSource({"pizza_margherita,1400"})
	void testCalcoloKcal(String pizzaMargherita, int kCal){

		Pizza pizza= (Pizza) context.getBean(pizzaMargherita);
		assertEquals(kCal, pizza.getKcal());
	}

	// verifica calcolo prezzo pizza
	@ParameterizedTest
	@CsvSource({"pizza_bufalotta,10.5"})
	void testCalcoloPrezzo(String pizzaBufalotta, double prezzo){

		Pizza pizza = (Pizza) context.getBean(pizzaBufalotta);
		assertEquals(prezzo, pizza.getPrezzo());
	}




}
