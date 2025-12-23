package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.cw.f;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kt;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.express.xt;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends xt {
    private boolean ae;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.f.xt f30606g;

    /* renamed from: m, reason: collision with root package name */
    private View f30607m;
    private final ae oq;
    private int tl;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.r up;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    protected int j() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        View view = this.f30607m;
        if (view == null || !this.ae) {
            return;
        }
        view.setVisibility(0);
    }

    public boolean cw() {
        return a.j(this.f30617j);
    }

    public void r() {
        this.f30607m = null;
        com.bytedance.sdk.openadsdk.core.ugeno.express.r rVar = this.up;
        if (rVar != null) {
            rVar.qv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    public ae xt() {
        return this.oq;
    }

    public up(n nVar, boolean z5, j jVar, cw cwVar) {
        super(nVar, jVar, cwVar);
        this.ae = false;
        this.tl = 2;
        this.oq = new ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void cw() {
                up.this.ae = false;
                if (up.this.f30607m != null) {
                    up.this.f30607m.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j(boolean z6) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void xt() {
                up.this.ae = true;
                up.this.up();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void r() {
                if (a.j() && up.this.f30606g != null) {
                    up.this.f30606g.j(up.this.f30617j);
                }
            }
        };
        this.f30606g = new com.bytedance.sdk.openadsdk.core.f.xt(nVar);
        this.f30618r = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    public boolean j(int i6, int i7) {
        return a.m(this.f30617j).j(i6, i7);
    }

    public void j(final ViewGroup viewGroup, final View view, final boolean z5) {
        if (viewGroup == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("render_type", Integer.valueOf(j()));
            hashMap.put("error_code", 100);
            this.cw.j(false, (Map<String, Object>) hashMap);
            return;
        }
        String r5 = a.m(this.f30617j).r();
        String up = a.m(this.f30617j).up();
        this.tl = a.m(this.f30617j).j();
        JSONObject xt = com.bytedance.sdk.openadsdk.core.ugeno.oq.xt(r5, up);
        if (xt != null && xt.length() > 0) {
            j(xt, viewGroup, view, z5);
        } else {
            com.bytedance.sdk.openadsdk.core.ugeno.oq.j(r5, up, new com.bytedance.sdk.openadsdk.core.ugeno.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw
                public void j(String str) {
                    try {
                        up.this.j(new JSONObject(str), viewGroup, view, z5);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final JSONObject jSONObject, final ViewGroup viewGroup, final View view, final boolean z5) {
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                up upVar = up.this;
                if (upVar.f30617j == null) {
                    return;
                }
                if (upVar.tl == 3) {
                    JSONObject j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(view);
                    up upVar2 = up.this;
                    jSONObject2 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(upVar2.f30617j, j6, jSONObject, upVar2.f30618r);
                } else {
                    jSONObject2 = jSONObject;
                }
                xt.j jVar = new xt.j();
                up upVar3 = up.this;
                jVar.up(com.bytedance.sdk.openadsdk.core.ugeno.oq.j(upVar3.f30617j, viewGroup, upVar3.f30618r));
                jVar.j(jSONObject2);
                jVar.j((f) new kt());
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                jVar.xt(height);
                jVar.j(width);
                jVar.j(com.bytedance.sdk.openadsdk.core.oq.i().up());
                jVar.oq(up.this.f30617j.ae());
                com.bytedance.sdk.openadsdk.core.ugeno.express.xt j7 = jVar.j();
                if (up.this.tl == 3) {
                    up.this.up = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(v.getContext(), up.this.f30617j, j7, viewGroup);
                } else {
                    up.this.up = new com.bytedance.sdk.openadsdk.core.ugeno.express.r(v.getContext(), up.this.f30617j, j7, viewGroup);
                }
                up.this.up.j(new com.bytedance.sdk.component.adexpress.xt.tl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.3.1
                    @Override // com.bytedance.sdk.component.adexpress.xt.tl
                    public void j(View view2, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                        up.this.xt.j(view2, i6, cwVar);
                    }

                    @Override // com.bytedance.sdk.component.adexpress.xt.tl
                    public void j(View view2, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
                        up.this.xt.j(view2, i6, cwVar);
                    }
                });
                up.this.up.j(new tl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tl
                    public void j() {
                        if (up.this.f30607m != null) {
                            up.this.f30607m.setVisibility(8);
                            try {
                                if (up.this.f30607m.getParent() != null) {
                                    ((ViewGroup) up.this.f30607m.getParent()).removeView(up.this.f30607m);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                up upVar4 = up.this;
                upVar4.cw.j(upVar4.j());
                up.this.up.j(new com.bytedance.sdk.component.adexpress.xt.ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.up.3.3
                    @Override // com.bytedance.sdk.component.adexpress.xt.ae
                    public void j(View view2, ws wsVar) {
                        boolean z6;
                        if (view2 == null) {
                            return;
                        }
                        up.this.f30607m = view2;
                        up.this.f30607m.setVisibility(8);
                        boolean z7 = false;
                        if (!(up.this.f30607m instanceof ViewGroup) || ((ViewGroup) up.this.f30607m).getChildCount() <= 0) {
                            z6 = false;
                        } else {
                            View childAt = ((ViewGroup) up.this.f30607m).getChildAt(0);
                            if (childAt != null && childAt.getVisibility() == 8) {
                                z7 = true;
                            }
                            z6 = z7;
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        up upVar5 = up.this;
                        ViewGroup viewGroup2 = viewGroup;
                        View view3 = view;
                        View view4 = upVar5.f30607m;
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        upVar5.j(viewGroup2, view3, view4, z5, z6, up.this.up.r(), up.this.f30606g);
                        up.this.up();
                    }

                    @Override // com.bytedance.sdk.component.adexpress.xt.ae
                    public void j(int i6, String str) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        up.this.xt.j(viewGroup);
                        HashMap hashMap = new HashMap();
                        hashMap.put("error_code", Integer.valueOf(i6));
                        hashMap.put("error_msg", str);
                        hashMap.put("render_type", Integer.valueOf(up.this.j()));
                        up.this.cw.j(false, (Map<String, Object>) hashMap);
                    }
                });
            }
        });
    }

    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        this.f30606g.j(xtVar);
    }
}
