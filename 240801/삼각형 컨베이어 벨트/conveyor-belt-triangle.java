import java.util.*;
import java.io.*;

public class Main {

    // 컨베이어 벨트 이동
    public static void solve(int belt[][], int cnt, int time) {

        // 벨트 이동
        while(time-->0) {

            // 임시 변수
            int mock[] = {belt[2][cnt-1], belt[0][cnt-1], belt[1][cnt-1]};

            // 이동
            for(int i=0; i<3; i++) {
                for(int j=cnt-1; j>0; j--) {
                    belt[i][j] = belt[i][j-1];
                }
                belt[i][0] = mock[i]; 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 개수, 시간 입력
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        // 컨베이어 벨트 생성
        int belt[][] = new int[3][cnt];

        // 벨트 정보 입력
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<cnt; j++) {
                belt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 컨베이어 벨트 이동
        solve(belt,cnt,time);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            for(int j=0; j<cnt; j++) {
                sb.append(belt[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}