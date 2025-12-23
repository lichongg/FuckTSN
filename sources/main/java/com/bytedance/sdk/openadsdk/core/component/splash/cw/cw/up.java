package com.bytedance.sdk.openadsdk.core.component.splash.cw.cw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.tj.nd;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private ae ae;
    volatile boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.j.j f28650g;

    /* renamed from: j, reason: collision with root package name */
    volatile boolean f28651j;

    /* renamed from: m, reason: collision with root package name */
    private xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae> f28652m;

    /* renamed from: r, reason: collision with root package name */
    volatile boolean f28653r;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m tl;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.up up;
    volatile boolean xt;

    public up(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.up upVar, xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae> xtVar, com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
        if (upVar != null && xtVar != null) {
            this.up = upVar;
            this.f28652m = xtVar;
            this.f28650g = jVar;
        }
    }

    public void j(final int i6) {
        if (this.up == null || this.f28652m == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i6)));
        if (i6 == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.cw().j(this.up, this.f28652m);
            return;
        }
        if (i6 == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j(this.f28650g).j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    up.this.f28652m.xt(mVar);
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.j.j.j(i6) || up.this.f28650g == null || up.this.up == null) {
                        return;
                    }
                    up.this.f28650g.xt(up.this.up.r(), up.this.up.up());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    if (aeVar != null && up.this.up != null) {
                        up.this.up.j(aeVar.r());
                        up.this.up.j(aeVar.cw());
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.cw().j(up.this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                            if (!up.this.f28653r) {
                                up.this.f28652m.xt(mVar);
                            } else {
                                if (up.this.f28650g == null || up.this.up == null) {
                                    return;
                                }
                                up.this.f28650g.j(mVar, up.this.up.r(), true, 1);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                        public void j(ae aeVar2) {
                            up.this.f28652m.j(aeVar2);
                            if (!com.bytedance.sdk.openadsdk.core.component.splash.j.j.j(i6) || up.this.f28650g == null || up.this.up == null) {
                                return;
                            }
                            up.this.f28650g.xt(up.this.up.r(), up.this.up.up());
                        }
                    });
                }
            });
            return;
        }
        if (i6 == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.cw().j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    up.this.tl = mVar;
                    if (up.this.ae != null && mVar != null) {
                        mVar.j(up.this.ae.r());
                        mVar.j(up.this.ae.cw());
                    }
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时物料加载成功 isCache " + mVar.up());
                    up.this.f28652m.xt(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时物料加载失败 ");
                    up.this.f28652m.j(aeVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j(this.f28650g).j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存物料加载成功 isCache " + mVar.up());
                    up.this.f28652m.xt(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    up.this.ae = aeVar;
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存物料加载失败  ");
                    if (up.this.tl != null && aeVar != null) {
                        up.this.tl.j(aeVar.r());
                        up.this.tl.j(aeVar.cw());
                    }
                    up.this.f28652m.j(aeVar);
                }
            });
        } else if (i6 == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.cw().j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    up.this.tl = mVar;
                    if (up.this.cw || up.this.f28653r) {
                        if (up.this.f28650g == null || up.this.up == null) {
                            return;
                        }
                        up.this.f28650g.j(mVar, up.this.up.r(), true, 3);
                        return;
                    }
                    if (up.this.ae != null && mVar != null) {
                        mVar.j(up.this.ae.r());
                        mVar.j(up.this.ae.cw());
                    }
                    up.this.cw = true;
                    up.this.f28652m.xt(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    up.this.f28651j = true;
                    if (up.this.xt) {
                        up.this.f28652m.j(aeVar);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.j.j.j(i6) || up.this.f28650g == null || up.this.up == null) {
                        return;
                    }
                    up.this.f28650g.xt(up.this.up.r(), up.this.up.up());
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j(this.f28650g).j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    if (up.this.cw) {
                        return;
                    }
                    up.this.cw = true;
                    up.this.f28652m.xt(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    up.this.ae = aeVar;
                    if (up.this.tl != null && aeVar != null) {
                        up.this.tl.j(aeVar.r());
                        up.this.tl.j(aeVar.cw());
                    }
                    up.this.xt = true;
                    if (up.this.f28651j) {
                        up.this.f28652m.j(aeVar);
                    }
                }
            });
        } else {
            if (i6 != 4) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j(this.f28650g).j(this.up, new xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                    up.this.f28652m.xt(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
                public void j(ae aeVar) {
                    up.this.f28652m.j(aeVar);
                }
            });
        }
    }

    public void j() {
        this.f28653r = true;
    }

    public static boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar) {
        return (xtVar == null || ndVar == null || TextUtils.isEmpty(xtVar.tj()) || ndVar.f30365r > 0) ? false : true;
    }
}
