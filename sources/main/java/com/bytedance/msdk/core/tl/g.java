package com.bytedance.msdk.core.tl;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends r {
    private String ae;

    /* renamed from: m, reason: collision with root package name */
    private long f24699m;
    private long tl;

    public g(String str, String str2, String str3, String str4, int i6, String str5, String str6) {
        super(str, str2, str3, str4, i6);
        this.tl = 0L;
        this.f24699m = 0L;
        try {
            this.f24699m = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.ae = str6;
    }

    public long g() {
        return this.f24699m;
    }

    public void j(long j6) {
        this.tl = j6;
    }

    public String oq() {
        return this.ae;
    }

    public long qv() {
        return this.tl;
    }

    @Override // com.bytedance.msdk.core.tl.r
    public boolean tl() {
        return (TextUtils.isEmpty(this.ae) || this.f24699m == 0) ? false : true;
    }

    @Override // com.bytedance.msdk.core.tl.r
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f24711j + "', showRulesVersion='" + this.cw + "', timingMode=" + this.up + "}IntervalPacingBean{pacing=" + this.f24699m + ", pacingRuleId='" + this.ae + "', effectiveTime=" + this.tl + '}';
    }

    public boolean vl() {
        return this.tl != 0;
    }

    public g(String str, String str2, String str3, String str4, int i6, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i6, str5, str6);
        this.tl = 0L;
        try {
            this.tl = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }
}
