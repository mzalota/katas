package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeDuplicate {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/PriceDB?" ;
    private static Logger logger = Logger.getLogger(DeDuplicate.class.getName());


    /*
    1) Right-click on DeDuplicat.java tab on top and select "Split Right". Align lookupPriceInDB() and readPrices() functions. You can jump between them with "Ctrl+Tab" shortcut
    2) Try "Extract Method" refactoring on last two lines from lookupPriceInDB() to see if the middle two lines in readPrices would be detected as the same.
    3) Undo, because IntelliJ did not detect duplication.
    4) In lookupPriceInDB() use Intention: introduce local variable on "return" statement (or apply "Extract Variable" refactoring to the last line)
	5) Now try to "Extract Method" on two lines with queryBuilder() and executeQuery() function calls. Now "Process Duplicates" dialog pops up. Press "Replace" button. Rename this method to "commonLogic01()"
    6) In readPrices() move "String jdbcConnectionForPrice" variable declaration to the top of the function.
    6) You now clearly see that log statements differ. It's not business logic. Just copy/paste these log statements between functions to make them identical in each function.
    7) Select all statements in the body of one of the functions and "Extract Method" refactoring. In "Process Duplicates" dialog press "Replace" button.
	8) Now rename newly created method to "lookupPriceInDBNew".
	9) In lookupPriceInDBNew(), put curson on "commonLogic01()" and do "Inline Method..." refactoring. Select "Inline all and remove the method"
	10) "Inline Method..." readPrices()
	11) "Inline Method..." lookupPriceInDB()
	12) "Rename..." refactoring on "lookupPriceInDBNew()" to rename to "lookupPriceInDB()" (without New suffix)
     */

    private int lookupPriceInDB(int tarifCategory, int validitMonth, int validityYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        String queryStr = queryBuilder(tarifCategory, validitMonth, validityYear, priceGroupIdInt);
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

    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        int price = lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
        if (price == 0) {
            return readPrices(baselineYear, baselineMonth, tarifCategory, priceGroupId);
        }
        return price;
    }

    int executeQuery(String jdbcConnectionForPrice, String sqlQuery){
        System.out.println("jdbcConnectionForPrice: " +jdbcConnectionForPrice);
        System.out.println("sqlQuery: "+sqlQuery);
        return 5;
    }

    public double getNettoPrice(int orderId, Integer priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceInEuros = lookupPriceInDB(tarifCategory, month, year, priceGroupId);
            double discount = 13;
            return priceInEuros*discount;
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }
    }

}
