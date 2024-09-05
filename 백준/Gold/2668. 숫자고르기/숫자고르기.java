import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int[] arr; // 주어진 숫자 배열
    static boolean[] visited; // 노드 방문 여부를 체크하는 배열
    static boolean[] inCycle; // 사이클에 포함된 노드를 체크하는 배열
    static PriorityQueue<Integer> answer; // 사이클 노드를 저장하고 정렬하기 위한 우선순위 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력받은 숫자 개수
        arr = new int[N + 1]; // 숫자 배열 (1부터 N까지 사용하기 위해 N+1 크기로 선언)
        visited = new boolean[N + 1]; // 방문 여부 배열
        inCycle = new boolean[N + 1]; // 사이클 포함 여부 배열
        answer = new PriorityQueue<>(); // 우선순위 큐 초기화

        // 입력 처리
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 각 노드가 가리키는 숫자를 입력받음
        }

        // 모든 노드를 시작으로 사이클 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                findCycle(i); // 사이클 탐색 함수 호출
            }
        }

        // 사이클에 포함된 결과를 수집
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (inCycle[i]) {
                result.add(i); // 사이클에 포함된 노드를 결과 리스트에 추가
            }
        }

        // 결과 출력
        System.out.println(result.size()); // 사이클에 포함된 노드의 개수 출력
        for (int num : result) {
            System.out.println(num); // 각 사이클 노드를 출력
        }
    }

    static void findCycle(int start) {
        boolean[] path = new boolean[arr.length]; // 경로 추적 배열
        List<Integer> cycle = new ArrayList<>(); // 현재 경로를 저장할 리스트
        int current = start; // 현재 노드

        while (true) {
            if (visited[current]) { // 현재 노드가 이미 방문된 경우
                if (path[current]) { // 현재 노드가 사이클의 시작점인 경우
                    int index = cycle.indexOf(current); // 사이클의 시작점 인덱스 찾기
                    for (int i = index; i < cycle.size(); i++) {
                        inCycle[cycle.get(i)] = true; // 사이클에 포함된 노드를 표시
                    }
                }
                break; // 사이클 탐색 종료
            }

            visited[current] = true; // 현재 노드를 방문 처리
            path[current] = true; // 경로에 현재 노드 추가
            cycle.add(current); // 현재 경로에 노드 추가
            current = arr[current]; // 다음 노드로 이동
        }
    }
}
