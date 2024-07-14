import java.io.*;
import java.util.*;

public class Main {

    // 3*3 탐색 메서드
    public static int solve(int map[][], int row, int col) {

        // 얻은 동전 수
        int cnt = 0;

        for(int i=0; i<row+3; i++) {
            for(int j=0; j<col+3; j++) {
                cnt += map[i][j];
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 격자 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 격자 생성
        int map[][] = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 격자 탐색
        for(int i=0; i<size-2; i++) {
            for(int j=0; j<size-2; j++) {

                // 3*3 탐색
                answer = Math.max(answer,solve(map,i,j));
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}