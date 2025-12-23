package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.msdk.cw.r.oq;
import com.bytedance.msdk.tl.av;
import com.bytedance.msdk.tl.mi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends r implements com.bytedance.msdk.j.xt.xt {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.r.xt f25097j;
    private com.bytedance.msdk.api.r.j.r.j xt;

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void cw() {
        v();
        if (this.av) {
            if (!av.j()) {
                s();
                com.bytedance.msdk.api.r.j.r.j jVar = this.xt;
                if (jVar != null) {
                    jVar.cw();
                    return;
                }
                return;
            }
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.cw()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 2, 1, tj() ? 1 : 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 2, 0, tj() ? 1 : 0, (String) null);
            }
            if (ch()) {
                return;
            }
            s();
            com.bytedance.msdk.api.r.j.r.j jVar2 = this.xt;
            if (jVar2 != null) {
                jVar2.cw();
            }
        }
    }

    public void xt(Activity activity, Object obj, String str) {
        j(activity, obj, str);
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        com.bytedance.msdk.api.r.j.r.xt xtVar = this.f25097j;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void tl() {
        com.bytedance.msdk.api.r.j.r.xt xtVar = this.f25097j;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.r.xt xtVar = this.f25097j;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    public tl(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f1  */
    @Override // com.bytedance.msdk.api.r.j.r.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g_() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.r.tl.g_():void");
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void h_() {
        String str;
        long j6;
        String str2;
        com.bytedance.msdk.api.r.j.r.j jVar;
        x();
        String str3 = null;
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.cw()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 5, 1, tj() ? 1 : 0, mi.j());
                    return;
                } else if (av.tl()) {
                    str2 = mi.j();
                    if (!ch() && (jVar = this.xt) != null) {
                        jVar.h_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!ch()) {
                jVar.h_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.r.j.r.j jVar2 = this.xt;
            if (jVar2 != null) {
                jVar2.h_();
            }
            str = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str3 = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            j6 = -1;
        }
        long j7 = j6;
        String str4 = str3;
        com.bytedance.msdk.core.xt.j.up(this.f25122m.v());
        com.bytedance.msdk.up.m.xt(this.f25123r, this.f25122m, tj() ? 1 : 0, str4, j7, str, this.f25123r.gq());
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, @NonNull com.bytedance.msdk.api.r.j.r.xt xtVar2) {
        super.xt(xtVar);
        this.f25097j = xtVar2;
        this.f25122m = xtVar;
        this.f25120g = this;
        g();
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void m() {
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.cw()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 3, 1, tj() ? 1 : 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 3, 0, tj() ? 1 : 0, (String) null);
            }
            if (!ch()) {
                s();
                com.bytedance.msdk.api.r.j.r.j jVar = this.xt;
                if (jVar != null) {
                    jVar.m();
                    return;
                }
                return;
            }
            return;
        }
        s();
        com.bytedance.msdk.api.r.j.r.j jVar2 = this.xt;
        if (jVar2 != null) {
            jVar2.m();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void r() {
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.cw()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 1, 1, tj() ? 1 : 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 1, 0, tj() ? 1 : 0, (String) null);
            }
            if (!ch()) {
                s();
                com.bytedance.msdk.api.r.j.r.j jVar = this.xt;
                if (jVar != null) {
                    jVar.r();
                    return;
                }
                return;
            }
            return;
        }
        s();
        com.bytedance.msdk.api.r.j.r.j jVar2 = this.xt;
        if (jVar2 != null) {
            jVar2.r();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void up() {
        String str;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, (com.bytedance.msdk.api.j) null, 2, tj() ? 1 : 0, str, j6);
        com.bytedance.msdk.api.r.j.r.j jVar = this.xt;
        if (jVar != null) {
            jVar.up();
        }
    }

    public void j(Activity activity) {
        xt(activity, null, null);
    }

    @Override // com.bytedance.msdk.cw.r.r
    @MainThread
    protected void j(Activity activity, Object obj, String str) {
        super.j(activity, obj, str, new oq.j() { // from class: com.bytedance.msdk.cw.r.tl.1
            @Override // com.bytedance.msdk.cw.r.oq.j
            public void j() {
                tl.this.cw(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            }
        });
        if (this.xt == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        j(this.f25123r);
    }

    public void j(com.bytedance.msdk.api.r.j.r.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.msdk.cw.r.oq, com.bytedance.msdk.cw.r.xt
    public void j() {
        if (this.f25123r == null) {
            com.bytedance.msdk.core.up.j.j.j().j(this.cw.kt(), this.up, this.f25122m, mi(), this.f25123r);
        }
        super.j();
        this.xt = null;
        this.f25097j = null;
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void j(com.bytedance.msdk.api.j jVar) {
        String str;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, jVar, 1, tj() ? 1 : 0, str, j6);
        cw(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.tl.2
            @Override // java.lang.Runnable
            public void run() {
                if (tl.this.xt != null) {
                    tl.this.xt.j(jVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.api.r.j.r.j
    public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
        com.bytedance.msdk.api.r.j.r.j jVar2 = this.xt;
        if (jVar2 != null) {
            jVar2.j(vl.j(this.f25122m, jVar, this.f25123r));
        }
    }
}
