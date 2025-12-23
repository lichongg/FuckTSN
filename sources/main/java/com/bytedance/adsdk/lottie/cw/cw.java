package com.bytedance.adsdk.lottie.cw;

import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public enum cw {
    JSON(".json"),
    ZIP(".zip");

    public final String cw;

    public String j() {
        return ".temp" + this.cw;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.cw;
    }

    cw(String str) {
        this.cw = str;
    }
}
