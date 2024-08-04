import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 공의 개수, 뽑을 공 개수 입력
        st = new StringTokenizer(br.readLine());
        int pickCnt = Integer.parseInt(st.nextToken());
        int ballCnt = Integer.parseInt(st.nextToken());

        // 공 넣기
        for(int i=1; i<=ballCnt; i++) {
            treeSet.add(i);
        }

        // 공 뽑기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<pickCnt; i++) {

            // 뽑을 공 입력
            int ballNum = Integer.parseInt(st.nextToken());

            // 공 뽑기
            treeSet.remove(ballNum);

            // 최대 값 저장
            sb.append(treeSet.last()).append("\n");
            
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}