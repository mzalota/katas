package com.katas.constructor;

class C05_ParamToConstructor {

    public void orchestrator(String date, int orderSize) {
        DomainEntity domainEntity = new DomainEntity(2);
        doStep01(domainEntity, "2022-02-02", orderSize);
        doStep02(date, orderSize);
    }

    private void doStep01(DomainEntity domainEntity, String date, int orderSize) {
        domainEntity.getDiscount(date, orderSize);
    }

    private void doStep02(String date, int orderSize) {
        DomainEntity domainEntity = new DomainEntity(1);
        domainEntity.getPromotion(date, 19);
    }

}
