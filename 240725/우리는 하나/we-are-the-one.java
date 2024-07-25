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
    
    // 결과, 격자 크기, 고를 도시 수, 높이 차 범위
    public static int answer, size, city, left, right;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 선택된 도시 리스트
    public static ArrayList<Point> selected;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 도시 이동 메서드
    public static void moveToCity() {

        // 이동 도시 수
        int moveCnt = 0;

        // 위치 탐색 관리 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 선택된 도시 확인
        for(int i=0; i<selected.size(); i++) {
            
            // 확인 도시
            Point point = selected.get(i);
            queue.offer(point);
            visited[point.y][point.x] = true;
            moveCnt++;
        }

        // 이동 가능한 위치 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 주변 확인
            for(int d=0; d<4; d++) {

                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 격자 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(visited[ny][nx]) continue;

                // 높이 차 확인
                int diff = Math.abs(map[current.y][current.x]-map[ny][nx]);
                if(diff<left || diff>right) continue;

                // 이동 가능한 위치 저장
                queue.offer(new Point(ny,nx));
                visited[ny][nx] = true;
                moveCnt++;
            }
        }

        // 결과 갱신
        answer = Math.max(answer,moveCnt);
    }


    // 도시 고르기 메서드
    public static void solve(int idx, int cnt) {

        // 도시를 다 고른 경우
        if(cnt==city) {

            // 도시 이동
            moveToCity();
            return;
        }

        // 도시 선택하기
        for(int i=idx; i<size*size; i++) {
            selected.add(new Point(i/size,i%size));
            solve(i+1,cnt+1);
            selected.remove(selected.size()-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 고를 도시 수, 높이 차 범위 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        city = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 선택된 도시 리스트
        selected = new ArrayList<>();

        // 도시 고르기
        answer = 0;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}