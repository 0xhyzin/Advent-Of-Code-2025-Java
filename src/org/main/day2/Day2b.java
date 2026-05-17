package org.main.day2;

import org.main.util.Util;

import java.io.IOException;
import java.util.*;

public class Day2b {
    public void main() throws IOException {
        List<String> listInput = Util.readInput(false, 2, true);
        List<String> InputString = Arrays.asList(listInput.toString().substring(1, listInput.toString().length() - 1).split(","));

        long finalResult = 0;

        for (String id : InputString) {
            if (id.isEmpty()) continue;
            long start = Long.parseLong(id.split("-")[0]);
            long end = Long.parseLong(id.split("-")[1]);

            List<Integer> listOfParts = new ArrayList<>();
            for (long i = start; i <= end; i++) {
                String stringNumber = Long.toString(i);
                for (int j = 1; j <= Math.floor(stringNumber.length() - 1); j++) {
                    if (stringNumber.length() % j == 0) {
                        listOfParts.add(j);
                    }
                }
                for (int part : listOfParts) { //[1,2]
                    List<Integer> numberParts = new ArrayList<>();
                    for (int k = 0; k <= stringNumber.length() - part; k += part) { //(0+2)->(0+(2*2))  (2+2)->(2+(4))
                        numberParts.add(Integer.parseInt(stringNumber.substring(k, k + part)));
                    }
                    System.out.println("NumberParts : " + numberParts);

                    Set<Integer> ConvertListToSetToRemoveTheSameItem = new HashSet<>(numberParts);
                    System.out.println("After Convert To Set : " + ConvertListToSetToRemoveTheSameItem);

                    if (ConvertListToSetToRemoveTheSameItem.size() == 1) {
                        System.out.println("is not valied : " + i);
                        System.out.println("----------");
                        finalResult += i;
                        System.out.println("----The final Result : " + finalResult);
                        System.out.println("----------");
                        break;
                    }
                    System.out.println("----------");
                }
                listOfParts.clear();

            }

        }
        System.out.println(finalResult);

    }
}
