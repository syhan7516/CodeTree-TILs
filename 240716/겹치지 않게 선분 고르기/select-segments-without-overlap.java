import java.util.*;
import java.io.*;

// 선분 클래스
class Line {
    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    // 결과, 선분의 개수
    public static int answer, lineCnt;

    // 선분 선택 여부 리스트
    public static ArrayList<Boolean> selected;

    // 선분 확인 메서드
    public static void verifyLines() {

        // 뽑은 선분 개수
        int pick = 0;

        // 이전 선분 
        int endLen = 0;

        // 선분 순회
        for(int i=0; i<lines.size(); i++) {

            // 선택된 선분인 경우
            if(selected.get(i)) {

                // 확인 선분
                Line current = lines.get(i);

                // 이전 선분과 겹치지 않는 경우
                if(endLen<current.start) {
                    pick++;
                    endLen = current.end;
                } 
            }
        }

        // 결과 갱신
        answer = Math.max(answer,pick);
    }

    // 선분 선택하기 메서드
    public static void solve(int cnt) {

        // 선분 선택이 완료된 경우
        if(cnt==lineCnt) {
            verifyLines();
            return;
        }

        // 선분 선택하기
        selected.set(cnt,true);
        solve(cnt+1);
        selected.set(cnt,false);
        solve(cnt+1);
    }

    // 선분 정보 저장 리스트
    public static ArrayList<Line> lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        answer = 0;

        // 선분 개수 입력
        lineCnt = Integer.parseInt(br.readLine());

        // 선분 정보 저장 리스트 생성
        lines = new ArrayList<Line>();

        // 선분 정보 입력
        for(int i=0; i<lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new Line(start,end));
        }

        // 선분 정렬
        Collections.sort(lines,(a,b) -> a.end - b.end);
        Collections.sort(lines,(a,b) -> a.start - b.start);

        // 선분 선택 여부 리스트 생성
        selected = new ArrayList<>();
        for(int i=0; i<lineCnt; i++)
            selected.add(false);

        // 선분 선택하기
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}