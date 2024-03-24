package com.katas;

public class ExtractRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;

    // #####Refactoring flows: "Push logic down-stack" and "Pull logic up-stack"
    //
    //---Move to new R
    //1) Refactor: "Extract Method": lookupPriceInDBNew() - content- last two lines of the method.
    //2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
    //3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
    //--- Pull logic "up-stack" (to the function "above")
    //1) Refactor: "Extract Method": lookupPriceInDB() - content last line of the method.
    //2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
    //3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()

    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        return lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
    }

    private int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
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
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private double lookupDiscountInDB(int orderId, int year) {
        jdbcConnection = jdbcConnection+";param2=value2";
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return Math.random()*orderId/year;
    }

}
