package Exercicio9;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcularDiaSemana {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Use o formato dd/MM/yyyy");
        String DataTeclado = sc.nextLine(); // data no formato "dd/MM/yyyy"
        try {
            Date data = formato.parse(DataTeclado);
            int ano = 2024; // Ano desejado

            String diaDaSemana = CalcularDiaDaSemana(data, ano);

            System.out.println(formatoData(data) + " em " + ano + " será " + diaDaSemana);
        } catch (Exception e) {
            System.out.println("Formato inválido, use o formato dd/MM/yyyy.");
        }
        sc.close();
    }

    public static String CalcularDiaDaSemana(Date data, int ano) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        calendario.set(Calendar.YEAR, ano);

        int diaDaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        String[] diasDaSemana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};

        return diasDaSemana[diaDaSemana - 1];
    }

    public static String formatoData(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
}

