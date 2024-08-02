import java.util.*;
import java.io.*;

public class Main {

    // 결과, 숫자 개수, 선택 개수
    public static int answer, numCnt, selectCnt;

    // 숫자 저장 배열
    public static int nums[];

    // 결과 최대 만들기 메서드
    public static void solve(int idx, int cnt, int value) {

        // 선택이 완료된 경우
        if(idx==numCnt) {

            // 개수만큼 선택이된 경우
            if(cnt==selectCnt)
                answer = Math.max(answer,value);
            return;
        }

        // 숫자 미선택
        solve(idx+1,cnt,value);

        // 숫자 선택
        solve(idx+1,cnt+1,value^nums[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 숫자 저장 배열 생성
        nums = new int[numCnt];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 결과 최대 만들기
        answer = Integer.MIN_VALUE;
        solve(0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}