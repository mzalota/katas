package com.katas.helpers;


public class DomainEntity {

    private final int multiplier;

    public DomainEntity(final int multi) {
        this.multiplier = multi;
    }

    public double getDiscount( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        if (year != "2000") {
            return 15.7 * orderSize * this.multiplier;
        } else {
            return 2000;
        }
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

