package org.main.day3;

import org.main.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3b {
    public void main() throws IOException {
        List<String> listInput = Util.readInput(false, 3, true);
        long totalJoltage = 0;
        for (String batteryList : listInput) {

            List<String> batteryJoltage = getBestIndexToStart(new ArrayList<>(Arrays.asList(batteryList.split(""))));


            for (int j = 0; j < batteryJoltage.size() - 1; j++) {
                int current = Integer.parseInt(batteryJoltage.get(j));
                int next = Integer.parseInt(batteryJoltage.get(j + 1));


                System.out.println(batteryJoltage);
                System.out.println("Current : " + current + " Next : " + next);
                if (current < next) {
                    System.out.println("remove : " + current);
                    batteryJoltage.remove(j);
                    j = 0;
                }
                if (batteryJoltage.size() == 12) {
                    break;

                }
            }

            // why? idon't know
            while (batteryJoltage.size() > 12) {
                batteryJoltage.removeLast();
            }


            System.out.println(batteryJoltage);
            totalJoltage += Long.parseLong(String.join("", batteryJoltage));
            System.out.println("-------");
        }
        System.out.println(totalJoltage);
    }

    private List<String> getBestIndexToStart(ArrayList<String> battaryList) {

        int bestIndex = 0;
        for (int i = 0; i < battaryList.size(); i++) {
            int number = Integer.parseInt(battaryList.get(i));
            int SubListLength = battaryList.subList(i, battaryList.size()).size();

            System.out.println("==========================");
            System.out.println(battaryList.subList(i, battaryList.size()));


            if (Integer.parseInt(battaryList.get(bestIndex)) < number && (SubListLength >= 12)) {
                bestIndex = i;
            }
        }
        System.out.println(battaryList.subList(bestIndex, battaryList.size()));
        return battaryList.subList(bestIndex, battaryList.size());
    }
}
