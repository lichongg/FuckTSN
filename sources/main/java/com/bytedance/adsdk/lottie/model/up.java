package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.ws;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static final up f23441j = new up();
    private final ws<String, com.bytedance.adsdk.lottie.m> xt = new ws<>(20);

    public static up j() {
        return f23441j;
    }

    public com.bytedance.adsdk.lottie.m j(String str) {
        if (str == null) {
            return null;
        }
        return this.xt.j((ws<String, com.bytedance.adsdk.lottie.m>) str);
    }

    up() {
    }

    public void j(String str, com.bytedance.adsdk.lottie.m mVar) {
        if (str == null) {
            return;
        }
        this.xt.j(str, mVar);
    }
}
