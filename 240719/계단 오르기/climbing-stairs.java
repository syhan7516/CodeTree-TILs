import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        int stage = Integer.parseInt(br.readLine());

        // DP 테이블 생성
        int DP[] = new int[1001];

        // 기본 설정
        DP[2] = 1;
        DP[3] = 1;

        // 계단 오르기
        for(int i=4; i<1001; i++) {
            DP[i] = DP[i-2]+DP[i-3];
        }

        // 결과 출력
        System.out.println(DP[stage]);
    }
}