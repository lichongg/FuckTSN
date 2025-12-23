package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends xt implements com.bytedance.adsdk.ugeno.up.j.r {
    private com.bytedance.adsdk.ugeno.up.j.cw qv;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        com.bytedance.adsdk.ugeno.up.j.j gx = this.xt.gx();
        if (gx == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.up.j.cw j6 = gx.j(this.f23744m);
        this.qv = j6;
        if (j6 != null) {
            j6.j(this);
            return false;
        }
        gx.j(this.f23744m, new com.bytedance.adsdk.ugeno.up.j.xt());
        return false;
    }

    public cw(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.up.j.r
    public void j(String str) {
        this.f23743j.j(this.xt, this.f23744m, this.cw.xt());
    }
}
