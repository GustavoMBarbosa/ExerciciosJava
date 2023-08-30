package Datas;

public class Aplicacao {
    public static void main(String[] args) {
        // Criando uma instância da classe Data
        Data data = new Data(2023, 8, 28);

        System.out.println("Data Inicial:");
        exibirInformacoesData(data);
        System.out.println();

        data.adicionaDias(5);

        System.out.println("Data Após Adicionar 5 Dias:");
        exibirInformacoesData(data);
        System.out.println();

        System.out.println("Dia da Semana da Data:");
        System.out.println(data.diaDaSemana());
        System.out.println();

        System.out.println("É um Ano Bissexto?");
        System.out.println(data.eAnoBisexto(data.getAno()));
        System.out.println();

        System.out.println("Data Completa:");
        System.out.println(data.ExibirDataporExtenso());
    }

    public static void exibirInformacoesData(Data data) {
        System.out.println("Dia: " + data.getDia());
        System.out.println("Mês: " + data.getMes());
        System.out.println("Ano: " + data.getAno());
    }
}

