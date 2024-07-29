import java.util.*;
import java.io.*;

public class Main {

    // 숫자 범위, 반복 횟수
    public static int range, maxCnt;
    
    // 결과 저장 빌더
    public static StringBuilder sb;

    // 선택된 숫자 저장 리스트
    public static ArrayList<Integer> nums;

    // 숫자 선택하기 메서드
    public static void solve(int cnt, int preNum, int numCnt) {

        // 동일 숫자가 3개인 경우
        if(numCnt==3) return;

        // 선택이 완료된 경우
        if(cnt==maxCnt) {

            // 결과 저장
            for(int n: nums) 
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        // 숫자 선택하기
        for(int i=1; i<=range; i++) {
            
            nums.add(i);
            
            // 이전과 동일한 숫자를 선택한 경우
            if(i==preNum) solve(cnt+1,i,numCnt+1);

            // 다른 숫자를 선택한 경우
            else solve(cnt+1,i,1);
            
            nums.remove(nums.size()-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 범위, 반복 횟수 입력
        st = new StringTokenizer(br.readLine());
        range = Integer.parseInt(st.nextToken());
        maxCnt = Integer.parseInt(st.nextToken());

        // 선택된 숫저 저장 리스트 생성
        nums = new ArrayList<Integer>();

        // 숫자 선택하기
        sb = new StringBuilder();
        solve(0,0,0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}