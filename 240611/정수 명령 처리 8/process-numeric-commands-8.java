import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 연결 리스트 생성
        LinkedList<Integer> list = new LinkedList<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령 수행
        for(int i=0; i<orderCnt; i++) {

            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch(order) {

                case "push_back":
                list.addLast(Integer.parseInt(st.nextToken()));
                break;

                case "push_front":
                list.addFirst(Integer.parseInt(st.nextToken()));
                break;

                case "pop_front":
                System.out.println(list.pollFirst());
                break;

                case "front":
                System.out.println(list.peekFirst());
                break;

                case "pop_back":
                System.out.println(list.pollLast());
                break;

                case "back":
                System.out.println(list.peekLast());
                break;

                case "size":
                System.out.println(list.size());
                break;

                case "empty":
                System.out.println(list.isEmpty() ? 1 : 0);
                break;
            }
        }
    }
}