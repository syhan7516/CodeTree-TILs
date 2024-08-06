import java.util.*;
import java.io.*;

public class Main {

    // 결과, 최소 합, 격자 크기
    public static int answer, minSum, size;

    // 격자 배열
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[];

    // 선택된 숫자 저장 리스트
    public static ArrayList<Integer> selected;

    // 최솟값 최대화하기 메서드
    public static void solve(int idx) {

        // 선택이 완료된 경우
        if(idx==size) {

            // 선택된 숫자 중 가장 작은 값
            int minNum = 10001;

            // 선택된 숫자 확인
            for(int n: selected)
                minNum = Math.min(minNum,n);

            // 결과 갱신
            answer = Math.max(answer,minNum);

            return;
        }

        // 숫자 확인
        for(int i=0; i<size; i++) {

            // 이미 방문한 경우
            if(visited[i]) continue;

            // 숫자 선택
            visited[i] = true;
            selected.add(map[idx][i]);

            solve(idx+1);

            // 복구
            visited[i] = false;
            selected.remove(selected.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 격자 배열 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문 여부 배열 생성
        visited = new boolean[size];

        // 선택된 숫자 저장 리스트 생성
        selected = new ArrayList<>();

        // 최솟값 최대화하기
        answer = -1;
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}