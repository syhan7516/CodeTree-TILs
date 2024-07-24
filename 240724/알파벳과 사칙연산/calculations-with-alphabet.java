import java.util.*;
import java.io.*;

public class Main {

    // 결과, 피연산자 개수
    public static long answer;
    public static int numCnt;

    // 식
    public static String letters;

    // 선택된 피연산자 저장 리스트
    public static ArrayList<Integer> selected;

    // 피연산자 선택 메서드
    public static void solve(int cnt) {

        // 선택이 완료된 경우
        if(cnt==numCnt) {

            // 피연자 인덱스
            int idx = 0; 

            // 연산 결과
            long result = selected.get(idx++);

            // 연산자 확인
            for(int i=1; i<letters.length(); i+=2) {
                
                // 현재 연산자
                char c = letters.charAt(i);

                // +
                if(c=='+') result += selected.get(idx++);

                // -
                else if(c=='-') result -= selected.get(idx++);

                // *
                else result *= selected.get(idx++);
            }

            // 결과 갱신
            answer = Math.max(answer,result);

            return;
        }

        // 아닌 경우
        for(int i=1; i<=4; i++) {
            selected.add(i);
            solve(cnt+1);
            selected.remove(selected.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 식 입력
        letters = br.readLine();

        // 결과
        answer = 0;

        // 피연산자 개수
        numCnt = letters.length()/2+1;

        // 선택된 피연산자 저장 리스트 생성
        selected = new ArrayList<>();

        // 피연산자 선택
        solve(0);
        
        // 결과 출력
        System.out.println(answer);
    }
}