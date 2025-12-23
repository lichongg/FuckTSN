package com.bytedance.msdk.tl.j;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f25216j;

    /* renamed from: r, reason: collision with root package name */
    private String f25217r;
    private long up;
    private String xt;

    public void j(String str) {
        this.f25216j = str;
    }

    public void cw(String str) {
        this.cw = str;
    }

    public String j() {
        return this.f25217r;
    }

    public void r(String str) {
        this.f25217r = str;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.f25216j + "', adnRit='" + this.xt + "', adnName='" + this.cw + "', adAction='" + this.f25217r + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.up)) + '}';
    }

    public void xt(String str) {
        this.xt = str;
    }

    public void j(long j6) {
        this.up = j6;
    }
}
