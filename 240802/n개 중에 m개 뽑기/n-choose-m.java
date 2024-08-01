import java.util.*;
import java.io.*;

public class Main {

    // 숫자 범위, 개수
    public static int range, numCnt;

    // 선택된 원소 저장 리스트
    public static ArrayList<Integer> selected;

    // 숫자 조합하기 메서드
    public static void solve(int number, int cnt) {
        
        // 선택이 완료된 경우
        if(cnt==numCnt) {

            // 결과 저장
            for(int n: selected) 
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        // 숫자 선택하기
        for(int i=number; i<=range; i++) {
            selected.add(i);
            solve(i+1,cnt+1);
            selected.remove(selected.size()-1);
        }
    }

    // 결과 저장 빌더
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        // 숫자 범위, 개수 입력
        st = new StringTokenizer(br.readLine());
        range = Integer.parseInt(st.nextToken());
        numCnt = Integer.parseInt(st.nextToken());

        // 선택된 원소 저장 리스트 생성
        selected = new ArrayList<>();
        
        // 숫자 조합하기
        solve(1,0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}