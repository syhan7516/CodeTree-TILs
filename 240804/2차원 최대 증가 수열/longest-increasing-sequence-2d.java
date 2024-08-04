import java.util.*;
import java.io.*;

public class Main {

    // 결과, 가로와 세로 크기
    public static int answer, rowSize, colSize;

    // 격자
    public static int map[][];

    // DP 테이블
    public static int DP[][];

    // 최대 증가 수열 구하기 메서드
    public static void solve() {

        // 초기 처리
        DP[0][0] = 1;

        // 모든 격자 확인
        for(int i=1; i<rowSize; i++) {
            for(int j=1; j<colSize; j++) {
                for(int a=i-1; a>=0; a--) {
                    for(int b=j-1; b>=0; b--) {

                        // 이전에 방문한 이력이 없는 경우
                        if(DP[a][b]==0) continue;

                        // 이전이 같거나 더 큰 경우
                        if(map[a][b]>=map[i][j]) continue;

                        // 기분 위치 저장 값 갱신
                        DP[i][j] = Math.max(DP[i][j],DP[a][b]+1);
                    }

                    
                    // 결과 갱신
                    answer = Math.max(answer,DP[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로와 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 격자 배열 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 테이블 생성
        DP = new int[rowSize][colSize];

        // 최대 증가 수열 구하기
        answer = 1;
        solve();

        // 결과 출력
        System.out.println(answer); 
    }
}