package org.main.day5;

import org.main.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class Day5a {
    public void main() throws IOException {
        Dictionary<String, List<String>> listInputs = Util.read2Input(false, 5, false);
        List<List<Long>> ingredientRanges = new ArrayList<>();
        List<Long> availableIngredient = new ArrayList<>();
        int totalAvailableIngredient = 0;

        for (String range : listInputs.get("1")) {
            List<Long> listNumbers = new ArrayList<>();
            for (String number : range.split("-"))
                listNumbers.add(Long.parseLong(number));
            ingredientRanges.add(listNumbers);
        }
        System.out.println(ingredientRanges);
        for (String ingredient : listInputs.get("2")) {
            availableIngredient.add(Long.parseLong(ingredient));
        }
        System.out.println(availableIngredient);

        for (int i = 0; i < availableIngredient.size(); i++) {
            for (int j = 0; j < ingredientRanges.size(); j++) {
                Long number = availableIngredient.get(i);
                Long left = ingredientRanges.get(j).get(0);
                Long right = ingredientRanges.get(j).get(1);
                System.out.println("Number : " + number + " Range From To : " + left + " " + right);
                if (number >= left && number <= right) {
                    totalAvailableIngredient++;
                    break;
                }
            }
            System.out.println("=========");
        }
        System.out.println("Total Available Ingredient : " + totalAvailableIngredient);

    }
}
