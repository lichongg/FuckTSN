package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.up.j;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.s;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.up ae;
    private boolean az;
    protected final String cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw f28220g;

    /* renamed from: j, reason: collision with root package name */
    protected final TTBaseVideoActivity f28221j;
    private final AtomicBoolean jy = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private m f28222m;
    private ViewGroup oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    public boolean f28223r;
    private com.bytedance.sdk.openadsdk.core.xt.j tl;
    private int up;
    private long vl;
    private final boolean ws;
    protected final n xt;

    public com.bykv.vk.openvk.component.video.api.cw.r qv() {
        com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(1, this.xt);
        j6.xt(this.xt.fs());
        j6.xt(100);
        j6.cw(100);
        j6.cw(this.xt.os());
        j6.xt(this.f28223r);
        return j6;
    }

    public String xt() {
        return this.cw;
    }

    public void ae() {
        if (Build.VERSION.SDK_INT < 23 || this.az) {
            return;
        }
        this.az = true;
        com.bytedance.sdk.openadsdk.i.cw.cw.xt j6 = a.j(7);
        if (ln.ws(this.xt) != null) {
            com.bykv.vk.openvk.component.video.api.cw.r j7 = ln.j(1, this.xt);
            j7.j("material_meta", this.xt);
            j7.j("ad_slot", Integer.valueOf(j6 != null ? j6.kt() : 0));
            com.bytedance.sdk.openadsdk.core.video.r.xt.j(j7, (j.InterfaceC0307j) null);
        }
    }

    public com.bytedance.sdk.openadsdk.core.xt.j cw() {
        return this.tl;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28220g;
        if (cwVar != null) {
            cwVar.xt();
        }
        n nVar = this.xt;
        rn.xt(nVar != null ? nVar.ae() : 0);
    }

    public boolean m() {
        return this.f28223r;
    }

    public void oq() {
        if (this.ws) {
            this.f28221j.j(this.xt, this.tl);
        }
    }

    public int r() {
        if (this.qv) {
            int xt = z.xt(this.xt) - this.up;
            this.up = z.xt(this.xt);
            return xt;
        }
        if (this.up >= z.xt(this.xt)) {
            return 0;
        }
        this.up++;
        return 1;
    }

    public void tl() {
        ed.j((View) this.oq, 0);
        this.f28221j.vl();
    }

    public j.InterfaceC0494j up() {
        return new j.InterfaceC0494j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xt.4
            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j() {
                xt.this.qv = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j(int i6, String str) {
                xt.this.tl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void xt() {
                xt.this.tl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j(long j6, long j7) {
                ed.j((View) xt.this.oq, 8);
                xt.this.vl = j6;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void cw() {
            }
        };
    }

    public long vl() {
        return this.vl;
    }

    public void xt(boolean z5) {
        this.xt.vl(z5);
    }

    public xt(final TTBaseVideoActivity tTBaseVideoActivity, n nVar, String str, boolean z5, boolean z6) {
        this.f28220g = null;
        this.f28221j = tTBaseVideoActivity;
        this.xt = nVar;
        this.cw = str;
        this.ws = z5;
        this.az = z6;
        m mVar = new m(tTBaseVideoActivity, nVar, str, uf.xt(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m, com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, qv qvVar) {
                super.j(view, qvVar);
                tTBaseVideoActivity.j(2);
            }
        };
        this.f28222m = mVar;
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(tTBaseVideoActivity.nd());
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.up(tTBaseVideoActivity, nVar, str, uf.xt(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.up, com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, qv qvVar) {
                super.j(view, qvVar);
                com.bytedance.sdk.openadsdk.core.xt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.xt.j.xt) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.xt.class);
                if (xtVar != null && xtVar.xt(view)) {
                    tTBaseVideoActivity.j(2);
                }
            }
        };
        this.ae = upVar;
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(tTBaseVideoActivity.nd());
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(tTBaseVideoActivity, nVar, str, 7);
        this.tl = jVar;
        tTBaseVideoActivity.j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(tTBaseVideoActivity.nd());
        if (nVar.jl() == 4) {
            this.f28220g = tl.j((Context) tTBaseVideoActivity, nVar, str, false);
            final String fs = j().fs();
            this.f28220g.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xt.3
                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j() {
                    j.C0431j.j(fs, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void cw(long j6, long j7, String str2, String str3) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 4, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, long j7, String str2, String str3) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 3, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void xt(long j6, long j7, String str2, String str3) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 2, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, String str2, String str3) {
                    j.C0431j.j(fs, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(String str2, String str3) {
                    j.C0431j.j(fs, 6, 100);
                }
            });
        }
    }

    public n j() {
        return this.xt;
    }

    public void j(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.oq = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || j() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28220g;
        if (cwVar != null) {
            cwVar.j();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.f28220g.j((Activity) fullRewardExpressView.getContext());
            }
        }
        this.f28222m.j(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.f28222m.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28220g);
        fullRewardExpressView.setClickListener(this.f28222m);
        this.ae.j(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ae.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28220g);
        fullRewardExpressView.setClickCreativeListener(this.ae);
        this.tl.j(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.f28220g);
        ae();
        ImageView imageView = new ImageView(this.f28221j);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(0)).j(imageView);
        this.oq.addView(imageView);
    }

    public void j(boolean z5) {
        this.f28223r = z5;
    }

    public void j(NativeExpressView nativeExpressView) {
        if (this.jy.getAndSet(true)) {
            return;
        }
        Map<String, Object> nd = this.f28221j.nd();
        s.j(nd, this.xt, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, nd, this.f28221j.rh());
        com.bytedance.sdk.openadsdk.core.a.j.j().r();
        n nVar = this.xt;
        rn.j(nVar != null ? nVar.ae() : 0);
    }
}
