package org.main.day2;

import org.main.util.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Day2a {
    public void main() throws IOException {
        List<String> listInput = Util.readInput(false, 2, false);
        List<String> InputString = Arrays.asList(listInput.toString().substring(1, listInput.toString().length() - 1).split(","));

        long finalResult = 0;

        for (String id : InputString) {
            if (id.isEmpty()) continue;
            long start = Long.parseLong(id.split("-")[0]);
            long end = Long.parseLong(id.split("-")[1]);
            for (long i = start; i <= end; i++) {

                String stringNumber = Long.toString(i);
                if (stringNumber.length() % 2 != 0) continue;

                long partA = Long.parseLong(stringNumber.substring(0, stringNumber.length() / 2));
                long partB = Long.parseLong(stringNumber.substring(stringNumber.length() / 2));
                if (partA == partB) {
                    System.out.println(i);
                    finalResult += i;
                }


            }

        }
        System.out.println(finalResult);

    }
}
