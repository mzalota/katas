package com.katas;

public class ExtractCommand {



    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()
    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int (Use "Push logic down-stack" Refactoring Flowout)

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

    private static int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
        return priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;
    }

}
