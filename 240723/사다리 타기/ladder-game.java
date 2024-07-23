import java.util.*;
import java.io.*;

// 가로 줄 클래스
class Line {
    int number;
    int rowNum;

    public Line(int number, int rowNum) {
        this.number = number;
        this.rowNum = rowNum;
    }
}

public class Main {

    // 결과, 사람 수, 가로 줄 수, 가로 크기
    public static int answer, people, rowCnt, maxRow;

    // 가로 줄 저장 리스트
    public static ArrayList<Line> rows;

    // 사다리 배열
    public static int ladder[][];

    // 사다리 결과 저장 배열
    public static int result[];

    // 사다리 타기 메서드
    public static void execute(int order, int cnt) {

        // 시작 위치
        int y = 0;
        int x = order;

        // 내려가기
        while(true) {

            // 끝까지 내려간 경우
            if(y==maxRow+1) {
                ladder[y][x] = order;
                break;
            }

            // 위치가 1인 경우
            if(ladder[y][x]==1) {
                x+=1;
                y+=1;
            }

            // 위치가 2인 경우
            else if(ladder[y][x]==2) {
                x-=1;
                y+=1;
            }

            // 위치가 0인 경우
            else y+=1;
        }

        // 가로 줄이 전부 선택된 경우
        if(cnt==rowCnt) {
            for(int i=1; i<=people; i++)
                result[i] = ladder[maxRow+1][i];
        }

        // 아닌 경우
        else {

            // 동일한지 비교
            for(int i=1; i<=people; i++)
                if(result[i] != ladder[maxRow+1][i]) return;

            // 결과 갱신
            answer = Math.min(answer,cnt);
        }
    }

    // 줄 고르기 메서드
    public static void solve(int idx, int cnt) {

        // 선택이 완료된 경우
        if(idx==rowCnt) {

            // 사다리 타기
            for(int i=1; i<=people; i++)
                execute(i,cnt);

            return;
        }

        // 가로 줄을 선택한 경우
        solve(idx+1,cnt+1);

        // 가로 줄을 선택하지 않은 경우
        Line line = rows.get(idx);
        ladder[line.rowNum][line.number] = 0;
        ladder[line.rowNum][line.number+1] = 0;

        solve(idx+1,cnt);
        
        // 사다리 복구
        ladder[line.rowNum][line.number] = 1;
        ladder[line.rowNum][line.number+1] = 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수, 가로 줄 수 입력
        st = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken());
        rowCnt = Integer.parseInt(st.nextToken());

        // 가로 줄 저장 리스트 생성
        rows = new ArrayList<>();

        // 가로 줄 정보 입력
        maxRow = 0;
        for(int i=0; i<rowCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int rowNum = Integer.parseInt(st.nextToken());
            rows.add(new Line(number,rowNum));
            maxRow = Math.max(maxRow,rowNum);
        }

        // 사다리 배열 생성
        ladder = new int[maxRow+2][people+1];

        // 사다리 정보 입력
        for(int i=0; i<rows.size(); i++) {

            // 학인 가로 줄
            Line line = rows.get(i);
            ladder[line.rowNum][line.number] = 1;
            ladder[line.rowNum][line.number+1] = 2;
        }

        // 줄 고르기
        answer = rowCnt;
        result = new int[people+1];
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}