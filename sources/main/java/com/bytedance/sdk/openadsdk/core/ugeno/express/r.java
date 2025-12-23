package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.component.adexpress.xt.ae;
import com.bytedance.sdk.component.adexpress.xt.tl;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.gq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements kt, w, com.bytedance.sdk.component.adexpress.dynamic.r, com.bytedance.sdk.component.adexpress.xt.r<View> {
    protected xt ae;
    protected com.bytedance.adsdk.ugeno.xt.cw az;
    protected com.bytedance.adsdk.ugeno.xt.cw<View> cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30701f;

    /* renamed from: g, reason: collision with root package name */
    protected tl f30702g;

    /* renamed from: i, reason: collision with root package name */
    protected f f30703i;

    /* renamed from: j, reason: collision with root package name */
    protected az f30704j;
    protected WeakReference<ViewGroup> jy;
    private String kt;

    /* renamed from: m, reason: collision with root package name */
    protected n f30705m;
    private List<com.bytedance.adsdk.ugeno.xt.cw<View>> mi;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tl oq;
    protected ws qv;

    /* renamed from: r, reason: collision with root package name */
    protected JSONObject f30706r;
    private String tj;
    protected UGTimerContainer tl;
    protected JSONObject up;

    /* renamed from: w, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.oq.j f30707w;
    protected com.bytedance.adsdk.ugeno.xt.cw ws;
    protected Context xt;
    protected qv vl = new qv();
    protected AtomicBoolean av = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public int cw() {
        return hh.xt(this.f30705m);
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
    }

    public float[] r() {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null) {
            return null;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> up = cwVar.up("InteractContainerView");
        if (up instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.interact.qv) {
            return ((com.bytedance.sdk.openadsdk.core.ugeno.component.interact.qv) up).ya();
        }
        return null;
    }

    public void xt() {
        List<com.bytedance.adsdk.ugeno.xt.cw<View>> list = this.mi;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = this.mi.iterator();
        while (it.hasNext()) {
            it.next().rh();
        }
    }

    private void cw(av avVar) {
        JSONObject cw;
        if (avVar == null || (cw = avVar.cw()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(this.f30705m, cw.optString("uttieUrl"), cw.optLong("duration"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ws() {
        n nVar = this.f30705m;
        if (nVar != null) {
            return nVar.ae();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public View ae() {
        return this.tl;
    }

    public boolean g() {
        return this.f30701f;
    }

    public void jy() {
        com.bytedance.adsdk.ugeno.xt.cw<View> r5;
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null || (r5 = cwVar.r("corver_container")) == null || r5.g() == null) {
            return;
        }
        r5.g().setVisibility(8);
    }

    protected com.bytedance.adsdk.ugeno.xt.cw m() {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null) {
            return null;
        }
        return cwVar.up("PlayableComponent");
    }

    protected JSONObject oq() {
        return this.ae.gq();
    }

    public void qv() {
        this.av.set(false);
        f fVar = this.f30703i;
        if (fVar != null) {
            fVar.xt(ws());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j jVar = this.f30707w;
        if (jVar != null) {
            jVar.xt();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r
    public void setSoundMute(boolean z5) {
        com.bytedance.adsdk.ugeno.xt.cw<View> r5;
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null || (r5 = cwVar.r("mute_image")) == null) {
            return;
        }
        if (z5) {
            if (!TextUtils.isEmpty(this.kt)) {
                ((com.bytedance.adsdk.ugeno.widget.image.xt) r5).vl(this.kt);
            }
        } else if (!TextUtils.isEmpty(this.tj)) {
            ((com.bytedance.adsdk.ugeno.widget.image.xt) r5).vl(this.tj);
        }
        r5.xt();
    }

    public List<com.bytedance.adsdk.ugeno.xt.cw<View>> tl() {
        return this.mi;
    }

    protected com.bytedance.adsdk.ugeno.xt.cw up() {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null) {
            return null;
        }
        return cwVar.up("VideoPlaceholder");
    }

    public void vl() {
        com.bytedance.adsdk.ugeno.xt.cw<View> r5;
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null || (r5 = cwVar.r("corver_container")) == null || r5.g() == null) {
            return;
        }
        r5.g().setVisibility(0);
    }

    public r(Context context, n nVar, xt xtVar, ViewGroup viewGroup) {
        JSONObject optJSONObject;
        this.f30701f = false;
        this.xt = context;
        this.f30704j = new az(context);
        this.f30705m = nVar;
        this.ae = xtVar;
        this.tl = new UGTimerContainer(context);
        this.jy = new WeakReference<>(viewGroup);
        JSONObject j6 = j();
        this.f30706r = j6;
        if (nVar != null && j6 != null && (optJSONObject = j6.optJSONObject("event_template")) != null) {
            this.f30701f = true;
            com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(optJSONObject);
        }
        if (com.bytedance.sdk.openadsdk.up.j.r(nVar)) {
            this.f30704j.j(new com.bytedance.adsdk.ugeno.cw.tl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.r.1
                @Override // com.bytedance.adsdk.ugeno.cw.tl
                public void j(g.j jVar) {
                    com.bytedance.sdk.openadsdk.up.j.j(true, jVar);
                }

                @Override // com.bytedance.adsdk.ugeno.cw.tl
                public void xt(g.j jVar) {
                    com.bytedance.sdk.openadsdk.up.j.j(false, jVar);
                }
            });
        }
    }

    public void j(tl tlVar) {
        this.f30702g = tlVar;
    }

    protected void xt(ae aeVar) {
        this.f30704j.j((w) this);
        this.f30704j.j((kt) this);
        this.cw = this.f30704j.j(this.f30706r);
        this.ae.rn().xt();
        this.ae.rn().cw();
        this.f30704j.xt(this.up);
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tl tlVar) {
        this.oq = tlVar;
    }

    private void cw(final av avVar, final w.xt xtVar, final w.j jVar) {
        if (this.f30703i == null) {
            f fVar = new f(v.getContext(), 2, this.ae.g());
            this.f30703i = fVar;
            fVar.j(this.f30705m.si());
            this.f30703i.cw(this.f30705m.ho());
            this.f30703i.xt(this.f30705m.km());
            this.f30703i.j(this.f30705m.mt());
            this.f30703i.m(this.f30705m.qo());
            this.f30703i.up(this.f30705m.wo());
            this.f30703i.xt(this.f30705m.lr());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.f30703i.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.r.2
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i6) {
                if (i6 != 2) {
                    return;
                }
                r rVar = r.this;
                rVar.f30703i.xt(rVar.ws());
                fArr[0] = 0.0f;
                View g6 = ((com.bytedance.adsdk.ugeno.xt.cw) xtVar).g();
                if (g6 != null) {
                    g6.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.r.2.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z5) {
                            if (z5) {
                                r rVar2 = r.this;
                                rVar2.f30703i.j(rVar2.ws());
                            } else {
                                r rVar3 = r.this;
                                rVar3.f30703i.xt(rVar3.ws());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                r.this.j(avVar, xtVar, jVar, 2);
            }
        });
        this.f30703i.j(new f.xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.r.3

            /* renamed from: j, reason: collision with root package name */
            float f30714j = 0.0f;
            float xt = 0.0f;
            float cw = 0.0f;

            /* renamed from: r, reason: collision with root package name */
            float f30716r = 0.0f;
            float up = 0.0f;

            /* renamed from: m, reason: collision with root package name */
            float f30715m = 0.0f;
            long ae = System.currentTimeMillis();

            @Override // com.bytedance.sdk.component.utils.f.xt
            public void j(float f6, float f7, float f8) {
                JSONObject cw;
                View g6;
                boolean z5;
                float f9;
                float f10;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ae < 100) {
                    return;
                }
                this.ae = currentTimeMillis;
                av avVar2 = avVar;
                if (avVar2 == null || (cw = avVar2.cw()) == null) {
                    return;
                }
                double optDouble = cw.optDouble("rotateZ", -1.0d);
                if (optDouble == -1.0d) {
                    return;
                }
                w.xt xtVar2 = xtVar;
                if ((xtVar2 instanceof com.bytedance.adsdk.ugeno.xt.cw) && (g6 = ((com.bytedance.adsdk.ugeno.xt.cw) xtVar2).g()) != null && g6.isShown()) {
                    float abs = Math.abs(f6);
                    float abs2 = Math.abs(f7);
                    float abs3 = Math.abs(f8);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f6 != 0.0f && f7 != 0.0f && f8 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.f30714j = abs;
                        this.xt = abs2;
                        this.cw = abs3;
                        this.f30716r = f6;
                        this.up = f7;
                        this.f30715m = f8;
                        return;
                    }
                    float max = Math.max(Math.abs(abs - this.f30714j), Math.max(Math.abs(abs2 - this.xt), Math.abs(abs3 - this.cw)));
                    int km = r.this.f30705m.km();
                    if (km <= 0) {
                        km = 50;
                    }
                    if (Math.abs(abs - this.f30714j) == max) {
                        f9 = f6 >= this.f30716r ? max : -max;
                        z5 = true;
                    } else {
                        z5 = false;
                        f9 = 0.0f;
                    }
                    if (Math.abs(abs2 - this.xt) == max) {
                        f9 = f7 >= this.up ? max : -max;
                        z5 = true;
                    }
                    if (Math.abs(abs3 - this.cw) != max) {
                        max = f9;
                    } else if (f8 < this.f30715m) {
                        max = -max;
                    }
                    if (r.this.f30705m.qo() == 0) {
                        f10 = (float) Math.ceil((max * 180.0f) / optDouble);
                    } else {
                        double degrees = Math.toDegrees(max);
                        float ceil = (float) Math.ceil(degrees / optDouble);
                        if (z5 && Math.abs(degrees) < km - 8) {
                            return;
                        } else {
                            f10 = z5 ? -Math.abs(ceil) : ceil;
                        }
                    }
                    if (Math.abs(f10 - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(g6, "rotation", fArr[0], f10);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    ofFloat.setDuration(100L);
                    ofFloat.start();
                    fArr[0] = f10;
                }
            }
        });
        this.f30703i.j(ws());
    }

    private void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar, List<com.bytedance.adsdk.ugeno.xt.cw<View>> list) {
        if (cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) {
            if (cwVar.j(4)) {
                list.add(cwVar);
            }
            List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae();
            if (ae == null || ae.size() == 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
            while (it.hasNext()) {
                j(it.next(), list);
            }
            return;
        }
        if (cwVar == null || !cwVar.j(4)) {
            return;
        }
        list.add(cwVar);
    }

    private boolean r(av avVar) {
        JSONObject cw;
        return avVar != null && avVar.xt() == 1 && (cw = avVar.cw()) != null && cw.optBoolean("lottieEvent", false);
    }

    private void r(final av avVar, final w.xt xtVar, final w.j jVar) {
        WeakReference<ViewGroup> weakReference = this.jy;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        gq.j(this.jy, new com.bytedance.sdk.openadsdk.core.xt.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.r.4
            @Override // com.bytedance.sdk.openadsdk.core.xt.cw
            public void j() {
                WeakReference<ViewGroup> weakReference2 = r.this.jy;
                if (weakReference2 == null || weakReference2.get() == null || !gq.j(r.this.jy.get())) {
                    return;
                }
                r.this.j(avVar, xtVar, jVar, 1);
            }
        });
    }

    private void xt(av avVar) {
        JSONObject cw;
        if (avVar == null || (cw = avVar.cw()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(this.f30705m, cw.optString("uttieUrl"));
    }

    private void xt(av avVar, w.xt xtVar, w.j jVar) {
        JSONObject cw = avVar.cw();
        if (cw == null) {
            return;
        }
        String optString = cw.optString("type", null);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        optString.getClass();
        if (optString.equals("clickEvent")) {
            j(avVar, xtVar, jVar, 0);
            return;
        }
        if (optString.equals("close")) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tl tlVar = this.oq;
            if (tlVar != null) {
                tlVar.j();
            }
            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(this.f30705m, cw.optString("uttieUrl"));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public void j(ae aeVar) {
        this.ae.rn().j();
        this.f30706r = j();
        JSONObject oq = oq();
        this.up = oq;
        if (this.f30706r != null && oq != null) {
            xt(aeVar);
            if (this.cw != null) {
                cw cwVar = new cw();
                this.qv = cwVar;
                cwVar.j(true);
                this.qv.j(cw());
                com.bytedance.adsdk.ugeno.xt.cw up = up();
                this.ws = up;
                if (up != null && (up instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.r.j)) {
                    ((cw) this.qv).j((FrameLayout) up.g());
                }
                com.bytedance.adsdk.ugeno.xt.cw m6 = m();
                this.az = m6;
                if (m6 != null && (m6 instanceof com.bytedance.adsdk.ugeno.widget.frame.j)) {
                    ((cw) this.qv).xt((FrameLayout) m6.g());
                }
                ws wsVar = this.qv;
                if (wsVar instanceof cw) {
                    ((cw) wsVar).j(this.f30707w);
                }
                this.tl.setTimerHolder(this.f30707w);
                int rn = this.cw.rn();
                int wq = this.cw.wq();
                ArrayList arrayList = new ArrayList();
                this.mi = arrayList;
                j(this.cw, arrayList);
                View g6 = this.cw.g();
                ViewGroup viewGroup = (ViewGroup) g6.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(g6);
                }
                this.tl.addView(this.cw.g(), new FrameLayout.LayoutParams(rn, wq));
                float h6 = this.ae.h();
                float la = this.ae.la();
                float cw = ed.cw(this.xt, h6);
                float cw2 = ed.cw(this.xt, la);
                int r5 = ed.r(this.xt);
                int g7 = (int) (ed.g(this.xt) + ed.qv(this.xt));
                float f6 = r5;
                if (cw > f6) {
                    cw = f6;
                }
                float f7 = g7;
                if (cw2 > f7) {
                    cw2 = f7;
                }
                if (la <= 0.0f) {
                    this.tl.setLayoutParams(new FrameLayout.LayoutParams((int) cw, -2));
                } else {
                    this.tl.setLayoutParams(new FrameLayout.LayoutParams((int) cw, (int) cw2));
                }
                if (la <= 0.0f) {
                    this.tl.measure(View.MeasureSpec.makeMeasureSpec((int) cw, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    int r6 = ed.r(this.xt, this.tl.getMeasuredWidth());
                    int r7 = ed.r(this.xt, this.tl.getMeasuredHeight());
                    this.qv.j(r6);
                    this.qv.xt(r7);
                } else {
                    this.qv.j(ed.r(this.xt, cw));
                    this.qv.xt(ed.r(this.xt, cw2));
                }
                if (this.av.get()) {
                    aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                    return;
                } else {
                    aeVar.j(this.tl, this.qv);
                    return;
                }
            }
            aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, (String) null);
            return;
        }
        aeVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
    }

    private void xt(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar;
        com.bytedance.adsdk.ugeno.xt.cw r5;
        if (jSONObject == null) {
            return;
        }
        String j6 = com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("type"), oq());
        String j7 = com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("nodeId"), oq());
        if (TextUtils.isEmpty(j7) || (cwVar = this.cw) == null || (r5 = cwVar.xt(cwVar).r(j7)) == null) {
            return;
        }
        if (TextUtils.equals(j6, "onDismiss")) {
            r5.xt(8);
        } else if (TextUtils.equals(j6, "onShow")) {
            r5.xt(0);
        }
    }

    protected JSONObject j() {
        return this.ae.up();
    }

    public void j(boolean z5) {
        this.av.set(z5);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(av avVar, w.xt xtVar, w.j jVar) {
        if (avVar == null) {
            return;
        }
        if (avVar.xt() == 18) {
            cw(avVar, xtVar, jVar);
        } else if (avVar.xt() == 3) {
            r(avVar, xtVar, jVar);
        } else if (avVar.xt() == 9) {
            xt(avVar.cw());
        } else if (avVar.xt() == 10) {
            j(avVar.cw());
        } else if (avVar.xt() == 21) {
            xt(avVar);
        } else if (avVar.xt() == 19) {
            cw(avVar);
        } else if (avVar.xt() != 20) {
            if (r(avVar)) {
                xt(avVar, xtVar, jVar);
            } else if (avVar.xt() == 22) {
                j(avVar);
            } else {
                j(avVar, xtVar, jVar, 0);
            }
        }
        if (avVar.cw() != null) {
            String optString = avVar.cw().optString("next");
            try {
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                av avVar2 = new av();
                avVar2.j(1);
                avVar2.j(new JSONObject(optString));
                avVar2.j(this.cw);
                j(avVar2, (w.xt) null, (w.j) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void j(av avVar) {
        JSONObject cw;
        if (avVar == null || (cw = avVar.cw()) == null) {
            return;
        }
        String optString = cw.optString("type");
        String optString2 = cw.optString("uchain");
        JSONObject optJSONObject = cw.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(next, com.bytedance.adsdk.ugeno.r.xt.j(optJSONObject.optString(next), oq()));
                } catch (Throwable unused) {
                }
            }
        }
        if ("true".equals(optString2)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("material_meta", this.f30705m);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("ugen_event_params", jSONObject);
            String xt = uf.xt(this.f30705m);
            uf.a();
            com.bytedance.sdk.openadsdk.core.g.j.r.j.j(this.f30705m, hashMap, optString, hashMap2, xt, hashMap3);
        }
    }

    private void j(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar;
        com.bytedance.adsdk.ugeno.xt.cw r5;
        if (jSONObject == null) {
            return;
        }
        String j6 = com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("type"), oq());
        String j7 = com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("nodeId"), oq());
        if (TextUtils.isEmpty(j7) || (cwVar = this.cw) == null || (r5 = cwVar.xt(cwVar).r(j7)) == null) {
            return;
        }
        if (TextUtils.equals(j6, "onShow")) {
            r5.xt(0);
        } else if (TextUtils.equals(j6, "onDismiss")) {
            r5.xt(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(av avVar, w.xt xtVar, w.j jVar, int i6) {
        com.bytedance.adsdk.ugeno.xt.cw j6;
        int i7;
        String str;
        JSONObject gq;
        CharSequence text;
        if (avVar == null || (j6 = avVar.j()) == null) {
            return;
        }
        JSONObject cw = avVar.cw();
        String j7 = com.bytedance.adsdk.ugeno.r.xt.j(cw.optString("nodeId"), oq());
        String j8 = com.bytedance.adsdk.ugeno.r.xt.j(cw.optString("type"), oq());
        int i8 = -1;
        if (TextUtils.equals(j8, "clickEvent")) {
            str = cw.optString("subConvertLinkTag");
            i8 = cw.optInt("dpaPosition", -1);
            i7 = 2;
        } else {
            if (TextUtils.equals(j8, "muteVideo")) {
                this.kt = cw.optString("muteSrc");
                this.tj = cw.optString("unmuteSrc");
                i7 = 5;
            } else if (TextUtils.equals(j8, "dislike")) {
                i7 = 3;
            } else if (TextUtils.equals(j8, "skip")) {
                i7 = 6;
            } else if (TextUtils.equals(j8, "openPolicy")) {
                i7 = 7;
            } else if (TextUtils.equals(j8, "openAppPolicy")) {
                i7 = 9;
            } else if (TextUtils.equals(j8, "openAppPermission")) {
                i7 = 10;
            } else if (TextUtils.equals(j8, "close")) {
                str = "";
                i7 = 8;
            } else if (TextUtils.equals(j8, "openAppFunctionDesc")) {
                i7 = 12;
            } else if (TextUtils.equals(j8, "videoControl") || TextUtils.equals(j8, "pauseVideo")) {
                i7 = 4;
            } else if (TextUtils.equals(j8, "openCommonUrl")) {
                i7 = 13;
            } else {
                if (TextUtils.equals(j8, "onDismiss")) {
                    com.bytedance.adsdk.ugeno.xt.cw r5 = avVar.j().xt(avVar.j()).r(j7);
                    if (r5 != null) {
                        r5.xt(8);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(j8, "onShow")) {
                    com.bytedance.adsdk.ugeno.xt.cw r6 = avVar.j().xt(avVar.j()).r(j7);
                    if (r6 != null) {
                        r6.xt(0);
                        return;
                    }
                    return;
                }
                str = "";
                i7 = 0;
            }
            str = "";
        }
        x.j up = new x.j().r(this.vl.ws()).cw(this.vl.az()).xt(this.vl.av()).j(this.vl.i()).j(j6.la()).xt(this.vl.vl()).j(this.vl.jy()).up(str).up(i8);
        JSONObject jSONObject = new JSONObject();
        if (i6 > 0) {
            try {
                jSONObject.put("convertActionType", i6);
            } catch (Throwable unused) {
            }
        }
        View g6 = j6.g();
        try {
            if ((g6 instanceof TextView) && (text = ((TextView) g6).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.f30705m != null && this.f30701f && cw.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", j8);
            }
        } catch (JSONException unused3) {
        }
        try {
            xt xtVar2 = this.ae;
            if (xtVar2 != null && (gq = xtVar2.gq()) != null) {
                jSONObject.put("ugen_id", gq.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String j9 = com.bytedance.adsdk.ugeno.r.xt.j(cw.optString("webUrl"), oq());
            String j10 = com.bytedance.adsdk.ugeno.r.xt.j(cw.optString("webTitle"), oq());
            jSONObject.put("openCommonWebUrl", j9);
            jSONObject.put("openCommonWebTitle", j10);
        } catch (JSONException unused5) {
        }
        up.j(jSONObject);
        x j11 = up.j();
        tl tlVar = this.f30702g;
        if (tlVar != null) {
            tlVar.j(g6, i7, j11);
        }
        if (xtVar == null || avVar.r() == null) {
            return;
        }
        xtVar.j(avVar.r());
    }

    public void j(long j6, long j7) {
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.ws;
        if (cwVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.r.j) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.r.j) cwVar).j(j6, j7);
        }
    }

    public void j(CharSequence charSequence, int i6, int i7, boolean z5) {
        com.bytedance.adsdk.ugeno.xt.cw<View> cwVar = this.cw;
        if (cwVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r5 = cwVar.r("count_down_skip_container");
        if (r5 != null && r5.g() != null) {
            r5.g().setVisibility(0);
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r6 = this.cw.r("count_down");
        com.bytedance.adsdk.ugeno.xt.cw<View> r7 = this.cw.r("skip");
        if ((r6 instanceof com.bytedance.adsdk.ugeno.widget.text.xt) && (r7 instanceof com.bytedance.adsdk.ugeno.widget.text.xt)) {
            if (i7 != 0) {
                ((com.bytedance.adsdk.ugeno.widget.text.xt) r6).qv(((Object) charSequence) + "s ");
                return;
            }
            if (!TextUtils.equals(charSequence, "0") && !z5) {
                ((com.bytedance.adsdk.ugeno.widget.text.xt) r6).qv(((Object) charSequence) + "s ");
                com.bytedance.adsdk.ugeno.widget.text.xt xtVar = (com.bytedance.adsdk.ugeno.widget.text.xt) r7;
                xtVar.qv("| 跳过");
                xtVar.g().setVisibility(0);
                return;
            }
            ((com.bytedance.adsdk.ugeno.widget.text.xt) r6).g().setVisibility(8);
            ((com.bytedance.adsdk.ugeno.widget.text.xt) r7).qv("跳过");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.kt
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.vl.cw(motionEvent.getRawX());
            this.vl.r(motionEvent.getRawY());
            this.vl.xt(System.currentTimeMillis());
            return;
        }
        this.vl.up((int) motionEvent.getRawX());
        this.vl.m((int) motionEvent.getRawY());
        this.vl.j(motionEvent.getRawX());
        this.vl.xt(motionEvent.getRawY());
        this.vl.j(System.currentTimeMillis());
        this.vl.xt(motionEvent.getToolType(0));
        this.vl.cw(motionEvent.getDeviceId());
        this.vl.r(motionEvent.getSource());
    }
}
