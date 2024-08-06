import java.util.*;
import java.io.*;

// 위치 클래스
class Point {
    int y;
    int x;
    
    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과, 점 개수, 선택 개수
    public static int answer, dotCnt, selectCnt;

    // 선택된 점 저장 리스트
    public static ArrayList<Point> selected;

    // 점 정보 저장 배열
    public static Point[] dots;

    // 거리 확인 메서드
    public static int calc(int x1, int y1, int x2, int y2) {

        // 거리 차
        int dx = Math.abs(x1-x2);
        int dy = Math.abs(y1-y2);

        // 제곱 
        dx = dx*dx;
        dy = dy*dy;

        return dx+dy;
    }

    // 선택된 점들 거리 확인 메서드
    public static int getMaxDist() {

        // 가장 먼 거리
        int maxDist = -1;

        // 점들 거리 확인
        for(int i=0; i<selected.size()-1; i++) {
            
            // 기준 점
            Point first = selected.get(i);

            for(int j=i+1; j<selected.size(); j++) {

                // 비교 점
                Point second = selected.get(j);

                // 거리 확인
                maxDist = Math.max(maxDist,calc(first.x,first.y,second.x,second.y));
            }
        }

        return maxDist;
    }

    // 점 선택하기 메서드
    public static void solve(int idx, int cnt) {

        // 선택이 완료된 경우
        if(idx==dotCnt) {

            // 개수가 부족하거나 많은 경우
            if(cnt<selectCnt || cnt>selectCnt) return;

            // 선택된 점들 거리 확인
            answer = Math.min(answer,getMaxDist());

            return;
        }

        // 점 선택 X
        solve(idx+1,cnt);

        // 점 선택 O
        selected.add(dots[idx]);
        solve(idx+1,cnt+1);
        selected.remove(selected.size()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 점 개수, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        dotCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 점 정보 저장 배열 생성
        dots = new Point[dotCnt];

        // 선택된 점 저장 리스트 생성
        selected = new ArrayList<>();

        // 점 정보 입력
        for(int i=0; i<dotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        // 점 선택하기
        answer = Integer.MAX_VALUE;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}