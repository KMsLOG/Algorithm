import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int node1; // 첫 번째 노드
    int node2; // 두 번째 노드
    int cost;  // 두 노드를 연결하는 비용

    public Node(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // 비용을 기준으로 오름차순 정렬
        return this.cost - o.cost;
    }
}

public class Main {

    static int V, E; // V: 정점의 수, E: 간선의 수
    static int[] parent; // Union-Find에서 부모를 저장하는 배열
    static int[] rank; // Union-Find에서 집합의 깊이를 저장하는 배열 (Union by Rank)
    static PriorityQueue<Node> pq; // 간선 정보를 담을 우선순위 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1]; // 부모 배열 초기화
        rank = new int[V+1]; // rank 배열 초기화

        for(int i = 0; i <= V; i++) {
            parent[i] = i; // 초기에는 각 노드가 자기 자신을 부모로 가짐
            rank[i] = 0;   // 초기에는 모든 노드의 rank를 0으로 설정
        }

        pq = new PriorityQueue<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(node1, node2, cost));
        }

        kruskal(); // Kruskal 알고리즘을 통해 최소 스패닝 트리 찾기
    }

    static void kruskal() {
        int cost = 0; // 최소 스패닝 트리의 총 비용
        int size = pq.size();
        
        for(int i = 0; i < size; i++) {
            Node cur = pq.poll(); // 우선순위 큐에서 가장 작은 비용의 간선 꺼내기

            // 두 노드가 서로 다른 집합에 있으면 (사이클이 생기지 않도록)
            if(find(cur.node1) != find(cur.node2)) {
                cost += cur.cost; // 최소 스패닝 트리에 간선 비용 추가
                union(cur.node1, cur.node2); // 두 노드를 같은 집합으로 만들기
            }
        }
        System.out.println(cost); // 최소 스패닝 트리의 총 비용 출력
    }

    static void union(int x, int y) {
        int rootX = find(x); // x의 부모 노드 찾기
        int rootY = find(y); // y의 부모 노드 찾기

        if (rootX != rootY) {
            // Union by Rank: 깊이가 더 낮은 트리를 깊이가 더 높은 트리에 붙임
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1; // 깊이가 같으면 루트 노드의 rank를 증가시킴
            }
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축: 모든 노드의 부모를 직접 연결
        }
        return parent[x]; // 최상위 부모 노드 반환
    }
}
