import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node123 {
    String data;
    int lchild;
    int rchild;

    Node123() {
        this.data = "";
        this.lchild = 0;
        this.rchild = 0;
    }
}

public class Solution {
    static Node123[] tree;
    static StringBuilder result;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            tree = new Node123[N + 1];
            for (int i = 1; i <= N; i++) {
                tree[i] = new Node123(); // 트리의 각 노드 설정
            }

            for (int i = 0; i < N; i++) {
                String[] nodeInfo = br.readLine().split(" ");
                int parent = Integer.parseInt(nodeInfo[0]);
                String data = nodeInfo[1];
                tree[parent].data = data;
                if (nodeInfo.length == 4) {
                    int lchild = Integer.parseInt(nodeInfo[2]);
                    int rchild = Integer.parseInt(nodeInfo[3]);
                    tree[parent].lchild = lchild;
                    tree[parent].rchild = rchild;
                } else if (nodeInfo.length == 3) {
                    int lchild = Integer.parseInt(nodeInfo[2]);
                    tree[parent].lchild = lchild;
                }
            }

            result = new StringBuilder();
            inOrder(1); // 루트 노드부터 시작

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    static void inOrder(int node) {
        if (node == 0) {
            return;
        }
        // 왼쪽 자식 노드 방문
        inOrder(tree[node].lchild);
        // 현재 노드 방문
        result.append(tree[node].data);
        // 오른쪽 자식 노드 방문
        inOrder(tree[node].rchild);
    }
}
