
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr1 = new int[n];

        for(int i = 0;i<n;i++){
         arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            int find = Integer.parseInt(st.nextToken());
            System.out.println(findBinarySearch(arr1,find));
        }

    }

    static int findBinarySearch(int[] arr, int number){

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(number < arr[mid]){
                right = mid - 1;
            }else if(number > arr[mid]){
                left = mid + 1;
            }else{
                return 1;
            }
        }

        return 0;
    }
}