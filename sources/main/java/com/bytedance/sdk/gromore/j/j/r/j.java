package com.bytedance.sdk.gromore.j.j.r;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.gromore.j.j.r {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.api.xt f27464j;

    @Override // com.bytedance.sdk.gromore.j.j.r
    public String cw() {
        com.bytedance.msdk.api.xt xtVar = this.f27464j;
        if (xtVar != null) {
            return xtVar.j();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r
    public String j() {
        com.bytedance.msdk.api.xt xtVar = this.f27464j;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r
    public int r() {
        com.bytedance.msdk.api.xt xtVar = this.f27464j;
        if (xtVar != null) {
            return xtVar.up();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r
    public String up() {
        com.bytedance.msdk.api.xt xtVar = this.f27464j;
        if (xtVar != null) {
            return xtVar.m();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r
    public String xt() {
        com.bytedance.msdk.api.xt xtVar = this.f27464j;
        if (xtVar != null) {
            return TextUtils.isEmpty(xtVar.cw()) ? this.f27464j.r() : this.f27464j.cw();
        }
        return null;
    }

    public j(com.bytedance.msdk.api.xt xtVar) {
        this.f27464j = xtVar;
    }
}
