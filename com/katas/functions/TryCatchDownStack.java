package com.katas.functions;


public class TryCatchDownStack {

/*
* Refactoring flow: "Push logic down-stack" and "Pull logic up-stack"
*
* ---Push logic "down-stack" (to the function "below")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - select last two lines in the method getBaselinePrice().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
* --- Pull logic "up-stack" (to the function "above")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - content last line in the method lookupPriceInDB().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
*/

    public int getBaselinePrice(String priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        return lookupPriceInDB(priceGroupId, tarifCategory, baselineMonth, baselineYear);
    }


    public int getPrice(String priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceFromDB = lookupPriceInDB(priceGroupId, tarifCategory, month, year);
            if (priceFromDB <= 0) {
                System.out.println("No price in DB found. Apply default price");
                return determineDefaultPrice(priceGroupId, date);
            }
            return priceFromDB;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        } finally {
            System.out.println("Date value was: "+date);
        }
    }

    private static int determineDefaultPrice(String priceGroupId, String date) {
        System.out.println(date + priceGroupId);
        return 15;
    }

    private static int lookupPriceInDB(String priceGroupId, int tarifCategory, int month, int year) {
        int priceGroupIdInt = Integer.parseInt(priceGroupId);
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory + year / month;
    }

}
