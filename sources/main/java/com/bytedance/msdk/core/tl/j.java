package com.bytedance.msdk.core.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f24700j;

    /* renamed from: r, reason: collision with root package name */
    private String f24701r;
    private String xt;

    public j(String str, String str2, long j6) {
        this(str, str2, j6, null);
    }

    public j(String str, String str2, long j6, String str3) {
        this.f24700j = str2;
        this.xt = str;
        this.cw = j6;
        this.f24701r = str3;
    }

    public long j() {
        return this.cw;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.f24700j + "', adnName='" + this.xt + "', effectiveTime=" + this.cw + '}';
    }

    public String xt() {
        return this.f24701r;
    }
}
