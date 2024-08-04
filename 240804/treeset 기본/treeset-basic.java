import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령어 수 만큼 수행
        for(int i=0; i<orderCnt; i++) {
            st = new StringTokenizer(br.readLine());

            // 명령어 입력
            String letter = st.nextToken();

            // 임시 변수
            int result = -1;

            // 명령어 확인
            switch(letter) {

                // add
                case "add":
                treeSet.add(Integer.parseInt(st.nextToken()));
                break;

                // remove
                case "remove":
                treeSet.remove(Integer.parseInt(st.nextToken()));
                break;

                // contains
                case "find":
                sb.append(treeSet.contains(Integer.parseInt(st.nextToken()))).append("\n");
                break;

                // ceiling
                case "lower_bound":
                result = Integer.parseInt(st.nextToken());
                if(treeSet.ceiling(result)==null) sb.append("None");
                else sb.append(treeSet.ceiling(result));
                sb.append("\n");
                break;

                // higher
                case "upper_bound":
                result = Integer.parseInt(st.nextToken());
                if(treeSet.higher(result)==null) sb.append("None");
                else sb.append(treeSet.higher(result));;
                sb.append("\n");
                break;

                // last
                case "largest":
                if(treeSet.size()==0) sb.append("None");
                else sb.append(treeSet.last());
                sb.append("\n");
                break;

                // first
                case "smallest":
                if(treeSet.size()==0) sb.append("None");
                else sb.append(treeSet.first());
                sb.append("\n");
                break;
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}