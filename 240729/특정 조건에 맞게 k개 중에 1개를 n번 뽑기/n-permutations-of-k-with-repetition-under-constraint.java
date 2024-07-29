import java.util.*;
import java.io.*;

public class Main {

    // 숫자 범위, 반복 횟수
    public static int range, maxCnt;
    
    // 결과 저장 빌더
    public static StringBuilder sb;

    // 숫자 개수 배열
    public static int num[];

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

            // 3개 이상인 경우
            if(num[i]==2) continue;

            nums.add(i);
            solve(cnt+1);
            num[nums.get(nums.size()-1)]--;
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

        // 숫자 개수 배열 생성
        num = new int[range+1];

        // 선택된 숫저 저장 리스트 생성
        nums = new ArrayList<Integer>();

        // 숫자 선택하기
        sb = new StringBuilder();
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}