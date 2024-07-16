import java.util.*;
import java.io.*;

public class Main {

    // 결과
    public static int answer;

    // 숫자 구성 리스트
    public static ArrayList<Integer> nums;

    // 연속한 숫자 개수 확인
    public static boolean verifyNumber(int len) {

        // 이전 숫자에 대한 정보
        int preIdx = 0;
        int preNumber = nums.get(0);

        // 숫자 확인
        for(int i=1; i<nums.size(); i++) {
            
            // 이전 숫자와 다른 경우
            if(nums.get(i)!=preNumber) {

                // 숫자 개수 확인
                int numCnt = i-preIdx;

                // 개수가 틀린 경우
                if(numCnt%preNumber!=0) 
                    return false;

                // 이전 숫자에 대한 정보 갱신
                preIdx = i;
                preNumber = nums.get(i);
            }
        }

        // 마지막까지 도달한 경우
        if((len-preIdx)%preNumber!=0) return false;
        else return true; 
    }

    // 숫자 생성
    public static void solve(int cnt, int len) {

        // 숫자를 완성한 경우
        if(cnt==len) {

            // 아름다운 수 확인
            if(verifyNumber(len))
                answer++;

            return;
        }

        // 미완성인 경우
        for(int i=1; i<=4; i++) {
            nums.add(i);
            solve(cnt+1,len);
            nums.remove(nums.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        answer = 0;

        // 숫자 구성 리스트 생성
        nums = new ArrayList<>();

        // 자리 수 입력
        int len = Integer.parseInt(br.readLine());

        // 숫자 생성
        solve(0,len);

        // 결과 출력
        System.out.println(answer);
    }
}