package com.katas;

public class FunctionParams {

    //---Push logic into subfunction
    public int getBaselinePrice(String priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;
        return lookupPriceInDB(baselineMonth, baselineYear, tarifCategory, Integer.parseInt(priceGroupId));
    }


    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()

    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int
    //5) Refactoring: "Extract Method": tmpMethod() for code "lookupPriceInDB(month, year, tarifCategory, priceGroupId1.getAsInt())"
    //6) Refactoring: "Inline Method...": lookupPriceInDB()
    //7) Refactoring: "Rename..." tmpMethod() to lookupPriceInDB()
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
        return priceGroupId*tarifCategory+year/month;
    }

}
