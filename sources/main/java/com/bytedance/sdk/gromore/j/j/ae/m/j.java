package com.bytedance.sdk.gromore.j.j.ae.m;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.g.r;
import com.bytedance.msdk.cw.r.jy;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.i.cw.xt.xt {
    private com.bytedance.sdk.openadsdk.r.j.xt.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private jy f27379j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.j f27380r;
    private r up = new r() { // from class: com.bytedance.sdk.gromore.j.j.ae.m.j.2
        @Override // com.bytedance.msdk.api.r.j.g.r
        public Activity getActivity() {
            return null;
        }

        @Override // com.bytedance.msdk.api.r.j.g.r
        public void cw() {
            if (j.this.cw != null) {
                j.this.cw.j();
            }
        }

        @Override // com.bytedance.msdk.api.r.j.g.r
        public void j() {
            if (j.this.cw != null) {
                j.this.cw.j(j.this);
            }
        }

        @Override // com.bytedance.msdk.api.r.j.g.r
        public void xt() {
            if (j.this.cw != null) {
                j.this.cw.xt();
            }
        }
    };
    private com.bytedance.sdk.openadsdk.r.j.xt.j.j xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void tl() {
        this.f27379j.j(new com.bytedance.msdk.api.r.j.g.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.m.j.1
            @Override // com.bytedance.msdk.api.r.j.g.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (j.this.f27380r == null || jVar == null) {
                    return;
                }
                j.this.f27380r.j(j.this, new com.bytedance.sdk.gromore.j.j.j(jVar.f24334j, jVar.xt));
            }

            @Override // com.bytedance.msdk.api.r.j.g.xt
            public void r() {
                if (j.this.xt != null) {
                    j.this.xt.xt(j.this);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.g.xt
            public void up() {
                if (j.this.xt != null) {
                    j.this.xt.j(j.this);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.g.xt
            public void xt(int i6) {
                if (j.this.xt != null) {
                    j.this.xt.j(j.this, i6);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.g.xt
            public void j(int i6) {
                if (j.this.xt != null) {
                    j.this.xt.j(j.this, i6);
                }
            }
        });
        this.f27379j.j(this.up);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public ae ae() {
        return new com.bytedance.sdk.gromore.j.j.m.j(new xt(this.f27379j));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public View cw() {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            return jyVar.m();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void m() {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            jyVar.x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public int r() {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            return jyVar.i();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public Map<String, Object> up() {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            return jyVar.w();
        }
        return null;
    }

    public j(jy jyVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar) {
        this.f27379j = jyVar;
        this.f27380r = jVar;
        tl();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public View xt() {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            return jyVar.f();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public PluginValueSet j() {
        return e.j(super.j()).e(1, com.bytedance.sdk.gromore.init.j.j()).k();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(final com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            jyVar.j(new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.m.j.3
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

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar) {
        this.cw = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(ViewGroup viewGroup) {
        jy jyVar = this.f27379j;
        if (jyVar == null || viewGroup == null) {
            return;
        }
        jyVar.j(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.xt
    public void j(ViewGroup viewGroup, Activity activity) {
        jy jyVar = this.f27379j;
        if (jyVar == null || viewGroup == null || activity == null) {
            return;
        }
        jyVar.j(viewGroup, activity);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        jy jyVar = this.f27379j;
        if (jyVar != null) {
            jyVar.j(xtVar);
        }
    }
}
