import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 해시 맵 생성
        HashMap<Integer,Integer> map = new HashMap<>();

        // 명령어 수 입력
        int n = Integer.parseInt(br.readLine());

        // 명령어 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int key = Integer.parseInt(st.nextToken());

            switch(order) {

                case "add":
                map.put(key,Integer.parseInt(st.nextToken()));
                break;

                case "find":
                if(map.containsKey(key)) System.out.println(map.get(key));
                else System.out.println("None");
                break;

                case "remove":
                map.remove(key);
                break;
            }
        }
    }
}