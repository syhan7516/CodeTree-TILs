import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int y;
    int x;
    int dist;

    public Point(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {

    // 결과, 격자 크기
    public static int answer, rowSize, colSize;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탈출하기 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        queue.offer(new Point(0,0,0));
        visited[0][0] = true;

        // 탈출하기
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 목적지인 경우
            if(current.y==rowSize-1 && current.x== colSize-1) {
                answer = current.dist;
                return;
            }

            // 이동 가능한 방향 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 이미 방문했거나, 뱀이 있는 경우
                if(visited[ny][nx] || map[ny][nx]==0) continue;

                // 탐색 위치에 추가
                queue.offer(new Point(ny,nx,current.dist+1));
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

        // 격자 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탈춯하기
        answer = -1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}