package calculadora;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@DisplayName("Inicializando classe para teste da calculadora")
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa divisão por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa divisão por zero com Assert Throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(5, 5);		
		Assertions.assertEquals(0, sub);		
	}
	
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int mult = calc.multiplicacao(5, 5);		
		Assertions.assertEquals(25, mult);		
	}
	
	@DisplayName("Testa a somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);		
		Assertions.assertEquals(15, somatoria);		
	}
	
	@DisplayName("Testa ehpositivo") //valor positivo
	@Test
	public void testEhpositivoNumeroPositivo() {
		boolean ehpositivo = calc.ehPositivo(5);		
		assertTrue(ehpositivo);
		assertFalse(ehpositivo); //Failures
		
	}
	
	@DisplayName("Testa ehpositivo") //valor negativo
	@Test
	public void testEhpositivoNumeroNegativo() {
		boolean ehpositivo = calc.ehPositivo(-8);		
		assertFalse(ehpositivo);
		assertTrue(ehpositivo); //Failures
	}
	
	
	@DisplayName("Testa compara")
	@Test
	public void testComparaDoisNumeros() {
		int compara = calc.compara(5, 5);		
		Assertions.assertEquals(0, compara);	
	}
}
