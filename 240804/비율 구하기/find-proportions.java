import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TreeMap 생성
        TreeMap<String,Integer> treeMap = new TreeMap<>();

        // 문자열 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 개수 만큼 수행
        for(int i=0; i<cnt; i++) {

            // 문자열 입력
            String letter = br.readLine();

            // 문자열 개수 갱신
            treeMap.put(letter,treeMap.getOrDefault(letter,0)+1); 
        }

        // 결과 출력
        for(Entry<String,Integer> e: treeMap.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();
            double ratio = (double)value/cnt*100;
            System.out.printf("%s %.4f\n", key, ratio);
        }
    }
}