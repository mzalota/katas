package com.katas.functions;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
In getBaselinePrice() method we see two different functions are called to get Price from DB: lookupPriceInDB() and readPrices()
Lets try to refactor these two functions to see if they actually have identical behavior. (Differences in logging messages can be ignored)
*/
public class F06_DeDuplicateFunctions {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/PriceDB?" ;
    private static Logger logger = Logger.getLogger(F06_DeDuplicateFunctions.class.getName());


    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        int price = lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
        if (price == 0) {
            return readPrices(baselineYear, baselineMonth, tarifCategory, priceGroupId);
        }
        return price;
    }
    /*

    1) Right-click on DeDuplicateFunctions.java tab on top and select "Split Right". Align lookupPriceInDB() and readPrices() functions. You can jump between them with "Ctrl+Tab" shortcut
    2) Try "Extract Method" refactoring on last two lines from lookupPriceInDB() to see if the middle two lines in readPrices would be detected as identical.
    3) Undo, because IntelliJ did not detect duplication.
    4) In lookupPriceInDB() use Intention: "Introduce local variable" on "return" statement (or apply "Extract Variable" refactoring to the last line)
	5) Now try to "Extract Method" on two lines with queryBuilder() and executeQuery() function calls. Now "Process Duplicates" dialog pops up. Press "Replace" button. Rename this method to "commonLogic01()"
    6) In readPrices() move "String jdbcConnectionForPrice" variable declaration to the top of the function.
    7) Functions look very similar, but log statements differ. Logging is not business logic. Just copy/paste log statements between functions to make log statements identical in both function.
    8) Select all statements in the body of one of the functions and "Extract Method" refactoring. In "Process Duplicates" dialog press "Replace" button.
	9) Now rename newly created method to "lookupPriceInDBNew".
	10) In lookupPriceInDBNew(), put cursor on "commonLogic01()" and do "Inline Method..." refactoring. Select "Inline all and remove the method"
	11) "Inline Method..." readPrices()
	12) "Inline Method..." lookupPriceInDB()
	13) "Rename..." refactoring on "lookupPriceInDBNew()" to rename to "lookupPriceInDB()" (remove "New" suffix at the end)

     */

    private int lookupPriceInDB(int tarifCategory, int validityMonth, int validityYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        String queryStr = queryBuilder(validityYear, validityMonth, tarifCategory, priceGroupIdInt);
        return executeQuery(jdbcConnectionForPrice, queryStr);
    }

    private static String queryBuilder(int year, int month, int tarifCategoryId, int priceGroupId) {
        return "SELECT column FROM db.table";
    }

    private int readPrices(int year, int month, int tarifCategoryId, int priceGroupId) {
        logger.log (Level.INFO, "Starting to read Price from DB");

        String connStr = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "DB connection is: "+connStr);

        String sql = queryBuilder(year, month, tarifCategoryId, priceGroupId);

        int responseFromDB = executeQuery(connStr, sql);

        logger.log (Level.INFO, "Finishing reading Price from DB. Response is: "+responseFromDB);
        return responseFromDB;
    }

     private int executeQuery(String jdbcConnectionForPrice, String sqlQuery){
        System.out.println("jdbcConnectionForPrice: " +jdbcConnectionForPrice);
        System.out.println("sqlQuery: "+sqlQuery);
        return 5;
    }
}
