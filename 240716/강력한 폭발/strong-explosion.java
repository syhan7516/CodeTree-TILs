import java.io.*;
import java.util.*;

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

    // 결과, 크기
    public static int answer, size;

    // 폭탄 위치 저장 리스트
    public static ArrayList<Point> points;

    // 폭탄 종류 순열 리스트
    public static ArrayList<Integer> kinds;

    // 폭탄 반경 위치
    public static int dy[][] = {{},
                                {1,2,-1,-2},
                                {1,0,-1,0},
                                {1,1,-1,-1}};
    public static int dx[][] = {{},
                                {0,0,0,0},
                                {0,1,0,-1},
                                {-1,1,1,-1}};

    // 폭탄 터트리기 메서드
    public static void boom(int map[][]) {

        // 복사된 격자
        boolean copyMap[][] = new boolean[size][size];

        // 초토화 수
        int pang = 0;

        // 폭탄 위치 순회
        for(int i=0; i<points.size(); i++) {

            // 현재 위치
            Point current = points.get(i);

            // 폭탄 종류
            int kind = kinds.get(i);

            // 범위 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[kind][d];
                int nx = current.x+dx[kind][d];

                // 범위를 벗어난 경우
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 격파되거나, 폭탄 자리인 경우
                if(copyMap[ny][nx] || map[ny][nx]!=0) continue;

                // 격파
                pang++;
                copyMap[ny][nx] = true;
            }
        }

        // 결과 갱신
        answer = Math.max(answer,pang+points.size());
    }

    // 폭탄 종류 선택 메서드
    public static void solve(int map[][], int cnt, int len) {

        // 폭탄 선택 완료된 경우
        if(cnt==len) {

            // 폭탄 터트리기
            boom(map);
            return;
        }

        // 폭탄 선택
        for(int i=1; i<=3; i++) {
            kinds.add(i);
            solve(map,cnt+1,len);
            kinds.remove(kinds.size()-1);
        }        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        answer = 0;

        // 리스트 생성
        points = new ArrayList<>();
        kinds = new ArrayList<>();

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 생성
        int map[][] = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 폭탄인 경우
                if(map[i][j]==1)
                    points.add(new Point(i,j));
            }
        }

        // 폭탄 종류 선택
        solve(map,0,points.size());

        // 결과 출력
        System.out.println(answer);
    }
}