import java.util.*;
import java.io.*;

public class Main {

    // 범위, 선택 개수
    public static int range, selectCnt;

    // 숫자 선택 결과 리스트
    public static ArrayList<Integer> result;

    // 숫자 선택 메서드
    public static void solve(int cnt) {

        // 모두 선택된 경우
        if(cnt==selectCnt) {
            
            // 저장된 결과값 출력
            for(int num: result)
                System.out.print(num+" ");
            System.out.println();
            
            return;
        }

        // 숫자 선택
        for(int i=1; i<=range; i++) {
            result.add(i);
            solve(cnt+1);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 범위, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        range = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 결과 리스트 생성
        result = new ArrayList<>();

        // 숫자 선택
        solve(0);
    }
}