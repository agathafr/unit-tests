package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nutricao.CalculosPesoIdeal;
import nutricao.IdadeException;

public class CalculosPesoIdealTeste {
	CalculosPesoIdeal pesoIdeal;

	@Before
	public void setUp() {
		pesoIdeal = new CalculosPesoIdeal();
	}

	@Test
	public void testCalculaIMC() {
		assertEquals("Caso 1:", 14.91, pesoIdeal.calculaIMC(50.5, 1.84), 0.1);
		assertEquals("Caso 2:", 22.86, pesoIdeal.calculaIMC(60.0, 1.62), 0.1);
		assertEquals("Caso 3:", 26.82, pesoIdeal.calculaIMC(81.0, 1.74), 0.1);
		assertEquals("Caso 4:", 39.22, pesoIdeal.calculaIMC(105.5, 1.64), 0.1);
		assertEquals("Caso 5:", 45.09, pesoIdeal.calculaIMC(114.0, 1.59), 0.1);

	}

	@Test
	public void testCalculaPesoIdealCrianca() throws IdadeException {
		assertEquals("Caso 7:", 15, pesoIdeal.calculaPesoIdealCrianca(3));
		assertEquals("Caso 6:", 29, pesoIdeal.calculaPesoIdealCrianca(10));
	}

	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealCriancaIdadeNegativa() throws IdadeException {
		assertEquals("Caso 35:", 0, pesoIdeal.calculaPesoIdealCrianca(-1));

	}

	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealCriancaIdadeMenorQueTres() throws IdadeException {
		assertEquals("Caso 8:", 13, pesoIdeal.calculaPesoIdealCrianca(2));
		assertEquals("Caso 9:", 31, pesoIdeal.calculaPesoIdealCrianca(11));
	}

	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealCriancaIdadeMaiorQueDez() throws IdadeException {
		assertEquals("Caso 9:", 31, pesoIdeal.calculaPesoIdealCrianca(11));
	}

	@Test
	public void testCalculaPesoIdealMulherAdulta() throws IdadeException {
		assertEquals("Caso 10:", 53.76, pesoIdeal.calculaPesoIdealMulherAdulta(1.60, 18), 0.1);
		assertEquals("Caso 11:", 69.56, pesoIdeal.calculaPesoIdealMulherAdulta(1.82, 64), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealMulherAdultaIdadeNegativa() throws IdadeException {
		assertEquals("Caso 10:", 0, pesoIdeal.calculaPesoIdealMulherAdulta(1.64, -1), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealMulherAdultaIdadeMaiorQue64() throws IdadeException {
		assertEquals("Caso 12:", 0, pesoIdeal.calculaPesoIdealMulherAdulta(1.90, 65), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealMulherAdultaIdadeMenorQue18() throws IdadeException {
		assertEquals("Caso 13:", 0, pesoIdeal.calculaPesoIdealMulherAdulta(1.72, 17), 0.1);
	}

	@Test
	public void testCalculaPesoIdealHomemAdulto() throws IdadeException {
		assertEquals("Caso 14:", 66.60, pesoIdeal.calculaPesoIdealHomemAdulto(1.74, 18), 0.1);
		assertEquals("Caso 15:", 63.58, pesoIdeal.calculaPesoIdealHomemAdulto(1.70, 64), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealHomemAdultoIdadeMaiorQue64() throws IdadeException {
		assertEquals("Caso 17:", 0, pesoIdeal.calculaPesoIdealHomemAdulto(1.65, 65), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealHomemAdultoIdadeMenorQue18() throws IdadeException {
		assertEquals("Caso 16:", 0, pesoIdeal.calculaPesoIdealHomemAdulto(1.83, 17), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealHomemAdultoIdadeNegativa() throws IdadeException {
		assertEquals("Caso 16:", 0, pesoIdeal.calculaPesoIdealHomemAdulto(1.72, -1), 0.1);
	}

	@Test
	public void testCalculaPesoIdealHomemIdoso() throws IdadeException {
		assertEquals("Caso 18:", 87.72, pesoIdeal.calculaPesoIdealHomemIdoso(69, 1.90), 0.1);
		assertEquals("Caso 19:", 83.14, pesoIdeal.calculaPesoIdealHomemIdoso(74, 1.82), 0.1);
		assertEquals("Caso 20:", 74.03, pesoIdeal.calculaPesoIdealHomemIdoso(78, 1.76), 0.1);
		assertEquals("Caso 21:", 63.74, pesoIdeal.calculaPesoIdealHomemIdoso(80, 1.64), 0.1);
		assertEquals("Caso 22:", 57.66, pesoIdeal.calculaPesoIdealHomemIdoso(92, 1.58), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealHomemIdosoIdadeMenorQue65() throws IdadeException {
		assertEquals("Caso 23:", 0, pesoIdeal.calculaPesoIdealHomemIdoso(64, 1.58), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealHomemIdosoIdadeNegativa() throws IdadeException {
		assertEquals("Caso 23:", 0, pesoIdeal.calculaPesoIdealHomemIdoso(-1, 1.98), 0.1);
	}

	@Test
	public void testCalculaPesoIdealMulherIdosa() throws IdadeException {
		assertEquals("Caso 24:", 80.23, pesoIdeal.calculaPesoIdealMulherIdosa(65, 1.74), 0.1);
		assertEquals("Caso 25:", 69.02, pesoIdeal.calculaPesoIdealMulherIdosa(70, 1.62), 0.1);
		assertEquals("Caso 26:", 84.56, pesoIdeal.calculaPesoIdealMulherIdosa(75, 1.80), 0.1);
		assertEquals("Caso 27:", 60.47, pesoIdeal.calculaPesoIdealMulherIdosa(80, 1.54), 0.1);
		assertEquals("Caso 28:", 67.40, pesoIdeal.calculaPesoIdealMulherIdosa(90, 1.69), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealMulherIdosaIdadeMenorQue65() throws IdadeException {
		assertEquals("Caso 29:", 0, pesoIdeal.calculaPesoIdealMulherIdosa(64, 1.58), 0.1);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaPesoIdealMulherIdosaIdadeNegativa() throws IdadeException {
		assertEquals("Caso 29:", 0, pesoIdeal.calculaPesoIdealMulherIdosa(-1, 1.78), 0.1);
	}

	@Test
	public void testClassificacao() {
		assertTrue("Caso 30:", pesoIdeal.classificaPeso(50.5, 1.84).equals("Abaixo do peso"));
		assertTrue("Caso 31:", pesoIdeal.classificaPeso(60.0, 1.62).equals("Peso normal"));
		assertTrue("Caso 32:", pesoIdeal.classificaPeso(81.0, 1.74).equals("Sobrepeso"));
		assertTrue("Caso 33:", pesoIdeal.classificaPeso(105.5, 1.64).equals("Obeso"));
		assertTrue("Caso 34:", pesoIdeal.classificaPeso(114.0, 1.59).equals("Obeso mórbido"));
	}
}
