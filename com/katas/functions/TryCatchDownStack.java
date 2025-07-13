package com.katas.functions;


import com.katas.helpers.DBAccess;
import com.katas.helpers.MyCustomTechnicalException;

public class TryCatchDownStack {

/*
*
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

    public float getPrice(String priceGroupId, int tarifCategory, String dateParam) throws MyCustomTechnicalException {
        int priceFromDB;
        try {
            priceFromDB = lookupPriceInDB(priceGroupId, tarifCategory);
            if (priceFromDB <= 0) {
                System.out.println("No price in DB found. Apply default price");
                return lookupDefaultPriceInDB(priceGroupId, dateParam);
            }
        } catch (final DBAccess.OracleDBException e) {
            System.out.println("Error reading from DB");
            throw new MyCustomTechnicalException("Database Error occured. original exception:  "+e.getMessage());
        }

        return applyDiscount(priceFromDB);
    }

    private int lookupDefaultPriceInDB(String priceGroupId, String date) throws DBAccess.OracleDBException {
        DBAccess.readFromDB();
        //hardcoded for kata. Otherwise we would take what DB returned.
        return 15;
    }

    private int lookupPriceInDB(String priceGroupId, int tarifCategory) throws DBAccess.OracleDBException {
        int priceGroupIdInt = Integer.parseInt(priceGroupId);
        DBAccess.readFromDB();
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory;
    }

    private float applyDiscount(int priceFromDB) {
        float multiplier = 0.95F;
        return priceFromDB * multiplier;
    }
}
