package com.bytedance.msdk.up;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    public final String cw;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f25319j;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f25320r;
    public final int xt;

    public String toString() {
        return "AdEventUploadResult{mSuccess=" + this.f25319j + ", mStatusCode=" + this.xt + ", mMsg='" + this.cw + "', mIsDataError=" + this.f25320r + '}';
    }

    public up(boolean z5, int i6, String str, boolean z6) {
        this.f25319j = z5;
        this.xt = i6;
        this.cw = str;
        this.f25320r = z6;
    }
}
