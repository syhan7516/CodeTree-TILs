import java.util.*;
import java.io.*;

public class Main {

    // 숫자 범위, 반복 횟수, 연속한 숫자, 연속한 개수
    public static int range, maxCnt, preNum, numCnt;
    
    // 결과 저장 빌더
    public static StringBuilder sb;

    // 선택된 숫자 저장 리스트
    public static ArrayList<Integer> nums;

    // 숫자 선택하기 메서드
    public static void solve(int cnt) {

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

            // 연속인 숫자 개수가 3개 이상인 경우
            if(preNum==i && numCnt==2) continue;

            // 아닌 경우
            else {

                // 이전과 동일한 숫자인 경우
                if(preNum==i) numCnt++;

                // 동일하지 않는 경우
                else {
                    preNum = i;
                    numCnt = 1;
                }
                
                nums.add(i);
                solve(cnt+1);
                nums.remove(nums.size()-1);
            }
           
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
        preNum = -1;
        numCnt = -1;
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}