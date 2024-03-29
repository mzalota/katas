package com.katas.ifs;

public class DoingMoreThanOneThing {



    public void doingTwoThings(boolean isHungry, boolean foodIsReady) {
        int barNumber = 0;
        double fooFactor = 1;
        if (isHungry) {
            System.out.println("In if top: she is hungry");
            barNumber = barMethod("ACTION - eat the food AA");
            fooFactor = fooMethod("ACTION - cook something tasty AA");
            if (foodIsReady) {
                fooFactor = fooMethod("ACTION - cook something tasty BB ");
            } else {
                barNumber = barMethod("ACTION - eat the food BBB");
            }

        } else {
            if (foodIsReady) {
                barNumber = barMethod("ACTION - eat the food CCC");
            } else {
                fooFactor = fooMethod("ACTION - cook something tasty CCC");
            }
            System.out.println("In else: she is NOT hungry");
        }

        double result = fooFactor * barNumber;
        System.out.println("Saving result to DB: "+result);
    }

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
            System.out.println("Saving default value to DB: "+defaultValue);
        } else {
            double result = fooFactor * barNumber;
            System.out.println("Saving calculated result to DB: " + result);
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
}
