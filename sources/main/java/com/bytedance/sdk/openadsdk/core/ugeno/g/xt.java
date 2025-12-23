package com.bytedance.sdk.openadsdk.core.ugeno.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.up;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.openadsdk.core.ugeno.ae.j implements l.j {

    /* renamed from: a, reason: collision with root package name */
    private boolean f30741a;
    private com.bytedance.sdk.openadsdk.core.w.cw ch;

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt f30742f;

    /* renamed from: l, reason: collision with root package name */
    private AtomicBoolean f30743l;

    /* renamed from: s, reason: collision with root package name */
    private long f30744s;

    /* renamed from: v, reason: collision with root package name */
    private boolean f30745v;

    /* renamed from: x, reason: collision with root package name */
    private final Handler f30746x;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int cw() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void r() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
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

    public void i() {
        ScrollView scrollView = new ScrollView(this.xt);
        LinearLayout linearLayout = new LinearLayout(this.xt);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.xt);
        kt.j(this.xt, "tt_ecomm_page_backup_img", imageView);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        imageView.setScaleType(scaleType);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ed.cw(this.xt, 10.0f);
        layoutParams.leftMargin = ed.cw(this.xt, 10.0f);
        layoutParams.rightMargin = ed.cw(this.xt, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.xt);
        imageView2.setScaleType(scaleType);
        kt.j(this.xt, "tt_ecomm_page_backup_img", imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = ed.cw(this.xt, 10.0f);
        layoutParams2.leftMargin = ed.cw(this.xt, 10.0f);
        layoutParams2.rightMargin = ed.cw(this.xt, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.cw.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.j
    public void jy() {
        try {
            this.az = oq.j(this.up);
            JSONObject ag = this.up.ag();
            this.ch = new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.xt.1
                @Override // com.bytedance.sdk.openadsdk.core.w.cw
                public void j(boolean z5, List<n> list, boolean z6) {
                    if (!z5) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.get() > 0) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.get();
                            ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.decrementAndGet();
                            xt.this.jy();
                            return;
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30525r.j(-3, "ad meta info load fail");
                            if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m != null) {
                                ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m.j(-3);
                                return;
                            }
                            return;
                        }
                    }
                    if (list != null && list.size() > 0) {
                        xt.this.xt(list);
                        return;
                    }
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.get() <= 0) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m != null) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m.j(-2);
                        }
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.get();
                        ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).tj.decrementAndGet();
                        xt.this.jy();
                    }
                }
            };
            n nVar = this.up;
            if (nVar != null) {
                if (nVar.h() != null) {
                    if (this.up.h().cw() != null) {
                        if (this.up.h().cw().optInt("use_gnd_prefetch", 0) == 1) {
                        }
                        n nVar2 = this.up;
                        com.bytedance.sdk.openadsdk.core.v.xt.j(nVar2, ag, this.ch, nVar2.rr());
                    }
                }
            }
            if (com.bytedance.sdk.openadsdk.core.playable.xt.j().j(this.up, this.ch)) {
                return;
            }
            n nVar22 = this.up;
            com.bytedance.sdk.openadsdk.core.v.xt.j(nVar22, ag, this.ch, nVar22.rr());
        } catch (Exception e6) {
            if (this.tj.get() > 0) {
                this.tj.get();
                this.tj.decrementAndGet();
                jy();
            } else {
                this.f30525r.j(-3, e6.getMessage());
                com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = this.f30524m;
                if (jVar != null) {
                    jVar.j(-3);
                }
            }
        }
    }

    public void kt() {
        this.f30746x.removeMessages(10082);
    }

    public void mi() {
        Handler handler = this.f30746x;
        if (handler != null) {
            handler.removeMessages(10081);
            this.f30746x.removeMessages(10082);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void r(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
    }

    public void tj() {
        if (oq.xt(this.up)) {
            this.f30746x.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.j
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> vl() {
        this.f30521g = new ArrayList();
        JSONObject tv2 = this.up.tv();
        try {
            tv2.put("env_info", oq.j());
        } catch (JSONException e6) {
            vl.j(e6);
        }
        this.f30521g.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw(tv2, -2134548432));
        return this.f30521g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void xt(int i6) {
    }

    public xt(Context context, ViewGroup viewGroup, up upVar, n nVar, String str, int i6) {
        super(context, viewGroup, upVar, nVar, str, i6);
        this.f30745v = false;
        this.f30746x = new l(Looper.getMainLooper(), this);
        this.f30741a = true;
        this.f30743l = new AtomicBoolean();
        this.f30744s = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.j
    public void av() {
        super.av();
        com.bytedance.sdk.openadsdk.core.playable.xt.j().xt(this.up);
        mi();
    }

    public void cw(boolean z5) {
        this.f30745v = z5;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.f30742f;
        if (xtVar != null) {
            xtVar.r(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6, float f7, float f8, float f9, int i6) {
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
    public void up(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        JSONObject oq;
        if (cwVar == null || (oq = cwVar.oq()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r5 = cwVar.r("video_".concat(String.valueOf(oq.optInt("image_mode"))));
        if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) r5;
            this.f30742f = xtVar;
            xtVar.r(this.f30745v);
            this.f30742f.qb();
        }
    }

    public void w() {
        mi();
        if (this.f30741a) {
            this.f30741a = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f30744s);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.xt.3
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(@NonNull List<n> list) {
        this.av = list.size();
        this.f30522i = list.size();
        this.f30528w = az();
        n nVar = list.get(0);
        if (nVar != null) {
            this.ws = nVar.ag();
        }
        this.f30521g = j(list);
        com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j(this.f30523j, new up.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j
            public void j(JSONObject jSONObject) {
                if (jSONObject != null) {
                    xt xtVar = xt.this;
                    xtVar.j(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw>) ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xtVar).f30521g);
                } else {
                    ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30525r.j(-1, "template info load fail");
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m != null) {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.ae.j) xt.this).f30524m.j(-1);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
    }

    public void cw(int i6) {
        if (i6 == 0) {
            if (this.f30743l.get()) {
                return;
            }
            this.f30746x.sendEmptyMessageDelayed(10081, 5000L);
            return;
        }
        if (this.f30743l.get()) {
            com.bytedance.sdk.openadsdk.core.ugeno.ae.xt xtVar = this.mi;
            if (xtVar != null) {
                xtVar.xt();
            }
            this.f30743l.set(false);
        }
        this.f30746x.removeMessages(10081);
        this.f30746x.removeMessages(10082);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void j(int i6, int i7) {
        if (i7 > 0) {
            this.oq.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.r
    public void j(RecyclerView recyclerView, int i6) {
        if (oq.xt(this.up)) {
            cw(i6);
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
        if (i6 == this.f30528w) {
            j(cwVar);
        }
        this.qv.put(Integer.valueOf(hashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (this.oq.get() == 1) {
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.vl, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.cw
    public void cw(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        n j6;
        if (cwVar == null) {
            return;
        }
        if (cwVar.oq().has("ugen_sub_meta")) {
            j6 = com.bytedance.sdk.openadsdk.core.j.j(cwVar.oq().optJSONObject("ugen_sub_meta"));
        } else {
            j6 = com.bytedance.sdk.openadsdk.core.j.j(cwVar.oq());
        }
        if (j6 != null) {
            j(j6, cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.f30742f;
        if (xtVar == null) {
            vl.r("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i6 == 2) {
            xtVar.sm();
        } else if (i6 == 3) {
            xtVar.ya();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(boolean z5) {
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 != 10081) {
            if (i6 != 10082) {
                return;
            }
            if (this.f30743l.get()) {
                j(kt.j(this.xt, "tt_ecomm_page_reward_slide_tip"));
                this.f30746x.sendEmptyMessageDelayed(10082, 6000L);
                return;
            } else {
                this.f30746x.removeMessages(10082);
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ae.xt xtVar = this.mi;
        if (xtVar != null) {
            xtVar.j();
            this.f30743l.set(true);
            j(kt.j(this.xt, "tt_ecomm_page_reward_slide_tip"));
            this.f30746x.sendEmptyMessageDelayed(10082, 6000L);
        }
    }

    public void j(String str) {
        ViewGroup viewGroup = this.cw;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        a.xt(this.xt, str, 0, 49, 0, 60);
    }
}
