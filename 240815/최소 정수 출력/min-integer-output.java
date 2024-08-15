import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 우선 순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 연산의 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 연산 개수만큼 수행
        for(int i=0; i<orderCnt; i++) {

            // 연산 입력
            int number = Integer.parseInt(br.readLine());

            // 0일 경우
            if(number==0) {

                // 우선 순위 큐가 빈 경우
                if(pq.isEmpty()) sb.append(0);

                // 원소가 존재하는 경우
                else sb.append(pq.poll());

                sb.append("\n");
            }

            // 0이 아닐 경우
            else {

                // 삽입
                pq.add(number);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}