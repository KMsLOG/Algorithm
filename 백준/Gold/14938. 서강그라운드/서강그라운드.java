import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Item implements Comparable<Item> {
    int now;
    int sum;
    public Item(int now, int sum) {
        this.now = now;
        this.sum = sum;
    }
    @Override
    public int compareTo(Item o) {
        return this.sum - o.sum;
    }
}

class Node {
    int next;
    int cost;
    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}

public class Main {
    static int N, M, R;
    static int[] items;
    static ArrayList<Node>[] graph;
    static int MAX_ITEM = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        for (int i = 1; i <= N; i++) {
            int result = dijkstra(i);
            if (result >= MAX_ITEM) MAX_ITEM = result;
        }

        System.out.println(MAX_ITEM);
    } // end of main

    static int dijkstra(int start) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Item(start, 0));

        while (!pq.isEmpty()) {
            Item cur = pq.poll();

            if (cur.sum > dist[cur.now]) {
                continue;
            }

            for (Node n : graph[cur.now]) {
                if (dist[n.next] > cur.sum + n.cost) {
                    dist[n.next] = cur.sum + n.cost;
                    pq.add(new Item(n.next, dist[n.next]));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                result += items[i];
            }
        }
        return result;
    } // end of dijkstra
} // end of class