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

    // 결과, 격자 크기, 돌 개수, 시작점 수, 시작점(y,x)
    public static int answer, size, rockCnt, startCnt, startY, startX;

    // 격자
    public static int map[][];

    // 선택된 돌 저장 리스트
    public static ArrayList<Integer> selected;

    // 방문 여부 배열
    public static boolean visited[][];

    // 시작점 위치, 돌 위치 저장 리스트
    public static ArrayList<Point> starts, rocks;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탐색 수행 메서드
    public static void bfs() {

        // 이동 칸 수
        int moveCnt = 0;

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 시작 위치 순회
        for(int i=0; i<starts.size(); i++) {
            Point start = starts.get(i);
            queue.offer(start);
            visited[start.y][start.x] = true;
            moveCnt++;
        }

        while(!queue.isEmpty()) {

            // 큐 크기
            int queueSize = queue.size();

            while(queueSize-->0) {

                // 현재 위치
                Point current = queue.poll();

                // 주변 확인
                for(int d=0; d<4; d++) {
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                    // 방문했거나, 돌인 경우
                    if(visited[ny][nx] || map[ny][nx]==1) continue;

                    // 탐색 대상 추가
                    queue.offer(new Point(ny,nx));
                    visited[ny][nx] = true;
                    moveCnt++;
                }
            }
        }

        // 결과 갱신
        answer = Math.max(answer,moveCnt);
    }

    // 돌 선택하기 메서드
    public static void solve(int idx, int cnt) {

        // 돌 선택이 완료된 경우
        if(cnt==rockCnt) {

            // 돌 제거하기
            for(int i=0; i<selected.size(); i++) {
                Point rock = rocks.get(selected.get(i));
                map[rock.y][rock.x] = 0;
            }

            // 탐색 수행
            bfs();

            // 돌 놔두기
            for(int i=0; i<selected.size(); i++) {
                Point rock = rocks.get(selected.get(i));
                map[rock.y][rock.x] = 1;
            }

            return;
        }

        // 돌 선택하기
        for(int i=idx; i<rocks.size(); i++) {
            selected.add(i);
            solve(i+1,cnt+1);
            selected.remove(selected.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 시작점 수, 치워야하는 돌의 개수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        startCnt = Integer.parseInt(st.nextToken());
        rockCnt = Integer.parseInt(st.nextToken());

        // 시작점 위치, 돌 위치 저장 리스트 생성
        starts = new ArrayList<>();
        rocks = new ArrayList<>();

        // 격자 배열 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 돌 위치인 경우
                if(map[i][j]==1) rocks.add(new Point(i,j));
            }
        }

        // 시작점 정보 입력
        for(int i=0; i<startCnt; i++) {
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            starts.add(new Point(startY-1,startX-1));
        }

        // 선택된 돌 저장 리스트 생성
        selected = new ArrayList<>();

        // 돌 선택하기
        answer = 0;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}