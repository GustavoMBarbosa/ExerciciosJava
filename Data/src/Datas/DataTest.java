package Datas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataTest {
	
	private Data data;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() {
        data = new Data(2023, 8, 28);
    }

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testConstrutorData() {
        assertEquals(2023, data.getAno());
        assertEquals(8, data.getMes());
        assertEquals(28, data.getDia());
    }

    @Test
    public void testConstrutorPadrao() {
        Data dataPadrao = new Data();
        assertEquals(1, dataPadrao.getDia());
        assertEquals(1, dataPadrao.getMes());
        assertEquals(1900, dataPadrao.getAno());
    }

    @Test
    public void testAdicionaDias() {
        data.adicionaDias(5);
        assertEquals(2023, data.getAno());
        assertEquals(9, data.getMes());
        assertEquals(2, data.getDia());
    }

    @Test
    public void testDiasNoMes() {
        assertEquals(31, data.diasNoMes(data.getAno(),data.getMes()));
    }

    @Test
    public void testDiaDaSemana() {
        assertEquals("Segunda-feira", data.diaDaSemana());
    }

    @Test
    public void testEAnoBissexto() {
        assertFalse(data.eAnoBisexto(data.getAno()));
    }

    @Test
    public void testProximoDia() {
        data.proximoDia();
        assertEquals(29, data.getDia());
    }

    @Test
    public void testExibirDataPorExtenso() {
        assertEquals("28 de Agosto de 2023", data.ExibirDataporExtenso());
    }

}
