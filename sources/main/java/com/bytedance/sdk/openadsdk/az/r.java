package com.bytedance.sdk.openadsdk.az;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum r {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String tl;

    @Override // java.lang.Enum
    public String toString() {
        return this.tl;
    }

    r(String str) {
        this.tl = str;
    }
}
