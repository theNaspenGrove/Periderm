package net.mov51.periderm.paper.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class formatting {

    public static String arrayListStringToString(ArrayList<String> array) {
        StringBuilder string = new StringBuilder();
        int size = array.size();
        if (size > 1) {
            AtomicInteger i = new AtomicInteger();
            array.forEach(arrayString -> {
                if (i.get() != size -1) {
                    string.append(arrayString).append(",");
                }else{
                    string.append(arrayString);
                }
                i.getAndIncrement();
            });

        }
        return string.toString();
    }

    public static ArrayList<String> StringToArrayListString(String string) {
        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array,string.split(","));
        return array;
    }
}

