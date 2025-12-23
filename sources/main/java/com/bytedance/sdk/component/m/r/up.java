package com.bytedance.sdk.component.m.r;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends j {

    /* renamed from: j, reason: collision with root package name */
    private byte[] f26604j;
    private com.bytedance.sdk.component.m.m xt;

    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        com.bytedance.sdk.component.m.cw.m kt = cwVar.kt();
        com.bytedance.sdk.component.m.cw.xt.j j6 = kt.j(cwVar);
        try {
            ws v5 = cwVar.v();
            if (v5 != null) {
                v5.j(10, null);
            }
            Bitmap j7 = j6.j(this.f26604j);
            if (j7 != null) {
                cwVar.j(new jy(j7, this.f26604j, this.xt, false));
                kt.j(cwVar.tj()).j(cwVar.ae(), j7);
            } else {
                j(1002, "decode failed bitmap null", null, cwVar);
            }
            if (v5 != null) {
                v5.j(11, j7);
            }
        } catch (Throwable th) {
            j(1002, "decode failed:" + th.getMessage(), th, cwVar);
        }
    }

    public up(byte[] bArr, com.bytedance.sdk.component.m.m mVar) {
        this.f26604j = bArr;
        this.xt = mVar;
    }

    private void j(int i6, String str, Throwable th, com.bytedance.sdk.component.m.cw.cw cwVar) {
        if (this.xt == null) {
            cwVar.j(new qv());
        } else {
            cwVar.j(new tl(i6, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "decode";
    }
}
