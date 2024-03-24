package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;


/*
##### Refactoring flow: "Extract Repository"
Notice three methods that interact DB: "lookupPriceInDB()", "readDiscount()" and loadPackageDiscount(). We will move them to a new repository class one by one.

9) Try to merge jdbc connection string in lookupPackagePriceInDB with field jdbcConnection
   9a) Refactor: Extract Field. Select seemingly duplicate string "postgresql://username:password@db.internal.com:5555/userdata?".
   9b) In "Initialize in" select "field declaration"
   9c) Check "Replace all occurrences (2)" box. Notice that the other occurrence was found and is, actually, identical!
   9d) Name new field with some temporary name, like "jdbcConnectionTemp"
   9e) Refactor: "Inline Field", the original jdbcConnection, Select "Inline all and remove the field"
   9f) Refactor: Rename "jdbcConnectionTemp" to "jdbcConnection"

*/


public class DeDuplicate {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;
    private static Logger logger = Logger.getLogger(DeDuplicate.class.getName());


    private int lookupPriceInDBOrig(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        int responseFromDB = priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;

        return responseFromDB;
    }

    private int lookupPriceInDB(int tarifCategory, int validitMonth, int validityYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        String queryStr = "";
        queryStr += "SELECT price FROM price_table WHERE";
        queryStr += " ";
        queryStr += "price_group_id = "+priceGroupIdInt;
        queryStr += " AND ";
        queryStr += "category_id = "+tarifCategory;
        queryStr += " AND ";
        queryStr += "validity_month = '"+validityYear+"-"+validitMonth+"'";
        queryStr += ",";

        return executeQuery(jdbcConnectionForPrice, queryStr);
    }

    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        int price = lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
        if (price == 0) {
            return loadPrices(baselineYear, baselineMonth, tarifCategory, priceGroupId);
        }
        return price;
    }

    private int loadPrices(int year, int month, int tarifCategoryId, int priceGroupId) {

        logger.log (Level.INFO, "Starting to read Price from DB");
        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "DB connection is: "+jdbcConnectionForPrice);

        String sql = "";
        sql += "SELECT price FROM price_table WHERE ";
        sql += "price_group_id = "+priceGroupId;
        sql += " AND ";
        sql += "category_id = "+tarifCategoryId;
        sql += " AND ";
        sql += "validity_month = '"+year+"-"+month+"'";
        sql += ",";

        int responseFromDB = executeQuery(jdbcConnectionForPrice, sql);

        logger.log (Level.INFO, "DB response is: "+responseFromDB);

        return responseFromDB;
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
