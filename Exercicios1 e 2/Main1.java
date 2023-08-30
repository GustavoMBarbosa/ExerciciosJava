import java.util.Scanner;

public class Main1 {
    
    /** 
     atividade 1
     imprimir vetor ao contrario
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor;
        vetor = new int[6];  
        int[] vetoralt;
        vetoralt = new int[6];
        for(int i=0;i<6;i++){
            vetor[i] = sc.nextInt();
            vetoralt[5-i]=vetor[i];
        }
        for(int i=0;i<6;i++){
            System.out.println(vetoralt[i]);
        }
        sc.close();
    }
}
