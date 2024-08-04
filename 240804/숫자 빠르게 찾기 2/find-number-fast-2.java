import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 숫자 개수, 찾을 개수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int findCnt = Integer.parseInt(st.nextToken());

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        // 찾는 숫자 입력
        for(int i=0; i<findCnt; i++) {

            // 숫자 입력
            int number = Integer.parseInt(br.readLine());

            // 숫자 찾기
            if(treeSet.ceiling(number)==null) {
                sb.append(-1).append("\n");
            }

            else sb.append(treeSet.ceiling(number)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}