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

        // 자릿수 조절 변수
        int point = 1;

        // 맨 뒤부터 맨 앞까지 확인
        for(int i=0; i<6; i++) {

            // 리스트 생성 및 초기화
            ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();

            for(int j=0; j<10; j++)
                bucket.add(new ArrayList<>());

            // 원소 확인
            for(int k=0; k<nums.length; k++) {
                
                // 저장 위치 수
                int digit = (nums[k]/point)%10;

                // 저장
                bucket.get(digit).add(nums[k]);
            }

            // 원소 넣기
            int index = 0;
            for(int a=0; a<10; a++) {
                for(int b=0; b<bucket.get(a).size(); b++) {
                    nums[index++] = bucket.get(a).get(b);
                }
            }

            // 자리 조절
            point++;
        }

        // 출력
        for(int i=0; i<cnt; i++)
            System.out.print(nums[i]+" ");
    }
}