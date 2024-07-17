import java.util.*;
import java.io.*;

public class Main {

    // 결과, 정점 수, 간선 수
    public static int answer, nodeCnt, edgeCnt;

    // 연결 관계 배열
    public static ArrayList<Integer>[] relation;

    // 방문 여부 배열
    public static boolean visited[];

    // 그래프 탐색 수행 메서드
    public static void solve(int node) {

        // 연결된 정점 확인
        for(int i=0; i<relation[node].size(); i++) {
            
            // 연결 정점
            int connect = relation[node].get(i);

            // 미방문 정점인 경우
            if(!visited[connect]) {
                visited[connect] = true;
                answer++;
                solve(connect);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 연결 관계 배열 생성
        relation = new ArrayList[nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++)
            relation[i] = new ArrayList<>();
        
        // 연결 관계 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            relation[start].add(end);
            relation[end].add(start);
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCnt+1];

        // 그래프 탐색 수행
        answer = 0;
        visited[1] = true;
        solve(1);
        
        // 결과 출력
        System.out.println(answer);
    }
}