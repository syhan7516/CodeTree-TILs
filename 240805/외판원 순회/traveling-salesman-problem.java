import java.util.*;
import java.io.*;

public class Main {

    // 결과, 격자 크기
    public static int answer, size;

    // 격자 배열
    public static int map[][];

    // 도시 방문 여부 배열
    public static boolean visited[];

    // 도시 순회하기 메서드
    public static void solve(int cnt, int city, int sum) {

        // 이미 기존보다 경로가 같거나, 더 긴 경우
        if(sum>=answer) return;

        // 모든 도시를 순회한 경우
        if(cnt==size) {
            if(map[city][1]>0) 
                answer = Math.min(answer,sum+map[city][1]);
            return;
        }

        // 연결된 도시 확인
        for(int i=1; i<=size; i++) {

            // 연결이 되어있으면서 미방문인 도시인 경우
            if(map[city][i]>0 && !visited[i]) {

                // 도시 방문
                visited[i] = true;
                solve(cnt+1,i,sum+map[city][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        map = new int[size+1][size+1];

        // 격자 정보 입력
        for(int i=1; i<=size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도시 방문 여부 배열 생성
        visited = new boolean[size+1];

        // 도시 순회하기
        answer = Integer.MAX_VALUE;
        visited[1] = true;
        solve(1,1,0);

        // 결과 출력
        System.out.println(answer);
    }
}