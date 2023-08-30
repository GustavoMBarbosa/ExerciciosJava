package pessoa;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa("Marlon", "12345678900", 20, 'M');
        Pessoa pessoa2 = new Pessoa("Lis", "98765432109", 40, 'F');

        // Exibindo informações das pessoas
        System.out.println("Informações da Pessoa 1:");
        exibirInformacoes(pessoa1);

        System.out.println("\nInformações da Pessoa 2:");
        exibirInformacoes(pessoa2);

	}

	public static void exibirInformacoes(Pessoa pessoa){
		JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome() +
									 "\nCPF: " + pessoa.getCpf() +
									 "\nIdade: " + pessoa.getIdade() + " anos" +
									 "\nSexo: " + pessoa.getSexo());
		
		/*System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCpf());
        System.out.println("Idade: " + pessoa.getIdade() + " anos");
        System.out.println("Sexo: " + pessoa.getSexo());
		*/

        if (pessoa.eMaiorDeIdade()) {
            System.out.println("É maior de idade.");
        } else {
            System.out.println("É menor de idade.");
        }
	}

}
