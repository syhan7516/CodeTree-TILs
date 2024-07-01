import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // n, k 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 번호 입력
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        // 인원 제거
        while(!queue.isEmpty()) {

            for(int i=1; i<=k-1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}