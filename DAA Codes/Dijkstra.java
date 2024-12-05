import java.util.*; 
public class Dijkstra { 
    static class Edge { 
        int dest, weight; 
        Edge(int dest, int weight) { 
            this.dest = dest;
            this.weight = weight; 
        }
    }
    public static void dijkstra(int vertices, List<List<Edge>> graph, int src) { 
        int[] dist = new int[vertices]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 
        pq.offer(new int[]{src, 0}); 
        boolean[] visited = new boolean[vertices]; 
        System.out.println("Dijkstra's Shortest Path:"); 
        while (!pq.isEmpty()) { 
            int[] curr = pq.poll(); 
            int node = curr[0]; 
            int nodeDist = curr[1]; 
            if (visited[node]) continue;
            visited[node] = true; 
            for (Edge edge : graph.get(node)) { 
                int neighbor = edge.dest; 
                int newDist = nodeDist + edge.weight;
                if (!visited[neighbor] && newDist < dist[neighbor]) { 
                    dist[neighbor] = newDist; 
                    pq.offer(new int[]{neighbor, newDist}); 
                }
            }
        }
        for (int i = 0; i < vertices; i++) { 
            System.out.println("Distance from node " + src + " to node " + i + " is " + dist[i]); 
        }
    }
    public static void main(String[] args) { 
        int vertices = 5; 
        List<List<Edge>> graph = new ArrayList<>(); 
        for (int i = 0; i < vertices; i++) { 
            graph.add(new ArrayList<>()); 
        }
        graph.get(0).add(new Edge(1, 2)); 
        graph.get(0).add(new Edge(3, 6)); 
        graph.get(1).add(new Edge(2, 3)); 
        graph.get(1).add(new Edge(3, 8)); 
        graph.get(1).add(new Edge(4, 5)); 
        graph.get(2).add(new Edge(4, 7)); 
        graph.get(3).add(new Edge(4, 9)); 
        dijkstra(vertices, graph, 0); 
    }
} 