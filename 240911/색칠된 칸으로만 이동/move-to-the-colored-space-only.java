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

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 색깔 위치 정보 저장 리스트
    public static ArrayList<Point> points;

    // 격자
    public static int map[][];

    // 방문 위치 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 색깔 위치 방문 여부 확인 메서드
    public static boolean solveVisited() {

        // 색깔 위치 순회
        for(int i=0; i<points.size(); i++) {

            // 확인 위치
            Point point = points.get(i);

            // 미방문인 경우
            if(!visited[point.y][point.x])
                return false;
        }

        return true;
    }


    // 거리 확인 메서드
    public static void solveDiff(int distLen) {

        // 색깔 시작 위치
        Point start = points.get(0);
        
        // 초기 설정
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[rowSize][colSize];
        queue.offer(new Point(start.y,start.x));
        visited[start.y][start.x] = true;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 이동 가능한 위치 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 방문여부 확인
                if(visited[ny][nx]) continue;

                // 거리 차 확인
                if(Math.abs(map[current.y][current.x]-map[ny][nx])>distLen) continue;

                // 탐색 위치 추가
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
                    points.add(new Point(i,j));
            }
        }

        // 모든 거리 확인
        answer = -1;
        int left = 0;
        int right = (int)1e9;
        
        while(left<=right) {

            // 차이 설정
            int mid = (left+right)/2;

            // 차이를 기준으로 거리 확인
            solveDiff(mid);

            // 색깔 위치 방문 여부 확인
            boolean flag = solveVisited();

            // 미방문이 존재하는 경우
            if(!flag) left = mid+1;

            // 모두 방문한 경우
            else {
                answer = mid;
                right = mid-1;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}