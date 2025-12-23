package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum Gender implements bv {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);

    private final int value;

    public static Gender findByValue(int i6) {
        if (i6 == 0) {
            return MALE;
        }
        if (i6 == 1) {
            return FEMALE;
        }
        if (i6 != 2) {
            return null;
        }
        return UNKNOWN;
    }

    @Override // com.umeng.analytics.pro.bv
    public int getValue() {
        return this.value;
    }

    Gender(int i6) {
        this.value = i6;
    }
}
