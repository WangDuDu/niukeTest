import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by wangshuyang on 2017/4/7.
 */
public class Test {
    private static List<Record> records = new ArrayList<Record>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            String record = line.substring(line.lastIndexOf("\\") + 1);
            int index = find(records,record);
            if (index != -1) {
                records.get(index).count++;
            } else {
                Record recordObj = new Record();
                recordObj.record = record;
                recordObj.count = 1;
                records.add(recordObj);
            }
        }
        Record[] array = records.toArray(new Record[records.size()]);//Record[] array = records.toArray(new Record[0]);
        insertSort(array);
        printRecord(array);
    }

    private static void printRecord(Record[] array){
        int length = array.length > 8 ? 8 : array.length;

        for (int i = 0; i < length; i++) {
            String fileName = array[i].record;
            int fileLength = fileName.lastIndexOf(" ");
            if (fileLength > 16) {
                fileName = fileName.substring(fileLength - 16);

            }
            System.out.println(fileName + " " + array[i].count);

        }
    }

    private static void insertSort(Record[] array){
        for (int i = 1; i < array.length; i++) {
            Record temp = array[i];
            int j;
            for (j= i; j > 0 && temp.count > array[j-1].count; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    private static int find(List<Record> records, String record) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).record.equals(record)) {
                return i;
            }
        }
        return -1;
    }

    static class Record{
        String record;
        int count;
    }

}
