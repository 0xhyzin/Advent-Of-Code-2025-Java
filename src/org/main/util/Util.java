package org.main.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
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

    public static Dictionary<String, List<String>> read2Input(boolean isTest, int day, boolean isPartB) throws IOException {
        List<String> listInput = new ArrayList<>();
        Dictionary<String, List<String>> list2Input = new Hashtable<>();
        String fileDire = "";
        if (isTest) {
            fileDire = (isPartB) ? "test_b" : "test_a";
        } else {
            fileDire = (isPartB) ? "input_b" : "input_a";
        }
        BufferedReader reader = new BufferedReader(new FileReader(fileDire + "/day" + day + ".txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                list2Input.put("1", new ArrayList<>(listInput));
                listInput.clear();
                continue;
            }
            listInput.add(line);
        }
        list2Input.put("2", new ArrayList<>(listInput));

        return list2Input;
    }
}
