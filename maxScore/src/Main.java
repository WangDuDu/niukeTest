

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshuyang on 2017/4/16.
 */
public class Main {
    private static List<Record> records = new ArrayList<Record>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String info = null;
        while ((info = bufferedReader.readLine()) != null) {
            String record = info.substring(info.lastIndexOf("\\") + 1);
            int index = find(records,record);
            if (index != -1) {
                records.get(index).count++;
            } else {
                Record newRecord = new Record();
                newRecord.record = record;
                newRecord.count = 1;
                records.add(newRecord);
            }

        }
        Record[] recordArray = records.toArray(new Record[records.size()]);
        insertSort(recordArray);
        printRecord(recordArray);

    }

    public static void printRecord(Record[] array) {
        int length = (array.length > 8) ? 8 : array.length;

        for (int i = 0; i < length; i++) {
            String recordName = array[i].record;
            int spaceIndex = recordName.lastIndexOf(" ");
            if (spaceIndex > 16){
                recordName = recordName.substring(spaceIndex-16);
            }
            System.out.println(recordName + " " + array[i].count);
        }
    }


    public static void insertSort(Record[] array) {
        Record temp;
        int j;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0 && (temp.count > array[j-1].count); j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }

    public static int find(List<Record> records, String record){
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).record.equals(record)){
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
