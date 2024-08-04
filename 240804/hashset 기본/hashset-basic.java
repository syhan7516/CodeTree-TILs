import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // HashSet 생성
        HashSet<Integer> set = new HashSet<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령어 수 만큼 수행
        for(int i=0; i<orderCnt; i++) {

            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령어 확인
            switch(order) {

                // add
                case "add":
                set.add(Integer.parseInt(st.nextToken()));
                break;

                // remove
                case "remove":
                set.remove(Integer.parseInt(st.nextToken()));
                break;

                // contains
                case "find":
                System.out.println(set.contains(Integer.parseInt(st.nextToken())));
                break;
            }
        }
    }
}