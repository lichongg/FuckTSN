package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.msdk.api.r.j;
import com.bytedance.msdk.api.r.tl;
import com.bytedance.msdk.api.r.vl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private static volatile SparseArray<Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f27331j;

    /* renamed from: r, reason: collision with root package name */
    private static volatile boolean f27332r;
    private static volatile AtomicBoolean xt = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private long f27333m;
    private com.bytedance.sdk.openadsdk.core.wq.cw up;

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.up != null) {
            f27332r = true;
            up.up = SystemClock.elapsedRealtime();
            if (this.f27333m != 0) {
                up.ae = SystemClock.elapsedRealtime() - this.f27333m;
            }
            com.bytedance.msdk.j.up.cw.xt("TMe", "sdk init call callback success");
            cw = com.bytedance.sdk.openadsdk.i.up.j().j(true).xt();
            this.up.j(0, cw);
            com.bytedance.msdk.m.r.cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (xt.get()) {
            com.bytedance.msdk.j.up.cw.xt("TMe", "通知成功或失败了不在通知");
            return;
        }
        xt.set(true);
        com.bytedance.msdk.j.up.cw.xt("TMe", "通知成功=----notifySdkSuccess");
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.sdk.gromore.init.cw.2
            @Override // java.lang.Runnable
            public void run() {
                cw.this.cw();
            }
        });
    }

    public void j(Context context, com.bytedance.sdk.gromore.j.xt.j jVar, com.bytedance.sdk.openadsdk.core.wq.cw cwVar, long j6) {
        this.up = cwVar;
        this.f27333m = j6;
        if (jVar == null) {
            com.bytedance.msdk.j.up.cw.xt("TMe", "init csjm configValueSet is null");
            return;
        }
        com.bytedance.msdk.core.j.qv().cw(jVar.up());
        if (com.bytedance.msdk.core.j.qv().ch()) {
            com.bytedance.msdk.tl.r.up.j(jVar);
        }
        com.bytedance.msdk.j.up.cw.xt("TMe", "init csjm " + f27331j);
        if (f27331j) {
            com.bytedance.msdk.j.up.cw.xt("TMe", "init csjm already");
            if (cwVar == null || cw == null) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "sdk正在初始化....");
                return;
            } else {
                cwVar.j(0, cw);
                return;
            }
        }
        com.bytedance.msdk.j.up.cw.xt("TMe", "init csjm ");
        f27331j = true;
        xt.set(false);
        com.bytedance.msdk.core.qv.j.j().xt();
        com.bytedance.msdk.core.qv.j.j().j(new com.bytedance.msdk.core.qv.xt() { // from class: com.bytedance.sdk.gromore.init.cw.1
            @Override // com.bytedance.msdk.core.qv.xt
            public void j() {
                com.bytedance.msdk.core.qv.j.j().j((com.bytedance.msdk.core.qv.xt) null);
                cw.this.xt();
            }

            @Override // com.bytedance.msdk.core.qv.xt
            public void j(int i6, String str) {
                com.bytedance.msdk.core.qv.j.j().j((com.bytedance.msdk.core.qv.xt) null);
                cw.this.j(i6, str);
            }
        });
        com.bytedance.msdk.api.r.oq.j(context, j(jVar));
        com.bytedance.msdk.api.r.oq.r();
    }

    private void xt(int i6, String str) {
        if (i6 == 40004) {
            com.bytedance.msdk.j.up.cw.xt("TMe", "sdk init call code is 40004 callback success");
            cw();
        } else if (this.up != null) {
            up.up = SystemClock.elapsedRealtime();
            com.bytedance.msdk.j.up.cw.xt("TMe", "sdk init call callback fail");
            cw = com.bytedance.sdk.openadsdk.i.up.j().j(false).j(i6).j(str).xt();
            this.up.j(0, cw);
            com.bytedance.msdk.m.r.cw();
        }
    }

    public boolean j() {
        return f27332r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        if (!xt.get()) {
            xt.set(true);
            xt(i6, str);
        } else {
            com.bytedance.msdk.j.up.cw.xt("TMe", "通知成功或失败了不在通知");
        }
    }

    private com.bytedance.msdk.api.r.j j(com.bytedance.sdk.gromore.j.xt.j jVar) {
        return new j.C0347j().j(jVar.up()).xt(jVar.m()).j(jVar.r()).cw(jVar.az()).xt(jVar.av()).j(xt.j(jVar.i())).j(jVar.w()).j(jVar.ws()).cw(jVar.mi()).j(jVar.kt()).r(jVar.vl()).j(new vl.j().j(jVar.ae()).xt(jVar.tl()).j(jVar.g()).j(jVar.oq()).xt(jVar.qv()).j(jVar.jy()).j(xt.j(jVar.w())).j()).j(new tl.j().j(jVar.f()).j(jVar.tj()).xt(jVar.v()).cw(jVar.x()).j()).j(jVar.xt()).j();
    }
}
