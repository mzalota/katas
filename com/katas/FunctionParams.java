package com.katas;

public class FunctionParams {

    // Refactoring flows: "Push logic down-stack" and "Pull logic up-stack"
    //---Push logic "down-stack" (to the function below)
    //1) Refactor: "Extract Method": lookupPriceInDBNew() - content- last two lines of the method. Choose option "Inline this only and keep method". In "Process Duplicates" select Replace
    //2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
    //3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()

    //--- Pull logic "up-stack" (to the function "above")
    //1) Refactor: "Extract Method": lookupPriceInDB() - content last line of the method.
    //2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
    //3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
    public int getBaselinePrice(String priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        int priceGroupIdInt = Integer.parseInt(priceGroupId);
        return lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupIdInt);
    }

    private static int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
        return priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;
    }


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

}
