package com.bytedance.adsdk.lottie.model;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private final String cw;

    /* renamed from: j, reason: collision with root package name */
    public final float f23437j;
    public final float xt;

    public boolean j(String str) {
        if (this.cw.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.cw.endsWith("\r")) {
            String str2 = this.cw;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public m(String str, float f6, float f7) {
        this.cw = str;
        this.xt = f7;
        this.f23437j = f6;
    }
}
