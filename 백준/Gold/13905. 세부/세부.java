import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    
    static class Graph {
        List<Edge>[] adjList;
        public Graph(int n) {
            adjList = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }
        }
        
        public void addEdge(int u, int v, int weight) {
            adjList[u].add(new Edge(u, v, weight));
            adjList[v].add(new Edge(v, u, weight));
        }
    }
    
    static int[] parent, rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Edge> edges = new PriorityQueue<>((a, b) -> b.weight - a.weight);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, weight));
        }
        
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        Graph graph = new Graph(N);
        
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                graph.addEdge(edge.u, edge.v, edge.weight);
            }
        }
        
        System.out.println(dijkstra(graph, s, e));
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    static int dijkstra(Graph graph, int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        boolean[] visited = new boolean[graph.adjList.length];
        int[] maxWeight = new int[graph.adjList.length];
        Arrays.fill(maxWeight, Integer.MIN_VALUE);
        
        pq.add(new int[] {start, Integer.MAX_VALUE});
        maxWeight[start] = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int weight = cur[1];
            
            if (visited[u]) continue;
            visited[u] = true;
            
            for (Edge edge : graph.adjList[u]) {
                int v = edge.v;
                int newWeight = Math.min(weight, edge.weight);
                if (newWeight > maxWeight[v]) {
                    maxWeight[v] = newWeight;
                    pq.add(new int[] {v, newWeight});
                }
            }
        }
        
        return maxWeight[end] == Integer.MIN_VALUE ? 0 : maxWeight[end];
    }
}
