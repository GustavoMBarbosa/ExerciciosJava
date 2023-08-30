package exercicio11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class atividade11 {
    public static String dataMaisAntiga = "31/12/9999";
    public static String dataMaisNova = "01/01/0000";
    /** 
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner leitor = new Scanner(new File("exercicio11\\escrita.txt"));
        //Scanner leitor = new Scanner(System.in);
        String data = "";
        while(!data.equals("FIM")){  
            while(leitor.hasNextLine()){
                data = leitor.nextLine();
                if(!data.equals("FIM")){
                System.out.println(datavalida(data));
                }
            }
        }
        leitor.close();

    }

    
    /** 
     * @param data1 data sendo comparada no momento
     * @param data2 a menor data registrada no programa
     * @return int retorna um valor inteiro que se for menor que 0 a menor data e alterada para nova menor nada
     */
    public static int MenorData(String data1, String data2) {
        String[] detalhes1 = data1.split("/");
        String[] detalhes2 = data2.split("/");

        int dia1 = Integer.parseInt(detalhes1[0]);
        int mes1 = Integer.parseInt(detalhes1[1]);
        int ano1 = Integer.parseInt(detalhes1[2]);

        int dia2 = Integer.parseInt(detalhes2[0]);
        int mes2 = Integer.parseInt(detalhes2[1]);
        int ano2 = Integer.parseInt(detalhes2[2]);

        if (ano1 < ano2) {
            return -1;
        } else if (ano1 > ano2) {
            return 1;
        } else {
            if (mes1 < mes2) {
                return -1;
            } else if (mes1 > mes2) {
                return 1;
            } else {
                if (dia1 < dia2) {
                    return -1;
                } else if (dia1 > dia2) {
                    return 1;
                } else {
                    return 0; // Datas são iguais
                }
            }
        }
    }

    /** 
     * @param data1 data sendo comparada no momento
     * @param data2 a maior data registrada no programa
     * @return int retorna um valor inteiro que se for maior que 0 a maior data e alterada para nova maior nada
     */

    public static int MaiorData(String data1, String data2) {
        String[] detalhes1 = data1.split("/");
        String[] detalhes2 = data2.split("/");

        int dia1 = Integer.parseInt(detalhes1[0]);
        int mes1 = Integer.parseInt(detalhes1[1]);
        int ano1 = Integer.parseInt(detalhes1[2]);

        int dia2 = Integer.parseInt(detalhes2[0]);
        int mes2 = Integer.parseInt(detalhes2[1]);
        int ano2 = Integer.parseInt(detalhes2[2]);

        if (ano1 < ano2) {
            return -1;
        } else if (ano1 > ano2) {
            return 1;
        } else {
            if (mes1 < mes2) {
                return -1;
            } else if (mes1 > mes2) {
                return 1;
            } else {
                if (dia1 < dia2) {
                    return -1;
                } else if (dia1 > dia2) {
                    return 1;
                } else {
                    return 0; // Datas são iguais
                }
            }
        }
    }
    

    static int[] diasdomes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    
    /** 
     * @param data data sendo comparada no momento
     * @return String retorna a mensagem dependendo se a data e válida ou não
     */
    public static String datavalida(String data){
        String resposta="Data valida";
        String[] detalhes = data.split("/");
        if(detalhes.length!=3 || data.length()!=10) {
            System.out.println("Data em formato incorreto, alterando para 01/01/1900");
            data = "01/01/1900";
            detalhes = data.split("/");
        }

        int dia = Integer.parseInt(detalhes[0]);
        int mes = Integer.parseInt(detalhes[1]);
        int ano = Integer.parseInt(detalhes[2]); 
        
        int maxdia;

        

        if (ano<1900){
        resposta = "Ano invalido: apenas 1900 para frente alterando para 01/01/1900";
        data = "01/01/1900";
        }
        else if(mes>12){
            resposta = "mes invalido: ate 12 meses alterando para 01/01/1900";
            data = "01/01/1900";
        }
        else{
            maxdia = diasdomes[mes];
            if(anoBissexto(ano)&&mes==2){
                maxdia++;
            }
            if(dia>maxdia){
                resposta = "dia invalido: maximo de "+maxdia+" alterando para 01/01/1900";
                data = "01/01/1900";
            }
            
        }

        if (MenorData(data, dataMaisAntiga) < 0) {
            dataMaisAntiga = data;
        }
        System.out.println("data mais antiga: "+dataMaisAntiga);

        if (MaiorData(data, dataMaisNova) > 0) {
            dataMaisNova = data;
        }
        System.out.println("data mais nova: "+dataMaisNova);

        return resposta;
        
    }

    
    /** 
     * @param ano ano da data que esta sendo analisada no momento
     * @return boolean retorna valor true se o ano e bissexto ou false se não
     */
    public static boolean anoBissexto(int ano){
        boolean resposta = false;
        if(ano%400==0){resposta = true;}
        else if(ano%4==0 && ano%100!=0){resposta = true;}
        return resposta;
    }
    
}

