import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 해시 맵 생성
        HashMap<String,Integer> hashMap = new HashMap<>();

        // 원소의 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 원소 정보 입력
        for(int i=0; i<cnt; i++) {

            // 원소 
            String letter = br.readLine();

            // 원소 저장
            hashMap.put(letter,hashMap.getOrDefault(letter,0)+1);

            // 결과 갱신
            answer = Math.max(answer,hashMap.get(letter));
        }
        
        // 결과 출력
        System.out.println(answer);
    }
}