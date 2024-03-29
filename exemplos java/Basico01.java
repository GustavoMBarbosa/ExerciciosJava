/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.util.Scanner;

public class Basico01{
  static Scanner leitor = new Scanner(System.in);
  
  static int[] inverter(int vetor[]) {
    int tmp;
    int oposto;
    int tamanho = vetor.length;
    for (int i = 0; i < (tamanho/2); i++) {
      oposto = (tamanho - i - 1);
      tmp = vetor[i];
      vetor[i] = vetor[oposto];
      vetor[oposto] = tmp;
    }
    return vetor;
  }
  
  static int[] lerVetor(int tamanho){
    int[] vetor = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      System.out.print("Digite o número na posição "+ (i + 1) +": ");
      vetor[i] = Integer.parseInt(leitor.nextLine());
    }
    return vetor;
  }
  
  static void imprimir(int[] vetor){
    for (int i = 0; i < vetor.length; i++)
      System.out.print(vetor[i]+" ");
  }
  
  public static void main(String[] args) throws Exception {
    final int TAMANHO = 6;
    int[]  inteiros;
      
    inteiros = lerVetor(TAMANHO);
    inteiros = inverter(inteiros);
    System.out.println("\nInvertido:\n");
    imprimir(inteiros);
    System.out.println("\nFIM.\n");
	leitor.close();
  }

  
}