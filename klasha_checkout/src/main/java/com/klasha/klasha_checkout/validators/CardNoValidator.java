package com.klasha.klasha_checkout.validators;


import com.klasha.klasha_checkout.utils.Utils;

public class CardNoValidator {

    public CardNoValidator() {
    }

    public boolean isCardNoStrippedValid(String cardNoStripped) {
        try {
            Long.valueOf(cardNoStripped);
            return !(cardNoStripped.length() < 12) && isValidLuhnNumber(cardNoStripped);
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Checks that a number is valid according to the
     * <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm</a>
     *
     * @param number to be checked
     * @return true if valid
     */
    public static boolean isValidLuhnNumber(String number) {

        try {// Verify that string contains only numbers
            Long parsed = Long.parseLong(number);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        String reversedNumber = new StringBuffer(number).reverse().toString();
        char[] reversedCharArray = reversedNumber.toCharArray();
        int luhnSum = 0;

        // Double the value of every second digit from the right
        for (int index = 1; index < number.length(); index += 2) {
            int doubleResult = Character.getNumericValue(reversedCharArray[index]) * 2;
            if (doubleResult > 9) {// If result has double digits, sum digits
                doubleResult = 1 + (doubleResult - 10);
            }

            reversedCharArray[index] = Character.forDigit(doubleResult, 10);
        }

        // Sum all digits
        for (int index = 0; index < number.length(); index++) {
            luhnSum += Character.getNumericValue(reversedCharArray[index]);
        }

        // For valiid Luhn number, sum result should be a multiple of 10
        return luhnSum % 10 == 0;
    }
}
