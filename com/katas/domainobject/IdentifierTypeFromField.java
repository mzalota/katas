package com.katas.domainobject;

public class IdentifierTypeFromField {

    /* ## Refactoring flow: Replace primitive-typed field with "Identifier Type".
     * (Ref: https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3)
     *
     * 1) Manually remove "final" keyword in the declaration of "customerId" field. Otherwise we cannot define a setter method for it.
     * 2) Refactor: Encapsulate Fields. Cursor on the declaration of "customerId" field. In "Encapsulate Fields" dialog:
     *    2a) Select only "customerId" field. Don't select "name" field
     *    2b) Select all boxes in Encapsulate section: "Get access", "Set access", "Use accessors even when field is accessible"
     * 	  2c) Click "Refactor" button.
     * 3) Refactor: Introduce Parameter Object. Cursor on the "setCustomerId()" method. In "Introduce Parameter Object" dialog:
     *    3a) In "Create new class Name" box enter "CustomerId".
     *    3b) In "Parameters to Extract" grid select "double customerId" parameter.
     * 	  3c) Click "Refactor" button.
     *    3d) In "Add File to Git" dialog click "Add" button.
     * 4) Intention: Convert record to class. Cursor on the new "CustomerId" class.
     * 5) Refactor: Extract Field. Place the cursor on newly created customerId1 parameter in setCustomerId() method.
     * 6) In getCustomerId() method manually replace "return customerId;" with "return customerId1.getCustomerId();"
     * 7) In setCustomerId() method manually delete line "this.customerId = this.customerId1.getCustomerId();"
     * 8) Intention: "Remove field customerId". Place the cursor on the definition of the customerId field.
     *
     * --- Clean up
     * 9) Refactor: Rename. customerId1 -> customerId.
     * 10) Refactor: Inline Method setCustomerId(). Choose option to remove setCustomerId() method - public setters are not welcomed.
     * 11) Refactor: Rename getCustomerId() to getCustomerIdDouble().
     * 12) Refactor: Encapsulate Fields. Cursor on the declation of "customerId" field. In "Encapsulate Fields" dialog:
     *    12a) Select only "customerId" field. Don't select "name" field.
     *    12b) Select all boxes in Encapsulate section: "Get access", "Use accessors even when field is accessible"
     * 	  12c) Click "Refactor" button.
     * 13) Refactor: Inline Method getCustomerIdDouble(). Choose option to remove method.
     * 14) In sameAs() manually replace getCustomerId().getCustomerId() != customerOther.getCustomerId().getCustomerId() with "getCustomerId() != customerOther.getCustomerId()"
     *
     */

    private final double customerId;
    private final String name ;

    public IdentifierTypeFromField(final double customerId, final String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public boolean sameAs(final IdentifierTypeFromField customerOther) {
        if (this.customerId != customerOther.customerId) {
            return false;
        }

        if (this.name == customerOther.name) {
            return true;
        }
        return false;
    }

    public String humanReadable() {
        final String text= "Customer: id:"+ this.customerId + ", name: "+ this.name;
        return text;
    }
}
