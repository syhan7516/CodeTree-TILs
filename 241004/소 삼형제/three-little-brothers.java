import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        // 문자열 저장 해시 생성
        HashMap<String,Integer> coms = new HashMap<>();

        // 조합 입력
        for(int i=0; i<n; i++) {
            String comToArr[] = br.readLine().split(" ");
            Arrays.sort(comToArr);
            String comToStr = String.join(" ",comToArr);

            // 해시에 저장
            coms.put(comToStr,coms.getOrDefault(comToStr,0)+1);
        }

        // 결과 확인
        int answer = 0;
        for(int num: coms.values())
            answer = Math.max(answer,num);

        // 결과 출력
        System.out.println(answer);
    }
}