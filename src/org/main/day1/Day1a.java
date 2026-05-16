package org.main.day1;

import java.io.IOException;

import org.main.util.Util;

import java.util.List;

public class Day1a {
    public static void main() throws IOException {
        List<String> listInput = Util.readInput(false, 1, false);

        int start = 50;
        int counter = 0;

        for (String line : listInput) {
            String direction = line.substring(0, 1);
            int dioration = Integer.parseInt(line.substring(1));

            switch (direction) {
                case "L":
                    start = (start == 0) ? 100 : start;
                    while (start < dioration) {
                        start += 100;
                    }
                    start = start - dioration;
                    break;
                case "R":
                    int result = start + dioration;
                    while (result >= 100) {
                        result -= 100;
                    }
                    start = result;
                    break;
            }
            if (start == 0) {
                counter += 1;
            }
        }
        System.out.println(counter);
    }
}
