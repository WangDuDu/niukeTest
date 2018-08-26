import java.util.ArrayList;

/**
 * Created by wangshuyang on 2017/4/18.
 */
public class test1 {

        public class ListNode {
            int val;
            ListNode next = null;
            ListNode(int val) {
                this.val = val;
           }
        }

     ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> print(ListNode node){
        if (node != null){
            arrayList = print(node.next);
            arrayList.add(node.val);
        }
        return arrayList;
    }

}
