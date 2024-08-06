import java.util.*;
import java.io.*;

public class Main {

    // 층 수, 남은 블록 수
    public static int floor, exist;

    // 젠가, 임시 젠가 배열
    public static int[] top, mock;

    // 블록 제거하기 메서드
    public static void solve(int start, int end) {

        // 남은 블록 수
        int blockCnt = 0;

        // 임시 젠가 배열 생성
        mock = new int[floor+1];

        // 블록 제거 처리
        for(int i=start; i<=end; i++)
            top[i] = 0;
        
        // 블록 확인
        int mockIdx = 1;
        for(int i=1; i<=floor; i++) {
            
            // 위치에 블록이 존재하는 경우
            if(top[i]!=0) {
                mock[mockIdx] = top[i];
                mockIdx++;
                blockCnt++;
            }
        }

        // 블록 제거 적용
        top = mock;
        exist = blockCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 층 수 입력
        floor = Integer.parseInt(br.readLine());

        // 젠가 배열 생성
        top = new int[floor+1];

        // 각 층 정보 입력
        for(int i=1; i<=floor; i++) 
            top[i] = Integer.parseInt(br.readLine());

        // 블록 제거
        for(int i=0; i<2; i++) {

            // 제거 블록 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 블록 제거하기
            solve(start,end);
        }

        // 결과 저장
        sb.append(exist).append("\n");
        for(int i=1; i<=floor; i++)
            if(top[i]!=0) sb.append(top[i]).append("\n");
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}