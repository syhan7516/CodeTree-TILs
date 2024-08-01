import java.util.*;
import java.io.*;

public class Main {

    // 가로와 세로 크기, 바람부는 횟수, 직사각형 시작과 끝 위치
    public static int rowSize, colSize, windyCnt, startY, startX, endY, endX;

    // 격자
    public static int map[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 평균 처리
    public static void avg() {

        // 복사 격자 생성
        int copy[][] = new int[rowSize][colSize];
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                copy[i][j] = map[i][j];
            }
        }

        // 평균 구하기
        for(int i=startY; i<=endY; i++) {
            for(int j=startX; j<=endX; j++) {

                // 숫자 개수, 합
                int cnt = 1;
                int sum = map[i][j];

                // 주위 방향 확인
                for(int d=0; d<4; d++) {
                    int ny = i+dy[d];
                    int nx = j+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                    // 숫자 개수 추가 및 합하기
                    cnt++;
                    sum += map[ny][nx];
                }

                // 평균 처리
                copy[i][j] = sum/cnt;
            }
        }

        // 평균 값으로 갱신
        map = copy;
    }

    // 바람 불기 메서드
    public static void solve() {

        // 임시 변수
        int mock = map[startY][endX];

        // 첫 번째 이동
        for(int i=endX; i>0; i--)
            map[startY][i] = map[startY][i-1];

        // 두 번째 이동
        for(int i=startY; i<endY; i++)
            map[i][startX] = map[i+1][startX];

        // 세 번째 이동
        for(int i=startX; i<endX; i++)
            map[endY][i] = map[endY][i+1];

        // 네 번째 이동
        for(int i=endY; i>1; i--)
            map[i][endX] = map[i-1][endX];

        // 마지막 처리
        map[startY+1][endX] = mock;

        // 평균 처리
        avg();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로와 세로 크기, 바람부는 횟수 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        windyCnt = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바람 정보 입력
        for(int i=0; i<windyCnt; i++) {
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken())-1;
            startX = Integer.parseInt(st.nextToken())-1;
            endY = Integer.parseInt(st.nextToken())-1;
            endX = Integer.parseInt(st.nextToken())-1;
            solve();
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}