package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.j.m;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.az.ae;
import com.bytedance.sdk.openadsdk.az.tl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.xt;
import com.bytedance.sdk.openadsdk.core.jy.r;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.j implements l.j, r.xt {
    private static final ae.j hh = new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.2
        @Override // com.bytedance.sdk.openadsdk.az.ae.j
        public void j(String str, String str2, Throwable th) {
            vl.cw(str, str2, th);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f28226a;

    /* renamed from: b, reason: collision with root package name */
    private DownloadListener f28227b;

    /* renamed from: c, reason: collision with root package name */
    private PlayableEndcardFrameLayout f28228c;
    protected final AtomicBoolean ch;

    /* renamed from: e, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.xt f28229e;
    private xt.InterfaceC0446xt ed;
    private com.bytedance.sdk.openadsdk.core.ugeno.cw.cw gq;
    private RewardLpBottomView gx;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f28230h;
    private com.bytedance.sdk.openadsdk.core.w.xt hl;

    /* renamed from: l, reason: collision with root package name */
    final l f28231l;
    private FrameLayout la;

    /* renamed from: n, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.playable.j f28232n;
    private com.bytedance.sdk.openadsdk.core.multipro.xt.j nd;
    private xt.j ol;

    /* renamed from: p, reason: collision with root package name */
    long f28233p;

    /* renamed from: q, reason: collision with root package name */
    private String f28234q;
    private final j rh;
    private up rn;

    /* renamed from: s, reason: collision with root package name */
    protected final AtomicBoolean f28235s;
    private boolean uf;
    private tl wq;

    /* renamed from: z, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.w.r f28236z;

    public interface j {
        void j(WebView webView, String str);

        void j(WebView webView, String str, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        this.av = true;
        this.f28226a.set(true);
        this.f28231l.sendMessage(xt(4));
        TTBaseVideoActivity tTBaseVideoActivity = this.f28248j;
        if (tTBaseVideoActivity != null) {
            tTBaseVideoActivity.vl(8);
        }
        xt.InterfaceC0446xt interfaceC0446xt = this.ed;
        if (interfaceC0446xt != null) {
            interfaceC0446xt.j();
        }
    }

    public void l() {
        j(true);
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.xt(true);
        }
        cw(true);
        j(false, true);
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = this.qv;
        if (rVar != null) {
            rVar.xt(false);
        }
    }

    private void c() {
        this.f28231l.sendMessage(xt(3));
        xt.j jVar = this.ol;
        if (jVar != null) {
            jVar.j();
        }
        this.f28248j.cw(0);
    }

    private void ed() {
        this.oq = tj.j(this.xt);
        float uo = this.xt.uo();
        if (TextUtils.isEmpty(this.oq)) {
            return;
        }
        if (this.mi == 1) {
            if (this.oq.contains("?")) {
                this.oq += "&orientation=portrait";
            } else {
                this.oq += "?orientation=portrait";
            }
        }
        if (this.oq.contains("?")) {
            this.oq += "&height=" + this.tj + "&width=" + this.kt + "&aspect_ratio=" + uo;
            return;
        }
        this.oq += "?height=" + this.tj + "&width=" + this.kt + "&aspect_ratio=" + uo;
    }

    private void gx() {
        if (this.f28248j.hl() == null) {
            return;
        }
        long av = !this.f28248j.hl().j() ? this.f28248j.hl().av() : 0L;
        boolean jy = this.f28248j.hl().jy();
        if (!(this.f28248j.e() instanceof g)) {
            tl tlVar = this.wq;
            jy = tlVar != null && tlVar.ae();
        }
        this.f28232n.j(av, jy);
    }

    private void uf() {
        RewardLpBottomView rewardLpBottomView;
        if (!tj.ae(this.xt)) {
            this.gx = null;
            return;
        }
        if (kt.r(this.xt)) {
            this.gx = null;
            return;
        }
        if (!kt.up(this.xt)) {
            this.gx = null;
        } else {
            if (this.f28228c == null || (rewardLpBottomView = this.gx) == null) {
                return;
            }
            rewardLpBottomView.j(this.xt, this.cw);
            this.f28228c.j(new PlayableEndcardFrameLayout.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.j
                public void j() {
                    if (cw.this.gx != null) {
                        cw.this.gx.xt();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = cw.this.f28248j;
                    if (tTBaseVideoActivity != null) {
                        tTBaseVideoActivity.g(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z5, Map<String, Object> map, View view) {
        SSWebView sSWebView = this.ae;
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.r xt = new com.bytedance.sdk.openadsdk.core.jy.r(this.xt, sSWebView).xt(true);
        this.vl = xt;
        xt.j(this);
        this.vl.j(true);
        this.vl.j(z5 ? "reward_endcard" : "fullscreen_endcard");
        rn rnVar = new rn(this.f28248j);
        this.tl = rnVar;
        rnVar.xt(this.ae).j(this.xt).xt(this.xt.fs()).cw(this.xt.os()).cw(z5 ? 7 : 5).j(this.f28251v).r(uf.av(this.xt)).j(this.ae).xt(oq.j(this.xt)).j(this.cw).j(map).j(this.f28253x).j(view).j(this.f28236z);
        if (!tj.cw(this.xt)) {
            this.tl.tl(true);
        }
        this.tl.j(this.hl);
        uf();
        ed();
        rn();
    }

    public void a() {
        SSWebView sSWebView;
        if (this.az || (sSWebView = this.ae) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.ae.loadUrl(this.oq);
        this.az = true;
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.m(this.oq);
        }
    }

    public boolean gq() {
        return !this.f28226a.get();
    }

    public boolean h() {
        rn rnVar = this.tl;
        if (rnVar != null) {
            return rnVar.oq();
        }
        return true;
    }

    public rn la() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void m() {
        SSWebView sSWebView = this.ae;
        if (sSWebView != null && sSWebView.getVisibility() == 0) {
            this.ed.cw().j(true);
        }
        super.m();
        this.f28232n.j();
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.xt(false);
        }
        j(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void r(boolean z5) {
        super.r(z5);
        if (!z5) {
            this.f28232n.xt();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = this.gq;
        if (cwVar != null) {
            cwVar.xt();
        }
    }

    public void rn() {
        if (this.ae == null || this.wq != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.oq.i().z()) {
            ae.j(hh);
        }
        com.bytedance.sdk.openadsdk.core.mi.cw cwVar = new com.bytedance.sdk.openadsdk.core.mi.cw();
        r rVar = new r(this.xt, this.cw, this.f28236z);
        com.bytedance.sdk.openadsdk.core.mi.up upVar = new com.bytedance.sdk.openadsdk.core.mi.up(this.tl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.xt.fs());
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.xt.os());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        tl j6 = cwVar.j(v.getContext(), this.ae, upVar, rVar, hashSet, tl.j.LAND_PAGE).up(this.oq).r(com.bytedance.sdk.openadsdk.core.tl.j.ae()).j(com.bytedance.sdk.openadsdk.core.tl.j.j()).up(jSONObject).j("sdkEdition", com.bytedance.sdk.openadsdk.core.tl.j.cw()).xt(com.bytedance.sdk.openadsdk.core.tl.j.up()).cw(com.bytedance.sdk.openadsdk.core.tl.j.r()).j(10L).xt(10L).cw(false).j(false);
        this.wq = j6;
        Set<String> oq = j6.oq();
        if (this.tl == null || oq == null || oq.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.wq);
        Iterator<String> it = oq.iterator();
        while (it.hasNext()) {
            this.tl.m().j(it.next(), (com.bytedance.sdk.component.j.up<?, ?>) new com.bytedance.sdk.component.j.up<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.8
                @Override // com.bytedance.sdk.component.j.up
                public JSONObject j(JSONObject jSONObject2, m mVar) throws Exception {
                    try {
                        tl tlVar = (tl) weakReference.get();
                        if (tlVar == null) {
                            return null;
                        }
                        return tlVar.r(j(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public void up(boolean z5) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            this.tl.ae(z5);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z5);
            this.tl.j("isVerifyReward", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public String x() {
        return "playable";
    }

    public cw(TTBaseVideoActivity tTBaseVideoActivity, n nVar, String str, int i6, int i7, boolean z5, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, nVar, str, i6, i7, z5);
        int i8;
        this.ch = new AtomicBoolean(false);
        this.f28235s = new AtomicBoolean(false);
        this.f28226a = new AtomicBoolean(false);
        this.f28230h = new AtomicBoolean(false);
        this.f28231l = new l(Looper.getMainLooper(), this);
        this.f28233p = 0L;
        this.rh = new j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.j
            public void j(WebView webView, String str2) {
                if (cw.this.f28248j.e() instanceof g) {
                    return;
                }
                cw.this.f28231l.removeMessages(101);
                if (cw.this.ch.getAndSet(true)) {
                    return;
                }
                if (tj.cw(cw.this.xt) || cw.this.uf) {
                    if (cw.this.f()) {
                        cw.this.j(0);
                    } else if (cw.this.ol != null) {
                        cw.this.ol.j();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.j
            public void j(WebView webView, String str2, Bitmap bitmap) {
                if (tj.cw(cw.this.xt)) {
                    if (cw.this.xt.fv() == 1 || kt.qv(cw.this.xt)) {
                        cw.this.f28231l.sendEmptyMessageDelayed(101, 10000L);
                    }
                    if (cw.this.f28235s.getAndSet(true)) {
                        return;
                    }
                    cw.this.f28233p = System.currentTimeMillis();
                    cw.this.ed.j();
                }
            }
        };
        this.f28236z = new com.bytedance.sdk.openadsdk.core.w.r() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.3
            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void cw() {
                if (!kt.j(cw.this.xt) || kt.qv(cw.this.xt)) {
                    return;
                }
                cw.this.f28248j.j(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void j() {
                cw.this.tl.g(true);
                if (kt.qv(cw.this.xt)) {
                    cw.this.ed.xt();
                }
                cw.this.f28248j.cw(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void xt() {
                if (e.qv(cw.this.xt)) {
                    cw.this.f28248j.r(3);
                }
            }
        };
        this.hl = new com.bytedance.sdk.openadsdk.core.w.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.4
            @Override // com.bytedance.sdk.openadsdk.core.w.xt
            public void j(boolean z6, int i9, String str2) {
                if (z6) {
                    cw.this.av = true;
                }
            }
        };
        this.ae = abstractEndCardFrameLayout.getPlayableWebView();
        this.la = (FrameLayout) this.f28248j.findViewById(2114387925);
        this.f28228c = (PlayableEndcardFrameLayout) this.f28248j.findViewById(2114387681);
        this.gx = (RewardLpBottomView) this.f28248j.findViewById(2114387830);
        if (tj.cw(this.xt)) {
            i8 = 2;
        } else {
            i8 = 1;
        }
        this.f28232n = new com.bytedance.sdk.openadsdk.core.playable.j(this.cw, tTBaseVideoActivity, nVar, i8, tTBaseVideoActivity.e().rn(), abstractEndCardFrameLayout.getVideoArea());
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void az() {
        super.az();
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.rn();
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.vl;
        if (rVar != null) {
            rVar.j((r.xt) null);
        }
        this.f28232n.r();
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = this.gq;
        if (cwVar != null) {
            cwVar.r();
        }
        up upVar = this.rn;
        if (upVar != null) {
            upVar.r();
        }
        this.f28227b = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void ch() {
        super.ch();
        this.f28232n.cw();
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = this.gq;
        if (cwVar != null) {
            cwVar.cw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void jy() {
        super.jy();
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.xt(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = this.gq;
        if (cwVar != null) {
            cwVar.xt();
        }
    }

    public long p() {
        return System.currentTimeMillis() - this.f28233p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void vl() {
        super.vl();
        if (this.wq != null && ed.r(this.ae)) {
            this.wq.xt(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = this.gq;
        if (cwVar != null) {
            cwVar.cw();
        }
        up upVar = this.rn;
        if (upVar != null) {
            upVar.cw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void ws() {
        super.ws();
        up upVar = this.rn;
        if (upVar != null) {
            upVar.j(0);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar) {
        this.nd = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(boolean z5, Map<String, Object> map, View view) {
        if (uf.kt(this.xt) && this.la != null) {
            j(map, view);
        } else {
            xt(z5, map, view);
        }
    }

    public void m(boolean z5) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        this.uf = z5;
    }

    private void j(final Map<String, Object> map, final View view) {
        up upVar = new up(this.xt);
        this.rn = upVar;
        upVar.j(true);
        this.rn.j();
        this.la.setVisibility(0);
        TTBaseVideoActivity tTBaseVideoActivity = this.f28248j;
        FrameLayout frameLayout = this.la;
        up upVar2 = this.rn;
        n nVar = this.xt;
        String str = this.cw;
        com.bytedance.sdk.openadsdk.core.ugeno.cw.cw cwVar = new com.bytedance.sdk.openadsdk.core.ugeno.cw.cw(tTBaseVideoActivity, frameLayout, upVar2, nVar, str, uf.xt(str), this.nd);
        this.gq = cwVar;
        cwVar.j();
        this.gq.j(new com.bytedance.sdk.openadsdk.core.ugeno.r.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(View view2) {
                cw.this.wq();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(int i6) {
                cw.this.gq = null;
                com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cw.this.la != null) {
                            cw.this.la.setVisibility(8);
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        cw cwVar2 = cw.this;
                        cwVar2.az = false;
                        cwVar2.xt(cwVar2.f28250r, map, view);
                        cw cwVar3 = cw.this;
                        cwVar3.xt(cwVar3.f28227b, cw.this.f28229e);
                        cw.this.f28227b = null;
                        cw.this.a();
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.f28227b = downloadListener;
        this.f28229e = xtVar;
        xt(downloadListener, xtVar);
    }

    private void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!tj.ae(this.xt) || (rewardLpBottomView = this.gx) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(int i6) {
        super.j(i6);
        gx();
    }

    public void j(xt.InterfaceC0446xt interfaceC0446xt) {
        this.ed = interfaceC0446xt;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 == 101) {
            c();
            return;
        }
        if (i6 != 102) {
            return;
        }
        if (!this.f28230h.getAndSet(true) && ln.ws(this.xt) != null) {
            tj.j(this.xt);
        }
        this.f28231l.removeMessages(102);
        this.ed.cw().j(true);
        this.f28248j.ya();
        int i7 = message.arg1;
        if (i7 == 2) {
            xt.j jVar = this.ol;
            if (jVar != null) {
                jVar.j();
                return;
            }
            return;
        }
        if (i7 == 0 || i7 == 1) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        if (this.ae == null) {
            return;
        }
        this.f28229e = null;
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = new com.bytedance.sdk.openadsdk.core.widget.j.r(this.f28248j, this.tl, this.xt.fs(), this.vl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i6, String str, String str2) {
                cw.this.f28247i.set(false);
                cw.this.f28252w = this.tl;
                cw cwVar = cw.this;
                cwVar.jy = i6;
                cwVar.ws = str;
                if (cwVar.wq != null) {
                    cw.this.wq.j(i6, str, str2);
                }
                super.onReceivedError(webView, i6, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (cw.this.wq != null && str != null && !str.contains("about:blank")) {
                    cw.this.wq.ae(str);
                }
                super.onPageFinished(webView, str);
                cw.this.rh.j(webView, str);
                if (cw.this.gx != null) {
                    cw.this.gx.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (cw.this.wq != null) {
                    try {
                        cw.this.wq.j(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (cw.this.oq.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        cw.this.f28247i.set(false);
                        cw.this.f28252w = this.tl;
                    }
                    if (webResourceResponse != null) {
                        cw.this.jy = webResourceResponse.getStatusCode();
                        cw.this.ws = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    n nVar = cw.this.xt;
                    if (nVar == null) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    if (TextUtils.isEmpty(nVar.el())) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    cw.this.up++;
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    vl.cw("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                cw.this.f28226a.set(true);
                cw.this.rh.j(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int errorCode;
                CharSequence description;
                if (webResourceRequest.isForMainFrame()) {
                    cw.this.f28247i.set(false);
                    cw.this.f28252w = this.tl;
                }
                cw cwVar = cw.this;
                errorCode = webResourceError.getErrorCode();
                cwVar.jy = errorCode;
                cw cwVar2 = cw.this;
                description = webResourceError.getDescription();
                cwVar2.ws = String.valueOf(description);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.qv = rVar;
        this.ae.setWebViewClient(rVar);
        this.ae.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.tl, this.vl));
        j(this.ae);
        this.ae.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.ae.setDisplayZoomControls(false);
        this.ae.setDownloadListener(downloadListener);
        j(xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.jy.r.xt
    public void j(String str) {
        if (TextUtils.isEmpty(this.f28234q)) {
            this.f28234q = str;
        }
        if (TextUtils.equals(this.f28234q, str)) {
            return;
        }
        this.f28234q = str;
        this.f28248j.g(1);
    }

    public void xt(int i6, int i7) {
        if (this.tl == null || this.f28248j.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i6);
            if (this.f28250r) {
                jSONObject.put("reward_remain_time", i7);
            }
            this.tl.j("reward_button_status", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void j(xt.j jVar) {
        this.ol = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void j(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.jy.tl tlVar = this.f28246g;
        if (tlVar != null) {
            tlVar.oq();
        }
        if (map == null || !tj.cw(this.xt)) {
            return;
        }
        map.put("duration", Long.valueOf(p()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.j
    public void xt(boolean z5) {
        tl tlVar = this.wq;
        if (tlVar != null) {
            tlVar.j(z5);
        }
        this.f28232n.j(z5);
    }

    private Message xt(int i6) {
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.arg1 = i6;
        return obtain;
    }
}
