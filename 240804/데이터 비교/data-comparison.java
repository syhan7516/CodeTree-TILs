import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집합 생성
        HashSet<Integer> set = new HashSet<>();

        // 원소 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++)
            set.add(Integer.parseInt(st.nextToken()));

        // 원소 개수 입력
        cnt = Integer.parseInt(br.readLine());

        // 다른 집합 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {

            // 기존 집합에 존재하는 경우
            if(set.contains(Integer.parseInt(st.nextToken())))
                System.out.print(1+" ");

            // 기존 집합에 존재하지 않는 경우
            else 
                System.out.print(0+" ");
        }
    }
}