package org.main.day4;

import org.main.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4b {
    public void main() throws IOException {
        List<List<String>> gridView = new ArrayList<>();
        List<String> listInput = Util.readInput(false, 4, true);
        int totalRolle = 0;
        boolean change = true;
        int[][] grid = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (String input : listInput) {
            gridView.add(new ArrayList<>(Arrays.asList(input.split(""))));
        }

        while (change) {
            change = false;
            List<int[]> indexWellChange = new ArrayList<>();
            int rollesCounter = 0;
            for (int i = 0; i < gridView.size(); i++) {
                for (int j = 0; j < gridView.get(i).size(); j++) {
                    int Counter = 0;

                    if (gridView.get(i).get(j).equals(".")) {
                        continue;
                    }
                    for (int[] wall : grid) {
                        String value = "";
                        try {
                            value = gridView.get(i + wall[0]).get(j + wall[1]);
                        } catch (IndexOutOfBoundsException e) {
                            value = ".";
                        }

                        if (value.equals("@")) {
                            Counter++;
                        }
                    }
                    if (Counter < 4) {
                        change = true;
                        totalRolle++;
                        rollesCounter++;
                        indexWellChange.add(new int[]{i, j});
                    }
                }

            }

            System.out.println(rollesCounter);
            rollesCounter = 0;
            for (int k = 0; k < indexWellChange.size(); k++) {
                gridView.get(indexWellChange.get(k)[0]).set(indexWellChange.get(k)[1], ".");
            }
            indexWellChange.clear();

        }


        System.out.println(totalRolle);

    }
}
