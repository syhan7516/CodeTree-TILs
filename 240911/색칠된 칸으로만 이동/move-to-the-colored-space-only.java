import java.util.*;
import java.io.*;

// 위치 클래스
class Point implements Comparable<Point> {
    int y;
    int x;
    int value;
    int maxDist;

    public Point(int y, int x, int value, int maxDist) {
        this.y = y;
        this.x = x;
        this.value = value;
        this.maxDist = Math.max(maxDist,value);
    }

    public int compareTo(Point other) {
        return this.value - other.value;
    }
}

public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 색깔 위치 정보 저장 리스트
    public static ArrayList<Point> points;

    // 격자
    public static int map[][];

    // 방문 위치 여부 배열
    public static boolean visited[][];

    // 우선 순위 큐
    public static PriorityQueue<Point> queue;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 거리 확인 메서드
    public static int solve(int start, int end) {

        // 시작 위치, 목적지 위치
        Point s = points.get(start);
        Point e = points.get(end);

        // 초기 설정
        queue = new PriorityQueue<>();
        visited = new boolean[rowSize][colSize];
        queue.add(s);
        visited[s.y][s.x] = true;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();
            visited[current.y][current.x] = true;

            // 목적지인 경우
            if(current.y==e.y && current.x==e.x)
                return current.maxDist;

            // 이동 가능한 위치 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 방문여부 확인
                if(visited[ny][nx]) continue;

                // 탐색 위치 추가
                queue.add(
                    new Point(ny,nx,
                    Math.abs(map[current.y][current.x]-map[ny][nx]),
                    current.maxDist));
            }
        }

        return -1;
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

        // 색깔 위치 정보 저장 리스트 생성
        points = new ArrayList<>();

        // 색깔 위치 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                if(Integer.parseInt(st.nextToken())==1)
                    points.add(new Point(i,j,0,0));
            }
        }

        // 색깔된 위치 거리 확인
        answer = 0;
        for(int i=0; i<points.size()-1; i++) {
            for(int j=i+1; j<points.size(); j++) {

                // 거리 확인
                answer = Math.max(answer,solve(i,j));
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}