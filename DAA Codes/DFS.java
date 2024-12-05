import java.util.*; 
public class DFS { 
    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited) { 
        if (visited[node]) {
            return; 
        } 
        visited[node] = true; 
        System.out.println("Processing node: " + node);
        for (int neighbour: graph.get(node)) { 
            if (! visited[neighbour]) { 
                dfs(graph, neighbour, visited); 
            } 
        } 
    } 
    public static void main (String[] args) { 
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(0, 3, 4));
        graph.add(Arrays.asList(0, 4));
        graph.add(Arrays.asList(1, 5));
        graph.add(Arrays.asList(1, 2, 5));
        graph.add(Arrays.asList(3, 4));
        int n = graph.size();
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited); 

    } 

} 