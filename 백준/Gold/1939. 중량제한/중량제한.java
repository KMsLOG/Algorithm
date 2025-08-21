import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int island;
    int weight;

    public Node(int island, int weight) {
        this.island = island;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - this.weight;
    }
}

public class Main {
    static int N, M, start, end;
    static ArrayList<Node>[] graph;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        weights = new int[N + 1];
        Arrays.fill(weights, 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    } // end of main

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        weights[start] = Integer.MAX_VALUE;

        pq.add(new Node(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (weights[cur.island] > cur.weight) continue;

            if (cur.island == end) return cur.weight;

            for (Node next : graph[cur.island]) {
                int nextIsland = next.island;
                int bridgeWeight = next.weight;

                int newWeight = Math.min(cur.weight, bridgeWeight);

                if (newWeight > weights[nextIsland]) {
                    weights[nextIsland] = newWeight;
                    pq.add(new Node(nextIsland, newWeight));
                }
            }
        }

        return -1;
    } // end of dijkstra
} // end of class