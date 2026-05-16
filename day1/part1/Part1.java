package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private static List<String> GetDataFromFile() {

        List<String> listString = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            listString = br.lines().toList();

        } catch (IOException e) {
            System.err.println(e);
        }

        return listString;
    }

    public static int StartRolit() {
        int start = 50;
        int password = 0;

        for (String line : GetDataFromFile()) {

            char dire = line.charAt(0);
            int amount = Integer.parseInt(line.substring(1, line.length()));

            start = WitchDiriction(start, dire, amount);
            if (start == 0) {
                password += 1;
            }
        }

        return password;

    }

    private static int WitchDiriction(int start, char diriction, int amount) {

        if (diriction == 'R') {
            start = InRightRolit(start, amount);
        } else if (diriction == 'L') {
            start = InLeftRolit(start, amount);
        }

        return start;
    }

    private static int InLeftRolit(int start, int amount) {
        while (amount > start) {
            start = start + 100;
        }
        return start - amount;

    }

    private static int InRightRolit(int start, int amount) {
        int result = start + amount;
        while (result >= 100) {
            result = result - 100;
        }
        return result;

    }

}
