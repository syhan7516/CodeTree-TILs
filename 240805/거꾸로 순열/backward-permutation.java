import java.util.*;
import java.io.*;

public class Main {

    // 범위
    public static int range;

    // 선택된 숫자 저장 리스트
    public static ArrayList<Integer> selected;

    // 방문 여부 배열
    public static boolean visited[];

    // 결과 저장 빌더
    public static StringBuilder sb = new StringBuilder();

    // 순열 구하기 메서드
    public static void solve(int cnt) {

        // 선택이 완료된 경우
        if(cnt==range) {
            
            // 선택된 숫자 저장
            for(int i:selected)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        // 숫자 선택하기
        for(int i=range; i>=1; i--) {

            // 이미 선택한 경우
            if(visited[i]) continue;

            // 리스트에 숫자 추가
            selected.add(i);
            visited[i] = true;
            solve(cnt+1);
            selected.remove(selected.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 범위 입력
        range = Integer.parseInt(br.readLine());

        // 선택된 숫자 저장 리스트 생성
        selected = new ArrayList<>();

        // 숫자 방문 여부 배열 생성
        visited = new boolean[range+1];

        // 순열 구하기
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}