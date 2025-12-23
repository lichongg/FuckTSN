package com.bytedance.adsdk.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends RuntimeException {
    public xt(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
