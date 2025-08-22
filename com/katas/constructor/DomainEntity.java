package com.katas.constructor;


/*
 * Move date parameter from every method to constructor.
 *
 * 1) Refactor: Introduce Field. Place cursor on "date" variable in the body of getPromotion() method in DomainEntity class.
 * 2) Refactor: Introduce Field. Place cursor on "date" variable in the body of getDiscount() method in DomainEntity class.
 *     2a) rename field name from offered "private String date1;" to "private String date;"
 * 3) Manually delete the duplicate (redundant) field 'date' in DomainEntity class.
 * 4) Refactor Extract Method: getDiscountNew(). Select body of getDiscount() except for the first line "this.setDate(date);". Keep original signature.
 * 5) Refactor Extract Method: getPromotionNew(). Select body of getPromotion() except for the first line "this.setDate(date);". Keep original signature.
 * 6) Intention: Add 'this' qualifier. Cursor on getDiscountNew() call in getDiscount() method.
 * 7) Refactor: Introduce Variable: domainEntity. Place cursor on 'this' keyword in getDiscount() method.
 *  7a) In "Expressions" dialog select 'this'
 *  7b) In "Multiple occurrences found" dialog select "Replace all 2 occurrences"
 * 8) Intention: Add 'this' qualifier. Cursor on getPromotionNew() call in getPromotion() method.
 * 9) Refactor: Introduce Variable: domainEntity. Place cursor on 'this' keyword in getPromotion() method.
 *  9a) In "Expressions" dialog select 'this'
 *  9b) In "Multiple occurrences found" dialog select "Replace all 2 occurrence"
 * 10) Refactor: Extract Method: createNew(). Select snippet in getPromotion() method with two lines "DomainEntity domainEntity = this; domainEntity.date = date;". In "Process Duplicates" dialog click "All" button.
 * 11) Refactor: Inline Variable domainEntity. Place cursor on 'domainEntity' variable in createNew() method.
 * 12) Refactor: Make Static. Place cursor on createNew() method.
 * 13) Intention: "Change access modifier: public". For createNew() method.
 * 14) Intention: "Change access modifier: public". For getDiscountNew() method.
 * 15) Intention: "Change access modifier: public". For getPromotionNew() method.
 * 16) Refactor: "Inline Method...": getDiscount(). Select first option: "Inline all and remove the method"
 * 17) Refactor: "Inline Method...": getPromotion(). Select first option: "Inline all and remove the method"
 * 18) Refactor: Extract Method: createNew2(). Select snippet in doStep02() method with two lines "DomainEntity domainEntity = new DomainEntity(1); DomainEntity domainEntity1 = DomainEntity.createNew(domainEntity, date);". In "Process Duplicates" dialog click "All" button.
 * 19) Refactor: Move Members. Place cursor on newly created "createNew2()" method definition. In "Move Static Members" dialog:
 *  19a) In "To (fully qualified name)" box enter "com.katas.constructor.DomainEntity".
 *  19b) In "Members to be moved (static only)" grid, select "createNew2()" method.
 *  19c) Click "Refactor" button
 * 20) Refactor: Introduce Parameter. Cursor on the domainEntity1 variable in  "doStep01()" method in C05_ParamToConstructor class
 * 21) Refactor: Introduce Variable. Cursor on the DomainEntity.createNew(domainEntity, "2022-02-02") in  "orchestrator()" method in C05_ParamToConstructor class
 * 22) Generate: Constructor. In "Choose Fields to Initialize by Constructor" dialog select all fields.
 * 23) In createNewFinal() method manually add date parameter as second parameter to the DomainEntity constructor.
 * 24) Intention: Safe delete DomainEntity(int). Cursor on originaly constructor with one parameter.
 *
 * "DomainEntity domainEntity = new DomainEntity(defaultMultiplier);
        DomainEntity domainEntity1 = DomainEntity.createNew(domainEntity, "2022-02-02");"
 *
 */

public class DomainEntity {

    private final int multiplier;

    public DomainEntity(final int multi) {
        this.multiplier = multi;
    }

    public double getDiscount( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        if (year != "2000") {
            return 15.7 * orderSize * this.multiplier;
        } else {
            return 2000;
        }
    }

    public double getPromotion( final String date, final int orderSize) {
        final String year = date.substring(6,10);
        if (year != "2000") {
            return 12.1 * orderSize* this.multiplier;
        } else {
            return 0.2;
        }
    }

}

