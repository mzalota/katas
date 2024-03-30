package com.katas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtractCommand {

    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()
    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int (Use "Push logic down-stack" Refactoring Flowout)

    // Replace primitive with "Identifier Type".
    //https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3

    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()
    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int (Use "Push logic down-stack" Refactoring Flowout)

    /*
    1)  Refactor: Introduce Parameter Object
    1a) In "Create new class Name" box enter "PriceGroupId"
    1b) In "Parameters to Extract" grid slect " int priceGroupId"
     *    1e) In "Add File to Git" dialog click "Add" button.
     */
    public double controllerGetPrice(String tarifCategory, String priceGroupId) {
        int tarifCategoryInt = Integer.parseInt(tarifCategory);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(new Date());
        int priceGroupIdInt = Integer.parseInt(priceGroupId);

        return calculateNettoPrice(tarifCategoryInt,today,priceGroupIdInt);
    }



    protected double calculateNettoPrice(int tarifCategory, String date, int priceGroupId) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int price = lookupPriceInDB(month, year, tarifCategory, priceGroupId);
            double discount = lookupDiscountInDB(year, priceGroupId, tarifCategory);
            return price*discount;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(int month, int year, int tarifCategory, int priceGroupID) {
        return priceGroupID * tarifCategory + year / month;
    }

    private static double lookupDiscountInDB(int year, int priceGroupId, int tarifCategory) {
        return priceGroupId * tarifCategory + year;
    }

}
