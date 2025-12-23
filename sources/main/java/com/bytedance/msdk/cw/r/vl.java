package com.bytedance.msdk.cw.r;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.cw.r.oq;
import com.bytedance.msdk.tl.av;
import com.bytedance.msdk.tl.mi;
import com.bytedance.msdk.tl.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends oq implements com.bytedance.msdk.j.xt.r {
    private com.bytedance.msdk.api.r.j.tl.j av;
    private final com.bytedance.msdk.j.xt.xt ch;

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.reward.j f25101f;

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.msdk.api.r.j.tl.j f25102j;
    private com.bytedance.msdk.api.r.j.tl.j kt;
    private com.bytedance.msdk.core.admanager.reward.j tj;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.reward.rewardagain.cw f25103v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f25104x;
    private com.bytedance.msdk.api.r.j.tl.xt xt;

    /* renamed from: com.bytedance.msdk.cw.r.vl$2, reason: invalid class name */
    class AnonymousClass2 implements com.bytedance.msdk.api.r.j.tl.j {
        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void j(@NonNull com.bytedance.msdk.api.j jVar) {
            String str;
            long j6;
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(vl.this.f25123r)) {
                str = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j6 = -1;
            }
            String str2 = str;
            long j7 = j6;
            vl vlVar = vl.this;
            com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, jVar, 1, 1, str2, j7);
            vl.this.cw(jVar);
        }

        AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
        @Override // com.bytedance.msdk.api.r.j.tl.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i_() {
            /*
                Method dump skipped, instructions count: 322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.r.vl.AnonymousClass2.i_():void");
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void cw() {
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.xt()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 2, 1, 1, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 2, 0, 1, (String) null);
                }
                if (!vl.this.ch() && vl.this.kt != null) {
                    vl.this.kt.cw();
                    return;
                }
                return;
            }
            if (vl.this.kt != null) {
                vl.this.kt.cw();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void j_() {
            String str;
            long j6;
            String str2;
            String str3 = null;
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.xt()) {
                        String j7 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 5, 1, 1, j7);
                        return;
                    } else if (av.up()) {
                        str2 = mi.j();
                        if (!vl.this.ch() && vl.this.kt != null) {
                            vl.this.kt.j_();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!vl.this.ch()) {
                    vl.this.kt.j_();
                }
                str = str2;
            } else {
                if (vl.this.kt != null) {
                    vl.this.kt.j_();
                }
                str = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(vl.this.f25123r)) {
                str3 = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                j6 = -1;
            }
            long j8 = j6;
            String str4 = str3;
            vl vlVar2 = vl.this;
            com.bytedance.msdk.xt.cw cwVar2 = vlVar2.f25123r;
            com.bytedance.msdk.up.m.xt(cwVar2, vlVar2.f25122m, 1, str4, j8, str, cwVar2.rn());
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void m() {
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.xt()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 3, 1, 1, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 3, 0, 1, (String) null);
                }
                if (!vl.this.ch()) {
                    if (vl.this.f25101f.j()) {
                        vl.this.f25101f.xt();
                    }
                    if (vl.this.kt != null) {
                        vl.this.kt.m();
                        return;
                    }
                    return;
                }
                return;
            }
            if (vl.this.f25101f.j()) {
                vl.this.f25101f.xt();
            }
            if (vl.this.kt != null) {
                vl.this.kt.m();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void r() {
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.xt()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 1, 1, 1, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 1, 0, 1, (String) null);
                }
                if (!vl.this.ch()) {
                    if (vl.this.f25101f.j()) {
                        vl.this.f25101f.up();
                    }
                    if (vl.this.kt != null) {
                        vl.this.kt.r();
                        return;
                    }
                    return;
                }
                return;
            }
            if (vl.this.f25101f.j()) {
                vl.this.f25101f.up();
            }
            if (vl.this.kt != null) {
                vl.this.kt.r();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void up() {
            String str;
            long j6;
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(vl.this.f25123r)) {
                str = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j6 = -1;
            }
            String str2 = str;
            long j7 = j6;
            vl vlVar = vl.this;
            com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, (com.bytedance.msdk.api.j) null, 2, 1, str2, j7);
            if (vl.this.kt != null) {
                vl.this.kt.up();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.tl.j
        public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
            if (!av.j()) {
                if (vl.this.f25101f.j()) {
                    vl.this.f25101f.r();
                    return;
                } else {
                    if (vl.this.kt != null) {
                        com.bytedance.msdk.api.r.j.tl.j jVar2 = vl.this.kt;
                        vl vlVar = vl.this;
                        jVar2.j(vl.j(vlVar.f25122m, jVar, vlVar.f25123r));
                        vl.this.j((com.bytedance.msdk.api.cw.j) null, 1);
                        return;
                    }
                    return;
                }
            }
            com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    String j6 = mi.j();
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 4, 1, 1, j6);
                    return;
                } else {
                    String j7 = av.m() ? mi.j() : null;
                    vl vlVar3 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar3.f25123r, vlVar3.f25122m, 4, 0, 1, j7);
                }
            }
            if (vl.this.ch()) {
                return;
            }
            if (vl.this.f25101f.j()) {
                vl.this.f25101f.r();
            } else if (vl.this.kt != null) {
                com.bytedance.msdk.api.r.j.tl.j jVar3 = vl.this.kt;
                vl vlVar4 = vl.this;
                jVar3.j(vl.j(vlVar4.f25122m, jVar, vlVar4.f25123r));
                vl.this.j((com.bytedance.msdk.api.cw.j) null, 1);
            }
        }
    }

    /* renamed from: com.bytedance.msdk.cw.r.vl$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.msdk.j.xt.xt {
        private volatile boolean xt = false;
        private volatile boolean cw = false;

        /* renamed from: r, reason: collision with root package name */
        private final Handler f25113r = new Handler(Looper.getMainLooper());

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
        }

        AnonymousClass6() {
        }

        private void tl() {
            this.f25113r.postDelayed(new Runnable() { // from class: com.bytedance.msdk.cw.r.vl.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass6.this.cw || AnonymousClass6.this.xt) {
                        AnonymousClass6.this.ae();
                        return;
                    }
                    vl.this.j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.r.vl.6.2.1
                        @Override // com.bytedance.msdk.api.cw.j
                        public boolean j() {
                            return true;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        @Nullable
                        public String cw() {
                            com.bytedance.msdk.api.j.xt xtVar = vl.this.f25122m;
                            return xtVar != null ? xtVar.p() : "";
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        @Nullable
                        public Map<String, Object> r() {
                            return new HashMap();
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public float xt() {
                            if (vl.this.f25122m != null) {
                                return r0.h();
                            }
                            return 0.0f;
                        }
                    });
                    AnonymousClass6.this.ae();
                }
            }, com.bytedance.msdk.ae.j.j.j().m());
        }

        public void ae() {
            this.f25113r.removeCallbacksAndMessages(null);
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void up() {
            vl.this.up();
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void cw() {
            ae();
            this.cw = true;
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.cw()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 2, 1, 0, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 2, 0, 0, (String) null);
                }
                if (!vl.this.ch()) {
                    vl.this.s();
                    if (!vl.this.f() && vl.this.av != null) {
                        vl.this.av.cw();
                        return;
                    }
                    return;
                }
                return;
            }
            vl.this.s();
            if (!vl.this.f() && vl.this.av != null) {
                vl.this.av.cw();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
        @Override // com.bytedance.msdk.api.r.j.r.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void g_() {
            /*
                Method dump skipped, instructions count: 384
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.r.vl.AnonymousClass6.g_():void");
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void h_() {
            String str;
            long j6;
            String str2;
            String str3 = null;
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.cw()) {
                        String j7 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 5, 1, 0, j7);
                        return;
                    } else if (av.tl()) {
                        str2 = mi.j();
                        if (!vl.this.ch() && vl.this.av != null) {
                            vl.this.av.j_();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!vl.this.ch()) {
                    vl.this.av.j_();
                }
                str = str2;
            } else {
                if (vl.this.av != null) {
                    vl.this.av.j_();
                }
                str = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(vl.this.f25123r)) {
                str3 = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                j6 = -1;
            }
            long j8 = j6;
            String str4 = str3;
            com.bytedance.msdk.core.xt.j.up(vl.this.up);
            vl vlVar2 = vl.this;
            com.bytedance.msdk.xt.cw cwVar2 = vlVar2.f25123r;
            com.bytedance.msdk.up.m.xt(cwVar2, vlVar2.f25122m, 0, str4, j8, str, cwVar2.gq());
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void j(@NonNull com.bytedance.msdk.api.j jVar) {
            String str;
            long j6;
            long currentTimeMillis = System.currentTimeMillis();
            if (mi.j(vl.this.f25123r)) {
                str = mi.xt();
                j6 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j6 = -1;
            }
            String str2 = str;
            long j7 = j6;
            vl vlVar = vl.this;
            com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, jVar, 1, 0, str2, j7);
            vl.this.r(jVar);
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void m() {
            ae();
            this.xt = true;
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.cw()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 3, 1, 0, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 3, 0, 0, (String) null);
                }
                if (!vl.this.ch()) {
                    vl.this.s();
                    if (vl.this.tj.j()) {
                        vl.this.tj.xt();
                    }
                    if (vl.this.av != null) {
                        vl.this.av.m();
                        return;
                    }
                    return;
                }
                return;
            }
            vl.this.s();
            if (vl.this.tj.j()) {
                vl.this.tj.xt();
            }
            if (vl.this.av != null) {
                vl.this.av.m();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.r.j
        public void r() {
            if (av.j()) {
                com.bytedance.msdk.xt.cw cwVar = vl.this.f25123r;
                if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                    if (!av.cw()) {
                        String j6 = mi.j();
                        vl vlVar = vl.this;
                        com.bytedance.msdk.up.m.j(vlVar.f25123r, vlVar.f25122m, 1, 1, 0, j6);
                        return;
                    }
                    vl vlVar2 = vl.this;
                    com.bytedance.msdk.up.m.j(vlVar2.f25123r, vlVar2.f25122m, 1, 0, 0, (String) null);
                }
                if (!vl.this.ch()) {
                    vl.this.s();
                    if (vl.this.tj.j()) {
                        vl.this.tj.up();
                    }
                    if (vl.this.av != null) {
                        vl.this.av.r();
                        return;
                    }
                    return;
                }
                return;
            }
            vl.this.s();
            if (vl.this.tj.j()) {
                vl.this.tj.up();
            }
            if (vl.this.av != null) {
                vl.this.av.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.vl.3
            @Override // java.lang.Runnable
            public void run() {
                if (vl.this.kt != null) {
                    vl.this.kt.j(jVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
        if (xtVar == null || xtVar.tl() == 1) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得，一次链路只展示一次激励再得: " + this.up);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.j g6 = com.bytedance.msdk.core.admanager.reward.rewardagain.cw.g(this.up);
        if (g6 == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得开关未开启: " + this.up);
            return false;
        }
        if (this.f25104x) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得，adn已经触发了再看一个: " + this.up);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar = this.f25103v;
        if (cwVar != null) {
            int j6 = cwVar.j(this.f25122m, g6, this.f25123r);
            com.bytedance.msdk.up.m.j(this.f25122m, j6, com.bytedance.msdk.core.up.xt.r.j().cw(this.up, this.f25122m.up()) ? this.f25068w ? 4 : 2 : 1);
            if (j6 == 0) {
                this.f25103v.j(g6, this.f25123r);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.r.vl.5
            @Override // java.lang.Runnable
            public void run() {
                if (vl.this.av != null) {
                    vl.this.av.j(jVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        com.bytedance.msdk.api.r.j.tl.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void j_() {
        String str;
        long j6;
        String str2;
        com.bytedance.msdk.api.r.j.tl.j jVar;
        com.bytedance.msdk.core.xt.j.up(this.f25122m.v());
        String str3 = null;
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 5, 1, 0, mi.j());
                    return;
                } else if (av.up()) {
                    str2 = mi.j();
                    if (!ch() && (jVar = this.av) != null) {
                        jVar.j_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!ch()) {
                jVar.j_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.r.j.tl.j jVar2 = this.av;
            if (jVar2 != null) {
                jVar2.j_();
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
        com.bytedance.msdk.xt.cw cwVar2 = this.f25123r;
        com.bytedance.msdk.up.m.xt(cwVar2, this.f25122m, 0, str4, j7, str, cwVar2.gq());
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void tl() {
        com.bytedance.msdk.api.r.j.tl.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
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
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, (com.bytedance.msdk.api.j) null, 2, 0, str, j6);
        com.bytedance.msdk.api.r.j.tl.j jVar = this.av;
        if (jVar != null) {
            jVar.up();
        }
    }

    public vl(Context context) {
        super(context);
        this.f25102j = new AnonymousClass2();
        this.ch = new AnonymousClass6();
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void cw() {
        com.bytedance.msdk.api.r.j.tl.j jVar;
        com.bytedance.msdk.api.r.j.tl.j jVar2;
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 2, 1, 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 2, 0, 0, (String) null);
            }
            if (ch()) {
                return;
            }
            s();
            if (f() || (jVar2 = this.av) == null) {
                return;
            }
            jVar2.cw();
            return;
        }
        s();
        if (f() || (jVar = this.av) == null) {
            return;
        }
        jVar.cw();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    @Override // com.bytedance.msdk.api.r.j.tl.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i_() {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.r.vl.i_():void");
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void m() {
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 3, 1, 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 3, 0, 0, (String) null);
            }
            if (!ch()) {
                s();
                if (this.tj.j()) {
                    this.tj.xt();
                }
                com.bytedance.msdk.api.r.j.tl.j jVar = this.av;
                if (jVar != null) {
                    jVar.m();
                    return;
                }
                return;
            }
            return;
        }
        s();
        if (this.tj.j()) {
            this.tj.xt();
        }
        com.bytedance.msdk.api.r.j.tl.j jVar2 = this.av;
        if (jVar2 != null) {
            jVar2.m();
        }
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void r() {
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 1, 1, 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 1, 0, 0, (String) null);
            }
            if (ch()) {
                return;
            }
            s();
            if (this.tj.j()) {
                this.tj.up();
            }
            com.bytedance.msdk.api.r.j.tl.j jVar = this.av;
            if (jVar != null) {
                jVar.r();
                return;
            }
            return;
        }
        s();
        if (this.tj.j()) {
            this.tj.up();
        }
        com.bytedance.msdk.api.r.j.tl.j jVar2 = this.av;
        if (jVar2 != null) {
            jVar2.r();
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.api.r.j.tl.xt xtVar = this.xt;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    public void j(com.bytedance.msdk.api.j.xt xtVar, @NonNull com.bytedance.msdk.api.r.j.tl.xt xtVar2) {
        j(xtVar);
        this.tj = new com.bytedance.msdk.core.admanager.reward.j(this.up);
        this.f25101f = new com.bytedance.msdk.core.admanager.reward.j(this.up);
        this.xt = xtVar2;
        this.f25120g = this;
        this.mi = this.f25102j;
        if (com.bytedance.msdk.core.admanager.reward.rewardagain.cw.g(this.up) != null) {
            this.f25103v = new com.bytedance.msdk.core.admanager.reward.rewardagain.cw(this.tl.get(), this.f25122m, this.av, this.kt);
        }
        g();
    }

    public void xt(com.bytedance.msdk.api.r.j.tl.j jVar) {
        this.kt = jVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar = this.f25103v;
        if (cwVar != null) {
            cwVar.xt(jVar);
        }
    }

    @MainThread
    public void j(Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar = this.f25103v;
        if (cwVar != null) {
            cwVar.j(activity, obj, str);
        }
        j(activity, obj, str, new oq.j() { // from class: com.bytedance.msdk.cw.r.vl.1
            @Override // com.bytedance.msdk.cw.r.oq.j
            public void j() {
                vl.this.r(new com.bytedance.msdk.api.j(40052, com.bytedance.msdk.api.j.j(40052)));
            }
        });
        if (this.av == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        j(this.f25123r);
    }

    @MainThread
    public void j(Activity activity) {
        j(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.cw.r.oq
    public void j(com.bytedance.msdk.xt.cw cwVar, Activity activity, Object obj, String str) {
        if (cwVar != null) {
            if (cwVar.rh() != 6 && cwVar.rh() == 7) {
                this.f25120g = this.ch;
            } else {
                this.f25120g = this;
            }
        }
        super.j(cwVar, activity, obj, str);
    }

    public void j(com.bytedance.msdk.api.r.j.tl.j jVar) {
        this.av = jVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar = this.f25103v;
        if (cwVar != null) {
            cwVar.j(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.msdk.api.cw.j jVar, int i6) {
        String str;
        long j6;
        String str2;
        int i7;
        int i8;
        Map<String, Object> r5;
        long currentTimeMillis = System.currentTimeMillis();
        if (mi.j(this.f25123r)) {
            str = mi.xt();
            j6 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j6 = -1;
        }
        String str3 = str;
        long j7 = j6;
        if (jVar != null && (r5 = jVar.r()) != null) {
            Integer num = (Integer) r5.get(MediationConstant.KEY_REASON);
            int intValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) r5.get("errorCode");
            int intValue2 = num2 != null ? num2.intValue() : 0;
            str2 = (String) r5.get(MediationConstant.KEY_ERROR_MSG);
            i8 = intValue2;
            i7 = intValue;
        } else {
            str2 = "";
            i7 = 0;
            i8 = 0;
        }
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, i6, str3, j7, i7, i8, str2);
    }

    public static com.bytedance.msdk.api.cw.j j(final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.api.cw.j jVar, final com.bytedance.msdk.xt.cw cwVar) {
        if (jVar == null) {
            return null;
        }
        return new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.r.vl.4
            @Override // com.bytedance.msdk.api.cw.j
            public String cw() {
                return com.bytedance.msdk.api.cw.j.this.cw();
            }

            @Override // com.bytedance.msdk.api.cw.j
            public boolean j() {
                return com.bytedance.msdk.api.cw.j.this.j();
            }

            @Override // com.bytedance.msdk.api.cw.j
            public Map<String, Object> r() {
                Map<String, Object> r5 = com.bytedance.msdk.api.cw.j.this.r();
                HashMap hashMap = (r5 == null || r5.size() <= 0) ? new HashMap() : new HashMap(r5);
                com.bytedance.msdk.api.cw j6 = ws.j(xtVar, cwVar, true);
                hashMap.put(MediationConstant.KEY_ADN_NAME, j6 != null ? j6.vl() : "");
                hashMap.put("ecpm", j6 != null ? j6.jy() : "");
                return hashMap;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public float xt() {
                return com.bytedance.msdk.api.cw.j.this.xt();
            }
        };
    }

    @Override // com.bytedance.msdk.cw.r.oq, com.bytedance.msdk.cw.r.xt
    public void j() {
        if (this.f25123r == null) {
            com.bytedance.msdk.core.up.j.j j6 = com.bytedance.msdk.core.up.j.j.j();
            List<com.bytedance.msdk.xt.cw> kt = this.cw.kt();
            String str = this.up;
            com.bytedance.msdk.api.j.xt xtVar = this.f25122m;
            j6.j(kt, str, xtVar, xtVar.up(), this.f25123r);
        }
        super.j();
        this.tj.cw();
        this.f25101f.cw();
        this.xt = null;
        this.av = null;
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void j(@NonNull com.bytedance.msdk.api.j jVar) {
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
        com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, jVar, 1, 0, str, j6);
        r(jVar);
    }

    @Override // com.bytedance.msdk.api.r.j.tl.j
    public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
        if (av.j()) {
            com.bytedance.msdk.xt.cw cwVar = this.f25123r;
            if (cwVar != null && MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
                if (!av.xt()) {
                    com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 4, 1, 0, mi.j());
                    return;
                }
                com.bytedance.msdk.up.m.j(this.f25123r, this.f25122m, 4, 0, 0, av.m() ? mi.j() : null);
            }
            if (ch()) {
                return;
            }
            com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar2 = this.f25103v;
            if (cwVar2 != null) {
                cwVar2.xt();
            }
            if (this.tj.j()) {
                this.tj.r();
                return;
            }
            com.bytedance.msdk.api.r.j.tl.j jVar2 = this.av;
            if (jVar2 != null) {
                jVar2.j(j(this.f25122m, jVar, this.f25123r));
                j((com.bytedance.msdk.api.cw.j) null, 0);
                return;
            }
            return;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.cw cwVar3 = this.f25103v;
        if (cwVar3 != null) {
            cwVar3.xt();
        }
        if (this.tj.j()) {
            this.tj.r();
            return;
        }
        com.bytedance.msdk.api.r.j.tl.j jVar3 = this.av;
        if (jVar3 != null) {
            jVar3.j(j(this.f25122m, jVar, this.f25123r));
            j((com.bytedance.msdk.api.cw.j) null, 0);
        }
    }
}
