import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int num;
    int y;
    int x;
    int dist;

    public Point(int num, int y, int x, int dist) {
        this.num = num;
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {

    // 결과
    public static int answer[][];

    // 격자 크기, 사람 수, 공간의 수
    public static int size, people, space;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][][];

    // 도착 여부 배열
    public static boolean complete[];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 사람 위치 정보 저장 리스트
    public static ArrayList<Point> sarams;

    // 비 피하기 메서드
    public static void solve() {

        // 도착 여부 배열 생성
        complete = new boolean[people];

        // 방문 여부 배열 생성
        visited = new boolean[people][size][size];

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작 위치 처리
        for(int i=0; i<sarams.size(); i++) {
            Point point = sarams.get(i);
            queue.offer(point);
            visited[point.num][point.y][point.x] = true;
        }

        // 비 피하기
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 이미 도착한 사람인 경우
            if(complete[current.num]) continue;

            // 비 피하는 공간인 경우
            if(map[current.y][current.x]==3 && !complete[current.num]) {
                Point point = sarams.get(current.num);
                answer[point.y][point.x] = current.dist;
                complete[current.num] = true;
                continue;
            }

            // 이동 가능한 위치 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문했거나, 벽인 경우
                if(visited[current.num][ny][nx] || map[ny][nx]==1) continue;

                // 탐색 위치 추가
                queue.offer(new Point(current.num,ny,nx,current.dist+1));
                visited[current.num][ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 사람 수, 공간의 수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        people = Integer.parseInt(st.nextToken());
        space = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[size][size];
        
        // 결과 배열 생성
        answer = new int[size][size];

        // 사람 위치 정보 저장 리스트 생성
        sarams = new ArrayList<>();

        // 격자 정보 입력
        int idx = 0;
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 사람인 경우
                if(map[i][j]==2) {
                    sarams.add(new Point(idx++,i,j,0));
                    answer[i][j] = -1;
                }
            }
        }

        // 비 피하기
        solve();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}