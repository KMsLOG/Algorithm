import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int answer;
    static LinkedList<Integer> root = new LinkedList<>();
    
    static class Node {
        int time = 0;
        int parent = -1; // 부모 노드의 위치를 저장
        
        Node(int time, int parent) {
            this.time = time;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        if(N == K) {
            System.out.println(0);
            System.out.println(N);
        } else {
            findFast(N, K);
            System.out.println(answer);
            for (int i : root) {
                System.out.print(i + " ");
            }
        }
    } // end of main

    static void findFast(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        
        Node[] arr = new Node[100001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node(-1, -1); // 초기화
        }
        arr[N] = new Node(0, -1); // 시작 위치 초기화
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] moveNext;
            if (cur == 0) {
                moveNext = new int[] {cur + 1, cur - 1};
            } else {
                moveNext = new int[] {cur * 2, cur + 1, cur - 1};
            }
            
            for (int next : moveNext) {
                if (next < 0 || next > 100000) continue;
                
                if (arr[next].time == -1) { // 아직 방문하지 않은 경우
                    arr[next].time = arr[cur].time + 1;
                    arr[next].parent = cur; // 부모 노드 설정
                    q.add(next);
                }
                if (next == K) {
                    answer = arr[next].time;
                    reconstructPath(arr, K);
                    return;
                }
            }
        }
    } // end of findFast

    static void reconstructPath(Node[] arr, int K) {
        for (int i = K; i != -1; i = arr[i].parent) {
            root.addFirst(i); // 경로를 역순으로 추가
        }
    }
} // end of class
