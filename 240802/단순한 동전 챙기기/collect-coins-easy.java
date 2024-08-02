import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int y;
    int x;
    int value;

    public Point(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }
}

public class Main {

    // 결과, 크기, 시작과 끝 위치
    public static int answer, size, startY, startX, endY, endX;

    // 격자
    public static char map[][];

    // 선택된 동전 저장 리스트
    public static ArrayList<Integer> selected;

    // 동전 정보 저장 리스트
    public static ArrayList<Point> coins;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 동전 찾기 메서드
    public static int find(int sy, int sx, int ey, int ex, boolean visited[][]) {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작 지점 처리
        queue.offer(new Point(sy,sx,0));
        visited[sy][sx] = true;

        // 이동 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 목적지에 도착한 경우
            if(current.y==ey && current.x==ex)
                return current.value;

            // 주변 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(visited[ny][nx]) continue;

                // 탐색 위치 추가
                queue.offer(new Point(ny,nx,current.value+1));
                visited[ny][nx] = true;
            }
        }

        return 0;
    }

    // 동전 선택하기 메서드
    public static void solve(int idx, int cnt) {

        // 선택이 완료된 경우
        if(cnt==3) {

            // 이동 수, 출발 위치
            int dist = 0;
            int sy = startY;
            int sx = startX;

            // 동전 확인
            for(int i=0; i<selected.size(); i++) {
                
                // 현재 동전
                Point coin = coins.get(i);

                // 동전 찾기
                dist += find(sy,sx,coin.y,coin.x,new boolean[size][size]);
                
                // 출발 위치 갱신
                sy = coin.y;
                sx = coin.x;
            }

            // 마지막 지점으로 이동
            dist += find(sy,sx,endY,endX,new boolean[size][size]);

            // 결과 갱신
            answer = Math.min(answer,dist);

            return;
        }

        // 동전 선택
        for(int i=idx; i<coins.size(); i++) {
            selected.add(i);
            solve(i+1,cnt+1);
            selected.remove(selected.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());

        // 선택된 동전 정보 리스트 생성
        selected = new ArrayList<>();

        // 동전 정보 저장 리스트 생성
        coins = new ArrayList<>();

        // 격자 생성
        map = new char[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            String letter = br.readLine();
            for(int j=0; j<size; j++) {
                map[i][j] = letter.charAt(j);

                // S
                if(map[i][j]=='S') {
                    startY = i;
                    startX = j;
                }

                // E
                if(map[i][j]=='E') {
                    endY = i;
                    endX = j;
                }

                // 1 ~ 9
                if(map[i][j]-'0'>=1 && map[i][j]-'0'<=9) {
                    coins.add(new Point(i,j,map[i][j]-'0'));
                }
            }
        }

        // 동전 정렬
        Collections.sort(coins, (a,b) -> a.value-b.value);

        // 동전 선택하기
        answer = Integer.MAX_VALUE;
        if(coins.size()>=3)
            solve(0,0);
        else answer = -1;

        // 결과 출력
        System.out.println(answer);
    }
}