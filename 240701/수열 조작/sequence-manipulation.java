import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 덱 생성
        Deque<Integer> queue = new ArrayDeque<>();

        // N 입력
        int n = Integer.parseInt(br.readLine());

        // 정수 입력
        for(int i=1; i<=n; i++)
            queue.addLast(i);

        // 수열 조작 수행
        while(queue.size()!=1) {

            // 맨 앞 정수 제거
            queue.pollFirst();

            // 맨 앞 정수 뒤로 보내기
            queue.addLast(queue.pollFirst());
        }

        // 결과 출력
        System.out.println(queue.poll());
    }
}