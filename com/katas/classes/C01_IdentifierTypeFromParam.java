package com.katas.classes;

public class C01_IdentifierTypeFromParam {

    /*
     * ## Refactoring flow: Replace primitive-typed parameter with "Identifier Type".
     * (Ref: https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3)
     *
     * 1) Refactor: Introduce Parameter Object. Cursor on the "lookupPriceInDB()" method. In "Introduce Parameter Object" dialog:
     *    1a) In "Create new class Name" box enter "PriceGroupId".
     *    1b) In "Parameters to Extract" grid select only "int priceGroupID" parameter.
     * 	  1c) Click "Refactor" button.
     *    1d) In "Add File to Git" dialog click "Add" button.
     * 2) Intention: Convert record to class. Cursor on the new "PriceGroupId" class.
     * 3) Refactor: Introduce Parameter Object. Cursor on "lookupDiscountInDB()" method. In "Introduce Parameter Object" dialog:
     *    3a) Select "Use exiting class" radio button.
     *    3b) In "Name" box enter "com.katas.domainobject.PriceGroupId".
     *    3c) In "Parameters to Extract" grid select only "int priceGroupId" parameter.
     *    3d) Click "Refactor" button.
     * 4) Refactor: Introduce Parameter. Place the cursor in "calculateNettoPrice()" method on "new PriceGroupId(priceGroupId)". Replace all 2 occurrences.
     * 5) Refactor: Introduce Variable. Place the cursor in "controllerGetPrice()" method on "new PriceGroupId(priceGroupId)".
     * 6) Refactor: Inline Variable. Place the cursor in "controllerGetPrice()" method on "priceGroupId" variable.
     +
     * Clean up PriceGroupId class; it should have only one getter method - "asInt()".
     * 7) Refactor: Extract Method. Place the cursor in "getPriceGroupID()" on priceGroupId field. Give method name "asInt()". Replace all occurrences.
     * 8) Intention: "Change access modifier: public". For asInt() method
     * 9) Refactor: Inline Method. Place the cursor on "getPriceGroupID()" method of class "PriceGroupId".
     * 10) Refactor: Inline Method. Place the cursor on "priceGroupID()" method of class "PriceGroupId".
     *
     *
     * Repeat this refactoring flow to create TarifCategoryId class from "int tarifCategory" primitive.
     *
     * Bonus: Create a new domain object PriceSpecification, which is a combination of TarifCategoryId and PriceGroupId
     */

    public double controllerGetPrice(final int tarifCategoryInt, final int priceGroupIdInt) {
        return this.calculateNettoPrice(tarifCategoryInt, priceGroupIdInt);
    }

    protected double calculateNettoPrice(final int tarifCategoryInt, final int priceGroupIdInt) {
        try {
            final int price = lookupPriceInDB(tarifCategoryInt, priceGroupIdInt);
            final double discount = lookupDiscountInDB(priceGroupIdInt, tarifCategoryInt);
            return price*discount;
        } catch (final NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(final int tarifCategory, final int priceGroupID) {
        return priceGroupID + tarifCategory;
    }

    private static double lookupDiscountInDB(final int priceGroupId, final int tarifCategory) {
        return priceGroupId * tarifCategory;
    }
}