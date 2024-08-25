import java.util.*;
import java.io.*;

public class Main {

    // 정점, 간선 개수 입력
    public static int nodeCnt, edgeCnt;

    // 거리 배열
    public static int dist[][];

    // 최단 경로 구하기 메서드
    public static void solve() {

        // 경로 탐색
        for(int k=1; k<=nodeCnt; k++) {
            for(int i=1; i<=nodeCnt; i++) {
                for(int j=1; j<=nodeCnt; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 거리 배열 생성
        dist = new int[nodeCnt+1][nodeCnt+1];

        // 거리 배열 초기화
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = (int)1e9;
            }
        }

        // 연결 관계 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dist[start][end] = Math.min(dist[start][end],value);
        }

        // 최단 경로 구하기
        solve();

        // 결과 출력
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(dist[i][j]==(int)1e9) sb.append(-1);
                else sb.append(dist[i][j]);
                sb.append(" "); 
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}