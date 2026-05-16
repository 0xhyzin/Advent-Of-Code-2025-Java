package org.main.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> readInput(boolean isTest, int day, boolean isPartB) throws IOException {
        String fileDire = "";
        if (isTest) {
            fileDire = (isPartB) ? "test_b" : "test_a";
        } else {
            fileDire = (isPartB) ? "input_b" : "input_a";
        }
        BufferedReader reader = new BufferedReader(new FileReader(fileDire + "/day" + day + ".txt"));
        List<String> listInput = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            listInput.add(line);
        }
        return listInput;
    }
}
