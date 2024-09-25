import java.util.*;
import java.io.*;

public class Main {

    // 숫자 제거하기 메서드
    public static int removeNum(int number, int nums[]) {

        // 이전 수
        int preNum = -1;

        // 연속 숫자
        int a = 0;

        // 최대 숫자
        int b = 0;

        // 차례로 확인
        for(int i=0; i<nums.length; i++) {

            // 만약 제거되는 수인 경우
            if(nums[i]==number) continue;

            // 아닌 경우
            else {
                
                // 이전과 동일한 수인 경우
                if(preNum==nums[i])
                    a++;

                // 다른 경우
                else {
                    b = Math.max(a,b);
                    preNum = nums[i];
                    a = 1;
                }
            }
        }
        
        return Math.max(a,b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 숫자 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 숫자 배열 생성
        int nums[] = new int[numCnt];

        // 숫자 방문 여부 배열
        boolean visited[] = new boolean[1000001];

        // 숫자 정보 입력
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(br.readLine());

        // 숫자 확인
        for(int i=0; i<numCnt; i++) {

            // 제거 숫자
            int check = nums[i];

            // 이미 수행한 경우
            if(visited[check]) continue;

            // 아닌 경우
            answer = Math.max(answer,removeNum(check,nums));
            visited[check] = true;
        }

        // 결과 출력
        System.out.println(answer);
    }
}