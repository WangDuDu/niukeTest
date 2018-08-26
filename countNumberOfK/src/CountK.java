import java.util.*;
/**
 * Created by wangshuyang on 2017/4/29.
 */
public class CountK {
        public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(input.length == 0 || input == null || k <= 0 || k > input.length){
                return list;
            }

            int left = 0;
            int right = input.length - 1;
            int index = partition(input,0,input.length-1);
            while(index != k - 1 ){
                if(index > k - 1){
                    right = index - 1;
                    index = partition(input,left,right);
                } else {
                    left = index + 1;
                    index = partition(input,left,right);
                }
            }
            for(int i = 0; i < k; i++){
                list.add(input[i]);
            }
            return list;
        }
        public static int partition(int[] input, int left, int right){
            int temp = input[left];
            while(left < right){
                while(left < right && input[right] > temp)
                    right--;
                input[left] = input[right];
                while(left < right && input[left] < temp)
                    left++;
                input[right] = input[left];
            }
            input[left] = temp;
            return left;
        }

         public static void main(String[] args) {
             Random random = new Random();
             int[] intArray = new int[10];
             for (int i = 0; i < 10; i++) {
                 intArray[i] = random.nextInt(100);
             }
             for (int j = 0; j < 10; j++){
                 System.out.print(intArray[j] + ",");
             }
             System.out.println();
             ArrayList<Integer> list = GetLeastNumbers_Solution(intArray,4);
             for (Integer i:list) {
                 System.out.print(i + ",");
             }
         }

}
