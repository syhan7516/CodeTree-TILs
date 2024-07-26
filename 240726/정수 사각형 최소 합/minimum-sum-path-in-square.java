import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        int map[][] = new int[size][size];

        // 최소 합 배열 생성
        int DP[][] = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 설정
        DP[0][size-1] = map[0][size-1];
        for(int i=size-2; i>=0; i--) DP[0][i] = DP[0][i+1]+map[0][i];
        for(int i=1; i<size; i++) DP[i][size-1] = DP[i-1][size-1]+map[i][size-1];

        // 최소 합 구하기
        for(int i=1; i<size; i++) {
            for(int j=size-2; j>=0; j--) {
                DP[i][j] = Math.min(DP[i-1][j],DP[i][j+1])+map[i][j];
            }
        }
         
        // 결과 출력
        System.out.println(DP[size-1][0]);
    }
}