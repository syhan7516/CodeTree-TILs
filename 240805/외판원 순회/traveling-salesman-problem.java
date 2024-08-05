import java.util.*;
import java.io.*;

// 간선 클래스
class Edge {
    int city;
    int dist;

    public Edge(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }
}

public class Main {

    // 결과, 격자 크기
    public static int answer, size;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 도시 방문 여부 배열
    public static boolean visited[];

    // 도시 순회하기 메서드
    public static void solve(int cnt, int city, int sum) {

        // 이미 기존보다 경로가 같거나 더 긴 경우
        if(sum>=answer) return;

        // 모든 도시를 순회한 경우
        if(cnt==size) {
            answer = Math.min(answer,sum);
            return;
        }

        // 연결된 도시 확인
        for(int i=0; i<relation.get(city).size(); i++) {
            
            // 연결 도시
            Edge current = relation.get(city).get(i);

            // 이미 방문한 도시인 경우
            if(visited[i]) continue;

            // 도시 선택
            visited[current.city] = true;
            solve(cnt+1,current.city,sum+current.dist);
            visited[current.city] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 연결 정보 리스트 생성
        relation = new ArrayList<>();

        // 연결 정보 리스트 초기화
        for(int i=0; i<=size; i++)
            relation.add(new ArrayList<>());

        // 연결 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                int dist = Integer.parseInt(st.nextToken());
                if(dist==0) continue;
                relation.get(i).add(new Edge(j,dist));
            }
        }

        // 도시 방문 여부 배열 생성
        visited = new boolean[size+1];

        // 도시 순회하기
        answer = Integer.MAX_VALUE;
        solve(0,1,0);

        // 결과 출력
        System.out.println(answer);
    }
}