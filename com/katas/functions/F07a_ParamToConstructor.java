package com.katas.functions;

import com.katas.helpers.EntityClass;

/*
 * Move date parameter from every method to constructor. (Steps #3 and #7 are key to this pattern)
 *
 * -- Refactor getPromotion() method in EntityClass - remove date parameter
 * 1) Refactor: Introduce Field. Place the cursor on the "date" variable in the body of the getPromotion() method in the EntityClass class.
 * 2) Refactor Extract Method: getPromotionNew(). Select the body of the getPromotion() method except for the first line "this.date = date;". Keep original signature.
 * 3) Intention: Add 'this' qualifier. Place the cursor on tje getPromotionNew() call in the getPromotion() method.
 * 4) Refactor: Introduce Variable: entityClass. Place the cursor on 'this' keyword in the getPromotion() method.
 *   4a) In "Expressions" dialog select 'this'.
 *   4b) In "Multiple occurrences found" dialog select "Replace all 2 occurrences".
 * 5) Refactor: Extract Method: factoryMethodTmp(). Select snippet in getPromotion() method with first two lines "EntityClass entityClass = this; EntityClass.date = date;".
 * 6) Refactor: Inline Variable: entityClass. Place the cursor on the 'entityClass' variable in the factoryMethodTmp() method.
 * 7) Refactor: Make Static. Place cursor on the factoryMethodTmp() method definition.
 *   7a) In the "Make Static" dialog click "Refactor" button.
 * 8) Intention: "Change access modifier: public". Place the cursor on the factoryMethodTmp() method definition.
 * 9) Intention: "Change access modifier: public". Place the cursor on the getPromotionNew() method definition.
 * 10) Generate: Constructor. Place the cursor on EntityClass definition.
 *   10a) In "Choose Fields to Initialize by Constructor" dialog select both fields.
 * 11) Refactor: Inline Method: getPromotion(). Place the cursor on the getPromotion() method definition.
 *   11a) In the "Inline Method" dialog select first option: "Inline all and remove the method"
 *
 * -- Replace original constructor in the method doLogic() with a new factory method "createNew(date, int)" that takes two parameters
 * 12) Refactor: Extract Method: createNew(). Select snippet in doLogic() method in F07a_ParamToConstructor class with the middle two lines "EntityClass entityClass = new EntityClass(1); EntityClass entityClass1 = EntityClass.factoryMethodTmp(EntityClass, date);".
 * 13) Refactor: Move Members. Place cursor on newly created "createNew()" method definition. In "Move Static Members" dialog:
 *   13a) In "To (fully qualified name)" box enter "com.katas.helpers.EntityClass".
 *   13b) In "Members to be moved (static only)" grid, select "createNew()" method.
 *   13c) Click "Refactor" button.
 *
 * -- De-duplicate createNew and createNew2 methods in EntityClass class
 *
 * 14) Manually add date parameter as second parameter to the EntityClass constructor in the createNew() method in the EntityClass.
 * 15) Manually remove the call to the factoryMethodTmp() method in the createNew() method (middle line in the body).
 * 16) Refactor: Inline Variable: entityClass. Place the cursor on the 'entityClass' variable in the createNew() method.
 * 17) Refactor: Inline Method: createNew(). Select first option: "Inline all usages, remove the method".
 * 18) Intention: Safe delete factoryMethodTmp(int). Place the cursor on the factoryMethodTmp() method definition.
 * 19) Intention: Safe delete EntityClass(int). Place the cursor on the original constructor with one parameter.
 * 20) Refactor: Rename: getPromotionNew() method to getPromotion().
 *
 */
class F07a_ParamToConstructor {

    public void orchestrator(String date, int orderSize) {
        int defaultMultiplier = 2;
        doLogic(date, orderSize);
    }

    private void doLogic(String date, int orderSize) {
        int multiplierForStep2 = 1;
        EntityClass EntityClass = new EntityClass(multiplierForStep2);
        EntityClass.getPromotion(date, 19);
    }
}
