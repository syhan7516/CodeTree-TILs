import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 큐 생성
        Queue<Integer>queue = new LinkedList<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령 수행
        for(int i=0; i<orderCnt; i++) {
            
            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령어 확인
            switch(order) {

                // 삽입
                case "push":
                queue.offer(Integer.parseInt(st.nextToken()));
                break;

                // 삭제
                case "pop":
                System.out.println(queue.poll());
                break;

                // 크기 확인
                case "size":
                System.out.println(queue.size());
                break;

                // 비어있는지 확인
                case "empty":
                int answer = queue.isEmpty()==true ? 1 : 0;
                System.out.println(answer);
                break;

                // 큐 확인
                case "front":
                System.out.println(queue.peek());
                break;
            }
        }
    }
}