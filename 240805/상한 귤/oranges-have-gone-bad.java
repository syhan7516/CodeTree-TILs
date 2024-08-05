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

    // 격자 크기, 상한 귤 개수
    public static int size, trashCnt;

    // 격자, 결과 배열
    public static int[][] map, result;

    // 상한 귤 위치 저장 리스트
    public static ArrayList<Point> trash;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 상한 귤 만들기 메서드
    public static void solve() {

        // 시간
        int time = 1;

        // 결과 배열 생성
        result = new int[size][size];

        // 방문 여부 배열 생성
        boolean visited[][] = new boolean[size][size];

        // 탐색 대상 위치 저장 큐
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        for(int i=0; i<trash.size(); i++) {
            Point point = trash.get(i);
            queue.offer(point);
            visited[point.y][point.x] = true;
        }

        // 탐색 수행
        while(!queue.isEmpty()) {
            
            // 상한 귤 개수
            int cnt = queue.size();

            // 상한 귤 확인
            while(cnt-->0) {
                
                // 현재 위치 
                Point current = queue.poll();

                // 주변 확인
                for(int d=0; d<4; d++) {
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                    // 이미 방문했거나, 귤이 아닌 경우
                    if(visited[ny][nx] || map[ny][nx]==0) continue;

                    // 탐색 대상 추가
                    queue.offer(new Point(ny,nx));
                    visited[ny][nx] = true;
                    result[ny][nx] = time;
                }
            }

            // 시간 증가
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 격자 크기, 상한 귤 개수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        trashCnt = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[size][size];

        // 상한 귤 위치 저장 리스트 생성
        trash = new ArrayList<>();

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 상한 귤인 경우
                if(map[i][j]==2) 
                    trash.add(new Point(i,j));
            }
        }

        // 상한 귤 만들기
        solve();

        // 결과 저장
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                // 비어있는 경우
                if(map[i][j]==0) sb.append(-1).append(" ");

                // 기존 상한 귤인 경우
                else if(map[i][j]==2) sb.append(0).append(" ");

                // 기존 귤인 경우
                else {

                    // 상한 귤로 변한 경우
                    if(result[i][j]!=0) sb.append(result[i][j]).append(" ");

                    // 상하지 않은 귤인 경우
                    else sb.append(-2).append(" ");
                }
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}