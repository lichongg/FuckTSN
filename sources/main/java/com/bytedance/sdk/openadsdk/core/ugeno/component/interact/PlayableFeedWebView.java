package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.jy.xt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.az.tl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.av;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class PlayableFeedWebView extends SSWebView implements xt.j, com.bytedance.sdk.openadsdk.core.f.cw, g {
    private final n ae;
    private final Runnable av;
    private final Runnable az;

    /* renamed from: g, reason: collision with root package name */
    private av f30582g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.az.tl f30583i;
    private boolean jy;
    private av kt;

    /* renamed from: m, reason: collision with root package name */
    private rn f30584m;
    private av mi;
    private final ViewGroup oq;
    private boolean qv;
    private double tj;
    private com.bytedance.sdk.openadsdk.core.f.xt tl;
    private final Context up;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.qv f30585w;
    private int ws;

    private void qv() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        j((SSWebView) this);
        if (this.ae != null) {
            Context context = this.up;
            rn rnVar = this.f30584m;
            n nVar = this.ae;
            setWebViewClient(new j(context, rnVar, nVar, nVar.fs()));
        }
        com.bytedance.sdk.component.adexpress.up.up.j().j(this, this.f30584m);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.f30584m));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.jy.cw
    public void destroy() {
        this.vl = null;
        I_();
        setOnShakeListener(null);
        rn rnVar = this.f30584m;
        if (rnVar != null) {
            rnVar.up();
            this.f30584m.j((SSWebView.xt) null);
        }
        this.f30584m = null;
        super.destroy();
    }

    public void m() {
        this.jy = true;
        rn rnVar = this.f30584m;
        if (rnVar != null) {
            rnVar.la();
        }
    }

    public void tl() {
        j(false);
    }

    public static class j extends com.bytedance.sdk.openadsdk.core.widget.j.r {

        /* renamed from: j, reason: collision with root package name */
        private n f30593j;

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.j.xt.j j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.j(webView, this.f30593j, str, new j.InterfaceC0467j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.j.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.InterfaceC0467j
                    public boolean j() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.InterfaceC0467j
                    public com.bytedance.sdk.component.adexpress.j.xt.j j(String str2, oq.j jVar, String str3) {
                        com.bytedance.sdk.component.adexpress.j.xt.j jVar2 = new com.bytedance.sdk.component.adexpress.j.xt.j();
                        jVar2.j(5);
                        jVar2.j(com.bytedance.sdk.openadsdk.core.ugeno.up.j.xt().j(webView, jVar, str2));
                        return jVar2;
                    }
                });
                if (j6 != null && j6.j() != null) {
                    return j6.j();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public j(Context context, rn rnVar, n nVar, String str) {
            super(context, rnVar, str);
            this.f30593j = nVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    private void g() {
        com.bytedance.sdk.openadsdk.core.mi.cw cwVar = new com.bytedance.sdk.openadsdk.core.mi.cw();
        com.bytedance.sdk.openadsdk.core.mi.up upVar = new com.bytedance.sdk.openadsdk.core.mi.up(this.f30584m);
        com.bytedance.sdk.openadsdk.core.mi.r rVar = new com.bytedance.sdk.openadsdk.core.mi.r();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.bytedance.sdk.openadsdk.az.tl cw = cwVar.j(v.getContext(), this, upVar, rVar, hashSet, tl.j.OTHER).up(getUrl()).r(com.bytedance.sdk.openadsdk.core.tl.j.ae()).j(com.bytedance.sdk.openadsdk.core.tl.j.j()).j("sdkEdition", com.bytedance.sdk.openadsdk.core.tl.j.cw()).xt(com.bytedance.sdk.openadsdk.core.tl.j.up()).cw(com.bytedance.sdk.openadsdk.core.tl.j.r()).cw(false);
        this.f30583i = cw;
        Set<String> oq = cw.oq();
        if (this.f30584m == null || oq == null || oq.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.f30583i);
        Iterator<String> it = oq.iterator();
        while (it.hasNext()) {
            this.f30584m.m().j(it.next(), (com.bytedance.sdk.component.j.up<?, ?>) new com.bytedance.sdk.component.j.up<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.4
                @Override // com.bytedance.sdk.component.j.up
                public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.az.tl tlVar = (com.bytedance.sdk.openadsdk.az.tl) weakReference.get();
                        if (tlVar == null) {
                            return null;
                        }
                        return tlVar.r(j(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    private void oq() {
        rn rnVar = new rn(this.up);
        this.f30584m = rnVar;
        rnVar.xt(this).j(this.ae).xt(this.ae.fs()).cw(this.ae.os()).j(uf.xt(this.ae)).r(uf.av(this.ae)).j((g) this).m(com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(0.0f, 0.0f, false, this.ae)).j(this.f30585w).j((SSWebView) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        j(Integer.MIN_VALUE, Integer.MIN_VALUE, this.oq.getWidth(), this.oq.getHeight());
        oq();
        g();
        qv();
        loadUrl(a.up(this.ae).j(this.oq.getWidth() <= this.oq.getHeight()));
        setExpressVideoListener(this.vl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public boolean E_() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void F_() {
        if (this.f30584m == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.a(this, this.f30584m, this.ae));
        if (this.tl != null) {
            this.tl.j(true, getMaxRectJson());
        }
        xt(getVisibility());
    }

    public void ae() {
        if (this.qv) {
            return;
        }
        this.qv = true;
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void cw() {
        if (this.tl != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.xt("xeasy", e6.getMessage());
            }
            this.tl.j(false, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.cw
    public JSONObject getActualRectJson() {
        return av.j(this.kt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.oq.getLeft();
            int top2 = this.oq.getTop();
            jSONArray.put(0, ed.r(getContext(), left));
            jSONArray.put(1, ed.r(getContext(), top2));
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.oq.getMeasuredWidth();
            int measuredHeight = this.oq.getMeasuredHeight();
            jSONArray2.put(0, ed.r(getContext(), measuredWidth));
            jSONArray2.put(1, ed.r(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("xeasy", e6.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.bytedance.sdk.openadsdk.core.f.xt xtVar = this.tl;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.cw
    public double getExceedAreaRate() {
        return this.tj;
    }

    public rn getJsObject() {
        return this.f30584m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.cw
    public JSONObject getMaxRectJson() {
        return av.j(this.mi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void j(av avVar, double d6) {
        this.mi = avVar;
        this.tj = d6;
        this.f30582g = avVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void r() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j jVar = this.vl;
        if (jVar != null) {
            jVar.j((View) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void setEasyPlayInteractionAreaInfo(av avVar) {
        this.kt = avVar;
    }

    public void setEasyPlayableListener(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j jVar) {
        this.vl = jVar;
    }

    public void setExpressVideoListener(com.bytedance.sdk.openadsdk.core.nativeexpress.qv qvVar) {
        rn rnVar = this.f30584m;
        if (rnVar != null) {
            rnVar.j(qvVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void xt() {
        com.bytedance.sdk.openadsdk.core.f.xt xtVar = this.tl;
        if (xtVar != null) {
            xtVar.cw();
        }
    }

    public PlayableFeedWebView(com.bytedance.sdk.openadsdk.core.f.xt xtVar, ViewGroup viewGroup) {
        super(xtVar.getContext());
        this.qv = false;
        this.jy = false;
        this.ws = 8;
        this.az = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.xt(0);
            }
        };
        this.av = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.xt(8);
            }
        };
        this.f30585w = new com.bytedance.sdk.component.adexpress.xt.qv() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.3
            @Override // com.bytedance.sdk.component.adexpress.xt.qv
            public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
            }

            @Override // com.bytedance.sdk.component.adexpress.xt.qv
            public void j(ws wsVar) {
            }

            @Override // com.bytedance.sdk.component.adexpress.xt.qv
            public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                PlayableFeedWebView.this.vl.xt(view, i6, cwVar);
            }
        };
        this.tl = xtVar;
        this.up = xtVar.getContext();
        this.ae = xtVar.j();
        this.oq = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.jy.cw
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i6) {
        boolean z5;
        super.onVisibilityChanged(view, i6);
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        j(z5);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        j(z5);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        removeCallbacks(this.av);
        removeCallbacks(this.az);
        if (i6 == 0) {
            postDelayed(this.az, 50L);
        } else {
            postDelayed(this.av, 50L);
        }
    }

    public void xt(int i6) {
        if (i6 == this.ws) {
            return;
        }
        this.ws = i6;
        if (this.f30584m == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", i6 == 0);
            this.f30584m.j("expressAdShow", jSONObject);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public void j(final int i6, final int i7, final int i8, final int i9) {
        com.bytedance.sdk.openadsdk.l.ae.j((Runnable) new com.bytedance.sdk.component.oq.g("changeFrame") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
                int i10 = i6;
                if (i10 == Integer.MIN_VALUE && i7 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                if (i10 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i10);
                }
                int i11 = i7;
                if (i11 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i11);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.up).j(false).j(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            kt.j(sSWebView, h.xt, n.r(this.ae));
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
            com.bytedance.sdk.component.utils.vl.r("xeasy", e6.toString());
        }
    }

    public void j(boolean z5) {
        rn rnVar = this.f30584m;
        if (rnVar != null) {
            rnVar.qv(z5);
        }
    }

    @Override // com.bytedance.sdk.component.jy.xt.j
    public Pair<Boolean, Boolean> j(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        int r5 = ed.r(getContext(), x5);
        int r6 = ed.r(getContext(), y5);
        av avVar = this.f30582g;
        if (avVar == null || avVar.j(r5, r6)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f.xt.j(this.ae, r5, r6, 2);
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }
}
