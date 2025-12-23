package com.bytedance.sdk.component.adexpress.dynamic.cw;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {

    /* renamed from: j, reason: collision with root package name */
    public float f25593j;
    public float xt;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (Float.compare(gVar.f25593j, this.f25593j) == 0 && Float.compare(gVar.xt, this.xt) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f25593j), Float.valueOf(this.xt)});
    }

    public g(float f6, float f7) {
        this.f25593j = f6;
        this.xt = f7;
    }
}
