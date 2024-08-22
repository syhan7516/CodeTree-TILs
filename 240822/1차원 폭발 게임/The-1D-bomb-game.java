import java.util.*;
import java.io.*;

public class Main {

    // 폭탄 개수, 연속 조건
    public static int boomCnt, cnt;

    // 폭탄 배열
    public static int boom[];

    // 폭탄 처리 메서드
    public static void setBoom(int end, int prefix) {

        // 터진 개수
        int find = 0;

        // 폭탄 대상 0으로 설정
        for(int i=end; i>=0; i--) {

            // 폭탄인 경우
            if(boom[i]!=0) {
                boom[i] = 0;
                find++;
                boomCnt--;
            }

            // 모두 처리한 경우
            if(find==prefix) return;
        }
    }

    // 폭탄 확인 메서드
    public static void solve() {

        // 폭탄 터트리기 반복
        while(true) {

            // 이전 폭탄 정보
            int preNum = -1;

            // 누적 개수
            int prefix = 0;

            // 폭탄 터짐 여부 
            boolean flag = false;

            // 차례로 폭탄 확인
            for(int i=0; i<boom.length; i++) {
                
                // 폭탄이 이미 터진 경우
                if(boom[i]==0) continue;

                // 이전과 동일한 경우
                if(preNum==boom[i]) prefix++;

                // 이전과 다른 경우
                else {

                    // 누적 개수가 조건에 부합한 경우
                    if(prefix>=cnt) {
                        setBoom(i-1,prefix);
                        flag = true;
                        break;
                    }
                    
                    // 초기화
                    preNum = boom[i];
                    prefix = 1;
                }
            }

            // 폭탄이 안터진 경우
            if(!flag) {

                // 조건에 부합하는 경우
                if(prefix>=cnt) setBoom(boom.length-1,prefix);
                else return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 폭탄 개수, 연속 조건 입력
        st = new StringTokenizer(br.readLine());
        boomCnt = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        // 폭탄 배열 생성
        boom = new int[boomCnt];
        
        // 폭탄 정보 입력
        for(int i=boomCnt-1; i>=0; i--) {
            boom[i] = Integer.parseInt(br.readLine());
        }

        // 폭탄 확인
        solve();

        // 결과 출력
        if(boomCnt==0) System.out.println(0);
        else {
            System.out.println(boomCnt);
            for(int i=boom.length-1; i>=0; i--)
                if(boom[i]!=0) System.out.println(boom[i]);
        }
    }
}