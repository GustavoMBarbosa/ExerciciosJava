package teste;

import javax.swing.JOptionPane;

public class Aplicacao {

	/**
	 * A Classe JOptionPane � capaz de exibir caixas de di�logo. 
	 * O m�todo <code>JOptionPane.showInputDialog(mensagem)</code> cria uma
	 * caixa de entrada que � capaz de ler um texto do usu�rio.
	 * 
	 *  O m�todo <code>Double.parseDouble</code> converte a String lida em 
	 *  um n�mero no formato double. 
	 */
	public static void main(String[] args) {

		double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso: "));

		double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));
		
		CalculadoraIMC calcImc = new CalculadoraIMC(peso, altura);

		calcImc.calcular();
		JOptionPane.showMessageDialog(null, "O IMC e: " + calcImc.getImc());

		if (calcImc.temSobrepeso()) {
			JOptionPane.showMessageDialog(null, "Tem sobrepeso.");
		}

	}

}
