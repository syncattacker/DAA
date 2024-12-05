import java.util.*; 
public class Kruskal { 
    static class Edge implements Comparable<Edge> { 
        int source, dest, weight; 
        Edge(int source, int dest, int weight) { 
            this.source = source; 
            this.dest = dest; 
            this.weight = weight; 
        } 
        @Override 
        public int compareTo(Edge other) { 
            return Integer.compare(this.weight, other.weight); 
        } 
    }
    static int findParent(int[] parent, int i) { 
        if (parent[i] == -1) { 
            return i; 
        } 
        return findParent(parent, parent[i]); 
    }
    static void union(int[] parent, int x, int y) { 
        parent[x] = y; 
    }
    public static void kruskalMST(List<Edge> edges, int vertices) { 
        Collections.sort(edges);
        int[] parent = new int[vertices]; 
        Arrays.fill(parent, -1); 
        System.out.println("Kruskal's Minimum Spanning Tree:"); 
        for (Edge edge : edges) { 
            int x = findParent(parent, edge.source); 
            int y = findParent(parent, edge.dest); 
            if (x != y) { 
                System.out.println(edge.source + " - " + edge.dest + ": " + edge.weight); 
                union(parent, x, y); 
            } 
        } 
    }
    public static void main(String[] args) { 
        int vertices = 4; // Number of vertices 
        List<Edge> edges = new ArrayList<>(); 
        edges.add(new Edge(0, 1, 10)); 
        edges.add(new Edge(0, 2, 6)); 
        edges.add(new Edge(0, 3, 5)); 
        edges.add(new Edge(1, 3, 15)); 
        edges.add(new Edge(2, 3, 4)); 
        kruskalMST(edges, vertices); 
    } 
} 