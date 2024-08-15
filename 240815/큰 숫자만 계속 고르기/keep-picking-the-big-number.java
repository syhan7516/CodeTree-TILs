import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 우선 순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        // 숫자 개수, 제거 횟수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int remCnt = Integer.parseInt(st.nextToken());

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }        

        // 제거 횟수만큼 제거
        for(int i=0; i<remCnt; i++) {
            pq.add(pq.poll()-1);
        }

        // 결과 출력
        System.out.println(pq.peek());
    }
}