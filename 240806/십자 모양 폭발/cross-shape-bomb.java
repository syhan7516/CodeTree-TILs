import java.util.*;
import java.io.*;

public class Main {

    // 격자 크기
    public static int size;

    // 격자 배열
    public static int map[][];

    // 임시 배열
    public static int mock[];

    // 가로 폭발 수행 메서드
    public static void boomRow(int row, int col, int boomSize) {

        // 폭발 크기
        int start = row-boomSize+1;
        int end = row+boomSize-1;

        for(int i=start; i<=end; i++) {

            // 범위 확인
            if(i<0 || i>size-1) continue;

            // 폭발
            map[i][col] = 0;
        }
    }

    // 세로 폭발 수행 메서드
    public static void boomCol(int row, int col, int boomSize) {

        // 폭발 크기
        int start = col-boomSize+1;
        int end = col+boomSize-1;

        for(int i=start; i<=end; i++) {

            // 범위 확인
            if(i<0 || i>size-1) continue;

            // 폭발
            map[row][i] = 0;
        }
    }

    // 폭발 처리 메서드
    public static void boomResult() {

        // 가로 확인
        for(int i=0; i<size; i++) {

            // 임시 배열 및 변수 생성
            mock = new int[size];
            int mockIdx = size-1;

            // 빈 곳 채우기
            for(int j=size-1; j>=0; j--) {
                if(map[j][i]!=0)
                    mock[mockIdx--] = map[j][i];
            }

            // 결과 옮기기
            for(int j=size-1; j>=0; j--)
                map[j][i] = mock[j];
        }
    }

    // 폭발 수행 메서드
    public static void solve(int row, int col) {

        // 임시 배열 생성
        mock = new int[size];

        // 폭발 크기
        int boomSize = map[row][col];

        // 가로, 세로 폭발 수행
        boomRow(row,col,boomSize);
        boomCol(row,col,boomSize);

        // 폭발 처리
        boomResult();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 폭발 위치 입력 및 수행
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        solve(row-1,col-1);

        // 결과 저장
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}