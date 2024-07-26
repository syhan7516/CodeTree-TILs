import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        int map[][] = new int[size+1][size+1];

        // 최소 합 배열 생성
        int DP[][] = new int[size+1][size+1];

        // 격자 정보 입력
        for(int i=1; i<=size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<=size; i++) {
            for(int j=0; j<=size; j++) {
                if(i==0 || j==0) DP[i][j] = Integer.MAX_VALUE;
            }
        }

        // 최소 합 구하기
        for(int i=1; i<=size; i++) {
            for(int j=size-1; j>=0; j--) {
                if(i==size-1 && j==size-1) DP[i][j] = map[i][j];
                else DP[i][j] = Math.min(DP[i-1][j],DP[i][j+1])+map[i][j];
            }
        }
        
        // 결과 출력
        System.out.println(DP[size][0]);
    }
}