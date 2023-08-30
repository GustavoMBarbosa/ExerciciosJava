import java.util.Scanner;

public class Main2 {
    
    /** 
     atividade 2
     imprimir soma de cada par de vizinhos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor;
        int numerovetor;
        int[] vetorsoma;

        System.out.print("digite o tamanho do vetor: ");
        
        numerovetor = sc.nextInt();
        vetor = new int[numerovetor];  

        if(vetor.length%2==1){vetorsoma = new int[(numerovetor/2)+1];}
        else{
        vetorsoma = new int[numerovetor/2];
        }
        System.out.print("digite os valores: ");
        for(int i=0;i<vetor.length;i++){
            vetor[i] = sc.nextInt();
            
        }

        for(int i=0,y=0;i<vetor.length;i=i+2,y++){
            if(i+1<vetor.length){
                vetorsoma[y] = vetor[i] + vetor[i+1];
                System.out.println("Alocado valores "+vetor[i]+"+"+vetor[(i+1)]+" na posição: "+y);
                }
            else{
                vetorsoma[y] = vetor[i]+vetor[i];
                System.out.println("Alocado valores "+vetor[i]+"+"+vetor[(i)]+" na posição: "+y);
            }

            }
        
            System.out.println("impressao dos valores: ");
        for(int i=0;i<vetorsoma.length;i++){

            System.out.println(vetorsoma[i]);
        }
    
        sc.close();
    }
}

