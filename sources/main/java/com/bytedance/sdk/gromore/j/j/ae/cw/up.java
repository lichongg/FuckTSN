package com.bytedance.sdk.gromore.j.j.ae.cw;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.i.cw.xt.qv;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends qv {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.r.j f27362j;
    private com.bytedance.sdk.openadsdk.x.j.xt.j.j xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public int cw() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void m() {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar == null) {
            return;
        }
        jVar.j(new com.bytedance.msdk.api.r.j.m.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.cw.up.1
            @Override // com.bytedance.msdk.api.r.j.m.j
            public void j() {
                if (up.this.xt != null) {
                    up.this.xt.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void ae() {
                if (up.this.xt instanceof com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) {
                    ((com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) up.this.xt).ae();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void cw() {
                if (up.this.xt != null) {
                    up.this.xt.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void m() {
                if (up.this.xt != null) {
                    up.this.xt.up();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void r() {
                if (up.this.xt != null) {
                    up.this.xt.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void tl() {
                if (up.this.xt instanceof com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) {
                    ((com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) up.this.xt).tl();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void up() {
                if (up.this.xt instanceof com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) {
                    ((com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) up.this.xt).m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void xt() {
                if (up.this.xt != null) {
                    up.this.xt.xt();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void j(com.bytedance.msdk.api.j jVar2) {
                if (jVar2 == null || !(up.this.xt instanceof com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) up.this.xt).j(jVar2.f24334j, jVar2.xt);
            }

            @Override // com.bytedance.msdk.api.r.j.m.j
            public void j(com.bytedance.msdk.api.cw.j jVar2) {
                if (up.this.xt instanceof com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) {
                    ((com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt) up.this.xt).j(r.j(jVar2));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r up() {
        return new tl(new m(this.f27362j));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public Map<String, Object> xt() {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            return jVar.w();
        }
        return null;
    }

    public up(com.bytedance.msdk.cw.r.j jVar) {
        this.f27362j = jVar;
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(final com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            jVar.j(new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.cw.up.2
                @Override // com.bytedance.msdk.api.r.j.xt
                public void j() {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j();
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt() {
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt(long j6, long j7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.cw(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, int i6, int i7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.xt(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(j6, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(@Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public long r() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public int j() {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            return jVar.i();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(Activity activity) {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            jVar.j(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(Activity activity, Object obj, String str) {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            jVar.j(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        com.bytedance.msdk.cw.r.j jVar = this.f27362j;
        if (jVar != null) {
            jVar.j(xtVar);
        }
    }
}
