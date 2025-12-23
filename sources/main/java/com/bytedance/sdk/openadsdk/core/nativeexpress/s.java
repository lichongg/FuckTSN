package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.az.tl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.rn.wq;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.feature.dynamic.b;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class s extends com.bytedance.sdk.component.adexpress.up.j implements az, ws {
    private String ae;
    private com.bytedance.sdk.openadsdk.az.tl av;
    private com.bytedance.sdk.openadsdk.core.rn.j az;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.m.j f29708g;

    /* renamed from: i, reason: collision with root package name */
    private ae f29709i;
    private rn jy;

    /* renamed from: m, reason: collision with root package name */
    private Context f29710m;
    private long mi;
    private String oq;
    private com.bytedance.sdk.openadsdk.core.jy.r qv;
    private n tl;
    private final Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.g f29711w;
    private int ws;

    private boolean av() {
        return !TextUtils.isEmpty(this.ae) && this.ae.equals("splash_ad");
    }

    private void i() {
        if (this.jy == null || ((ViewGroup) this.cw.getParent()) == null) {
            return;
        }
        rn rnVar = this.jy;
        rnVar.j(new a(this.cw, rnVar, this.tl));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.az
    public rn D_() {
        return this.jy;
    }

    public ae az() {
        return this.f29709i;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.j
    public void b_(int i6) {
        if (this.jy == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i6);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        this.jy.j("themeChange", jSONObject);
    }

    public void jy() {
        SSWebView sSWebView = this.cw;
        if (sSWebView == null) {
            return;
        }
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.rn.rn.j(this.tl));
        try {
            this.cw.setBackgroundColor(0);
            this.cw.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        j(this.cw);
        if (j() != null) {
            this.qv = new com.bytedance.sdk.openadsdk.core.jy.r(this.tl, j()).xt(false);
        }
        this.qv.j(this.f29708g);
        this.cw.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.jy, this.qv));
        this.cw.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.s.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
                if (!s.this.vl.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.qv.xt.cw j7 = com.bytedance.sdk.openadsdk.core.qv.tl.j(s.this.f29710m, str, s.this.tl, s.this.ae);
                    s.this.vl.put(str, j7);
                    j7.j(uf.mi(s.this.tl), false);
                } else {
                    com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = (com.bytedance.sdk.openadsdk.core.qv.xt.cw) s.this.vl.get(str);
                    if (cwVar != null) {
                        cwVar.j(uf.mi(s.this.tl), false);
                    }
                }
            }
        });
        if ("rewarded_video".equals(this.ae) || "fullscreen_interstitial_ad".equals(this.ae)) {
            ed.j((com.bytedance.sdk.component.jy.cw) this.cw);
        }
        com.bytedance.sdk.component.adexpress.up.up.j().j(this.cw, this.jy);
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    public void m() {
        rn rnVar = this.jy;
        if (rnVar == null) {
            return;
        }
        rnVar.j("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    public void r() {
        if (this.up.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.qv;
        if (rVar != null) {
            rVar.m();
        }
        SSWebView sSWebView = this.cw;
        if (sSWebView != null) {
            sSWebView.I_();
            this.cw.setOnShakeListener(null);
        }
        rn rnVar = this.jy;
        if (rnVar != null) {
            rnVar.up();
        }
        super.r();
        this.vl.clear();
        this.jy = null;
        com.bytedance.sdk.openadsdk.az.tl tlVar = this.av;
        if (tlVar == null) {
            return;
        }
        tlVar.rn();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j, com.bytedance.sdk.openadsdk.core.nativeexpress.ws
    public void tl() {
        super.tl();
        if (this.jy == null) {
            return;
        }
        i();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.jy.j("expressShow", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    public void up() {
        if (j() == null) {
            return;
        }
        try {
            j().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void vl() {
        if (this.cw == null) {
            return;
        }
        rn rnVar = new rn(this.f29710m);
        this.jy = rnVar;
        rnVar.xt(this.cw).j(this.tl).xt(this.tl.fs()).cw(this.tl.os()).j(this.ae).cw(uf.xt(this.ae)).r(uf.av(this.tl)).j(this).m(this.f25852j).j(this.cw).j(this.f29708g);
    }

    public void ws() {
        if (this.cw == null || this.av != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.mi.cw cwVar = new com.bytedance.sdk.openadsdk.core.mi.cw();
        com.bytedance.sdk.openadsdk.core.mi.r rVar = new com.bytedance.sdk.openadsdk.core.mi.r();
        com.bytedance.sdk.openadsdk.core.mi.up upVar = new com.bytedance.sdk.openadsdk.core.mi.up(this.jy);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.tl.fs());
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.tl.os());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        this.av = cwVar.j(com.bytedance.sdk.openadsdk.core.v.getContext(), this.cw, upVar, rVar, hashSet, "embeded_ad".equals(this.ae) ? tl.j.FEED : tl.j.OTHER).up(this.oq).r(com.bytedance.sdk.openadsdk.core.tl.j.ae()).j(com.bytedance.sdk.openadsdk.core.tl.j.j()).up(jSONObject).j("sdkEdition", com.bytedance.sdk.openadsdk.core.tl.j.cw()).xt(com.bytedance.sdk.openadsdk.core.tl.j.up()).cw(com.bytedance.sdk.openadsdk.core.tl.j.r()).cw(false);
        ae aeVar = new ae(this.f29710m, this.jy, this.tl, this.qv, av(), this.av, qv());
        this.f29709i = aeVar;
        this.cw.setWebViewClient(aeVar);
        com.bytedance.sdk.component.adexpress.xt.g gVar = this.f29711w;
        if (gVar instanceof oq) {
            ((oq) gVar).j(this.av);
        }
        Set<String> oq = this.av.oq();
        if (this.jy == null || oq == null || oq.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.av);
        Iterator<String> it = oq.iterator();
        while (it.hasNext()) {
            this.jy.m().j(it.next(), (com.bytedance.sdk.component.j.up<?, ?>) new com.bytedance.sdk.component.j.up<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.s.2
                @Override // com.bytedance.sdk.component.j.up
                public JSONObject j(JSONObject jSONObject2, com.bytedance.sdk.component.j.m mVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.az.tl tlVar = (com.bytedance.sdk.openadsdk.az.tl) weakReference.get();
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

    public s(Context context, com.bytedance.sdk.component.adexpress.xt.jy jyVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.m.j jVar, n nVar, com.bytedance.sdk.component.adexpress.xt.g gVar) {
        super(context, jyVar, themeStatusBroadcastReceiver);
        this.vl = Collections.synchronizedMap(new HashMap());
        this.ws = 8;
        this.mi = -1L;
        this.f29710m = context;
        this.ae = jyVar.m();
        this.tl = nVar;
        this.f29708g = jVar;
        this.f25852j = jyVar.up();
        String j6 = j(nVar);
        this.oq = j6;
        this.f29711w = gVar;
        j(wq.xt(j6));
        themeStatusBroadcastReceiver.j(this);
        vl();
        jy();
        ws();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j, com.bytedance.sdk.component.adexpress.xt.r
    public int cw() {
        return hh.xt(this.tl);
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    protected void g() {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = com.bytedance.sdk.openadsdk.core.oq.i().r();
        this.az = r5;
        r5.j(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    protected void oq() {
        super.oq();
        com.bytedance.sdk.openadsdk.core.rn.j jVar = this.az;
        if (jVar != null) {
            jVar.xt(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j, com.bytedance.sdk.openadsdk.core.nativeexpress.ws
    public void xt(final int i6) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.s.3
            @Override // java.lang.Runnable
            public void run() {
                s.this.cw(i6);
                s.this.r(i6);
                if (i6 == s.this.ws) {
                    return;
                }
                s.this.ws = i6;
                s.this.xt(i6 == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i6) {
        com.bytedance.sdk.openadsdk.az.tl tlVar = this.av;
        if (tlVar == null) {
            return;
        }
        if (i6 == 0) {
            tlVar.xt(true);
            this.av.j(false);
        } else {
            tlVar.xt(false);
            this.av.j(true);
        }
    }

    public static String j(n nVar) {
        return com.bytedance.sdk.component.adexpress.j.xt.xt.xt(hh.tl(nVar) ? b.f33222u : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z5) {
        if (this.jy == null || this.cw == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z5);
            this.jy.j("expressAdShow", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static void j(Map<String, Object> map, n nVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (hh.m(nVar) != null && !TextUtils.isEmpty(hh.m(nVar).qv())) {
                map.put("engine_version", hh.m(nVar).qv());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e6) {
            e6.getMessage();
        }
    }

    private void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.f29710m).j(false).j(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            com.bytedance.sdk.openadsdk.core.rn.kt.j(sSWebView, h.xt, n.r(this.tl));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("WebViewRender", e6.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i6) {
        try {
            if (h.j() && i6 == 0) {
                long yl = com.bytedance.sdk.openadsdk.core.v.xt().yl();
                if (this.mi != -1 && System.currentTimeMillis() - this.mi > yl) {
                    SSWebView j6 = j();
                    WebView webView = j6.getWebView();
                    j6.removeView(webView);
                    j6.addView(webView);
                }
                this.mi = -1L;
                return;
            }
            this.mi = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    public SSWebView j() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    protected void j(boolean z5, int i6) {
        super.j(z5, i6);
        com.bytedance.sdk.openadsdk.m.j jVar = this.f29708g;
        if (jVar != null) {
            jVar.j(z5, i6);
            this.f29708g.xt(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.j
    protected void j(float f6, float f7) {
        float f8 = this.f29710m.getResources().getDisplayMetrics().density;
        float f9 = Resources.getSystem().getDisplayMetrics().density;
        super.j(ed.xt(f8, ed.j(f9, f6)), ed.xt(f8, ed.j(f9, f7)));
    }
}
