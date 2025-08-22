package com.katas.constructor;

class C05_ParamToConstructor {

    public void orchestrator(String date, int orderSize) {
        int defaultMultiplier = 2;
        String startingDate = "2022-02-02";
        DomainEntity domainEntity = new DomainEntity(defaultMultiplier);
        doStep01(domainEntity, startingDate, orderSize);
        doStep02(date, orderSize);
    }

    private void doStep01(DomainEntity domainEntity, String date, int orderSize) {
        domainEntity.getDiscount(date, orderSize);
    }

    private void doStep02(String date, int orderSize) {
        int multiplierForStep2 = 1;
        DomainEntity domainEntity = new DomainEntity(multiplierForStep2);
        domainEntity.getPromotion(date, 19);
    }

}
