import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int y;
    int x;
    int dist;
    int wall;

    public Point(int y, int x, int dist, int wall) {
        this.y = y;
        this.x = x;
        this.dist = dist;
        this.wall = wall;
    }
}

public class Main {

    // 결과, 격자 크기, 벽 부수기 개수, 시작과 끝 위치
    public static int answer, size, boomCnt, startY, startX, endY, endX;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0}; 

    // 벽 없애고 탈출하기 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[boomCnt+1][size][size];

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작 위치 처리
        queue.offer(new Point(startY-1,startX-1,0,0));
        visited[0][startY-1][startX-1] = true;

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
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(visited[current.wall][ny][nx]) continue;

                // 벽이면서 부술 수 없는 경우
                if(map[ny][nx]==1 && current.wall==boomCnt) continue;

                // 벽이면서 부술 수 있는 경우
                if(map[ny][nx]==1 && current.wall<boomCnt) {
                    queue.offer(new Point(ny,nx,current.dist+1,current.wall+1));
                    visited[current.wall+1][ny][nx] = true;
                }

                // 벽이 없는 경우
                else {
                    queue.offer(new Point(ny,nx,current.dist+1,current.wall));
                    visited[current.wall][ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 벽 부수기 개수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        boomCnt = Integer.parseInt(st.nextToken());

        // 격자 배열 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 좌표 입력
        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());

        // 끝 좌표 입력
        st = new StringTokenizer(br.readLine());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());


        // 벽 없애고 탈출하기
        answer = -1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}