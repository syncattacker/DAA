import java.util.*; 
public class BFS { 
    public static void bfs(List<List<Integer>> graph, int start) { 
        int n = graph.size();
        boolean[] visited = new boolean[n]; 
        Queue<Integer> queue = new LinkedList<>(); 
        queue.offer(start); 
        while (!queue.isEmpty()) { 
            int node = queue.poll(); 
            if (visited[node]) { 
                continue; 
            } 
            visited[node] = true; 
            System.out.println("Processing node: " + node);
            for (int neighbour : graph.get(node)) { 
                if (!visited[neighbour]) { 
                    queue.offer(neighbour); 
                } 
            } 
        } 
    }
    public static void main(String[] args) { 
        List<List<Integer>> graph = new ArrayList<>(); 
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(0, 3, 4));
        graph.add(Arrays.asList(0, 4)); 
        graph.add(Arrays.asList(1, 5)); 
        graph.add(Arrays.asList(1, 2, 5));
        graph.add(Arrays.asList(3, 4)); 
        bfs(graph, 0); 
    } 

} 