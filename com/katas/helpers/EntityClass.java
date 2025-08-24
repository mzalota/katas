package com.katas.helpers;


public class EntityClass {

    private final int multiplier;

    public EntityClass(final int multi) {
        this.multiplier = multi;
    }

    public double getPromotion( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        if (year != "2000") {
            return 12.1 * orderSize* this.multiplier;
        } else {
            return 0.2;
        }
    }
}

