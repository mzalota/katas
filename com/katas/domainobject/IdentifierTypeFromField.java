package com.katas.domainobject;

public class IdentifierTypeFromField {

    /* ## Replace primitive with "Identifier Type". (https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3)
     *
     * 1) Refactor: Encapsulate Fields. Cursor on the declation of "customerId" field. In "Encapsulate Fields" dialog:
     *    1a) Select only customerId  field. Don't select name field
     *    1b) Select all boxes in Encapsulate secion: "Get access", "Set access", "Use accessors even wehn field is accessible"
     * 	  1c) Click "Refactor" button.
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

    private double customerId;
    private String name ;

    public IdentifierTypeFromField(double customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public boolean sameAs(IdentifierTypeFromField customerOther) {
        if (this.customerId != customerOther.customerId)
            return false;

        if (this.name != customerOther.name) {
            return false;
        }
        return true;
    }

    public String humanReadable() {
        String text= "Customer: id:"+String.valueOf(customerId) + ", name: "+name;
        return text;
    }
}


}