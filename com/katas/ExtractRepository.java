package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;


// #####Refactoring flow: "Extract Repository"
//
//---Move to new R
//1) Refactor: "Extract Delegate". (place cursor on class name to get that refactor menu option)
//2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
//3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
//--- Pull logic "up-stack" (to the function "above")
//1) Refactor: "Extract Method": lookupPriceInDB() - content last line of the method.
//2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
//3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()

public class ExtractRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;
    private static Logger logger = Logger.getLogger(ExtractRepository.class.getName());


    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        return lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
    }

    private int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
        logger.log (Level.INFO, "Reading Price from DB");

        jdbcConnection = jdbcConnection+";param1=value1";
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;
    }

    public double getNettoPrice(int orderId, Integer priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceInEuros = lookupPriceInDB(tarifCategory, month, year, priceGroupId);
            double discount = lookupDiscountInDB(orderId, year);
            return priceInEuros*discount;
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }
    }

    private double lookupDiscountInDB(int orderId, int year) {
        logger.log (Level.INFO, "Reading Discount from DB");
        jdbcConnection = jdbcConnection+";param2=value2";
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return Math.random()*orderId/year;
    }

}
