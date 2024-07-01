import java.util.*;
import java.io.*;

public class Main {

    // 적합성 판단 메서드
    static int solve(Stack<Character> st,String letter) {

        // 괄호 확인
        for(int i=0; i<letter.length(); i++) {

            // 확인 괄호
            char c = letter.charAt(i);

            // 열린 괄호인 경우
            if(c=='(') {
                st.push(c);
            }

            // 닫힌 괄호인 경우
            else {
                
                // 스택이 비었는지 확인
                if(st.isEmpty()) {
                    return -1;
                }

                st.pop();
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 괄호 확인을 위한 스택 생성
        Stack<Character> st = new Stack<>();

        // 괄호 문자열 입력
        String letter = br.readLine();

        // 적합성 판단하기
        int answer = solve(st,letter);

        // 괄호가 다 처리되었는지 확인
        if(!st.isEmpty() || answer==-1) System.out.println("No");
        else System.out.println("Yes");
    }
}