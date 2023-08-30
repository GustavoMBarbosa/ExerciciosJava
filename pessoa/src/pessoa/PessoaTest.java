package pessoa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaTest {

	private Pessoa pessoa;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//criar pessoa pra cada teste
		pessoa = new Pessoa("Marlon", "12345678901", 20, 'M');
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		assertEquals("Marlon",pessoa.getNome());
		assertEquals("12345678901",pessoa.getCpf());
		assertEquals(20,pessoa.getIdade());
		assertEquals('M',pessoa.getSexo());
	}
	
	@Test
	public void testSet(){
		pessoa.setNome("Lis");
		pessoa.setCpf("98765432109");
		pessoa.setIdade(40);
		pessoa.setSexo('F');

		assertEquals("Lis",pessoa.getNome());
		assertEquals("98765432109",pessoa.getCpf());
		assertEquals(40,pessoa.getIdade());
		assertEquals('F',pessoa.getSexo());

	}

	@Test
	public void testMaiorIdade(){
		assertTrue(pessoa.eMaiorDeIdade());

		//teste com menor de idade
		Pessoa menorIdade = new Pessoa("Pedro", "11111111111", 16, 'M');
		assertFalse(menorIdade.eMaiorDeIdade());
	}

}
