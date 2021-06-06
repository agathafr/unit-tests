package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import nutricao.CalculosNecessidadeEnergetica;
import nutricao.IdadeException;

public class CalculosNecessidadeEnergeticaTeste {
	CalculosNecessidadeEnergetica necessidadeEnergetica;
	IdadeException idadeException;

	@Before
	public void setUp() {
		necessidadeEnergetica = new CalculosNecessidadeEnergetica();
		idadeException = new IdadeException(null);
	}

	@Test
	public void testCalculaTaxaMetabolicaBasalMulher() throws IdadeException {
		assertEquals("Caso 1", 1478.0, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(17, 60.0), 0.01);
		assertEquals("Caso 2", 1583.8, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(18, 74.0), 0.01);
		assertEquals("Caso 3", 1438.0, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(30, 70.0), 0.01);
		assertEquals("Caso 4", 1278.5, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(60, 65.0), 0.01);
		assertEquals("Caso 5", 1446.5, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(61, 81.0), 0.01);
	}

	@Test(expected = IdadeException.class)
	public void testCalculaTaxaMetabolicaBasalMulherIdadeMenorQueDez() throws IdadeException {
		assertEquals("Caso 6", 0, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(9, 50.0), 0.01);
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaTaxaMetabolicaBasalMulherIdadeNegativa() throws IdadeException {
		assertEquals("Caso 6", 0, necessidadeEnergetica.calculaTaxaMetabolicaBasalMulher(-1, 62.0), 0.01);
	}

	@Test
	public void testCalculaTaxaMetabolicaBasalHomem() throws IdadeException {
		assertEquals("Caso 7", 2051.0, necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(17, 80.0), 0.01);
		assertEquals("Caso 8", 1673.5, necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(18, 65.0), 0.01);
		assertEquals("Caso 9", 1505.4, necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(30, 72.0), 0.01);
		assertEquals("Caso 10", 1418.5, necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(60, 69.0), 0.01);
		assertEquals("Caso 11", 1283.5, necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(61, 59.0), 0.01);
	}

	@Test(expected = IdadeException.class)
	public void testCalculaTaxaMetabolicaBasalHomemIdadeMenorQueDez() throws IdadeException {
		assertEquals(idadeException.getMessage(), necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(7, 50.0));
	}
	
	@Test(expected = IdadeException.class)
	public void testCalculaTaxaMetabolicaBasalHomemIdadeNegativa() throws IdadeException {
		assertEquals(idadeException.getMessage(), necessidadeEnergetica.calculaTaxaMetabolicaBasalHomem(-1, 82.0));
	}

	@Test
	public void testSetFatorAtividadeMulher() {
		assertEquals("Caso 13", 1.2, necessidadeEnergetica.setFatorAtividadeMulher(1), 0.01);
		assertEquals("Caso 14", 1.3, necessidadeEnergetica.setFatorAtividadeMulher(2), 0.01);
		assertEquals("Caso 15", 1.45, necessidadeEnergetica.setFatorAtividadeMulher(3), 0.01);
		assertEquals("Caso 16", 1.5, necessidadeEnergetica.setFatorAtividadeMulher(4), 0.01);
		assertEquals("Caso 17", 1.7, necessidadeEnergetica.setFatorAtividadeMulher(5), 0.01);
		assertEquals("Caso 18", 0, necessidadeEnergetica.setFatorAtividadeMulher(6), 0.01);
	}

	@Test
	public void testSetFatorAtividadeHomem() {
		assertEquals("Caso 19", 1.2, necessidadeEnergetica.setFatorAtividadeHomem(1), 0.01);
		assertEquals("Caso 20", 1.4, necessidadeEnergetica.setFatorAtividadeHomem(2), 0.01);
		assertEquals("Caso 21", 1.5, necessidadeEnergetica.setFatorAtividadeHomem(3), 0.01);
		assertEquals("Caso 22", 1.6, necessidadeEnergetica.setFatorAtividadeHomem(4), 0.01);
		assertEquals("Caso 23", 1.8, necessidadeEnergetica.setFatorAtividadeHomem(5), 0.01);
		assertEquals("Caso 24", 0, necessidadeEnergetica.setFatorAtividadeHomem(6), 0.01);
	}

	@Test
	public void testCalculaNecessidadeEnergeticaMulher() throws IdadeException {
		assertEquals("Caso 25", 1773.6, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(17, 60.0, 1), 0.01);
		assertEquals("Caso 26", 2058.94, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(18, 74.0, 2), 0.01);
		assertEquals("Caso 27", 2085.1, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(30, 70.0, 3), 0.01);
		assertEquals("Caso 28", 1917.75, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(60, 65.0, 4), 0.01);
		assertEquals("Caso 29", 2459.05, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(61, 81.0, 5), 0.01);
		assertEquals("Caso 30", 0, necessidadeEnergetica.calculaNecessidadeEnergeticaMulher(75, 62.0, 6), 0.01);
	}

	@Test
	public void testCalculaNecessidadeEnergeticaHomem() throws IdadeException {
		assertEquals("Caso 31", 2461.2, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(17, 80.0, 1), 0.01);
		assertEquals("Caso 32", 2342.9, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(18, 65.0, 2), 0.01);
		assertEquals("Caso 33", 2258.1, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(30, 72.0, 3), 0.01);
		assertEquals("Caso 34", 2269.6, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(60, 69.0, 4), 0.01);
		assertEquals("Caso 35", 2310.3, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(61, 59.0, 5), 0.01);
		assertEquals("Caso 36", 0, necessidadeEnergetica.calculaNecessidadeEnergeticaHomem(80, 60.0, 6), 0.01);
	}

}
