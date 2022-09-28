package com.springboot.OMS_POC.utils;

public enum OrderStatus {


    INITIATED(1),
    ASSIGNED(2),
    INVOICED(3),
    SHIPPED(4),
    OUT_FOR_DELIVER(5),
    DELIVERED(6),
    CANCELED(7);

    int levelOfStatus;

    OrderStatus(int levelOfStatus) {
        this.levelOfStatus = levelOfStatus;
    }


}
