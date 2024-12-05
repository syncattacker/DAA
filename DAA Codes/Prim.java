import java.util.*; 
public class Prim {
    static class Edge implements Comparable<Edge> { 
        int src, dest, weight; 
        Edge(int src, int dest, int weight) { 
            this.src = src; 
            this.dest = dest; 
            this.weight = weight; 
        }
        @Override 
        public int compareTo(Edge other) { 
            return Integer.compare(this.weight, other.weight); 
        }
    }
    public static void primMST(int vertices, List<List<Edge>> graph) { 
        boolean[] visited = new boolean[vertices]; 
        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
        List<Edge> mstEdges = new ArrayList<>(); 
        visited[0] = true; 
        for (Edge edge : graph.get(0)) { 
            pq.offer(edge); 
        }
        System.out.println("Prim's Minimum Spanning Tree:"); 
        while (!pq.isEmpty() && mstEdges.size() < vertices - 1) { 
            Edge edge = pq.poll(); 
            if (!visited[edge.dest]) { 
                visited[edge.dest] = true; 
                mstEdges.add(edge); 
                System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight); 
                for (Edge nextEdge : graph.get(edge.dest)) { 
                    if (!visited[nextEdge.dest]) { 
                        pq.offer(nextEdge); 
                    }
                }
            } 
        }
        if (mstEdges.size() != vertices - 1) { 
            System.out.println("The graph is not connected; MST cannot be formed."); 
        }
    }
    public static void main(String[] args) { 
        int vertices = 5; 
        List<List<Edge>> graph = new ArrayList<>(); 
        for (int i = 0; i < vertices; i++) { 
            graph.add(new ArrayList<>()); 
        }
        graph.get(0).add(new Edge(0, 1, 2)); 
        graph.get(0).add(new Edge(0, 3, 6)); 
        graph.get(1).add(new Edge(1, 0, 2)); 
        graph.get(1).add(new Edge(1, 2, 3)); 
        graph.get(1).add(new Edge(1, 3, 8)); 
        graph.get(1).add(new Edge(1, 4, 5)); 
        graph.get(2).add(new Edge(2, 1, 3)); 
        graph.get(2).add(new Edge(2, 4, 7)); 
        graph.get(3).add(new Edge(3, 0, 6)); 
        graph.get(3).add(new Edge(3, 1, 8)); 
        graph.get(3).add(new Edge(3, 4, 9)); 
        graph.get(4).add(new Edge(4, 1, 5)); 
        graph.get(4).add(new Edge(4, 2, 7)); 
        graph.get(4).add(new Edge(4, 3, 9)); 
        primMST(vertices, graph); 
    }
}