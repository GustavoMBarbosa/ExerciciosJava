package Datas;

public class Data {
    private int ano;
    private int mes;
    private int dia;

    private static final String[] DIAS_DA_SEMANA = {
        "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
        "Quinta-feira", "Sexta-feira", "Sábado"
    };
    
    private static final int[] DIAS_NO_MES = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public Data(int ano, int mes, int dia) {
        if (ano >= 1900 && mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasNoMes(ano, mes)) {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Data inválida.");
        }
    }

    public Data() {
        this(1900, 1, 1);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void adicionaDias(int dias) {
        for (int i = 0; i < dias; i++) {
            proximoDia();
        }
    }

    public int diasNoMes(int ano, int mes) {
        if (mes == 2 && eAnoBisexto(ano)) {
            return 29;
        }
        return DIAS_NO_MES[mes];
    }

    public String diaDaSemana() {
        int a = (14 - mes) / 12;
        int y = ano - a;
        int m = mes + 12 * a - 2;
        int diaDaSemana = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
        return DIAS_DA_SEMANA[diaDaSemana];
    }

    public boolean eAnoBisexto(int ano) {
        return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
    }

    public void proximoDia() {
        if (dia < diasNoMes(ano, mes)) {
            dia++;
        } else {
            dia = 1;
            if (mes < 12) {
                mes++;
            } else {
                mes = 1;
                ano++;
            }
        }
    }

    public String ExibirDataporExtenso() {
        String nomeMes;
        switch (mes) {
            case 1: nomeMes = "Janeiro"; break;
            case 2: nomeMes = "Fevereiro"; break;
            case 3: nomeMes = "Março"; break;
            case 4: nomeMes = "Abril"; break;
            case 5: nomeMes = "Maio"; break;
            case 6: nomeMes = "Junho"; break;
            case 7: nomeMes = "Julho"; break;
            case 8: nomeMes = "Agosto"; break;
            case 9: nomeMes = "Setembro"; break;
            case 10: nomeMes = "Outubro"; break;
            case 11: nomeMes = "Novembro"; break;
            case 12: nomeMes = "Dezembro"; break;
            default: nomeMes = "Mês inválido"; break;
        }
        return dia + " de " + nomeMes + " de " + ano;
    }
}
