package com.katas.functions;


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

    public float getPrice(String priceGroupId, int tarifCategory, String dateParam) throws MyTechnicalException {
        int priceFromDB;
        try {
            priceFromDB = lookupPriceInDB(priceGroupId, tarifCategory);
            if (priceFromDB <= 0) {
                System.out.println("No price in DB found. Apply default price");
                return fetchDefaultPriceFromDB(priceGroupId, dateParam);
            }
        } catch (final OracleDBException e) {
            System.out.println("Error reading from DB");
            throw new MyTechnicalException("Database Error occured. original exception:  "+e.getMessage());
        } finally {
            System.out.println("Releasing Resources. By the way, dateParam value was: "+ dateParam);
        }

        float multiplier = 0.95F;
        return priceFromDB*multiplier;
    }

    private static int fetchDefaultPriceFromDB(String priceGroupId, String date) throws OracleDBException {
        System.out.println(date + priceGroupId);
        return 15;
    }

    private static int lookupPriceInDB(String priceGroupId, int tarifCategory) throws OracleDBException {
        int priceGroupIdInt = Integer.parseInt(priceGroupId);
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory;
    }

    public static class MyTechnicalException extends Throwable {
        public MyTechnicalException(String message) {
            super(message);
        }
    }

    public static class OracleDBException extends Exception {
    }
}
