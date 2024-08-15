import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = Integer.MIN_VALUE;

        // 숫자 개수와 범위 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        // 숫자 배열, 누적합 배열 생성
        int nums[] = new int[numCnt];
        int prefixSum[] = new int[numCnt];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 누적합 정보 입력
        prefixSum[0] = nums[0];
        for(int i=1; i<numCnt; i++)
            prefixSum[i] = prefixSum[i-1]+nums[i];

        // 초기 설정
        answer = prefixSum[range-1];

        // 합 구하기
        for(int i=range; i<numCnt; i++) {
            int sum = prefixSum[i]-prefixSum[i-range];
            answer = Math.max(answer,sum);
        }

        // 결과 출력
        System.out.println(answer);
    }
}