import java.util.*;
import java.io.*;

public class Main {

    // 행복한 수열 구하기 메서드
    public static int solve(int map[][], int size, int target) {        

        // 확인 결과
        int result = 0;

        // 횟수 
        int maxCnt, cnt = 0;

        // 이전 값
        int preNum = -1;

        // 행 기준 확인
        for(int i=0; i<size; i++) {
            
            // 횟수 초기화
            maxCnt = 0;
            cnt = 0;

            // 이전 값 초기화
            preNum = -1;

            for(int j=0; j<size; j++) {
                
                // 이전과 같이 동일한 경우
                if(map[i][j]==preNum) cnt++;

                // 다른 경우
                else {
                    maxCnt = Math.max(maxCnt,cnt);
                    cnt = 1;
                    preNum = map[i][j];
                }
            }

            // 한 번 더 갱신
            maxCnt = Math.max(maxCnt,cnt);

            // 결과에 반영
            if(maxCnt>=target) result++;
        }

        // 행 기준 확인
        for(int i=0; i<size; i++) {
            
            // 횟수 초기화
            maxCnt = cnt = 0;

            // 이전 값 초기화
            preNum = -1;

            for(int j=0; j<size; j++) {
                
                // 이전과 같이 동일한 경우
                if(map[j][i]==preNum) cnt++;

                // 다른 경우
                else {
                    maxCnt = Math.max(maxCnt,cnt);
                    cnt = 1;
                    preNum = map[j][i];
                }
            }

            // 한 번 더 갱신
            maxCnt = Math.max(maxCnt,cnt);

            // 결과에 반영
            if(maxCnt>=target) result++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 연속 정도 입력
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 격자 생성
        int map[][] = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행복한 수열 개수 구하기
        int answer = solve(map,size,target);
        
        // 결과 출력
        System.out.println(answer);
    }
}