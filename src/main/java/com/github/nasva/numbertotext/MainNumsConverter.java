package com.github.nasva.numbertotext;

public class MainNumsConverter {
    public String convert(String nums, boolean isThousand) {
        var result = new StringBuilder();
        if (nums.length() == 3 && nums.charAt(0) != '0') {
            result.append(NumberUtils.HUNDREDS.get(nums.charAt(0)))
                    .append(" ");
        }
        if (nums.length() >= 2) {
            int tens = Integer.parseInt(nums.substring(nums.length() - 2));

            if (tens >= 20) {
                result.append(NumberUtils.TWENTY_TO_HUNDRED.get(nums.charAt(nums.length() - 2)))
                        .append(" ");
            } else if (tens != 0){
                appendLastDigit(result, tens, isThousand);
            }
        }
        if (nums.length() == 1 || (nums.charAt(nums.length() - 2) > '1' && nums.charAt(nums.length() - 1) != '0')) {
            appendLastDigit(result, nums.charAt(nums.length() - 1) - '0', isThousand);
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

    private void appendLastDigit(StringBuilder result, int tens, boolean isThousand) {
        if (isThousand && NumberUtils.ZERO_TO_TWENTY_FOR_THOUSANDS.containsKey(tens)){
            result.append(NumberUtils.ZERO_TO_TWENTY_FOR_THOUSANDS.get(tens));
        }
        else {
            result.append(NumberUtils.ZERO_TO_TWENTY.get(tens));
        }
        result.append(" ");
    }

}
