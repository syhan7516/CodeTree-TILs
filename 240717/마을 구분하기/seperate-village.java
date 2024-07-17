import java.util.*;
import java.io.*;

public class Main {

    // 크기, 사람 수
    public static int size, cnt;

    // 격자 
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 결과 정보 저장 리스트
    public static ArrayList<Integer> result;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 마을 탐색하기 메서드
    public static void solve(int row, int col) {

        // 주변 확인
        for(int d=0; d<4; d++) {

            int ny = row+dy[d];
            int nx = col+dx[d];

            // 범위를 넘은 경우
            if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

            // 벽이거나 이미 방문한 경우
            if(map[ny][nx]==0 || visited[ny][nx]) continue;

            // 탐색 가능한 경우
            visited[ny][nx] = true;
            cnt++;
            solve(ny,nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 정보 저장 리스트 생성
        result = new ArrayList<>();

        // 방문 여부 배열 생성
        visited = new boolean[size][size];

        // 마을 탐색하기
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                // 벽이 아니면서 방문하지 않은 마을인 경우
                if(map[i][j]==1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = 1;
                    solve(i,j);
                    result.add(cnt);
                }
            }
        }

        // 결과 정렬
        Collections.sort(result);
        
        // 결과 출력
        sb.append(result.size()).append("\n");
        for(int i: result) sb.append(i).append("\n");
        System.out.println(sb.toString());
    }
}