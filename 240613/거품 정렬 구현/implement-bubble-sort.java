import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 개수 입력
        int cnt = Integer.parseInt(st.nextToken());

        // 숫자 저장 배열 생성
        int nums[] = new int[cnt];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 교환 여부
        boolean sorted = true;

        // 버블 정렬 수행
        do {

            // 여부 초기화
            sorted = true;

            for(int i=0; i<cnt-1; i++) {
                
                // 현재 값이 다음 값보다 큰 경우
                if(nums[i]>nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    sorted = false;
                }
            }
        } while(!sorted);

        // 출력
        for(int i=0; i<cnt; i++)
            System.out.print(nums[i]+" ");
    }
}