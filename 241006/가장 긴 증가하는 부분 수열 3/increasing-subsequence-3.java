import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 숫자 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 숫자 배열, 길이 배열 생성
        int nums[] = new int[numCnt];
        int dp[] = new int[numCnt];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        
        // 가장 긴 증가하는 부분 수열 구하기
        for(int i=0; i<numCnt; i++) {
            
            // 길이
            int maxLen = 1;

            // 이전 숫자 확인
            for(int j=i-1; j>0; j--) {

                // 비교
                maxLen = Math.max(maxLen,dp[j]+1);
            }

            // LCS 값 저장 및 결과 갱신
            dp[i] = maxLen;
            answer = Math.max(answer,maxLen);
        }

        // 결과 출력
        System.out.println(answer);
    }
}