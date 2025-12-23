package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
class r extends com.bytedance.sdk.openadsdk.core.mi.r {
    private final String cw;

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<com.bytedance.sdk.openadsdk.core.w.r> f28270j;
    private final n xt;

    @Override // com.bytedance.sdk.openadsdk.az.j
    public void j() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.r> weakReference = this.f28270j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28270j.get().j();
    }

    r(n nVar, String str, com.bytedance.sdk.openadsdk.core.w.r rVar) {
        this.xt = nVar;
        this.cw = str;
        this.f28270j = new WeakReference<>(rVar);
    }

    @Override // com.bytedance.sdk.openadsdk.az.j
    public void j(int i6, String str) {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.r> weakReference = this.f28270j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28270j.get();
    }
}
