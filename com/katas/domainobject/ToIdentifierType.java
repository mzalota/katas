package com.katas.domainobject;

public class ToIdentifierType {
    /*
    /* ## Replace primitive with "Identifier Type". (https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3)
     *
     * 1) Refactor: Introduce Parameter Object. Cursor on "lookupPriceInDB()" method. In "Introduce Parameter Object" dialog:
     *    1a) In "Create new class Name" box enter "PriceGroupId".
     *    1b) In "Parameters to Extract" grid select only "int priceGroupID" parameter.
     * 	  1c) Click "Refactor" button.
     *    1d) In "Add File to Git" dialog click "Add" button.
     *  2) Refactor: Introduce Parameter Object. Cursor on "lookupDiscountInDB()" method. In "Introduce Parameter Object" dialog:
     *    2a) Select "Use exiting class" radio button.
     *    2b) In "Name" box enter "com.katas.PriceGroupId".
     *    2c) In "Parameters to Extract" grid select only "int priceGroupId" parameter.
     *    2d) Click "Refactor" button.
     * 3) Refactor: Introduce Parameter. Place cursor in "calculateNettoPrice()" method on "new PriceGroupId(priceGroupId)". Replace all 2 occurrences.
     * 4) Refactor: Introduce Variable. Place cursor in "controllerGetPrice()" method on "new PriceGroupId(priceGroupId)".
     * 5) Refactor: Inline Variable. Place current in "controllerGetPrice()" method on "priceGroupId" variable.
     * 6) Refactor: Rename. Variables "priceGroupId1" to "priceGroupId" without numeral 1 at the end.
     * 7) Refactor: Rename. Method "getPriceGroupID()" in class "PriceGroupId" to be "asInt()".
     *
     *
     * Repeat this refactoring flow to create TarifCategoryId class from "int tarifCategory" primitive.
     *
     * Bonus: Create a new domain object PriceSpecification, which is a combination of TarifCategoryId and PriceGroupId
     */
    public double controllerGetPrice(int tarifCategory, int priceGroupId) {
        return calculateNettoPrice(tarifCategory, priceGroupId);
    }

    protected double calculateNettoPrice(int tarifCategory, int priceGroupId) {
        try {
            int price = lookupPriceInDB(tarifCategory, priceGroupId);
            double discount = lookupDiscountInDB(priceGroupId, tarifCategory);
            return price*discount;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(int tarifCategory, int priceGroupID) {
        return priceGroupID + tarifCategory;
    }

    private static double lookupDiscountInDB(int priceGroupId, int tarifCategory) {
        return priceGroupId * tarifCategory;
    }
}