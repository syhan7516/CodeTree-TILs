import java.util.*;
import java.io.*;

public class Main {

    // 결과, 격자 크기
    public static int answer, size;

    // 격자
    public static int map[][];

    // 이동 정보 저장 배열
    public static int move[][];

    // 방문 여부 저장 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,-1,-1,0,1,1,1,0,-1};
    public static int dx[] = {0,0,1,1,1,0,-1,-1,-1};

    // 이동 메서드
    public static void solve(int row, int col, int cnt) {

        // 결과 갱신
        answer = Math.max(answer,cnt);

        // 현재 위치
        int y = row;
        int x = col;

        // 같은 방향으로 계속 이동
        while(true) {

            // 이동 방향 확인
            y = y+dy[move[row][col]];
            x = x+dx[move[row][col]];

            // 범위 확인
            if(y<0 || y>size-1 || x<0 || x>size-1) return;

            // 미방문이면서 현재 칸보다 큰 경우
            if(!visited[y][x] && map[row][col]<map[y][x]) {
            
                // 이동
                visited[y][x] = true;
                solve(y,x,cnt+1);
                visited[y][x] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

        
        // 이동 정보 저장 배열 생성
        move = new int[size][size];

        // 이동 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 입력
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 순서대로 확안하기
        answer = 0;

        // 이동
        visited[startY-1][startX-1] = true;
        solve(startY-1,startX-1,0);
        
        // 결과 출력
        System.out.println(answer);
    }
}