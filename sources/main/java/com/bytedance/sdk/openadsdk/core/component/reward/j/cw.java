package com.bytedance.sdk.openadsdk.core.component.reward.j;

import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import com.bytedance.sdk.openadsdk.i.cw.xt.qv;
import com.bytedance.sdk.openadsdk.tj.j.xt.j.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private ae f28288j;
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.r xt;

    public cw(ae aeVar) {
        this.f28288j = aeVar;
    }

    public void j(int i6, String str) {
        ae aeVar = this.f28288j;
        if (aeVar != null) {
            aeVar.j(i6, str);
        }
        com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar = this.xt;
        if (rVar != null) {
            rVar.j(i6, str);
        }
    }

    public void xt(Object obj) {
        ae aeVar = this.f28288j;
        if (aeVar != null && (obj instanceof az)) {
            aeVar.j();
            this.f28288j.xt((az) obj);
        }
        com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar = this.xt;
        if (rVar == null || !(obj instanceof qv)) {
            return;
        }
        rVar.j();
        this.xt.xt((qv) obj);
    }

    public cw(com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        this.xt = rVar;
    }

    public void j(Object obj) {
        ae aeVar = this.f28288j;
        if (aeVar != null && (obj instanceof az)) {
            aeVar.j((az) obj);
        }
        com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar = this.xt;
        if (rVar == null || !(obj instanceof qv)) {
            return;
        }
        rVar.j((qv) obj);
    }

    public long j() {
        Object obj = this.f28288j;
        if (obj != null) {
            return obj instanceof com.bytedance.sdk.openadsdk.core.j.xt ? ((com.bytedance.sdk.openadsdk.core.j.xt) obj).xt() : System.currentTimeMillis();
        }
        Object obj2 = this.xt;
        if (obj2 != null) {
            return obj2 instanceof com.bytedance.sdk.openadsdk.core.j.xt ? ((com.bytedance.sdk.openadsdk.core.j.xt) obj2).xt() : System.currentTimeMillis();
        }
        return 0L;
    }
}
