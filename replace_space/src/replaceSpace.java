/**
 * Created by wangshuyang on 2017/4/17.
 */
public class replaceSpace {
    public static String replaceSpace(StringBuilder str){
        int spaceNumber = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNumber++;
            }
        }
        int indexOfOld = str.length() - 1;
        int indexOfNew = str.length() + spaceNumber*2 - 1;
        str.setLength(str.length() + spaceNumber * 2);
        while (indexOfOld >= 0 && indexOfNew > indexOfOld) {
            if (str.charAt(indexOfOld) != ' ') {
                str.setCharAt(indexOfNew--,str.charAt(indexOfOld--));
            } else {
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
                indexOfOld--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello world!");
        stringBuilder.append(" wang!");
        String string = replaceSpace(stringBuilder);
        System.out.println(string);
    }
}
