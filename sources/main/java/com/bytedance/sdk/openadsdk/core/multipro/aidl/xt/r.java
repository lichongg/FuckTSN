package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Bundle;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends i.j {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.a.j.xt.j.xt f29556j;

    @Override // com.bytedance.sdk.openadsdk.core.i
    public Bundle j(int i6) {
        com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar = this.f29556j;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (xtVar != null) {
            xtVar.j(i6, new com.bytedance.sdk.openadsdk.w.j.j.xt.j.j() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.r.1
                @Override // com.bytedance.sdk.openadsdk.w.j.j.xt.j.j
                public void j(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            return bundle;
        } catch (InterruptedException e6) {
            vl.j(e6);
            return bundle;
        }
    }

    public r(com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar) {
        this.f29556j = xtVar;
    }
}
