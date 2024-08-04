import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 결과
        int answer = Integer.MAX_VALUE;

        // TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 점의 개수 입력
        int dotCnt = Integer.parseInt(br.readLine());

        // 0인 점 추가
        treeSet.add(0);

        // 점 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<dotCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            treeSet.add(num);

            // 가까운 점 찾기
            if(treeSet.higher(num)!=null) {
                answer = Math.min(answer, treeSet.higher(num)-num);
            }
            answer = Math.min(answer, num-treeSet.lower(num));

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}