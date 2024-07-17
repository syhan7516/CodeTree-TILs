import java.util.*;
import java.io.*;

public class Main {

    // 가로 크기, 세로 크기
    public static int rowSize, colSize;

    // 결과 
    public static boolean flag;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1};
    public static int dx[] = {1,0};

    // 범위 확인 메서드
    public static boolean inRange(int row, int col) {
        return (row<0 || row>rowSize-1 || col<0 || col>colSize-1);
    }
    
    // 미로 탈출하기 메서드
    public static void solve(int row, int col) {

        // 목표 지점에 도달한 경우
        if(row==rowSize-1 && col== colSize-1) {
            flag = true;
            return;
        }

        // 주변 확인
        for(int d=0; d<2; d++) {

            int ny = row+dy[d];
            int nx = col+dx[d];

            // 범위 확인
            if(inRange(ny,nx)) continue;

            // 이미 방문했거나, 뱀인 경우
            if(visited[ny][nx] || map[ny][nx]==1) continue;

            // 탐색 가능한 경우
            visited[ny][nx] = true;
            solve(ny,nx);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 격자 배열 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 미로 탈출하기
        flag = false;
        solve(0,0);

        // 결과 출력
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}