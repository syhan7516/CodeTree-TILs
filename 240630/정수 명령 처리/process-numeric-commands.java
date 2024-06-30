import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령 수행
        for(int i=0; i<orderCnt; i++) {

            // 명령 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령 확인
            switch(order) {
                
                // 삽입
                case "push":
                stack.push(Integer.parseInt(st.nextToken()));
                break;

                // 개수 확인
                case "size":
                System.out.println(stack.size());
                break;

                // 비었는지 확인
                case "empty":
                int result = stack.empty()==true ? 1 : 0;
                System.out.println(result);
                break;

                // 제거
                case "pop":
                System.out.println(stack.pop());
                break;

                // 맨 위 원소 확인
                case "top":
                System.out.println(stack.peek());
                break;
            }
        }
    }
}