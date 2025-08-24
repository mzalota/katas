package com.katas.functions;

import com.katas.helpers.EntityClass;

/*
 * Move date parameter from every method to constructor.
 *
 * -- Evolve getPromotion() method to not expect date as parameter
 * 1) Refactor: Introduce Field. Place cursor on "date" variable in the body of getPromotion() method in EntityClass class.
 * 2) Refactor Extract Method: getPromotionNew(). Select body of getPromotion() except for the first line "this.date = date;". Keep original signature.
 * 3) Intention: Add 'this' qualifier. Cursor on getPromotionNew() call in getPromotion() method.
 * 4) Refactor: Introduce Variable: EntityClass. Place cursor on 'this' keyword in getPromotion() method.
 *  4a) In "Expressions" dialog select 'this'
 *  4b) In "Multiple occurrences found" dialog select "Replace all 2 occurrence"
 * 5) Refactor: Extract Method: factoryMethodTmp(). Select snippet in getPromotion() method with two lines "EntityClass EntityClass = this; EntityClass.date = date;". In "Process Duplicates" dialog click "All" button.
 * 6) Refactor: Inline Variable: EntityClass. Place cursor on 'EntityClass' variable in factoryMethodTmp() method.
 * 7) Refactor: Make Static. Place cursor on factoryMethodTmp() method.
 * 8) Intention: "Change access modifier: public". For factoryMethodTmp() method.
 * 9) Intention: "Change access modifier: public". For getPromotionNew() method.
 * 10) Generate: Constructor. In "Choose Fields to Initialize by Constructor" dialog select all fields.
 * 11) Refactor: Inline Method: getPromotion(). Select first option: "Inline all and remove the method"
 *
 * -- Replace original EntityClass(int) constructor in method doLogic() with a temporary factory method "createNew(date, int)".
 * 12) Refactor: Extract Method: createNew(). Select snippet in doLogic() method in F07a_ParamToConstructor class with two lines "EntityClass entityClass = new EntityClass(1); EntityClass entityClass1 = EntityClass.factoryMethodTmp(EntityClass, date);".
 * 13) Refactor: Move Members. Place cursor on newly created "createNew()" method definition. In "Move Static Members" dialog:
 *  13a) In "To (fully qualified name)" box enter "com.katas.helpers.EntityClass".
 *  13b) In "Members to be moved (static only)" grid, select "createNew()" method.
 *  13c) Click "Refactor" button.
 *
 * -- De-duplicate createNew and createNew2 methods in EntityClass class
 * 25) Refactor: Extract Method: createNewFinal . Select body of createNew2() method. In "Process Duplicates" dialog click "All" button.
 * 26) Manually add date parameter as second parameter to the EntityClass constructor in createNewFinal() method.
 * 27) Manually remove call to factoryMethodTmp() method in createNewFinal() method
 * 28) Intention: "Change access modifier: public". For createNewFinal() method.
 * 29) Refactor: Inline Method: createNew(). Select first option: "Inline all and remove the method"
 * 30) Refactor: Inline Method: createNew2(). Select first option: "Inline all and remove the method"
 * 31) Refactor: Inline Method: createNewFinal(). Select first option: "Inline all and remove the method"
 * 32) Intention: Safe delete factoryMethodTmp(int). Cursor on the factoryMethodTmp() method.
 * 33) Intention: Safe delete EntityClass(int). Cursor on the original constructor with one parameter.
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
