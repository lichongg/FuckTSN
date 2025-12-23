package com.bytedance.sdk.component.cw.xt.j.up;

import okhttp3.internal.http2.Header;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw {
    public final com.bytedance.sdk.component.cw.j.m ae;

    /* renamed from: g, reason: collision with root package name */
    final int f26263g;
    public final com.bytedance.sdk.component.cw.j.m tl;

    /* renamed from: j, reason: collision with root package name */
    public static final com.bytedance.sdk.component.cw.j.m f26260j = com.bytedance.sdk.component.cw.j.m.j(":");
    public static final com.bytedance.sdk.component.cw.j.m xt = com.bytedance.sdk.component.cw.j.m.j(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.cw.j.m cw = com.bytedance.sdk.component.cw.j.m.j(Header.TARGET_METHOD_UTF8);

    /* renamed from: r, reason: collision with root package name */
    public static final com.bytedance.sdk.component.cw.j.m f26262r = com.bytedance.sdk.component.cw.j.m.j(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.cw.j.m up = com.bytedance.sdk.component.cw.j.m.j(Header.TARGET_SCHEME_UTF8);

    /* renamed from: m, reason: collision with root package name */
    public static final com.bytedance.sdk.component.cw.j.m f26261m = com.bytedance.sdk.component.cw.j.m.j(Header.TARGET_AUTHORITY_UTF8);

    public cw(String str, String str2) {
        this(com.bytedance.sdk.component.cw.j.m.j(str), com.bytedance.sdk.component.cw.j.m.j(str2));
    }

    public cw(com.bytedance.sdk.component.cw.j.m mVar, String str) {
        this(mVar, com.bytedance.sdk.component.cw.j.m.j(str));
    }

    public boolean equals(Object obj) {
        if (obj instanceof cw) {
            cw cwVar = (cw) obj;
            if (this.ae.equals(cwVar.ae) && this.tl.equals(cwVar.tl)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.ae.hashCode() + 527) * 31) + this.tl.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.cw.xt.j.cw.j("%s: %s", this.ae.j(), this.tl.j());
    }

    public cw(com.bytedance.sdk.component.cw.j.m mVar, com.bytedance.sdk.component.cw.j.m mVar2) {
        this.ae = mVar;
        this.tl = mVar2;
        this.f26263g = mVar.ae() + 32 + mVar2.ae();
    }
}
