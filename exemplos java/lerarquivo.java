package exercicio11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class lerarquivo {
    public static void main(String[] args)throws FileNotFoundException{
        Scanner leitor = new Scanner(new File("exercicio11\\escrita.txt"));
        System.out.println(leitor);
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
            System.out.println(linha);
        }
        leitor.close();
    }
}

