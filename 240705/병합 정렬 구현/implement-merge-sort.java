import java.io.*;
import java.util.*;

public class Main {

    // 병합 정렬 메서드
    static void mergeSort(int nums[], int low, int high) {

        // 원소 개수가 2개 이상인 경우
        if(low<high) {

            // 중간 설정
            int mid = (low+high)/2;

            // 좌측 분할
            mergeSort(nums,low,mid);

            // 우측 분할
            mergeSort(nums,mid+1,high);

            // 두 구간 병합
            merge(nums,low,mid,high);
        }
    }

    // 두 구간 병합 메서드
    static void merge(int nums[], int low, int mid, int high) {

        // 두 구간 시작점 설정
        int i = low;
        int j = mid+1;

        // 원소 저장할 임시 배열
        int mock[] = new int[nums.length];

        // 빈 배열 인덱스
        int k = low;

        // 병합 수행
        while(i<=mid && j<=high) {

            // 우측이 같거나 큰 경우
            if(nums[i]<nums[j]) {
                mock[k] = nums[i];
                k++;
                i++;
            }

            // 좌측이 더 큰 경우
            else {
                mock[k] = nums[j];
                k++;
                j++;
            }
        }

        // 좌측 구간이 남은 경우
        while(i<=mid) {
            mock[k] = nums[i];
            k++;
            i++;
        }

        // 우측 구간이 남은 경우
        while(j<=high) {
            mock[k] = nums[j];
            k++;
            j++;
        }

        // 원본 배열에 반영
        for(int n=low; n<=high; n++) {
            nums[n] = mock[n];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 숫자 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 숫자 배열 생성
        int nums[] = new int[cnt];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 병합 정렬 수행
        mergeSort(nums,0,nums.length-1);

        // 결과 출력
        for(int n: nums) sb.append(n).append(" ");
        System.out.println(sb.toString());
    }
}