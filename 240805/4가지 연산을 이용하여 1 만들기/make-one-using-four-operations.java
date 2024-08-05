import java.util.*;
import java.io.*;

public class Main { 

    // 결과, 범위
    public static int answer, range;

    // 연산 가능 여부 확인 메서드
    public static boolean possible(int number, int operator) {

        // -1, +1
        if(operator==0 || operator==1)
            return true;

        // /2
        else if(operator==2)
            return number%operator==0 ? true : false;

        // /3
        else return number%operator==0 ? true : false;
    }

    // 연산 수행 메서드 
    public static int calc(int number, int operator) {

        // -1
        if(operator==0) return number-1;
        
        // +1
        else if(operator==1) return number+1;

        // /2
        else if(operator==2) return number/2;

        // /3
        else return number/3;
    }

    // 1로 만들기 메서드
    public static void solve(int start) {

        // 연산 횟수 저장 배열
        int cnt[] = new int[range+1];

        // 방문 여부 배열 생성
        boolean visited[] = new boolean[range+1];

        // 탐색 대상 저장 큐 대상
        Queue<Integer> queue = new LinkedList<>();

        // 시작 처리
        queue.offer(start);
        visited[start] = true;
        cnt[start] = 0;

        // 1까지 반복
        while(true) {

            // 확인 숫자
            int current = queue.poll();

            // 1인 경우
            if(current==1) {
                answer = cnt[current];
                return;
            }

            // 연산 확인
            for(int o=0; o<4; o++) {

                // 연산 가능 여부 확인
                if(!possible(current,o)) continue;

                // 연산 수행
                int next = calc(current,o);

                // 범위, 방문 여부 확인
                if(next>range || visited[next]) continue;

                // 탐색 대상 추가
                queue.offer(next);
                visited[next] = true;
                cnt[next] = cnt[current]+1;
            }
        }   
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 시작 숫자 입력
        int start = Integer.parseInt(br.readLine());

        // 1로 만들기
        answer = 1000000;
        range = start*2-1;
        solve(start);

        // 결과 출력
        System.out.println(answer);
    }
}