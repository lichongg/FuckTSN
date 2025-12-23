package com.bytedance.sdk.openadsdk.core.v;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.kt.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements av<Bitmap> {

    /* renamed from: j, reason: collision with root package name */
    private boolean f30949j;
    private com.bytedance.sdk.openadsdk.core.kt.j.xt xt;

    public void j(String str) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.cw(str);
    }

    public void cw(String str) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.r(str);
    }

    public void r(String str) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.tl(str);
    }

    public void xt(String str) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.m(str);
    }

    public cw(boolean z5) {
        this.f30949j = z5;
        if (z5) {
            this.xt = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt();
        }
    }

    public void j(int i6) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.j(i6);
    }

    @Override // com.bytedance.sdk.component.m.av
    @ATSMethod(1)
    public void j(qv<Bitmap> qvVar) {
        if (!this.f30949j || this.xt == null) {
            return;
        }
        if (qvVar == null || qvVar.cw() == null) {
            this.xt.xt(202).ae(g.j(202));
            ws.j().j(this.xt);
        }
    }

    @Override // com.bytedance.sdk.component.m.av
    @ATSMethod(2)
    public void j(int i6, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar;
        if (!this.f30949j || (xtVar = this.xt) == null) {
            return;
        }
        xtVar.xt(201).ae(g.j(201));
        ws.j().j(this.xt);
    }
}
