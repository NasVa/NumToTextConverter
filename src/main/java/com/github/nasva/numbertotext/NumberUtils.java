package com.github.nasva.numbertotext;

import java.util.List;
import java.util.Map;

public class NumberUtils {

    public static final String MINUS = "минус";
    public static final List<String> ZERO_TO_TWENTY = List.of(
            "ноль",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"
    );

    public static final Map<Integer, String> ZERO_TO_TWENTY_FOR_THOUSANDS = Map.of(
            1, "одна",
            2, "две"
    );
    public static final Map<Character, String> TWENTY_TO_HUNDRED = Map.of(
            '2', "двадцать",
            '3', "тридцать",
            '4', "сорок",
            '5', "пятьдесят",
            '6', "шестьдесят",
            '7', "семьдесят",
            '8', "восемьдесят",
            '9', "девяносто"
    );

    public static final Map<Character, String> HUNDREDS = Map.of(
            '1', "сто",
            '2', "двести",
            '3', "триста",
            '4', "четыреста",
            '5', "пятьсот",
            '6', "шестьсот",
            '7', "семьсот",
            '8', "восемьсот",
            '9', "девятьсот"
    );

    private static Map<Integer, String> POWERS = Map.ofEntries(
            Map.entry(2, "миллион"),
            Map.entry(3, "миллиард"),
            Map.entry(4, "триллион"),
            Map.entry(5, "квадриллион"),
            Map.entry(6, "квинтиллион"),
            Map.entry(7, "секстиллион"),
            Map.entry(8, "септиллион"),
            Map.entry(9, "октиллион"),
            Map.entry(10, "нониллион"),
            Map.entry(11, "дециллион"),
            Map.entry(12, "ундециллион"),
            Map.entry(13, "дуодециллион"),
            Map.entry(14, "тредециллион"),
            Map.entry(15, "кваттордециллион"),
            Map.entry(16, "квиндециллион"),
            Map.entry(17, "седециллион"),
            Map.entry(18, "септдециллион"),
            Map.entry(19, "дуодевигинтиллион"),
            Map.entry(20, "ундевигинтиллион"),
            Map.entry(21, "вигинтиллион")
    );

    public static String getPower(int tens, int pow) {
        if (tens < 0 || tens > 99) {
            throw new IllegalArgumentException();
        }
        boolean isNotTenToTwenty = tens > 20 || tens < 10;
        boolean cond1 = tens % 10 == 1 && isNotTenToTwenty;
        boolean cond2 = tens % 10 >= 2 && tens % 10 <= 4 && isNotTenToTwenty;
        if (pow == 1 ) {
            if (cond1) {
                return "тысяча";
            } else if (cond2) {
                return "тысячи";
            } else {
                return "тысяч";
            }
        }
        var power = POWERS.get(pow);
        if (cond1) {
            return power;
        } else if (cond2) {
            return power + "а";
        } else {
            return power + "ов";
        }
    }

}
