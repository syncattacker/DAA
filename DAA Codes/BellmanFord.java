import java.util.*; 
public class BellmanFord { 
    static class Edge { 
        int src, dest, weight; 
        Edge(int src, int dest, int weight) {
            this.src = src; 
            this.dest = dest; 
            this.weight = weight; 
        }
    } 
    public static void bellmanFord(List<Edge> edges, int vertices, int src) { 
        int[] dist = new int[vertices]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[src] = 0; 
        for (int i = 0; i < vertices - 1; i++) { 
            for (Edge edge : edges) { 
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) { 
                    dist[edge.dest] = dist[edge.src] + edge.weight; 
                } 
            } 
        }
        for (Edge edge : edges) { 
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) { 
                System.out.println("Graph contains negative weight cycle"); 
                return; 
            }
        }
        System.out.println("Vertex Distance from Source:"); 
        for (int i = 0; i < vertices; i++) { 
            System.out.println(i + " \t " + dist[i]); 
        }
    }
    public static void main(String[] args) { 
        int vertices = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1)); 
        edges.add(new Edge(0, 2, 4)); 
        edges.add(new Edge(1, 2, 3)); 
        edges.add(new Edge(1, 3, 2)); 
        edges.add(new Edge(1, 4, 2)); 
        edges.add(new Edge(3, 2, 5)); 
        edges.add(new Edge(3, 1, 1)); 
        edges.add(new Edge(4, 3, -3)); 
        bellmanFord(edges, vertices, 0); 
    }
} 