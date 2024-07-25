import java.util.*;
import java.io.*;

public class Main {

    // 결과
    public static int answer;

    // 식
    public static String letters;

    // 선택된 피연산자 저장 리스트
    public static ArrayList<Integer> selected;

    // 피연산자 선택 메서드
    public static void solve(int cnt) {

        // 선택이 완료된 경우
        if(cnt==6) {

            // 연산 결과
            int result = selected.get(letters.charAt(0)-'a');

            // 연산자 확인
            for(int i=1; i<letters.length(); i+=2) {
                
                // 현재 연산자
                char c = letters.charAt(i);

                // 현재 피연산자
                char num = letters.charAt(i+1);

                // +
                if(c=='+') result += selected.get(num-'a');

                // -
                else if(c=='-') result -= selected.get(num-'a');

                // *
                else result *= selected.get(num-'a');
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
        answer = Integer.MIN_VALUE;

        // 선택된 피연산자 저장 리스트 생성
        selected = new ArrayList<>();

        // 피연산자 선택
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}