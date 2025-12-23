package com.bytedance.adsdk.lottie.model.xt;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class av implements cw {
    private final boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23447j;
    private final List<cw> xt;

    public String j() {
        return this.f23447j;
    }

    public boolean cw() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.r(tlVar, cwVar, this, mVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f23447j + "' Shapes: " + Arrays.toString(this.xt.toArray()) + '}';
    }

    public List<cw> xt() {
        return this.xt;
    }

    public av(String str, List<cw> list, boolean z5) {
        this.f23447j = str;
        this.xt = list;
        this.cw = z5;
    }
}
