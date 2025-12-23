package com.bytedance.sdk.component.cw.xt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum gq {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* renamed from: m, reason: collision with root package name */
    final String f26141m;

    public static gq j(String str) {
        str.getClass();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
        }
    }

    gq(String str) {
        this.f26141m = str;
    }

    static List<gq> j(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(j(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String j() {
        return this.f26141m;
    }
}
