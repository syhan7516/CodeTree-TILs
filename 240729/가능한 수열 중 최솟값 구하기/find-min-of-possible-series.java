import java.util.*;
import java.io.*;

public class Main {

    // 수열 길이
    public static int size;

    // 선택된 숫자 저장 리스트
    public static ArrayList<Integer> selected;

    // 범위 내 값 비교 메서드
    public static boolean compare(int firstStart, int firstEnd, int secondStart, int secondEnd) {

        // 비교 수행
        for(int i=0; i<=firstEnd-firstStart; i++) {

            // 다른 경우
            if(selected.get(firstStart+i)!=selected.get(secondStart+i))
                return false;
        }

        return true;
    }

    // 가능한 수열인지 확인하기 메서드
    public static boolean check(int cnt) {

        // 초기 길이
        int len = 1;

        // 비교하기
        while(true) {

            // 비교 시작, 끝 설정
            int firstEnd = selected.size()-1;
            int firstStart = firstEnd-len+1;
            int secondEnd = firstStart-1;
            int secondStart = secondEnd-len+1;
    
            if(secondStart<0) break;
    
            // 범위 내 값 비교
            if(compare(firstStart,firstEnd,secondStart,secondEnd))
                return false;

            len++;
        }
    
        return true;
    }

    // 가능한 수열 구하기 메서드
    public static void solve(int cnt) {

        // 선택이 끝난 경우
        if(cnt==size) {
            
            // 결과 출력
            StringBuilder sb = new StringBuilder();
            for(int n: selected) sb.append(n);
            System.out.println(sb.toString());
            System.exit(0);
        }

        // 숫자 선택하기
        for(int i=4; i<=6; i++) {

            // 숫자 선택
            selected.add(i);

            // 가능한 수열인 경우
            if(check(cnt+1)) solve(cnt+1);

            // 복구
            selected.remove(selected.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 길이 입력
        size = Integer.parseInt(br.readLine());

        // 선택된 숫자 저장 리스트
        selected = new ArrayList<>();

        // 가능한 수열 구하기
        solve(0);
    }
}