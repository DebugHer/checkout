package com.klasha.klasha_checkout.validators;

public class CvvValidator {

    public CvvValidator() {
    }

    public boolean isCvvValid(String cvv) {

        try {
            Integer.parseInt(cvv);
            return cvv.length() == 3 || cvv.length() == 4;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
