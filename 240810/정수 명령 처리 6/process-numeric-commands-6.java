import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> a-b
        );

        // 명령어 개수 입력
        int orederCnt = Integer.parseInt(br.readLine());

        // 명령어 개수 만큼 수행
        for(int i=0; i<orederCnt; i++) {

            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령어 확인
            switch(order) {

                // "offer"
                case "push":
                queue.offer(Integer.parseInt(st.nextToken()));
                break;

                // "size"
                case "size":
                System.out.println(queue.size());
                break;

                // "isEmpty"
                case "empty":
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;

                // "poll"
                case "pop":
                System.out.println(queue.poll());
                break;

                // "peek"
                case "top":
                System.out.println(queue.peek());
                break;
            }
        }
    }
}