import java.util.*;
import java.io.*;

public class Main {

    // 결과, 턴 수, 범위, 말의 수
    public static int answer, termCnt, range, people;

    // 거리 정보 배열
    public static int dist[];

    // 위치 정보 배열
    public static int point[];

    // 순서 정하기 메서드
    public static void solve(int cnt, int score) {

        // 턴이 끝난 경우
        if(cnt==termCnt+1) {
            answer = Math.max(answer,score);
            return;
        }

        // 윷 던지기
        for(int i=0; i<people; i++) {

            // 해당 선수가 이미 목적지인 경우
            if(point[i]>=range-1) 
                solve(cnt+1,score);
            
            // 아닌 경우
            else {

                // 이동
                point[i] += dist[cnt];

                // 목적지에 도착한 경우
                if(point[i]>=range-1) solve(cnt+1,score+1);

                // 목적지에 도착하지 못한 경우
                else solve(cnt+1,score);

                // 이동 복구
                point[i] -= dist[cnt];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 턴 수, 범위, 말의 수 입력
        st = new StringTokenizer(br.readLine());
        termCnt = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        people = Integer.parseInt(st.nextToken());

        // 위치 정보 배열 생성
        point = new int[range];

        // 거리 정보 배열 생성
        dist = new int[termCnt+1];

        // 위치 정보 배열 생성
        point = new int[people];

        // 거리 정보 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=termCnt; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        
        // 순서 정하기
        answer = 0;
        solve(1,0);

        // 결과 출력
        System.out.println(answer);
    }
}