import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자 입력
        int number = Integer.parseInt(br.readLine());

        // DP 테이블 생성
        int DP[] = new int[1001];

        // 기본 설정
        DP[0] = 1;
        DP[1] = 2;
        DP[2] = 7;

        // 사각형 채우기
        for(int i=2; i<=number; i++) {
            DP[i] = (DP[i-1]*2+DP[i-2]*3)%1000000007;
            for(int j=i-3; j>=0; j--) {
                DP[i] = (DP[i]+DP[j]*2)%1000000007;
            }
        }

        // 결과 출력
        System.out.println(DP[number]);
    }
}