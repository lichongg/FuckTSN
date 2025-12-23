package com.bytedance.adsdk.lottie.model.j;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class ws<V, O> implements jy<V, O> {

    /* renamed from: j, reason: collision with root package name */
    final List<com.bytedance.adsdk.lottie.m.j<V>> f23365j;

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public List<com.bytedance.adsdk.lottie.m.j<V>> cw() {
        return this.f23365j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f23365j.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f23365j.toArray()));
        }
        return sb.toString();
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public boolean xt() {
        return this.f23365j.isEmpty() || (this.f23365j.size() == 1 && this.f23365j.get(0).up());
    }

    ws(List<com.bytedance.adsdk.lottie.m.j<V>> list) {
        this.f23365j = list;
    }
}
