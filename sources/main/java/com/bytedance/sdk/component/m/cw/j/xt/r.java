package com.bytedance.sdk.component.m.cw.j.xt;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.w;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements w {

    /* renamed from: j, reason: collision with root package name */
    private final w f26571j;
    private final com.bytedance.sdk.component.m.cw.j.xt xt;

    public r(w wVar) {
        this(wVar, null);
    }

    public r(w wVar, com.bytedance.sdk.component.m.cw.j.xt xtVar) {
        this.f26571j = wVar;
        this.xt = xtVar;
    }

    @Override // com.bytedance.sdk.component.m.j
    public boolean xt(String str) {
        return this.f26571j.xt(str);
    }

    @Override // com.bytedance.sdk.component.m.j
    public boolean j(String str, Bitmap bitmap) {
        return this.f26571j.j(str, bitmap);
    }

    @Override // com.bytedance.sdk.component.m.j
    public Bitmap j(String str) {
        return this.f26571j.j((w) str);
    }

    @Override // com.bytedance.sdk.component.m.j
    public void j(double d6) {
        this.f26571j.j(d6);
    }
}
