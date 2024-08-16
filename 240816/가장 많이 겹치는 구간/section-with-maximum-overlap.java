import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 구간 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 구간 연산 배열 생성
        int calc[] = new int[200001];

        // 구간 정보 입력
        for(int i=1; i<=cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // +1,-1 수행
            calc[start]++;
            calc[end]--;
        }

        // 구간 정보 확인
        int sum = 0;
        for(int i=1; i<=200000; i++) {
            sum += calc[i];
            answer = Math.max(answer,sum);
        }

        // 결과 출력
        System.out.println(answer);
    }
}