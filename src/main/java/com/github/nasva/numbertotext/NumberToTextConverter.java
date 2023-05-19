package com.github.nasva.numbertotext;

import java.util.ArrayList;
import java.util.List;

public class NumberToTextConverter {

    private final MainNumsConverter mainNumsConverter = new MainNumsConverter();

    public String convert(String str) {
        var result = new StringBuilder();
        if (str.startsWith("-")){
            result.append(NumberUtils.MINUS)
                    .append(" ");
            str = str.substring(1);
        }
        var parts = splitParts(str);
        for (int i = 0; i < parts.size(); i++) {
            var pow = parts.size() - i - 1;
            var part = parts.get(i);
            var tens = Integer.parseInt(part.substring(Math.max(0, part.length() - 2)));
            if (part.equals("000")){
                continue;
            }
            result.append(mainNumsConverter.convert(part, pow == 1))
                    .append(" ");
            if (pow != 0) {
                result.append(NumberUtils.getPower(tens, pow))
                        .append(" ");
            }
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }


    List<String> splitParts(String str) {
        var parts = new ArrayList<String>();
        if (str.length() % 3 != 0) {
            parts.add(str.substring(0, str.length() % 3));
        }
        for (int i = str.length() % 3; i < str.length(); i += 3) {
            parts.add(str.substring(i, i + 3));
        }
        return parts;
    }
}
