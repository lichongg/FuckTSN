package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class tl extends h {
    private final com.bytedance.sdk.component.cw.j.up cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f26177j;
    private final long xt;

    @Override // com.bytedance.sdk.component.cw.xt.h
    public com.bytedance.sdk.component.cw.j.up cw() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.cw.xt.h
    public tj j() {
        String str = this.f26177j;
        if (str != null) {
            return tj.j(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.cw.xt.h
    public long xt() {
        return this.xt;
    }

    public tl(String str, long j6, com.bytedance.sdk.component.cw.j.up upVar) {
        this.f26177j = str;
        this.xt = j6;
        this.cw = upVar;
    }
}
