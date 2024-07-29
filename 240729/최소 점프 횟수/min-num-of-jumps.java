import java.util.*;
import java.io.*;

public class Main {

    // 결과, 거리 범위
    public static int answer, range;

    // 거리 배열
    public static int dist[];

    // 점프 수행 메서드
    public static void solve(int point, int cnt) {

        // 도착한 경우
        if(point==range-1) {
            answer = Math.min(answer,cnt);
            return;
        }

        // 점프 위치 확인
        for(int i=1; i<=dist[point]; i++) {

            // 점프 가능한 위치
            int np = point+i;

            // 범위 확인
            if(np>range-1) continue;

            // 점프 수행
            solve(np,cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 거리 범위 입력
        range = Integer.parseInt(br.readLine());

        // 거리 배열 생성
        dist = new int[range];

        // 거리 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<range; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        // 점프 수행
        answer = 10;
        solve(0,0);

        // 결과 출력
        if(answer==10) System.out.println(-1);
        else System.out.println(answer);
    }
}