import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 덱 생성
        Deque<Integer> queue = new ArrayDeque<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령어 입력
        for(int i=0; i<orderCnt; i++) {

            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령어 확인
            switch(order) {

                // 맨 앞 삽입
                case "push_front":
                queue.addFirst(Integer.parseInt(st.nextToken()));
                break;

                // 맨 뒤 삽입
                case "push_back":
                queue.addLast(Integer.parseInt(st.nextToken()));
                break;

                // 맨 앞 제거
                case "pop_front":
                System.out.println(queue.pollFirst());
                break;

                // 맨 뒤 제거
                case "pop_back":
                System.out.println(queue.pollLast());
                break;

                // 개수 확인
                case "size":
                System.out.println(queue.size());
                break;

                // 비어있는지 확인
                case "empty":
                int answer = queue.isEmpty()==true ? 1 : 0;
                System.out.println(answer);
                break;

                // 맨 앞 원소 확인
                case "front":
                System.out.println(queue.peekFirst());
                break;

                // 맨 뒤 원소 확인 
                case "back":
                System.out.println(queue.peekLast());
                break;
            }
        }
    }
}