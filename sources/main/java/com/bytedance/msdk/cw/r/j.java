package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.msdk.cw.r.oq;
import com.bytedance.msdk.tl.av;
import com.bytedance.msdk.tl.mi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends r {

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.msdk.j.xt.xt f25047j;
    private com.bytedance.msdk.api.r.j.m.xt kt;
    private com.bytedance.msdk.api.r.j.m.j tj;
    com.bytedance.msdk.j.xt.cw xt;

    private void xt(Activity activity, Object obj, String str) {
        super.j(activity, obj, str, new oq.j() { // from class: com.bytedance.msdk.cw.r.j.1
            @Override // com.bytedance.msdk.cw.r.oq.j
            public void j() {
                j.this.j(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            }
        });
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        com.bytedance.msdk.api.r.j.m.xt xtVar = this.kt;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void tl() {
        com.bytedance.msdk.api.r.j.m.xt xtVar = this.kt;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.m.xt xtVar = this.kt;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    public j(Context context) {
        super(context);
        this.f25047j = new com.bytedance.msdk.j.xt.xt() { // from class: com.bytedance.msdk.cw.r.j.3
            @Override // com.bytedance.msdk.api.r.j.r.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                String str;
                long j6;
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                String str2 = str;
                long j7 = j6;
                j jVar2 = j.this;
                com.bytedance.msdk.up.m.j(jVar2.f25123r, jVar2.f25122m, jVar, 1, jVar2.tj() ? 1 : 0, str2, j7);
                j.this.j(jVar);
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void cw() {
                j.this.v();
                if (j.this.av) {
                    if (!av.j()) {
                        j.this.s();
                        if (j.this.tj != null) {
                            j.this.tj.cw();
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.xt.cw cwVar = j.this.f25123r;
                    if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                        if (!av.cw()) {
                            String j6 = mi.j();
                            j jVar = j.this;
                            com.bytedance.msdk.up.m.j(jVar.f25123r, jVar.f25122m, 2, 1, jVar.tj() ? 1 : 0, j6);
                            return;
                        }
                        j jVar2 = j.this;
                        com.bytedance.msdk.up.m.j(jVar2.f25123r, jVar2.f25122m, 2, 0, jVar2.tj() ? 1 : 0, (String) null);
                    }
                    if (j.this.ch()) {
                        return;
                    }
                    j.this.s();
                    if (j.this.tj != null) {
                        j.this.tj.cw();
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x010f  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
            @Override // com.bytedance.msdk.api.r.j.r.j
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void g_() {
                /*
                    Method dump skipped, instructions count: 351
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.r.j.AnonymousClass3.g_():void");
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void h_() {
                String str;
                long j6;
                String str2;
                j.this.x();
                String str3 = null;
                if (av.j()) {
                    com.bytedance.msdk.xt.cw cwVar = j.this.f25123r;
                    if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                        if (!av.cw()) {
                            String j7 = mi.j();
                            j jVar = j.this;
                            com.bytedance.msdk.up.m.j(jVar.f25123r, jVar.f25122m, 5, 1, jVar.tj() ? 1 : 0, j7);
                            return;
                        } else if (av.tl()) {
                            str2 = mi.j();
                            if (!j.this.ch() && j.this.tj != null) {
                                j.this.tj.xt();
                            }
                            str = str2;
                        }
                    }
                    str2 = null;
                    if (!j.this.ch()) {
                        j.this.tj.xt();
                    }
                    str = str2;
                } else {
                    if (j.this.tj != null) {
                        j.this.tj.xt();
                    }
                    str = null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str3 = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    j6 = -1;
                }
                long j8 = j6;
                String str4 = str3;
                com.bytedance.msdk.core.xt.j.up(j.this.up);
                j jVar2 = j.this;
                com.bytedance.msdk.up.m.xt(jVar2.f25123r, jVar2.f25122m, jVar2.tj() ? 1 : 0, str4, j8, str, j.this.f25123r.gq());
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void m() {
                if (av.j()) {
                    com.bytedance.msdk.xt.cw cwVar = j.this.f25123r;
                    if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                        if (!av.cw()) {
                            String j6 = mi.j();
                            j jVar = j.this;
                            com.bytedance.msdk.up.m.j(jVar.f25123r, jVar.f25122m, 3, 1, jVar.tj() ? 1 : 0, j6);
                            return;
                        }
                        j jVar2 = j.this;
                        com.bytedance.msdk.up.m.j(jVar2.f25123r, jVar2.f25122m, 3, 0, jVar2.tj() ? 1 : 0, (String) null);
                    }
                    if (!j.this.ch()) {
                        j.this.s();
                        if (j.this.tj != null) {
                            j.this.tj.m();
                            return;
                        }
                        return;
                    }
                    return;
                }
                j.this.s();
                if (j.this.tj != null) {
                    j.this.tj.m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void r() {
                if (av.j()) {
                    com.bytedance.msdk.xt.cw cwVar = j.this.f25123r;
                    if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                        if (!av.cw()) {
                            String j6 = mi.j();
                            j jVar = j.this;
                            com.bytedance.msdk.up.m.j(jVar.f25123r, jVar.f25122m, 1, 1, jVar.tj() ? 1 : 0, j6);
                            return;
                        }
                        j jVar2 = j.this;
                        com.bytedance.msdk.up.m.j(jVar2.f25123r, jVar2.f25122m, 1, 0, jVar2.tj() ? 1 : 0, (String) null);
                    }
                    if (!j.this.ch()) {
                        j.this.s();
                        if (j.this.tj != null) {
                            j.this.tj.r();
                            return;
                        }
                        return;
                    }
                    return;
                }
                j.this.s();
                if (j.this.tj != null) {
                    j.this.tj.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void up() {
                String str;
                long j6;
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                String str2 = str;
                long j7 = j6;
                j jVar = j.this;
                com.bytedance.msdk.up.m.j(jVar.f25123r, jVar.f25122m, (com.bytedance.msdk.api.j) null, 2, jVar.tj() ? 1 : 0, str2, j7);
                if (j.this.tj != null) {
                    j.this.tj.up();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.r.j
            public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
                if (j.this.tj != null) {
                    com.bytedance.msdk.api.r.j.m.j jVar2 = j.this.tj;
                    j jVar3 = j.this;
                    jVar2.j(vl.j(jVar3.f25122m, jVar, jVar3.f25123r));
                }
            }
        };
        this.xt = new com.bytedance.msdk.j.xt.cw() { // from class: com.bytedance.msdk.cw.r.j.4
            @Override // com.bytedance.msdk.api.r.j.up.j
            public void j() {
                String str;
                long j6;
                j.this.f();
                if (j.this.tj != null) {
                    j.this.tj.j();
                }
                com.bytedance.msdk.core.tl.jy.j().ae(j.this.up);
                if (j.this.f25123r != null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(j.this.up, "show_listen") + "adSlotId：" + j.this.f25123r.qa() + "，广告类型：" + com.bytedance.msdk.xt.j.j(j.this.f25123r.pz()));
                    com.bytedance.msdk.core.tl.qv j7 = com.bytedance.msdk.core.tl.qv.j();
                    j jVar = j.this;
                    j7.xt(jVar.up, jVar.f25123r.qa());
                }
                j jVar2 = j.this;
                jVar2.j(jVar2.cw);
                j jVar3 = j.this;
                jVar3.cw(jVar3.f25123r);
                com.bytedance.msdk.xt.cw cwVar = j.this.f25123r;
                if (cwVar != null) {
                    String zz = cwVar.zz();
                    j jVar4 = j.this;
                    com.bytedance.msdk.core.cw.cw.j(zz, jVar4.up, jVar4.f25123r.qa());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                String str2 = str;
                long j8 = j6;
                j jVar5 = j.this;
                com.bytedance.msdk.up.m.j(jVar5.f25123r, jVar5.f25122m, jVar5.tj() ? 1 : 0, str2, j8, false);
                j jVar6 = j.this;
                com.bytedance.msdk.core.ae.cw.j(jVar6.up, jVar6.f25123r);
            }

            @Override // com.bytedance.msdk.api.r.j.up.j
            public void cw() {
                j.this.v();
                j jVar = j.this;
                if (jVar.av) {
                    jVar.s();
                    if (j.this.tj != null) {
                        j.this.tj.cw();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.r.j.up.j
            public void r() {
                if (j.this.tj != null) {
                    j.this.tj.ae();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.up.j
            public void up() {
                if (j.this.tj != null) {
                    j.this.tj.tl();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.up.j
            public void xt() {
                String str;
                long j6;
                j.this.x();
                if (j.this.tj != null) {
                    j.this.tj.xt();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                String str2 = str;
                long j7 = j6;
                j jVar = j.this;
                com.bytedance.msdk.xt.cw cwVar = jVar.f25123r;
                com.bytedance.msdk.api.j.xt xtVar = jVar.f25122m;
                boolean tj = jVar.tj();
                com.bytedance.msdk.up.m.xt(cwVar, xtVar, tj ? 1 : 0, str2, j7, j.this.f25123r.gq());
            }

            @Override // com.bytedance.msdk.api.r.j.up.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                String str;
                long j6;
                long currentTimeMillis = System.currentTimeMillis();
                if (mi.j(j.this.f25123r)) {
                    str = mi.xt();
                    j6 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j6 = -1;
                }
                String str2 = str;
                long j7 = j6;
                j jVar2 = j.this;
                com.bytedance.msdk.up.m.j(jVar2.f25123r, jVar2.f25122m, jVar, 1, jVar2.tj() ? 1 : 0, str2, j7);
                j.this.j(jVar);
            }
        };
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.j.m.xt xtVar2) {
        super.xt(xtVar);
        this.f25122m = xtVar;
        this.kt = xtVar2;
        this.f25120g = this.f25047j;
        g();
    }

    public void j(Activity activity) {
        j(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.cw.r.r
    public void j(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "activity can not be null !");
        } else {
            xt(activity, obj, str);
            j(this.f25123r);
        }
    }

    public void j(com.bytedance.msdk.api.r.j.m.j jVar) {
        this.tj = jVar;
    }

    @Override // com.bytedance.msdk.cw.r.oq, com.bytedance.msdk.cw.r.xt
    public void j() {
        if (this.f25123r == null) {
            com.bytedance.msdk.core.up.j.j.j().j(this.cw.kt(), this.up, this.f25122m, mi(), this.f25123r);
        }
        super.j();
        this.tj = null;
        this.kt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.j.2
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.tj != null) {
                    j.this.tj.j(jVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.cw.r.r, com.bytedance.msdk.cw.r.oq
    public void j(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        if (cwVar != null) {
            if (cwVar.rh() == 1) {
                this.f25120g = this.xt;
            } else if (cwVar.rh() == 2) {
                this.f25120g = this.f25047j;
            }
        }
        super.j(cwVar, activity, obj, str);
    }
}
