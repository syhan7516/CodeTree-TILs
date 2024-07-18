import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 탈출 여부
    public static boolean flag;

    // 가로, 세로 크기
    public static int rowSize, colSize;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탈출하기 메서드
    public static void solve(int row, int col) {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 삽입
        queue.offer(new Point(row,col));
        visited[row][col] = true;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 위치가 탈출구인 경우
            if(current.y==rowSize-1 && current.x==colSize-1) {
                flag = true;
                return;
            }

            // 주변 탐색
            for(int d=0; d<4; d++) {

                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 이미 방문했거나, 뱀인 경우
                if(visited[ny][nx] || map[ny][nx]==0) continue;

                // 큐에 위치 추가
                queue.offer(new Point(ny,nx));
                visited[ny][nx] = true;
            }
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

        // 탈출하기
        flag = false;
        solve(0,0);

        // 결과 출력
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}