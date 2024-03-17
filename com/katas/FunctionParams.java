package com.katas;

public class FunctionParams {


    //1) Refactoring: "Introduce Parameter Object": Class name PriceGroupId, select priceGroupId
    //2) Refactoring: "Introduce Parameter Object": Class name PriceGroup, select tarifCategory and date
    //3) Refactoring: "Move instance method"
    public int getPrice(String priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            return lookupPriceInDB(month, year, tarifCategory, Integer.parseInt(priceGroupId));
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    protected int lookupPriceInDB(int month, int year, int tarifCategory, int priceGroupId) {
        return 321;
    }

    protected void barMethod(String message) {
        System.out.println(message);
    }
}
