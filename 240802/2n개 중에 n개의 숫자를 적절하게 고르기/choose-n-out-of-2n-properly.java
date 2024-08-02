import java.util.*;
import java.io.*;

public class Main {

    // 결과, 원소 개수, 원소 총 합
    public static int answer, numCnt, totalSum;

    // 원소 배열
    public static int nums[];

    // 원소 고르기 메서드
    public static void solve(int idx, int cnt, int score) {

        // 선택을 완료한 경우
        if(idx==numCnt*2) {

            // 개수 확인
            if(cnt==numCnt) {

                // 반대편 점수
                int rival = totalSum-score;

                // 결과 갱신
                answer = Math.min(answer,Math.abs(rival-score));
            }

            return;
        }

        // 원소 미선택
        solve(idx+1,cnt,score);

        // 원소 선택
        solve(idx+1,cnt+1,score+nums[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 원소 개수 입력
        numCnt = Integer.parseInt(br.readLine());

        // 원소 배열 생성
        nums = new int[numCnt*2];

        // 원소 정보 입력
        totalSum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            totalSum += nums[i];
        }

        // 원소 고르기
        answer = Integer.MAX_VALUE;
        solve(0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}