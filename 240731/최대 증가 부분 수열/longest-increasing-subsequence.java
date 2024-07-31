import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 1;

        // 원소 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 원소 배열 생성
        int nums[] = new int[numCnt];

        // 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // DP 테이블 생성
        int DP[] = new int[numCnt];

        // 최대 증가 부분 수열 구하기
        for(int i=0; i<numCnt; i++) {
            
            // 기본 값
            DP[i] = 1;
            for(int j=0; j<i; j++) {

                // 기준 수보다 작은 경우
                if(nums[i]>nums[j]) {
                    DP[i] = Math.max(DP[i],DP[j]+1);
                    answer = Math.max(answer,DP[i]);
                }
            }
        } 

        // 결과 출력
        System.out.println(answer);
    }
}