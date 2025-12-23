package com.bytedance.sdk.openadsdk.core.ugeno.ae;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.i;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.tj.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.up;
import com.bytedance.sdk.openadsdk.core.ugeno.g.cw;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.cw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements qv, cw, r, tl {
    protected com.bytedance.adsdk.ugeno.xt.cw<View> ae;
    protected int av;
    protected int az;
    private FrameLayout ch;
    protected ViewGroup cw;

    /* renamed from: g, reason: collision with root package name */
    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> f30521g;

    /* renamed from: i, reason: collision with root package name */
    protected int f30522i;

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.m.j f30523j;
    protected Map<String, Object> jy;
    protected InterfaceC0478j kt;

    /* renamed from: m, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.r.j f30524m;
    protected xt mi;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.jy.up f30525r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f30526s;
    protected com.bytedance.adsdk.ugeno.xt.cw<View> tl;
    protected n up;
    protected String vl;

    /* renamed from: w, reason: collision with root package name */
    protected int f30528w;
    protected JSONObject ws;

    /* renamed from: x, reason: collision with root package name */
    private m f30529x;
    protected Context xt;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30520f = true;

    /* renamed from: v, reason: collision with root package name */
    private boolean f30527v = true;
    protected AtomicInteger tj = new AtomicInteger(2);
    protected AtomicInteger oq = new AtomicInteger();
    protected Map<Integer, Boolean> qv = new HashMap();

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.ae.j$6, reason: invalid class name */
    class AnonymousClass6 extends g {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.bytedance.adsdk.ugeno.xt.cw f30535j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
            super(str);
            this.f30535j = cwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            com.bytedance.sdk.openadsdk.core.v.xt.j(jVar.up, jVar.ws, new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.6.1
                @Override // com.bytedance.sdk.openadsdk.core.w.cw
                public void j(boolean z5, List<n> list, boolean z6) {
                    if (list == null || list.size() <= 0) {
                        if (j.this.tj.get() > 0) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            j.this.j(anonymousClass6.f30535j);
                            j.this.tj.decrementAndGet();
                            return;
                        } else {
                            InterfaceC0478j interfaceC0478j = j.this.kt;
                            if (interfaceC0478j != null) {
                                interfaceC0478j.j();
                                return;
                            }
                            return;
                        }
                    }
                    j.this.av = list.size();
                    j.this.f30522i += list.size();
                    j jVar2 = j.this;
                    jVar2.f30528w = jVar2.az();
                    n nVar = list.get(0);
                    if (nVar != null) {
                        j.this.ws = nVar.ag();
                    }
                    final List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> j6 = j.this.j(list);
                    tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.adsdk.ugeno.xt.cw cwVar = AnonymousClass6.this.f30535j;
                            if (cwVar == null || !(cwVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m)) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) cwVar).xt(j6);
                        }
                    });
                }
            }, j.this.up.rr());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.ae.j$j, reason: collision with other inner class name */
    public interface InterfaceC0478j {
        void j();
    }

    public abstract List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> vl();

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public View i() {
        this.ch = new FrameLayout(this.xt);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.ch.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.xt);
        com.bytedance.sdk.openadsdk.g.xt.j(com.bytedance.sdk.openadsdk.core.tl.cw.j("shop_page_guide_gif.gif")).cw(3).j(Bitmap.Config.RGB_565).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.3
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(com.bytedance.sdk.component.m.qv qvVar) {
                Object cw = qvVar.cw();
                try {
                    if (cw instanceof byte[]) {
                        if (qvVar.tl()) {
                            gifView.j((byte[]) cw, false);
                        } else {
                            gifView.setImageDrawable(i.j((byte[]) cw, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int cw = ed.cw(this.xt, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cw, cw);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = ed.cw(this.xt, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.ch.addView(gifView);
        TextView textView = new TextView(this.xt);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = ed.cw(this.xt, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.ch.addView(textView);
        this.ch.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.g.cw(this.xt, new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.g.cw.j
            public void j() {
                com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = j.this.tl;
                if ((cwVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) && cwVar.g() != null) {
                    ((RecyclerView) j.this.tl.g()).xt(1);
                }
                j jVar = j.this;
                jVar.j(jVar.tl);
                j.this.ch.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.jy.cw.j(j.this.up, "landingpage", "in_web_click", (com.bytedance.sdk.openadsdk.m.j.j) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.g.cw.j
            public void xt() {
                j.this.ch.setVisibility(8);
            }
        }, 200));
        this.ch.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.5
            @Override // java.lang.Runnable
            public void run() {
                j.this.ch.setVisibility(8);
            }
        }, 3000L);
        return this.ch;
    }

    public void av() {
        n nVar = this.up;
        rn.xt(nVar != null ? nVar.ae() : 0);
    }

    protected int az() {
        int i6 = this.av;
        int i7 = this.az;
        return Math.max(i6 < i7 ? this.f30522i - i6 : this.f30522i - i7, 0);
    }

    public boolean ws() {
        com.bytedance.adsdk.ugeno.xt.cw<View> r5;
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.ae;
        return (cwVar == null || (r5 = cwVar.r("interactionWebView")) == null || r5.g() == null || r5.g().getVisibility() != 0) ? false : true;
    }

    public void xt(boolean z5) {
        this.f30526s = z5;
    }

    public j(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.jy.up upVar, n nVar, String str, int i6) {
        this.xt = context;
        this.cw = viewGroup;
        this.f30525r = upVar;
        this.up = nVar;
        this.vl = str;
        this.f30523j = nVar.p();
        m mVar = new m(this.xt, this.f30525r, nVar, str, i6);
        this.f30529x = mVar;
        mVar.j((r) this);
        this.f30529x.j((cw) this);
        if (this.up.hu() != null) {
            this.f30529x.j((tl) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(n nVar, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        String xt = uf.xt(this.up);
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.xt, nVar, xt, uf.xt(xt));
        Map<String, Object> up = ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).up();
        up.put("click_element_type", cwVar.la());
        Map<String, Object> map = this.jy;
        if (map != null) {
            up.putAll(map);
        }
        final String fs = nVar.fs();
        com.bytedance.sdk.openadsdk.core.qv.xt.r xt2 = com.bytedance.sdk.openadsdk.core.qv.tl.xt(this.xt, nVar, xt, false);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j((com.bytedance.sdk.openadsdk.core.qv.xt.cw) xt2);
        jVar.j(null, new com.bytedance.sdk.openadsdk.core.tj.qv());
        if (xt2 != null) {
            xt2.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.9
                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j() {
                    j.C0431j.j(fs, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void cw(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 4, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 3, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void xt(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 2, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, String str, String str2) {
                    j.C0431j.j(fs, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(String str, String str2) {
                    j.C0431j.j(fs, 6, 100);
                }
            });
        }
        Object obj = this.xt;
        if (obj instanceof com.bytedance.sdk.openadsdk.core.tl.xt) {
            ((com.bytedance.sdk.openadsdk.core.tl.xt) obj).j(2);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar) {
        this.f30524m = jVar;
    }

    public void jy() {
        try {
            this.f30521g = vl();
            up.j(this.f30523j, new up.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j
                public void j(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        j jVar = j.this;
                        jVar.j(jSONObject, jVar.f30521g);
                        return;
                    }
                    j.this.f30525r.j(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar2 = j.this.f30524m;
                    if (jVar2 != null) {
                        jVar2.j(-1);
                    }
                }
            });
        } catch (Exception e6) {
            this.f30525r.j(-3, e6.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = this.f30524m;
            if (jVar != null) {
                jVar.j(-3);
            }
        }
    }

    protected void j(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> list) {
        this.f30525r.xt();
        this.f30529x.j((qv) this);
        this.f30529x.j(jSONObject, list, new ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = j.this.f30524m;
                if (jVar != null) {
                    jVar.j(i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                j jVar = j.this;
                jVar.ae = cwVar;
                jVar.tl = jVar.f30529x.j();
                j.this.cw.addView(cwVar.g(), new FrameLayout.LayoutParams(cwVar.rn(), cwVar.wq()));
                if (j.this.f30526s) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ed.cw(j.this.xt, 200.0f), ed.cw(j.this.xt, 200.0f));
                    layoutParams.gravity = 17;
                    j jVar2 = j.this;
                    jVar2.cw.addView(jVar2.i(), layoutParams);
                }
                com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar3 = j.this.f30524m;
                if (jVar3 != null) {
                    jVar3.j(cwVar.g());
                }
                j jVar4 = j.this;
                com.bytedance.sdk.openadsdk.core.jy.cw.j(jVar4.up, jVar4.vl, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.m.j.j) null);
            }
        });
    }

    public void j(xt xtVar) {
        this.mi = xtVar;
        m mVar = this.f30529x;
        if (mVar != null) {
            mVar.j(xtVar);
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        com.bytedance.sdk.component.oq.ae.xt(new AnonymousClass6("shop_page", cwVar));
    }

    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> j(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw cwVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw();
            JSONObject tv2 = nVar.tv();
            try {
                tv2.put("voice_btn_position", kt.az(this.up));
            } catch (JSONException unused) {
            }
            cwVar.j(-2134548432);
            cwVar.j(tv2);
            arrayList.add(cwVar);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.tl
    public void xt(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        n nVar = this.up;
        if (nVar == null || nVar.hu() == null) {
            return;
        }
        cwVar.xt(0);
    }

    protected void j(final n nVar, final com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (TextUtils.equals(cwVar.la(), "mute")) {
            com.bytedance.adsdk.ugeno.xt.j h6 = cwVar.h();
            if (h6 != null) {
                com.bytedance.adsdk.ugeno.xt.cw r5 = h6.r("video_" + nVar.ve());
                if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) r5;
                    if (xtVar.tl()) {
                        xtVar.r(false);
                        if (cwVar instanceof com.bytedance.adsdk.ugeno.widget.image.xt) {
                            ((com.bytedance.adsdk.ugeno.widget.image.xt) cwVar).xt(com.bytedance.sdk.component.utils.kt.cw(this.xt, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    xtVar.r(true);
                    if (cwVar instanceof com.bytedance.adsdk.ugeno.widget.image.xt) {
                        ((com.bytedance.adsdk.ugeno.widget.image.xt) cwVar).xt(com.bytedance.sdk.component.utils.kt.cw(this.xt, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.f30520f) {
            if (!oq.m(this.up)) {
                j(this.up, this.jy);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, this.vl, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.m.j.j) null);
            com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, this.vl, "page_click", (com.bytedance.sdk.openadsdk.m.j.j) null);
            this.f30520f = false;
        }
        j(nVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.g.r) {
            nVar.oq(1);
            n nVar2 = this.up;
            if (nVar2 != null) {
                nVar.j(nVar2.p());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j(nVar, true)) {
            com.bytedance.sdk.openadsdk.core.xt.j.xt.cw cwVar2 = new com.bytedance.sdk.openadsdk.core.xt.j.xt.cw(nVar, this.xt);
            cwVar2.j(new cw.xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.7
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.xt
                public void j() {
                    tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n nVar3 = nVar;
                            if (nVar3 == null || nVar3.ml() == null) {
                                return;
                            }
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            a.j(j.this.xt, nVar.ml().r(), 0);
                        }
                    });
                    j.this.xt(nVar, cwVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.xt
                public void j(final String str, final boolean z5) {
                    tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z5 && "has_applied".equals(str)) {
                                a.j(j.this.xt, "你已领券，快去直播间下单吧", 0);
                            } else {
                                a.j(j.this.xt, "领券失败", 0);
                            }
                        }
                    });
                    j.this.xt(nVar, cwVar);
                }
            });
            cwVar2.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.j.8
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j
                public void j() {
                }
            });
            return;
        }
        xt(nVar, cwVar);
    }

    private void j(n nVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.g.j h6;
        JSONObject xt;
        ws j6;
        if (nVar == null || (h6 = nVar.h()) == null || (xt = h6.xt()) == null || (j6 = ws.j(xt)) == null) {
            return;
        }
        if (j6.cw() == 0 || j6.cw() == 5) {
            nVar.j(j6);
        }
    }

    public void j(JSONObject jSONObject) {
        n j6;
        if (jSONObject == null || (j6 = com.bytedance.sdk.openadsdk.core.j.j(jSONObject)) == null) {
            return;
        }
        String xt = uf.xt(this.up);
        HashMap hashMap = new HashMap();
        hashMap.put("is_slide", this.oq);
        com.bytedance.sdk.openadsdk.core.jy.cw.j(j6, xt, hashMap, (Double) null);
        com.bytedance.sdk.openadsdk.core.a.j.j().r();
        n nVar = this.up;
        rn.j(nVar != null ? nVar.ae() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.f30527v && this.oq.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.oq);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.jy.cw.j(j6, xt, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.m.j.j) null);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public void j(Map<String, Object> map) {
        this.jy = map;
    }

    public void j(InterfaceC0478j interfaceC0478j) {
        this.kt = interfaceC0478j;
    }

    private void j(n nVar, Map<String, Object> map) {
        if (nVar == null) {
            return;
        }
        String xt = uf.xt(nVar);
        int tl = ed.tl(v.getContext());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, nVar, new oq.j().m(-1.0f).up(-1.0f).r(-1.0f).cw(-1.0f).xt(-1L).j(-1L).cw(-1).r(-1).up(-1024).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(tl).j(ed.m(v.getContext())).xt(ed.ae(v.getContext())).j(), xt, true, map, -1, false);
    }
}
