package net.mov51.periderm.logs;

import java.util.ArrayList;

public class Strings {
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
}
