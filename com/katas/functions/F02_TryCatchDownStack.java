package com.katas.functions;


import com.katas.helpers.DBAccess;
import com.katas.helpers.MyCustomTechnicalException;

/*
 * Refactoring flow: "Push try/catch block down-stack"
 *
 * ---Push try/catch clause "down-stack" into lookupPriceInDB() method.
 * 1) Duplicate method getPrice() and call it getPrice_tmp().
 * 2) In getPrice_tmp() inside the try block remove all lines except the line containing call to the lookupPriceInDB() method. ("priceFromDB = this.lookupPriceInDB(priceGroupId, tarifCategory);")
 * 3) Refactor: "Extract Method": lookupPriceInDB_new() - content of the second try/catch block.
 * 4) Delete getPrice_tmp() method.
 * 5) Manually rename (not using 'Rename' refactoring) method lookupPriceInDB() definition to have the suffix '_old'. Inside lookupPriceInDB_new() edit manually to call lookupPriceInDB_old().
 * 6) Manually rename (not using 'Rename' refactoring) method lookupPriceInDB_new() to lookupPriceInDB(). Now all up-stack methods are calling the new method with the moved try/catch.
 * 7) Refactor: "Inline Method...": lookupPriceInDB_old(). Select first option: "Inline all and remove the method".
 * 8) Intention: "Move 'return' closer to computation of the value of 'priceFromDB'". Place cursor on return statement in lookupPriceInDB() method.
 *
 * ---Push try/catch clause "down-stack" into lookupDefaultPriceInDB() method.
 * 1) Duplicate method getPrice() and call it getPrice_tmp().
 * 2) In getPrice_tmp() inside the try block remove all lines except the line containing call to the lookupDefaultPriceInDB() method. ("return this.lookupDefaultPriceInDB(priceGroupId, dateParam);")
 * 3) Refactor: "Extract Method": lookupDefaultPriceInDB_new() - content of the second try/catch block.
 * 4) Delete getPrice_tmp() method.
 * 5) Manually rename (not using 'Rename' refactoring) method lookupDefaultPriceInDB() definition to have the suffix '_old'. Inside lookupDefaultPriceInDB_new() edit manually to call lookupDefaultPriceInDB_old()
 * 6) Manually rename (not using 'Rename' refactoring) method lookupDefaultPriceInDB_new() to lookupDefaultPriceInDB(). Now all up-stack methods are calling the new method with the moved try/catch.
 * 7) Intention: "Delete catch for 'com.katas.helpers.DBAcces.OracleDBException'". Place cursor on catch statement in getPrice() method.
 * 8) Refactor: "Inline Method...": lookupDefaultPriceInDB_old(). Select first option: "Inline all and remove the method".
 *
 */

public class F02_TryCatchDownStack {

    public float getPrice(final String priceGroupId, final int tarifCategory, final String dateParam) throws MyCustomTechnicalException {
        final int priceFromDB;
        try {
            priceFromDB = this.lookupPriceInDB(priceGroupId, tarifCategory);
            if (priceFromDB <= 0) {
                System.out.println("No price in DB found. Apply default price");
                return this.lookupDefaultPriceInDB(priceGroupId, dateParam);
            }
        } catch (final DBAccess.OracleDBException e) {
            System.out.println("Error reading from DB");
            throw new MyCustomTechnicalException("Database Error occurred. Original exception:  "+e.getMessage());
        }

        return this.applyDiscount(priceFromDB);
    }

    private int lookupPriceInDB(final String priceGroupId, final int tarifCategory) throws DBAccess.OracleDBException {
        final int priceGroupIdInt = Integer.parseInt(priceGroupId);
        DBAccess.readFromDB();
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory;
    }

    private int lookupDefaultPriceInDB(final String priceGroupId, final String date) throws DBAccess.OracleDBException {
        DBAccess.readFromDB();
        //hardcoded for kata. Otherwise we would take what DB returned.
        return 15;
    }

    private float applyDiscount(final int priceFromDB) {
        final float multiplier = 0.95F;
        return priceFromDB * multiplier;
    }
}
