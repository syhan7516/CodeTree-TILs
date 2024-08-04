import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // TreeSet 생성
            TreeSet<Integer> treeSet = new TreeSet<>();

            // 임시 변수
            int mock = -1;

            // 명령어 수 입력
            int orderCnt = Integer.parseInt(br.readLine());

            // 명령어 수 만큼 수행
            for(int i=0; i<orderCnt; i++) {
                st = new StringTokenizer(br.readLine());

                // 명령어 입력
                String order = st.nextToken();

                // 명령어 확인

                // remove
                if(order.charAt(0)=='D') {
                    
                    // 빈 경우
                    if(treeSet.size()==0)
                        st.nextToken();

                    // 원소가 존재하는 경우
                    else {

                        // -1
                        if(Integer.parseInt(st.nextToken())==-1) {
                            mock = treeSet.first();
                            treeSet.remove(mock);
                        }

                        // 1
                        else {
                            mock = treeSet.last();
                            treeSet.remove(mock);
                        }
                    }
                }

                // add
                else treeSet.add(Integer.parseInt(st.nextToken()));
            }
            
            // 결과 저장
            if(treeSet.size()==0) sb.append("EMPTY");
            else sb.append(treeSet.last()).append(" ").append(treeSet.first());
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}