package com.bytedance.sdk.openadsdk.core.xt.j.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.x;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {

    /* renamed from: m, reason: collision with root package name */
    private int f31341m;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.cw up;

    public j() {
    }

    public void j(com.bytedance.sdk.openadsdk.core.nativeexpress.cw cwVar) {
        this.up = cwVar;
    }

    public j(n nVar, Context context) {
        this.f31325j = nVar;
        this.xt = context;
    }

    public void j(int i6) {
        this.f31341m = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.j
    public void j(View view) {
        this.f31326r = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.j
    public int j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xt.j.cw cwVar) {
        if (this.up == null) {
            return 0;
        }
        if (this.cw == null) {
            this.cw = new qv();
        }
        View m6 = this.cw.m();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (m6 != null) {
            iArr = ed.j(m6);
            iArr2 = ed.cw(m6);
        }
        this.up.j(this.f31326r, this.f31341m, new x.j().r(this.cw.ws()).cw(this.cw.az()).xt(this.cw.av()).j(this.cw.i()).xt(this.cw.vl()).j(this.cw.jy()).j(iArr[0]).xt(iArr[1]).cw(iArr2[0]).r(iArr2[1]).j(this.cw.up()).j(this.cw.oq()).j());
        return 1;
    }
}
