import java.util.*;
public class Naive{
    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();//Inicia o contador para o tempo de execução;

        int vertices = 10;//Número de vértices (mude para alterar o tamanho do gráfico);
        int arestas = 15;//Número de arestas (mude para alterar o tamanho do gráfico);
        List<List<Integer>> graph = GerarGrafoAleatorio(vertices, arestas);
        System.out.println("Gerador de Grafos (Naive):");
        //ImprimirGrafo(graph);//Função que imprime os vertices do grafico;
        Set<Integer> base = AcharBase(graph);
        Set<Integer> antibase = AcharAntibase(graph, base);
        //Imprime a Base e a Antibase;
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

    //Função que cria o gráfico direcionado aleatório;
    public static List<List<Integer>> GerarGrafoAleatorio(int vertices, int arestas){
        List<List<Integer>> graph = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }

        int numarestas = 0;
        while(numarestas < arestas){
            int from = rand.nextInt(vertices);
            int to = rand.nextInt(vertices);
            if (from != to && !graph.get(from).contains(to)){
                graph.get(from).add(to);
                numarestas++;
            }
        }

        return graph;
    }

    //Procura a base do grafo;
    public static Set<Integer> AcharBase(List<List<Integer>> graph){
        Set<Integer> base = new HashSet<>();
        int vertices = graph.size();

        for(int i = 0; i < vertices; i++){
            boolean flag = true;
            for(int j = 0; j < vertices; j++){
                if(graph.get(j).contains(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                base.add(i);
            }
        }
        return base;
    }

    //Procura a Antibase do grafo;
    public static Set<Integer> AcharAntibase(List<List<Integer>> graph, Set<Integer> base){
        Set<Integer> antibase = new HashSet<>();
        int vertices = graph.size();

        for(int i = 0; i < vertices; i++){
            if(!base.contains(i)){
                boolean flag = true;
                for(int j = 0; j < vertices; j++){
                    if(graph.get(i).contains(j) && base.contains(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    antibase.add(i);
                }
            }
        }
        return antibase;
    }

    //Encontra o fecho transitivo direto do grafo;
    public static List<List<Integer>> fechoTransitivoDireto(List<List<Integer>> graph){
        int n = graph.size();
        List<List<Integer>> closure = new ArrayList<>();
        for(int i = 0; i < n; i++){
            closure.add(new ArrayList<>());
            closure.get(i).addAll(graph.get(i));
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(closure.get(i).contains(k) && closure.get(k).contains(j)){
                        closure.get(i).add(j);
                    }
                }
            }
        }
        return closure;
    }

    //Encontra o fecho transitivo inverso do grafo;
    public static List<List<Integer>> fechoTransitivoInverso(List<List<Integer>> graph){
        int n = graph.size();
        List<List<Integer>> closure = new ArrayList<>();
        for(int i = 0; i < n; i++){
            closure.add(new ArrayList<>());
            closure.get(i).addAll(graph.get(i));
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(closure.get(i).contains(k) && closure.get(k).contains(j)){
                        closure.get(j).add(i);
                    }
                }
            }
        }
        return closure;
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