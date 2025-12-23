package com.bytedance.sdk.component.xt.j.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends vl {
    public r jy;

    @Override // com.bytedance.sdk.component.xt.j.vl
    public com.bytedance.sdk.component.xt.j.r j() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.component.xt.j.vl
    public com.bytedance.sdk.component.xt.j.xt j(ws wsVar) {
        wsVar.j(this);
        if (wsVar.xt() == null || wsVar.xt().j() == null || TextUtils.isEmpty(wsVar.xt().j().toString())) {
            return null;
        }
        return new j(wsVar, this.jy);
    }

    public cw(vl.j jVar) {
        super(jVar);
        this.jy = new r();
    }
}
