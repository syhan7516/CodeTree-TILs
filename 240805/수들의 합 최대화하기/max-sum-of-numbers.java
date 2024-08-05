import java.util.*;
import java.io.*;

public class Main {
    
    // 결과, 격자 크기
    public static int answer, size;

    // 격자 배열
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[];

    // 순열 구하기 메서드
    public static void solve(int cnt, int sum) {

        // 선택이 완료된 경우
        if(cnt==size) {
            answer = Math.max(answer,sum);
            return;
        }

        // 숫자 선택하기
        for(int i=0; i<size; i++) {

            // 이미 방문한 경우
            if(visited[i]) continue;

            // 숫자 선택
            visited[i] = true;
            solve(cnt+1,sum+map[cnt][i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문 여부 배열 생성
        visited = new boolean[size];

        // 순열 구하기
        answer = 0;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}