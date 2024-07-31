import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

        // 최대 점프 횟수 구하기
        for(int i=0; i<numCnt; i++) {

            // 0인 경우
            if(nums[i]==0) continue;

            for(int j=1; j<=nums[i]; j++) {

                // 점프 위치
                int target = i+j;

                // 점프가 범위를 넘는 경우
                if(target>numCnt-1) break;

                // 해당 위치에 더 많은 점프를 한 경우
                DP[target] = Math.max(DP[target],DP[i]+1);
            }
        }
        
        // 결과
        System.out.println(DP[numCnt-1]);
    }
}