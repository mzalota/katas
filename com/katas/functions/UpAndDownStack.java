package com.katas.functions;


public class UpAndDownStack {

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

        int priceGroupIdInt = Integer.parseInt(priceGroupId);
        return lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupIdInt);
    }

    private static int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;
    }


    public int getPrice(String priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceGroupIdInt = Integer.parseInt(priceGroupId);
            return lookupPriceInDB(tarifCategory, month, year, priceGroupIdInt);
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

}
