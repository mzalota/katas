package com.katas.constructor;

class Consumer {

    public void doLogic(String date, int orderSize) {
        ParamToConstructor paramToConstructor = new ParamToConstructor(2);
        this.doLogic1(paramToConstructor, "2022-02-02", orderSize);
        doLogic2(date, orderSize);

    }

    public void doLogic1(ParamToConstructor paramToConstructor, String date, int orderSize) {
        paramToConstructor.getDiscount(date, orderSize);
    }

    public void doLogic2(String date, int orderSize) {
        ParamToConstructor paramToConstructor = new ParamToConstructor(1);
        paramToConstructor.getPromotion(date, 19);
    }

}
