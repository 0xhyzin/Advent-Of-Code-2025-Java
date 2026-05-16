package part2;

import part1.Part1;

public class Part2 {

    public static int numberZeroShow = 0;

    public static int StartRolit() {
        int start = 50;
        int password = 0;

        for (String line : Part1.GetDataFromFile()) {

            char dire = line.charAt(0);
            int amount = Integer.parseInt(line.substring(1, line.length()));

            start = WitchDiriction(start, dire, amount);
            
            password += numberZeroShow;
            numberZeroShow=0;
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
        if(start==0)
            start=100;
        while (amount > start) {
            start = start + 100;
            if (start != 0)
                numberZeroShow += 1;
        }
        return start - amount;

    }

    private static int InRightRolit(int start, int amount) {
        int result = start + amount;
        while (result >= 100) {
            result = result - 100;
            if (result != 0)
                numberZeroShow += 1;
        }
        return result;

    }
}
