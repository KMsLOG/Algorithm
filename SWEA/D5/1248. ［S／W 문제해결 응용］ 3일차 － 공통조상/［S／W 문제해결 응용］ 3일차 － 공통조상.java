import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int parent;
	int lchild;
	int rchild;
	Node(){
		this.parent = 0;
		this.lchild = 0;
		this.rchild = 0;
	}
	Node(int parent, int lchild, int rchild){
		this.parent = parent;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}

public class Solution {
	
	static int V, E, Node1, Node2;
	static Node[] tree;
	static int ancient = 1;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	// 정점의 개수
			E = Integer.parseInt(st.nextToken());	// 간선의 개수
			Node1 = Integer.parseInt(st.nextToken());	// 정점 번호 1
			Node2 = Integer.parseInt(st.nextToken());	// 정점 번호 2

			tree = new Node[V + 1];					// 노드들을 저장 시킬 트리
			visited = new boolean[V + 1];			// 방문여부 확인
			count = 0;								// 서브 트리의 크기
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node();				// 트리의 각 노드 설정
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());	// 부모
				int child = Integer.parseInt(st.nextToken());	// 자식
				if (tree[parent].lchild == 0) {	// 부모노드 왼쪽에 자식이 없으면
					tree[parent].lchild = child;// 자식은 부모 노드의 왼쪽 자식
				} else {						// 부모노드 왼쪽에 자식이 있으면
					tree[parent].rchild = child;// 자식은 부모 노드의 오른쪽 자식
				}
				tree[child].parent = parent;	// 부모는 자식의 부모
			}

			findAncient();	// 공통조상 찾기 메서드
			counttree(tree[ancient]);	// 해당 노드의 크기 알아내는 메서드
			sb.append("#"+ tc + " " + ancient + " " + count+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	// 공통 조상 찾기 메서드
	static void findAncient() {
		while (true) {
			if (Node1 != 1) {	// 노드가 최상위 노드가 아니면
				int parent = tree[Node1].parent; // 부모는 해당 노드의 부모
				if (visited[parent]) {	// 부모 노드에 이미 방문했다면
					ancient = parent;	// 공통 조상은 해당 부모
					break;
				}
				visited[parent] = true;	// 부모 노드 방문 표시
				Node1 = parent;			// 새로운 노드는 부모노드
			}
			if (Node2 != 1) {	// 노드가 최상위 노드가 아니면
				int parent = tree[Node2].parent;// 부모는 해당 노드의 부모
				if (visited[parent]) {	// 부모 노드에 이미 방문했다면
					ancient = parent;	// 공통 조상은 해당 부모
					break;
				}
				visited[parent] = true;	// 부모 노드 방문 표시
				Node2 = parent;			// 새로운 노드는 부모노드
			}		
		}
	} // end of findAncient
	
	// 노드의 크기 찾기 메서드
	static void counttree(Node node) {
		count++;	// 카운트 하나 더하기
		if (node.lchild != 0)	// 왼쪽자식이 있으면
			counttree(tree[node.lchild]);	// 재귀
		if (node.rchild != 0)	// 오른쪽자식이 있으면
			counttree(tree[node.rchild]);	// 재귀
	} // end of counttree
		
} // end of class
