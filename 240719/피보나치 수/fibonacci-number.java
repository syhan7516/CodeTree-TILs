import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        int number = Integer.parseInt(br.readLine());

        // DP 테이블 생성
        int DP[] = new int[number+1];

        // 기본 설정
        DP[1] = 1;

        // 피보나치 구하기
        for(int i=2; i<=number; i++) {
            DP[i] = DP[i-1]+DP[i-2];
        }

        // 결과 출력
        System.out.println(DP[number]);
    }
}