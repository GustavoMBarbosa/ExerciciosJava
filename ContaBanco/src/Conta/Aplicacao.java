package Conta;




public class Aplicacao {

	public static void main(String[] args) {
		// Criando instâncias da classe Conta
        Conta conta1 = new Conta("Marlon", 1000.0);
        Conta conta2 = new Conta("Lis", 1500.0);

        // Exibindo informações das contas
        System.out.println("Informações da Conta 1:");
        conta1.exibirInformacoes();
        System.out.println();

        System.out.println("Informações da Conta 2:");
        conta2.exibirInformacoes();
        System.out.println();

        
        conta1.depositar(500.0);
        conta2.sacar(300.0);

        // Exibindo informações atualizadas
        System.out.println("Informações da Conta 1 após depósito:");
        conta1.exibirInformacoes();
        System.out.println();

        System.out.println("Informações da Conta 2 após saque:");
        conta2.exibirInformacoes();
	}

}
