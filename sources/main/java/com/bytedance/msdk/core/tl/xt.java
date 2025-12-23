package com.bytedance.msdk.core.tl;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private List<String> f24722j;
    private List<String> xt;

    public long j() {
        return this.cw;
    }

    public List<String> xt() {
        return this.f24722j;
    }

    public List<String> cw() {
        return this.xt;
    }

    public void j(long j6) {
        this.cw = j6;
    }

    public String toString() {
        return "AdnLoadFailShowConfigBean{ breadRequestErrorCode=" + this.f24722j + ",ritList=" + this.xt + ",breadRequestDuration=" + this.cw + " }";
    }

    public void xt(List<String> list) {
        this.xt = list;
    }

    public void j(List<String> list) {
        this.f24722j = list;
    }
}
