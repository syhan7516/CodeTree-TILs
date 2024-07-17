import java.util.*;
import java.io.*;

public class Main {

    // 결과, 가로 크기, 세로 크기, 잠김 정도, 높이
    public static int answer, rowSize, colSize, degree, high;

    // 격자
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 안전 지대 탐색 메서드
    public static void solve(int row, int col) {

        // 주변 확인
        for(int d=0; d<4; d++) {

            int ny = row+dy[d];
            int nx = col+dx[d];

            // 범위 확인
            if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

            // 이미 방문했거나, 물에 잠긴 경우
            if(visited[ny][nx]) continue;

            // 안전 지대인 경우
            visited[ny][nx] = true;
            solve(ny,nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 격자 배열 생성
        map = new int[rowSize][colSize];

        // 잠김 정도
        degree = (int)1e9;

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 잠김 정도
        degree = 0;

        // 결과
        answer = -1;

        // 높이 
        high = 0;

        // 안전 지대 확인하기
        while(degree<=100) {

            // 방문 여부 배열 생성
            visited = new boolean[rowSize][colSize];

            // 비 내리기
            for(int i=0; i<rowSize; i++) {
                for(int j=0; j<colSize; j++) {

                    // 만약 잠김 정도가 같거나 더 큰 경우
                    if(map[i][j]<=degree)
                        visited[i][j] = true;
                }
            }

            // 안전 지대 수
            int cnt = 0;

            // 안전 지대 확인
            for(int i=0; i<rowSize; i++) {
                for(int j=0; j<colSize; j++) {

                    // 안전 지대인 경우
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        cnt++;
                        solve(i,j);
                    }
                }
            }

            // 이전보다 안전 지대가 더 많은 경우
            if(answer<cnt) {
                answer = cnt;
                high = degree;
            }

            // 잠김 정도 증가
            degree++;
        }

        // 결과 출력
        System.out.println(high+" "+answer);
    }
}