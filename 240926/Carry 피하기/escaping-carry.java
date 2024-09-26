import java.util.*;
import java.io.*;

public class Main {

    // 결과, 숫자 개수
    public static int answer, numCnt;

    // 숫자 배열
    public static int nums[];

    // carry 확인 메서드
    public static boolean carry(int a, int b) {

        // 숫자 -> 문자열
        String num1 = String.format("%09d",a);
        String num2 = String.format("%09d",b); 

        // 확인
        for(int i=num1.length()-1; i>=0; i--) {
            
            // 한 자리 수 가져오기
            a = num1.charAt(i)-'0';
            b = num2.charAt(i)-'0';

            // 더한 후 확인
            if((a+b)>9) return true;
        }

        return false;
    }

    // 숫자 선택 메서드
    public static void solve(int idx, int cnt, int selectedCnt, int sum) {

        // 숫자 선택이 완료된 경우
        if(cnt==numCnt) {
            answer = Math.max(answer,selectedCnt);
            return;
        }

        // 숫자 선택하기
        for(int i=idx; i<numCnt; i++) {

            solve(i+1,cnt+1,selectedCnt,sum);

            // carry 확인
            if(carry(sum,nums[i])) continue;
            else solve(i+1,cnt+1,selectedCnt+1,sum+nums[i]);
        }

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
        solve(0,0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}