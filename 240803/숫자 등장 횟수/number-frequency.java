import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 해시 맵 생성
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        // 원소의 개수, 질의 개수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());

        // 원소 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {

            // 원소 
            int number = Integer.parseInt(st.nextToken());

            // 원소 저장
            if(hashMap.containsKey(number))
                hashMap.put(number,hashMap.get(number)+1);
            else 
                hashMap.put(number,1);
        }

        // 질의 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<orderCnt; i++) {

            // 원소
            int order = Integer.parseInt(st.nextToken());

            // 원소 개수 확인
            if(hashMap.containsKey(order))
                sb.append(hashMap.get(order));
            else 
                sb.append(0);

            sb.append(" ");
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}