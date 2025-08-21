package com.katas.constructor;


/*
 * Move date parameter from every method to constructor.
 *
 * 1) Refactor: Introduce Field. Place cursor on "date" variable in the body of getPromotion() method in DomainEntity class.
 * 2) Refactor: Introduce Field. Place cursor on "date" variable in the body of getDiscount() method in DomainEntity class.
 *     2a) rename field name from offered "private String date1;" to "private String date;"
 * 3) Manually delete the second/redundant field 'date' in DomainEntity class.
 * 4) Refactor Extract Method: getDiscountNew().  Select body of getDiscount() except for the first line "this.setDate(date);".
 * 5) Refactor Extract Method: getDiscountNew().  Select body of getDiscount() except for the first line "this.setDate(date);".
 * 4) Refactor: Encapsulate Fields. Place cursor on "date" field in DomainEntity class. In "Encapsulate Fields" dialog:
 *   4a) Select only "date" field. Don't select "multiplier" field
 *   4b) Select 2 boxes in Encapsulate section: , "Set access", "Use accessors even when field is accessible". Deselect "Get access" box
 * 	 4c) Click "Refactor" button.
 * 5) Manually add "return this;" at the bottom of the newly created setDate() method.
 * 6) Intention: Make 'setDate()' return 'com.katas.constructor.DomainEntity'. Place cursor on ' return this;' in setDate() method.
 * 7) Refactor: Introduce Variable: domainEntity. Place cursor on 'this.date' keyword in getPromotion() method.
 *  7a) In "Expressions" dialog select 'this'
 *  7b) In "Multiple occurrences found" dialog select "Replace this occurrence only"
 * 8) Refactor: Introduce Variable: domainEntity. Place cursor on 'this.date' keyword in getDiscount() method.
 *  8a) In "Expressions" dialog select 'this'
 *  8b) In "Multiple occurrences found" dialog select "Replace this occurrence only"
 * 9) Refactor: Extract Method: createNew(). Select snippet with two lines "this.setDate(date);  DomainEntity domainEntity = this;". In "Process Duplicates" dialog click "All" button.
 * 10) Refactor: Make Static
 *
 * 10) Refactor: Inline Variable domainEntity. Place cursor on 'domainEntity' variable in createNew() method.

  10) Refactor: Make Static. Place cursor on createNew() method.
 Check box "Add object as a parameter with name:"
 Select name variable name 'entity' from the drop-down
 * 14) Refactor: Inline class
 *
 */

public class DomainEntity {

    private final int multiplier;

    public DomainEntity(final int multi) {
        this.multiplier = multi;
    }

    public double getDiscount( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        return 15.7 * orderSize * this.multiplier;
    }

    public double getPromotion( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        return 12.1 * orderSize* this.multiplier;
    }

}

