import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 동적 배열 선언
        ArrayList<Integer> list = new ArrayList<>();

        // 명령 수행
        for(int i=0; i<orderCnt; i++) {
            st = new StringTokenizer(br.readLine());

            // 명령어 확인
            switch(st.nextToken()) {

                // 맨 뒤 요소 삽입
                case "push_back":
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                
                // 원하는 위치 요소 조회
                case "get":
                    System.out.println(list.get(Integer.parseInt(st.nextToken())-1));
                    break;
                
                // 데이터 개수 조회
                case "size":
                    System.out.println(list.size());
                    break;

                // 맨 뒤 요소 삭제
                case "pop_back":
                    list.remove(list.size()-1);
                    break;
            }
        }
    }
}