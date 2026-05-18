package org.main.day3;

import org.main.util.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day3a {
    public void main() throws IOException {
        List<String> listInput = Util.readInput(false, 3, false);
        int totalJoltage = 0;
        for (String batteryList : listInput) {
            int bigestNumber = 0;
            for (int i = 0; i <= batteryList.length(); i++) {
                for (int j = i + 1; j < batteryList.length(); j++) {
                    int number = Integer.parseInt(String.format("%c%c", batteryList.charAt(i), batteryList.charAt(j)));
                    if (bigestNumber < number) {
                        bigestNumber = number;
                    }
                }
            }
            totalJoltage += bigestNumber;
            System.out.println(bigestNumber);
            System.out.println("-------");
        }
        System.out.println(totalJoltage);
    }
}
