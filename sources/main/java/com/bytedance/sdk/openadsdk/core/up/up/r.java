package com.bytedance.sdk.openadsdk.core.up.up;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.up.xt;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends xt {
    private final long up;

    private interface j {
        void j(boolean z5);
    }

    private void cw(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, up upVar, nd ndVar) {
        j(xtVar, upVar, ndVar, (com.bytedance.sdk.openadsdk.core.up.up.j.xt) null);
    }

    public void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, up upVar) {
        if (i6 == -1) {
            i6 = xt();
        }
        tl.j jVar = this.f30931j;
        if (jVar != null) {
            jVar.j();
        }
        if (i6 == 1) {
            j(xtVar, upVar, ndVar, 0L);
            return;
        }
        if (i6 == 2) {
            j(xtVar, upVar, ndVar);
            return;
        }
        if (i6 == 3) {
            xt(xtVar, upVar, ndVar);
            return;
        }
        if (i6 == 4) {
            r(xtVar, upVar, ndVar);
        } else if (i6 != 5) {
            cw(xtVar, upVar, ndVar);
        } else {
            m(xtVar, upVar, ndVar);
        }
    }

    private void m(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, up upVar, nd ndVar) {
        int cw;
        double d6;
        tl.xt qv = this.f30931j.qv();
        xt.j j6 = com.bytedance.sdk.openadsdk.core.up.xt.j(xtVar.r(), qv);
        if (qv.xt() > 0) {
            try {
                d6 = Double.parseDouble(com.bytedance.sdk.openadsdk.core.ch.j.j().j("DeviceRate", "bytebench_value"));
            } catch (Exception unused) {
                d6 = 0.0d;
            }
            if (d6 > 0.0d && d6 < qv.xt()) {
                StringBuilder sb = new StringBuilder();
                sb.append(d6);
                j(xtVar, upVar, ndVar, true, 0L, "device_score", sb.toString());
                return;
            }
        }
        if (qv.cw() > 0 && ((cw = ws.cw(v.getContext())) == 2 ? (qv.cw() & 1) != 0 : !(cw == 3 ? (2 & qv.cw()) == 0 : cw == 4 ? (qv.cw() & 16) == 0 : cw == 5 ? (4 & qv.cw()) == 0 : cw != 6 || (qv.cw() & 8) == 0))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cw);
            j(xtVar, upVar, ndVar, true, 0L, "net_type", sb2.toString());
            return;
        }
        if (qv.r() > 0) {
            j6.j(qv);
            int j7 = j6.j(qv.r(), qv);
            if (j7 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - (j7 * 60000);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(j7);
                j(xtVar, upVar, ndVar, true, currentTimeMillis, "good_cache", sb3.toString());
                return;
            }
            if (j7 == 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(j7);
                j(xtVar, upVar, ndVar, true, 0L, "behavior_score", sb4.toString());
                return;
            }
        }
        j(xtVar, upVar, ndVar, false, 0L, "", "");
    }

    private void r(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, nd ndVar) {
        j(xtVar, upVar, (com.bytedance.sdk.openadsdk.core.up.up.j.xt) null, 0L, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.10
            @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
            public void j(boolean z5) {
                if (z5) {
                    return;
                }
                upVar.j(-3, "no cache");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, up upVar, nd ndVar) {
        final tl.xt qv = this.f30931j.qv();
        final xt.j j6 = com.bytedance.sdk.openadsdk.core.up.xt.j(xtVar.r(), qv);
        final com.bytedance.sdk.openadsdk.core.up.up.j.r rVar = new com.bytedance.sdk.openadsdk.core.up.up.j.r(this.f30931j);
        rVar.j();
        j(xtVar, upVar, ndVar, rVar);
        final int j7 = j6.j(qv.up(), qv);
        if (j7 < 0) {
            rVar.j(false);
        } else {
            j(xtVar, upVar, rVar, j7 > 0 ? System.currentTimeMillis() - (j7 * 60000) : 0L, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.11
                @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
                public void j(boolean z5) {
                    rVar.j(z5);
                    if (z5) {
                        xt.j jVar = j6;
                        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2 = xtVar;
                        tl.xt xtVar3 = qv;
                        StringBuilder sb = new StringBuilder();
                        sb.append(j7);
                        jVar.j(xtVar2, xtVar3, "backup_cache", sb.toString());
                    }
                }
            });
        }
    }

    public r(int i6) {
        super(i6);
        this.up = System.currentTimeMillis();
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, final up upVar) {
        ae.r(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.1
            @Override // java.lang.Runnable
            public void run() {
                r.this.xt(xtVar, ndVar, i6, new m(upVar));
            }
        });
    }

    private void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, final nd ndVar, long j6) {
        final com.bytedance.sdk.openadsdk.core.up.up.j.j jVar = new com.bytedance.sdk.openadsdk.core.up.up.j.j(this.f30931j) { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.6
            @Override // com.bytedance.sdk.openadsdk.core.up.up.j.j
            public void j() {
                r.this.j(xtVar, upVar, ndVar, this);
            }
        };
        j(xtVar, upVar, jVar, j6, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.7
            @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
            public void j(boolean z5) {
                if (z5) {
                    return;
                }
                jVar.j(false);
            }
        });
    }

    private void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, up upVar, nd ndVar) {
        final com.bytedance.sdk.openadsdk.core.up.up.j.r rVar = new com.bytedance.sdk.openadsdk.core.up.up.j.r(this.f30931j);
        rVar.j();
        j(xtVar, upVar, ndVar, rVar);
        j(xtVar, upVar, rVar, 0L, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.8
            @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
            public void j(boolean z5) {
                rVar.j(true);
            }
        });
    }

    private void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, up upVar, nd ndVar) {
        final com.bytedance.sdk.openadsdk.core.up.up.j.cw cwVar = new com.bytedance.sdk.openadsdk.core.up.up.j.cw(this.f30931j);
        j(xtVar, upVar, ndVar, cwVar);
        j(xtVar, upVar, cwVar, 0L, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.9
            @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
            public void j(boolean z5) {
                if (z5) {
                    return;
                }
                cwVar.j(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xt() {
        tl.j jVar = this.f30931j;
        return (jVar == null || jVar.tl() == -1) ? com.bytedance.sdk.openadsdk.core.up.up.j.j(this.xt) : this.f30931j.tl();
    }

    private void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, final nd ndVar, boolean z5, long j6, final String str, final String str2) {
        final tl.xt qv = this.f30931j.qv();
        final xt.j j7 = com.bytedance.sdk.openadsdk.core.up.xt.j(xtVar.r(), qv);
        if (z5) {
            final com.bytedance.sdk.openadsdk.core.up.up.j.j jVar = new com.bytedance.sdk.openadsdk.core.up.up.j.j(this.f30931j) { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.12
                @Override // com.bytedance.sdk.openadsdk.core.up.up.j.j
                public void j() {
                    r.this.up(xtVar, upVar, ndVar);
                }
            };
            j(xtVar, upVar, jVar, j6, new j() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.13
                @Override // com.bytedance.sdk.openadsdk.core.up.up.r.j
                public void j(boolean z6) {
                    if (z6) {
                        j7.j(xtVar, qv, str, str2);
                    } else {
                        jVar.j(false);
                    }
                }
            });
        } else {
            up(xtVar, upVar, ndVar);
        }
    }

    private void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, final com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar2, long j6, final j jVar) {
        n nVar;
        xtVar.r();
        if (!TextUtils.isEmpty(xtVar.tj())) {
            jVar.j(false);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String r5 = xtVar.r();
        com.bytedance.sdk.openadsdk.core.up.cw.j jVar2 = this.cw;
        if (jVar2 != null) {
            jVar2.xt(r5);
            nVar = this.cw.j(r5, j6);
        } else {
            nVar = null;
        }
        if (nVar == null) {
            jVar.j(false);
            return;
        }
        if (!j(nVar)) {
            jVar.j(false);
            return;
        }
        com.bytedance.sdk.openadsdk.core.up.j.xt xtVar3 = this.f30932r;
        if (xtVar3 == null) {
            jVar.j(false);
            return;
        }
        if (!xtVar3.j(xtVar, nVar)) {
            jVar.j(false);
            return;
        }
        com.bytedance.sdk.openadsdk.core.up.xt.j jVar3 = new com.bytedance.sdk.openadsdk.core.up.xt.j(this.xt);
        jVar3.j(currentTimeMillis);
        jVar3.xt(System.currentTimeMillis());
        final n nVar2 = nVar;
        jVar3.j(nVar2, new com.bytedance.sdk.openadsdk.core.up.xt.m() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.2
            @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
            public void j(boolean z5, long j7) {
                if (z5) {
                    r.this.j(nVar2, xtVar, xtVar2, upVar, jVar);
                } else {
                    jVar.j(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
            public void xt() {
                r.this.j(nVar2, xtVar, xtVar2, upVar, jVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
            public void j() {
                r.this.j(xtVar, nVar2, upVar, xtVar2, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar, final up upVar, final com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar2, final j jVar) {
        tl.j jVar2 = this.f30931j;
        if (jVar2 != null && jVar2.oq() == 1) {
            final long currentTimeMillis = System.currentTimeMillis();
            List<com.bytedance.sdk.openadsdk.core.up.xt.r> j6 = com.bytedance.sdk.openadsdk.core.up.xt.r.j(nVar);
            if (j6 != null && !j6.isEmpty()) {
                j6.size();
                v.j().j(j6, new com.bytedance.sdk.openadsdk.core.up.xt.xt<com.bytedance.sdk.openadsdk.core.up.xt.cw>() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.3
                    @Override // com.bytedance.sdk.openadsdk.core.up.xt.xt
                    public void j(com.bytedance.sdk.openadsdk.core.up.xt.cw cwVar, long j7, long j8) {
                        n j9 = com.bytedance.sdk.openadsdk.core.up.xt.r.j(cwVar, nVar);
                        com.bytedance.sdk.openadsdk.core.kt.ws.j(xtVar, j9 != null, j7, j8, System.currentTimeMillis() - currentTimeMillis, r.this.xt);
                        if (j9 == null) {
                            jVar.j(false);
                        } else {
                            r.this.j(j9, xtVar, xtVar2, upVar, jVar);
                        }
                    }
                });
                return;
            } else {
                jVar.j(false);
                return;
            }
        }
        j(nVar, xtVar, xtVar2, upVar, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, final nd ndVar, final com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar2) {
        xtVar.r();
        v.j().j(xtVar, ndVar, this.xt, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.4
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) {
                com.bytedance.sdk.openadsdk.core.up.j.xt xtVar4 = r.this.f30932r;
                if (xtVar4 != null) {
                    xtVar4.j(xtVar, i6, str, xtVar3);
                }
                com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar5 = xtVar2;
                if (xtVar5 != null) {
                    xtVar5.j(upVar, i6, str);
                    return;
                }
                up upVar2 = upVar;
                if (upVar2 != null) {
                    upVar2.j(i6, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) {
                com.bytedance.sdk.openadsdk.core.up.j.xt xtVar4 = r.this.f30932r;
                cw j6 = xtVar4 == null ? null : xtVar4.j(jVar, xtVar3, ndVar, xtVar, upVar);
                if (j6 != null) {
                    com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar5 = xtVar2;
                    if (xtVar5 == null) {
                        j6.j();
                    } else {
                        xtVar5.j(j6);
                    }
                }
                com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar6 = xtVar2;
                if (xtVar6 != null) {
                    xtVar6.cw();
                }
            }
        });
    }

    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar) {
        if (xtVar == null) {
            return;
        }
        xtVar.r();
        if (com.bytedance.sdk.openadsdk.core.live.up.r.j(xtVar.f())) {
            ae.r(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.up.r.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(xtVar.tj())) {
                        com.bytedance.sdk.openadsdk.core.up.j.xt xtVar2 = r.this.f30932r;
                        if (xtVar2 != null) {
                            xtVar2.j(xtVar);
                            return;
                        }
                        return;
                    }
                    if (r.this.xt() != 0 && r.this.cw.j(xtVar.r())) {
                        xtVar.r();
                        r.this.j(xtVar, (up) null, ndVar, (com.bytedance.sdk.openadsdk.core.up.up.j.xt) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, com.bytedance.sdk.openadsdk.core.up.up.j.xt xtVar2, up upVar, j jVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong(d.f41197p, this.up);
        cw j6 = this.f30932r.j(nVar, xtVar, upVar, bundle);
        if (xtVar2 != null) {
            xtVar2.xt(j6);
            xtVar2.j(true);
            xtVar.r();
        } else {
            j6.j();
            xtVar.r();
        }
        jVar.j(true);
    }
}
