import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 식 입력
        String letters = br.readLine();

        // 결과
        int answer = 4;

        // 식 확인
        for(int i=1; i<letters.length(); i+=2) {

            // 현재 문자
            char c = letters.charAt(i);

            // -
            if(c=='-') answer -= 1;

            // +
            else if(c=='+') answer += 4;

            // *
            else answer *= 4;
        }

        // 결과 출력
        System.out.println(answer);
    }
}