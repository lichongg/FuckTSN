package com.bytedance.sdk.openadsdk.core.ugeno.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.core.ugeno.ae.j {

    /* renamed from: f, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> f30736f;

    /* renamed from: v, reason: collision with root package name */
    private int f30737v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f30738x;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int cw() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void r() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void up() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int xt() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void m(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        JSONObject oq;
        if (cwVar == null || (oq = cwVar.oq()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r5 = cwVar.r("video_".concat(String.valueOf(oq.optInt("image_mode"))));
        if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) r5).xq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void r(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        j(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void up(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        if (cwVar == null) {
            return;
        }
        if (this.f30737v <= 0 && !this.f30738x && TextUtils.equals(cwVar.la(), "header")) {
            cw(0);
            this.f30738x = true;
        }
        JSONObject oq = cwVar.oq();
        if (oq == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r5 = cwVar.r("video_".concat(String.valueOf(oq.optInt("image_mode"))));
        if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) r5;
            xtVar.j(this.jy);
            xtVar.qb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.j
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> vl() {
        this.f30736f = new ArrayList();
        JSONObject tv2 = this.up.tv();
        this.f30736f.add(0, new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw(tv2, -1221270899));
        this.f30736f.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw(tv2, -2134548432));
        return this.f30736f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void xt(int i6) {
    }

    public r(Context context, ViewGroup viewGroup, up upVar, n nVar, String str, int i6) {
        super(context, viewGroup, upVar, nVar, str, i6);
    }

    public void cw(int i6) {
        this.f30737v = i6;
        if (i6 < 0) {
            return;
        }
        final String format = String.format("浏览%d秒可领金币", Integer.valueOf(i6));
        if (this.ae instanceof m) {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.r.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) r.this).ae != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((m) ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) r.this).ae).j();
                            if (recyclerView.getScrollState() != 0 || recyclerView.ws()) {
                                return;
                            }
                            ((m) ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) r.this).ae).j(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((m) this.ae).j(new up.r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.r.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.r
                public void j(RecyclerView.v vVar, int i7) {
                    com.bytedance.adsdk.ugeno.xt.cw r5 = ((up.C0483up) vVar).a().r("count_down");
                    if (r5 instanceof com.bytedance.adsdk.ugeno.widget.text.xt) {
                        ((com.bytedance.adsdk.ugeno.widget.text.xt) r5).qv(format);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6, float f7, float f8, float f9, int i6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void j(RecyclerView recyclerView, int i6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.cw
    public void cw(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        n j6;
        if (cwVar == null || (j6 = com.bytedance.sdk.openadsdk.core.j.j(cwVar.oq())) == null) {
            return;
        }
        j(j6, cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void j(int i6, int i7) {
        if (i7 > 0) {
            this.oq.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, int i6, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw cwVar2) {
        if (cwVar2 == null || cwVar2.j() == null) {
            return;
        }
        int hashCode = cwVar2.j().hashCode();
        if (this.qv.get(Integer.valueOf(hashCode)) != null && this.qv.containsKey(Integer.valueOf(hashCode)) && this.qv.get(Integer.valueOf(hashCode)).booleanValue()) {
            return;
        }
        j(cwVar2.j());
        this.qv.put(Integer.valueOf(hashCode), Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(boolean z5) {
    }
}
