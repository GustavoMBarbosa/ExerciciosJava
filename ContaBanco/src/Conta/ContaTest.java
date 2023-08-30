package Conta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
    public void setUp() {
        conta = new Conta("Marlon", 1000.0);
    }

	@AfterEach
	void tearDown() throws Exception {
	}

	private Conta conta;

    @Test
    public void testGetNumeroConta() {
        int numeroConta = conta.getNumeroConta();
        assertTrue(numeroConta > 0);
    }

    @Test
    public void testGetSaldo() {
        double saldo = conta.getSaldo();
        assertEquals(1000.0, saldo, 0.01);
    }

    @Test
    public void testGetTitular() {
        String titular = conta.getTitular();
        assertEquals("Marlon", titular);
    }

    @Test
    public void testDepositar() {
        conta.depositar(500.0);
        assertEquals(1500.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testDepositarValorInvalido() {
        conta.depositar(-100.0);
        assertEquals(1000.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testSacar() {
        conta.sacar(500.0);
        assertEquals(500.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testSacarValorInvalido() {
        conta.sacar(-100.0);
        assertEquals(1000.0, conta.getSaldo(), 0.01);
    }

    @Test
    public void testSacarSaldoInsuficiente() {
        conta.sacar(1500.0);
        assertEquals(1000.0, conta.getSaldo(), 0.01);
    }

}
