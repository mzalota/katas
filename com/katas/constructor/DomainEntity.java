package com.katas.constructor;

/*
 * Move date parameter from every method to constructor.
 *
 * -- Evolve getPromotion() and getDiscount() methods to not expect date as parameter
 * 1) Refactor: Introduce Field. Place cursor on "date" variable in the body of getPromotion() method in DomainEntity class.
 * 2) Refactor: Introduce Field. Place cursor on "date" variable in the body of getDiscount() method in DomainEntity class.
 *     2a) Rename field name from offered "private String date1;" to "private String date;"
 * 3) Manually delete the newly created duplicate field 'date' in the DomainEntity class.
 * 4) Refactor Extract Method: getDiscountNew(). Select body of getDiscount() except for the first line "this.date = date;". Keep original signature.
 * 5) Refactor Extract Method: getPromotionNew(). Select body of getPromotion() except for the first line "this.date = date;". Keep original signature.
 * 6) Intention: Add 'this' qualifier. Cursor on getDiscountNew() call in getDiscount() method.
 * 7) Refactor: Introduce Variable: domainEntity. Place cursor on 'this' keyword in getDiscount() method.
 *  7a) In "Expressions" dialog select 'this'
 *  7b) In "Multiple occurrences found" dialog select "Replace all 2 occurrences"
 * 8) Intention: Add 'this' qualifier. Cursor on getPromotionNew() call in getPromotion() method.
 * 9) Refactor: Introduce Variable: domainEntity. Place cursor on 'this' keyword in getPromotion() method.
 *  9a) In "Expressions" dialog select 'this'
 *  9b) In "Multiple occurrences found" dialog select "Replace all 2 occurrence"
 * 10) Refactor: Extract Method: factoryMethodTmp(). Select snippet in getPromotion() method with two lines "DomainEntity domainEntity = this; domainEntity.date = date;". In "Process Duplicates" dialog click "All" button.
 * 11) Refactor: Inline Variable domainEntity. Place cursor on 'domainEntity' variable in factoryMethodTmp() method.
 * 12) Refactor: Make Static. Place cursor on factoryMethodTmp() method.
 * 13) Intention: "Change access modifier: public". For factoryMethodTmp() method.
 * 14) Intention: "Change access modifier: public". For getDiscountNew() method.
 * 15) Intention: "Change access modifier: public". For getPromotionNew() method.
 * 16) Generate: Constructor. In "Choose Fields to Initialize by Constructor" dialog select all fields.
 * 17) Refactor: "Inline Method...": getDiscount(). Select first option: "Inline all and remove the method"
 * 18) Refactor: "Inline Method...": getPromotion(). Select first option: "Inline all and remove the method"
 *
 * -- Replace original DomainEntity(int) constructor in method doStep02() with a temporary factory method "createNew(date, int)".
 * 19) Refactor: Extract Method: createNew(). Select snippet in doStep02() method in C05_ParamToConstructor class with two lines "DomainEntity domainEntity = new DomainEntity(1); DomainEntity domainEntity1 = DomainEntity.factoryMethodTmp(domainEntity, date);". In "Process Duplicates" dialog click "All" button.
 * 20) Refactor: Move Members. Place cursor on newly created "createNew()" method definition. In "Move Static Members" dialog:
 *  20a) In "To (fully qualified name)" box enter "com.katas.constructor.DomainEntity".
 *  20b) In "Members to be moved (static only)" grid, select "createNew()" method.
 *  20c) Click "Refactor" button.
 *
 * -- Replace original DomainEntity(int) constructor in method orchestrator() with another temporary factory method "createNew2(date, int)".
 * 21) Refactor: Introduce Parameter. Cursor on the domainEntity1 variable in  "doStep01()" method in C05_ParamToConstructor class
 * 22) Refactor: Introduce Variable, domainEntity1. Cursor on the DomainEntity.factoryMethodTmp(domainEntity, startingDate) in  "orchestrator()" method in C05_ParamToConstructor class
 * 23) Refactor: Extract Method: createNew2(). Select snippet in orchestrator() method with two lines "DomainEntity domainEntity = new DomainEntity(defaultMultiplier); DomainEntity domainEntity1 = DomainEntity.factoryMethodTmp(domainEntity, startingDate);".
 * 24) Refactor: Move Members. Place cursor on newly created "createNew2()" method definition. In "Move Static Members" dialog:
 *  24a) In "To (fully qualified name)" box enter "com.katas.constructor.DomainEntity".
 *  24b) In "Members to be moved (static only)" grid, select "createNew2()" method.
 *  24c) Click "Refactor" button

 * -- De-duplicate createNew and createNew2 methods in DomainEntity class
 * 25) Refactor: Extract Method: createNewFinal . Select body of createNew2() method. In "Process Duplicates" dialog click "All" button.
 * 26) Manually add date parameter as second parameter to the DomainEntity constructor in createNewFinal() method.
 * 27) Manually remove call to factoryMethodTmp() method in createNewFinal() method
 * 28) Intention: "Change access modifier: public". For createNewFinal() method.
 * 29) Refactor: "Inline Method...": createNew(). Select first option: "Inline all and remove the method"
 * 30) Refactor: "Inline Method...": createNew2(). Select first option: "Inline all and remove the method"
 * 31) Refactor: "Inline Method...": createNewFinal(). Select first option: "Inline all and remove the method"
 * 32) Intention: Safe delete factoryMethodTmp(int). Cursor on the factoryMethodTmp() method.
 * 33) Intention: Safe delete DomainEntity(int). Cursor on the original constructor with one parameter.
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

