package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends xt {
    private final ae ae;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.f.xt f30599m;
    private PlayableFeedWebView up;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    protected int j() {
        return 0;
    }

    public boolean cw() {
        return a.xt(this.f30617j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    public boolean j(int i6, int i7) {
        return true;
    }

    public void r() {
        PlayableFeedWebView playableFeedWebView = this.up;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt
    public ae xt() {
        return this.ae;
    }

    public m(n nVar, boolean z5, j jVar, cw cwVar) {
        super(nVar, jVar, cwVar);
        this.ae = new ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.m.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j() {
                if (m.this.up != null) {
                    m.this.up.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void cw() {
                m.this.up.tl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void xt() {
                if (m.this.up != null) {
                    m.this.up.ae();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j(boolean z6) {
                if (m.this.up != null) {
                    m.this.up.j(z6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void r() {
                if (a.j() && m.this.f30599m != null) {
                    m.this.f30599m.j(m.this.f30617j);
                }
            }
        };
        this.f30599m = new com.bytedance.sdk.openadsdk.core.f.xt(nVar);
        this.f30618r = z5;
    }

    public void j(final ViewGroup viewGroup, final View view, final boolean z5) {
        if (viewGroup == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("render_type", Integer.valueOf(j()));
            hashMap.put("error_code", 100);
            this.cw.j(false, (Map<String, Object>) hashMap);
            return;
        }
        this.cw.j(j());
        PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.f30599m, viewGroup);
        this.up = playableFeedWebView;
        this.f30599m.j(playableFeedWebView);
        this.up.setMaterialMeta(rn.j(this.f30617j));
        this.up.setEasyPlayableListener(this.xt);
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.m.2
            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                mVar.j(viewGroup, view, mVar.up, z5, false, null, null);
            }
        });
    }

    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        this.f30599m.j(xtVar);
    }
}
