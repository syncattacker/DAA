public class FloydWarshall { 
    public static void floydWarshall(int[][] graph, int vertices) { 
        int[][] dist = new int[vertices][vertices]; 
        for (int i = 0; i < vertices; i++) { 
            for (int j = 0; j < vertices; j++) { 
                if (i == j) { 
                    dist[i][j] = 0; 
                } else if (graph[i][j] == 0) {
                    dist[i][j] = Integer.MAX_VALUE; 
                } else { 
                    dist[i][j] = graph[i][j]; 
                } 
            } 
        } 
        for (int k = 0; k < vertices; k++) { 
            for (int i = 0; i < vertices; i++) { 
                for (int j = 0; j < vertices; j++) { 
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE 
                            && dist[i][k] + dist[k][j] < dist[i][j]) { 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    } 
                } 
            } 
        }
        System.out.println("Shortest distances between every pair of vertices:"); 
        for (int i = 0; i < vertices; i++) { 
            for (int j = 0; j < vertices; j++) { 
                if (dist[i][j] == Integer.MAX_VALUE) { 
                    System.out.print("INF "); 
                } else { 
                    System.out.print(dist[i][j] + " "); 
                } 
            } 
            System.out.println(); 
        } 
    }
    public static void main(String[] args) { 
        int vertices = 4; 
        int[][] graph = { 
            {0, 3, 0, 5}, 
            {0, 0, 2, 0}, 
            {0, 0, 0, 4}, 
            {0, 0, 0, 0} 
        };
        floydWarshall(graph, vertices); 
    } 
} 