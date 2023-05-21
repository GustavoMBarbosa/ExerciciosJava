import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Warshall{
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();//Inicia o contador para o tempo de execução;

        int vertices = 10;
        int arestas = 15;
        System.out.println("Gerador de Grafos (Warshall):");
        List<List<Integer>> graph = GeradorDeGrafo(vertices, arestas);
        //System.out.println("Random Graph: " + graph);//Função que imprime os vertices do grafico;

        List<Integer> base = AcharBase(graph);//Função que acha a base do grafo;
        List<Integer> antibase = AcharAntibase(graph, base);//Função que acha a antibase do grafo;

        System.out.println("Base: " + base);
        System.out.println("Antibase: " + antibase);

        //Achar fecho transitivo direto e inverso de todos os vértices;
        List<List<Integer>> fechoDireto = fechoTransitivoDireto(graph);
        List<List<Integer>> fechoInverso = fechoTransitivoInverso(graph);
        System.out.println("Fecho transitivo direto:");
        ImprimirGrafo(fechoDireto);//Imprime o fecho transitivo direto;
        System.out.println("Fecho transitivo inverso:");
        ImprimirGrafo(fechoInverso);//Imprime o fecho transitivo inverso;

        //Tempo de execução;
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Tempo de execução: " + duration + " milissegundos");
    }
    
    //Função que gera um gráfico direcionado aleatório;
    public static List<List<Integer>> GeradorDeGrafo(int vertices, int arestas){
        List<List<Integer>> graph = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
        int numarestas = 0;
        while(numarestas < arestas){
            int u = rand.nextInt(vertices);
            int v = rand.nextInt(vertices);
            if(u != v && !graph.get(u).contains(v)){
                graph.get(u).add(v);
                numarestas++;
            }
        }
        return graph;
    }
    //Acha a base do grafo;
    public static List<Integer> AcharBase(List<List<Integer>> graph){
        int vertices = graph.size();
        boolean[] visited = new boolean[vertices];
        List<Integer> base = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            if(!visited[i]){
                visited[i] = true;
                base.add(i);
                for(int j = 0; j < vertices; j++){
                    if(!visited[j] && graph.get(i).contains(j)){
                        visited[j] = true;
                    }
                }
            }
        }
        return base;
    }
    //Acha a Antibase do grafo;
    public static List<Integer> AcharAntibase(List<List<Integer>> graph, List<Integer> base){
        int vertices = graph.size();
        boolean[] visited = new boolean[vertices];
        List<Integer> antibase = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            if(!base.contains(i)){
                visited[i] = true;
                antibase.add(i);
                for(int j = 0; j < vertices; j++){
                    if(!visited[j] && !base.contains(j) && graph.get(i).contains(j)){
                        visited[j] = true;
                    }
                }
            }
        }
        return antibase;
    }

    //Encontra o fecho transitivo direto do grafo usando Warshall;
    public static List<List<Integer>> fechoTransitivoDireto(List<List<Integer>> graph){
        int n = graph.size();
        boolean[][] matriz = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriz[i][j] = graph.get(i).contains(j);
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                if(graph.get(i).isEmpty()){
                    continue;
                }
                for(int j = 0; j < n; j++){
                    if(graph.get(j).isEmpty()){
                        continue;
                    }
                    matriz[i][j] = matriz[i][j] || (matriz[i][k] && matriz[k][j]);
                }
            }
        }
        List<List<Integer>> fechoTransitivo = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> linha = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(matriz[i][j]){
                    linha.add(j);
                }
            }
            fechoTransitivo.add(linha);
        }
        return fechoTransitivo;
    }

    //Encontra o fecho transitivo inverso do grafo usando Warshall;
    public static List<List<Integer>> fechoTransitivoInverso(List<List<Integer>> graph){
        int n = graph.size();
        boolean[][] matriz = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriz[i][j] = graph.get(i).contains(j);
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                if(graph.get(i).isEmpty()){
                    continue;
                }
                for(int j = 0; j < n; j++){
                    if(graph.get(j).isEmpty()){
                        continue;
                    }
                    matriz[i][j] = matriz[i][j] || (matriz[i][k] && matriz[k][j]);
                }
            }
        }
        List<List<Integer>> fechoTransitivo = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> linha = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(matriz[j][i]){
                    linha.add(j);
                }
            }
            fechoTransitivo.add(linha);
        }
        return fechoTransitivo;
    }
    
    //Imprime o Grafo; 
    public static void ImprimirGrafo(List<List<Integer>> graph){
        for(int i = 0; i < graph.size(); i++){
            System.out.print(i + ": ");
            for(int j : graph.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
               
