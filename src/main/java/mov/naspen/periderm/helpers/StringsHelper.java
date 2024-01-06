package mov.naspen.periderm.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class StringsHelper {
    public static String formatArray(ArrayList<String> array) {
        StringBuilder out = new StringBuilder();
        int arraySize = array.size();
        if(arraySize > 1){
            for (int i = 0; i < arraySize; i++) {
                if(i == 0){
                    //First cycle
                    out.append(array.get(i));
                }else{
                    if(i != arraySize - 1){
                        //second cycle and on
                        out.append(", ").append(array.get(i));
                    }else{
                        //last cycle
                        out.append(", and ").append(array.get(i));
                    }
                }
            }
        }

        return out.toString();
    }

    public static String arrayListStringToString(ArrayList<String> array) {
        StringBuilder string = new StringBuilder();
        int size = array.size();
            AtomicInteger i = new AtomicInteger();
            array.forEach(arrayString -> {
                if (i.get() != size -1) {
                    string.append(arrayString).append(",");
                }else{
                    string.append(arrayString);
                }
                i.getAndIncrement();
            });
        return string.toString();
    }

    public static ArrayList<String> StringToArrayListString(String string) {
        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array,string.split(","));
        return array;
    }
}
