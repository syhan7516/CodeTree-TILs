import java.util.*;
import java.io.*;

public class Main {

    // 결과, 숫자 개수
    public static int answer, numCnt;

    // 숫자 배열
    public static int nums[];

    // carry 확인 메서드
    public static boolean carry(int a, int b) {

        // 확인
        while(true) {

            // 둘 중 하나라도 0인 경우
            if(a==0 || b==0) return false;

            // 수 확인
            int sum = (a%10)+(b%10);
            if(sum>9) return true;

            // 자리 변경
            a = a/10;
            b = b/10;
        }
    }

    // 숫자 선택 메서드
    public static void solve(int cnt, int selectedCnt, int sum) {

        // 이미 불가능한 경우
        if((numCnt-cnt+selectedCnt)<=answer) return;

        // 숫자 선택이 완료된 경우
        if(cnt==numCnt) {
            answer = Math.max(answer,selectedCnt);
            return;
        }

        // 숫자 선택하기
        solve(cnt+1,selectedCnt,sum);

        // carry 확인
        if(carry(sum,nums[cnt])) return;
        else solve(cnt+1,selectedCnt+1,sum+nums[cnt]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 개수 입력
        numCnt = Integer.parseInt(br.readLine());

        // 숫자 정보 배열 생성
        nums = new int[numCnt];

        // 숫자 입력
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(br.readLine());

        // 숫자 선택하기
        answer = 0;
        solve(0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}