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

    // 결과, 격자 크기, 터진 블록 수, 최대 블록 크기
    public static int answer, size, boom, maxBlockCnt;

    // 격자
    public static int map[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 블록 확인 메서드
    public static void solve(int row, int col) {

        // 탐색 번호
        int number = map[row][col];

        // 현재 블록 개수
        int cnt = 0;

        // 탐색 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        queue.offer(new Point(row,col));
        map[row][col] = -1;
        cnt++;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 노드
            Point current = queue.poll();

            // 주변 탐색
            for(int d=0; d<4; d++) {
                
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(map[ny][nx]==-1) continue;

                // 동일한 수가 아닌 경우
                if(map[ny][nx]!=number) continue;

                // 탐색 위치로 추가
                queue.offer(new Point(ny,nx));
                map[ny][nx] = -1;
                cnt++;
            }
        }

        // 탐색 블록 수가 4개 이상인 경우
        if(cnt>=4) boom++;
        maxBlockCnt = Math.max(maxBlockCnt,cnt);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 격차 확인
        boom = 0;
        maxBlockCnt = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                // 미방문 블록인 경우
                if(map[i][j]!=-1)

                    // 블록 확인
                    solve(i,j);
            }
        }

        // 결과 출력
        System.out.println(boom+" "+maxBlockCnt);
    }
}