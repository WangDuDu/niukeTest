/**
 * Created by wangshuyang on 2017/5/5.
 */
public class Solution {
    public static int getNumberOfK(int [] array , int k) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        int low = 0;
        int high = 0;
        while(left < right){
            mid = (left + right) / 2;
            if(array[mid] > k)
                right = mid -1;
            else if(array[mid] < k)
                left = mid +1;
            else
                right = mid;
        }
        if(array[left] == k)
            low = left;


        left = 0;
        right = array.length - 1;
        while(left < right){
            mid = (left + right) / 2;
            if(array[mid] > k)
                right = mid - 1;
            else if(array[mid] < k)
                left = mid + 1;
            else
                left = mid;
        }
        if(array[right] == k)
            high = right;

        return high - low + 1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,3,3,3,5};
        int a = getNumberOfK(array,2);
        System.out.println(a);

    }
}
