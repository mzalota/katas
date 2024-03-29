package com.katas.ifs;

public class DoingMoreThanOneThing {

    public void doingTwoThingsSmaller(boolean isHungry, int defaultValue) {

        //culculate the Number and the Factor
        int barNumber = 0;
        double fooFactor = 1;
        if (isHungry) {
            System.out.println("In if top: she is hungry");
            barNumber = barMethodAAA("ACTION - eat the food AA");
            fooFactor = fooMethodAAA("ACTION - cook something tasty AA");
        } else {
            barNumber = barMethod("ACTION - eat the food CCC");
            fooFactor = fooMethod("ACTION - cook something tasty CCC");
        }

        //Save to DB if necessary
        if (fooFactor==0){
            saveToDB(String.valueOf(defaultValue));
            System.out.println("Saved default value to DB");
        } else {
            double result = fooFactor * barNumber;
            System.out.println("Saving calculated result to DB");
            saveToDB(String.valueOf(result));
        }
    }
    protected double fooMethodAAA(String message) {
        return 5.4;
    }

    protected double fooMethod(String message) {
        return 5.4;
    }

    protected int barMethod(String message) {
        System.out.println(message);
        return 7;
    }
    protected int barMethodAAA(String message) {
        System.out.println(message);
        return 7;
    }
    protected void saveToDB(String valueToStore) {
        System.out.println("Committing to DB value: " + valueToStore);
    }
}
