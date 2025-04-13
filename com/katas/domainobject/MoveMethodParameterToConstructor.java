package com.katas.domainobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoveMethodParameterToConstructor {

    /* ## Add Factory Methods.
     *
     * Approach would be to refactor all public methods so that their first line is to pass parameter to a setter. Then call similar method without this parameter.
     * Then in the caller methods move the setter up-stack to meet the constructor of the object. Then extract these two methods (constructor then setter) to a factory method.
     */
    public double controllerGetPrice(int priceGroupId) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(new Date());
        return calculateNettoPrice(today, priceGroupId);
    }

    protected double calculateNettoPrice(String date, int priceGroupId) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int price = lookupPriceInDB(month, year, priceGroupId);
            return price;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(int month, int year, int priceGroupID) {
        return priceGroupID + year / month;
    }
}