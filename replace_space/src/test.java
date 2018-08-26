/**
 * Created by wangshuyang on 2017/4/17.
 */
public class test {
    public static String replace(StringBuffer str) {
        int spaceNumber = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                spaceNumber++;
            }
        }

        int indexOfOld = str.length() - 1;
        int newLength = str.length() + spaceNumber * 2;
        int indexOfNew = newLength - 1;
        str.setLength(newLength);
        while (indexOfOld >= 0 && indexOfOld < indexOfNew) {
            if (str.charAt(indexOfOld) != ' ') {
                str.setCharAt(indexOfNew--,str.charAt(indexOfOld));
            } else {
                str.setCharAt(indexOfNew--,'%');
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
            }
            indexOfOld--;
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }
}
