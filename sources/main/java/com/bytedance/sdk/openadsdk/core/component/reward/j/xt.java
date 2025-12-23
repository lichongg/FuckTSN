package com.bytedance.sdk.openadsdk.core.component.reward.j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.stub.StubApp;
import com.umeng.analytics.pro.d;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt {

    /* renamed from: j, reason: collision with root package name */
    protected Context f28298j;
    private com.bytedance.sdk.openadsdk.core.up.up.r xt;

    public void j(final String str) {
        ae.j(new g("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                com.bytedance.sdk.openadsdk.i.cw.cw.xt j6 = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().j(str);
                if (j6 != null && !TextUtils.isEmpty(j6.r())) {
                    if (xt.this.xt()) {
                        i6 = 7;
                    } else {
                        i6 = 8;
                    }
                    n j7 = com.bytedance.sdk.openadsdk.core.up.r.r.j(i6).j(j6.r(), false, 0L);
                    if (v.xt().xt(j6.r()) && j7 != null) {
                        if (j7.c() + j7.ch() < System.currentTimeMillis()) {
                            com.bytedance.sdk.openadsdk.core.up.r.r.j(i6).j(j6.r());
                        }
                    }
                    if (j7 == null) {
                        xt.this.j(j6);
                    }
                }
            }
        });
    }

    protected abstract boolean xt();

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (this.xt != null) {
            this.xt.j(xtVar, j(xtVar, null, true, null));
        }
    }

    protected xt(Context context) {
        Context origApplicationContext;
        int i6;
        if (context == null) {
            origApplicationContext = v.getContext();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f28298j = origApplicationContext;
        if (xt()) {
            i6 = 7;
        } else {
            i6 = 8;
        }
        this.xt = new com.bytedance.sdk.openadsdk.core.up.up.r(i6);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, cw cwVar) {
        if (xtVar != null) {
            xtVar.r();
        }
        j(xtVar, cwVar, null);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final cw cwVar, com.bytedance.sdk.openadsdk.core.component.reward.business.xt.cw cwVar2) {
        boolean z5 = (cwVar2 == null || !cwVar2.cw()) && com.bytedance.sdk.openadsdk.core.live.up.r.j(xtVar.f());
        nd j6 = j(xtVar, cwVar2, false, cwVar);
        com.bytedance.sdk.openadsdk.core.up.up.r rVar = this.xt;
        if (rVar != null) {
            rVar.j(xtVar, j6, z5 ? -1 : 0, new com.bytedance.sdk.openadsdk.core.up.up.up() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.xt.2
                @Override // com.bytedance.sdk.openadsdk.core.up.up.up
                public void j(Object obj) {
                    cw cwVar3 = cwVar;
                    if (cwVar3 != null) {
                        cwVar3.j(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.up.up.up
                public void xt(Object obj) {
                    cw cwVar3 = cwVar;
                    if (cwVar3 != null) {
                        cwVar3.xt(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.up.up.up
                public void j(int i6, String str) {
                    cw cwVar3 = cwVar;
                    if (cwVar3 != null) {
                        cwVar3.j(i6, str);
                    }
                }
            });
        }
    }

    private nd j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.business.xt.cw cwVar, boolean z5, cw cwVar2) {
        boolean z6;
        nd ndVar = new nd();
        if (z5) {
            ndVar.f30363j = 2;
        }
        if (v.xt().oq(xtVar.r()) || xtVar.tl() > 0.0f) {
            ndVar.f30364m = 2;
        }
        if (cwVar == null || !cwVar.cw()) {
            z6 = false;
        } else {
            ndVar.xt = cwVar.j();
            ndVar.cw = cwVar.xt();
            z6 = true;
            ndVar.f30365r = 1;
        }
        if (cwVar2 != null) {
            ndVar.tl = cwVar2.j();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z6);
        bundle.putBoolean("is_preload", z5);
        bundle.putLong(d.f41197p, ndVar.tl);
        ndVar.az = bundle;
        return ndVar;
    }
}
