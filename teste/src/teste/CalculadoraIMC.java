package teste;

/**
 * C�digo inspirado em Beginning Java Programming (2015) - Bart Baesens and
 * Aim�e Backiel Cap�tulo 1
 * 
 * @author Bart Baesens and Aim�e Backiel
 * 
 **/
public class CalculadoraIMC {
	private double peso, altura, imc;

	/**
	 * M�todo respons�vel por construir e inicializar um objeto da classe
	 * <code>CalculadoraIMC</code>.
	 * 
	 * @param peso   recebe o valor inicial do peso.
	 * @param altura recebe o valor inicial da altura.
	 */
	public CalculadoraIMC(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	/**
	 * Calcula o �ndice de Massa Corporal (IMC).
	 */
	public void calcular() {
		imc = peso / (altura * altura);
	}

	/**
	 * Verifica se as condi��es de peso e altura cadastradas configuram situa��o de
	 * sobrepeso.
	 * 
	 * @return verdadeiro se as situa��es de peso e altura configuram sobrepeso.
	 */
	public boolean temSobrepeso() {
		return (imc > 25);
	}

	/**
	 * M�todo de acesso ao atributo IMC.
	 * 
	 * @return valor do IMC.
	 */
	public double getImc() {
		return imc;
	}
}
