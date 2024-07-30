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

    // 결과, 격자 크기, 시작과 끝 위치
    public static int answer, size, startY, startX, endY, endX;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {2,1,-1,-2,-2,-1,1,2};
    public static int dx[] = {1,2,2,1,-1,-2,-2,-1};

    // 탈출하기 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        queue.offer(new Point(startY-1,startX-1,0));
        visited[startY-1][startX-1] = true;

        // 탈출하기
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 목적지인 경우
            if(current.y==endY-1 && current.x==endX-1) {
                answer = current.dist;
                return;
            }

            // 이동 가능한 방향 확인
            for(int d=0; d<8; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(visited[ny][nx]) continue;

                // 탐색 위치에 추가
                queue.offer(new Point(ny,nx,current.dist+1));
                visited[ny][nx] = true;
             }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 생성
        map = new int[size][size];

        // 시작과 끝 정보 입력
        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        // 탈춯하기
        answer = -1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}