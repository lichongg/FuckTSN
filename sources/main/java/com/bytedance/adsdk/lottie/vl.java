package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class vl<V> {

    /* renamed from: j, reason: collision with root package name */
    private final V f23565j;
    private final Throwable xt;

    public vl(V v5) {
        this.f23565j = v5;
        this.xt = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vl)) {
            return false;
        }
        vl vlVar = (vl) obj;
        if (j() != null && j().equals(vlVar.j())) {
            return true;
        }
        if (xt() == null || vlVar.xt() == null) {
            return false;
        }
        return xt().toString().equals(xt().toString());
    }

    public V j() {
        return this.f23565j;
    }

    public Throwable xt() {
        return this.xt;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{j(), xt()});
    }

    public vl(Throwable th) {
        this.xt = th;
        this.f23565j = null;
    }
}
