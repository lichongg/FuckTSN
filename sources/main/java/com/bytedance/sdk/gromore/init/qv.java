package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.la;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv implements Function<SparseArray<Object>, Object> {
    private final com.bytedance.sdk.openadsdk.core.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.gromore.j.xt.j f27341j;

    /* renamed from: r, reason: collision with root package name */
    private cw f27342r;
    private Bundle up;
    private com.bytedance.sdk.openadsdk.core.wq.cw xt;

    public qv(Bundle bundle, com.bytedance.sdk.openadsdk.core.cw cwVar) {
        this.cw = cwVar;
        this.up = bundle;
        up.j();
        Bundle bundle2 = this.up;
        if (bundle2 != null) {
            up.f27347j = bundle2.getLong("call_init_time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, com.bytedance.sdk.gromore.j.xt.j jVar, com.bytedance.sdk.openadsdk.core.wq.cw cwVar, long j6) {
        up.f27349r = SystemClock.elapsedRealtime();
        cw cwVar2 = new cw();
        this.f27342r = cwVar2;
        cwVar2.j(context, jVar, cwVar, j6);
    }

    private void j(final Context context, final PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.core.wq.cw cwVar = new com.bytedance.sdk.openadsdk.core.wq.cw(this.f27341j.cw());
        this.xt = cwVar;
        cwVar.j(new com.bytedance.sdk.openadsdk.core.wq.xt() { // from class: com.bytedance.sdk.gromore.init.qv.1
            /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
            @Override // com.bytedance.sdk.openadsdk.core.wq.xt
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void j(boolean r9) {
                /*
                    r8 = this;
                    r0 = 0
                    com.bykv.vk.openvk.api.proto.PluginValueSet r2 = r2     // Catch: java.lang.Exception -> L1e
                    long r3 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L1e
                    r5 = 1
                    long r2 = r2.longValue(r5, r3)     // Catch: java.lang.Exception -> L1e
                    int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                    if (r4 == 0) goto L1c
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L19
                    long r0 = r0 - r2
                    com.bytedance.sdk.gromore.init.up.f27348m = r0     // Catch: java.lang.Exception -> L19
                    goto L1c
                L19:
                    r0 = r2
                    goto L1f
                L1c:
                    r6 = r2
                    goto L20
                L1e:
                L1f:
                    r6 = r0
                L20:
                    if (r9 == 0) goto L39
                    long r0 = android.os.SystemClock.elapsedRealtime()
                    com.bytedance.sdk.gromore.init.up.cw = r0
                    com.bytedance.sdk.gromore.init.qv r2 = com.bytedance.sdk.gromore.init.qv.this
                    android.content.Context r3 = r3
                    com.bytedance.sdk.gromore.j.xt.j r4 = com.bytedance.sdk.gromore.init.qv.j(r2)
                    com.bytedance.sdk.gromore.init.qv r9 = com.bytedance.sdk.gromore.init.qv.this
                    com.bytedance.sdk.openadsdk.core.wq.cw r5 = com.bytedance.sdk.gromore.init.qv.xt(r9)
                    com.bytedance.sdk.gromore.init.qv.j(r2, r3, r4, r5, r6)
                L39:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.qv.AnonymousClass1.j(boolean):void");
            }
        });
        if (this.cw != null) {
            up.xt = SystemClock.elapsedRealtime();
            this.cw.j(context, pluginValueSet, this.xt);
        } else {
            this.xt.j(0, com.bytedance.sdk.openadsdk.i.up.j().j(false).j(MediationConstant.ErrorCode.ADN_INIT_FAIL).j("init error Initializer is null").xt());
        }
    }

    public boolean j() {
        com.bytedance.sdk.gromore.j.xt.j jVar = this.f27341j;
        if (jVar != null && jVar.j()) {
            com.bytedance.sdk.openadsdk.core.cw cwVar = this.cw;
            return cwVar != null && this.f27342r != null && cwVar.j() && this.f27342r.j();
        }
        com.bytedance.sdk.openadsdk.core.cw cwVar2 = this.cw;
        if (cwVar2 != null) {
            return cwVar2.j();
        }
        return false;
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        switch (k6.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(j());
            case -999001:
                com.bytedance.sdk.gromore.j.xt.j j6 = com.bytedance.sdk.gromore.j.xt.j.j(k6);
                this.f27341j = j6;
                if (j6.r()) {
                    com.bytedance.msdk.j.up.cw.j();
                    com.bytedance.sdk.component.g.j.j();
                }
                if (this.f27341j.vl() && !AdSdkInitializerHolder.isSdkInitSuccess()) {
                    h.j();
                }
                j(k6);
                boolean fx = v.xt().fx();
                Context context = (Context) k6.objectValue(-998000, Context.class);
                if (!this.f27341j.j() && !fx) {
                    up.xt = SystemClock.elapsedRealtime();
                    this.cw.apply(sparseArray);
                    break;
                } else {
                    com.bytedance.msdk.core.qv.j.j().xt();
                    com.bytedance.msdk.core.qv.j.j().j(fx);
                    j(context, k6);
                    break;
                }
            case -999000:
                if (this.cw != null) {
                    com.bytedance.msdk.j.up.cw.xt("TMe", "getManager mediation");
                    la xt = this.cw.xt();
                    if (xt != null) {
                        return new oq(xt);
                    }
                }
                break;
        }
        apply = e.f22772d.apply(sparseArray);
        return apply;
    }

    private void j(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                com.bytedance.sdk.openadsdk.core.h.f29116j = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }
}
