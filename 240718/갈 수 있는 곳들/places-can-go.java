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

    // 결과, 크기, 시작점 수
    public static int answer, size, startCnt;

    // 시작점 저장 리스트
    public static ArrayList<Point> startPoints;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 갈 수 있는 곳 확인 메서드
    public static void solve() {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 시작점 삽입
        for(int i=0; i<startPoints.size(); i++) {
            Point point = startPoints.get(i);
            queue.offer(point);
            visited[point.y][point.x] = true;
            answer++;
        }

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 탐색 위치 개수
            int cnt = queue.size();

            // 위치 개수만큼 탐색
            while(cnt-->0) {

                // 현재 노드
                Point current = queue.poll();

                // 주변 확인
                for(int d=0; d<4; d++) {
                    
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                    // 이미 방문했거나, 못 가는 칸인 경우
                    if(visited[ny][nx] || map[ny][nx]==1) continue;

                    // 큐에 삽입
                    queue.offer(new Point(ny,nx));
                    visited[ny][nx] = true;
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기, 시작점 수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        startCnt = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작점 저장 리스트 생성
        startPoints = new ArrayList<>();

        // 시작점 입력
        for(int i=0; i<startCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            startPoints.add(new Point(y-1,x-1));
        }

        // 갈 수 있는 곳 확인
        answer = 0;
        solve();
        
        // 결과 출력
        System.out.println(answer);
    }
}