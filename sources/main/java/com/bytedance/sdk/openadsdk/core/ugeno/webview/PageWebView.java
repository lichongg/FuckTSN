package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.av.r;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.widget.j.cw;
import com.bytedance.sdk.openadsdk.core.widget.j.xt;
import com.bytedance.sdk.openadsdk.l.ae;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class PageWebView extends FrameLayout implements r {

    /* renamed from: j, reason: collision with root package name */
    private static final SparseArray<WeakReference<DownloadListener>> f30838j = new SparseArray<>();
    private Context cw;

    /* renamed from: m, reason: collision with root package name */
    private ws f30839m;

    /* renamed from: r, reason: collision with root package name */
    private n f30840r;
    private rn up;
    private SSWebView xt;

    @Override // com.bytedance.sdk.openadsdk.core.av.r
    public void j(boolean z5, JSONArray jSONArray) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        xt.j(this.cw).j(false).xt(false).j(this.xt);
        SSWebView sSWebView = this.xt;
        if (sSWebView != null) {
            kt.j(sSWebView, h.xt, n.r(this.f30840r));
        }
        this.xt.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = f30838j.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.xt.setDownloadListener(weakReference.get());
    }

    public void setMeta(n nVar) {
        this.f30840r = nVar;
        SSWebView sSWebView = this.xt;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.rn.rn.j(nVar));
        }
    }

    public void setUGenContext(ws wsVar) {
        this.f30839m = wsVar;
    }

    public void xt(final JSONObject jSONObject) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.cw(jSONObject);
            }
        });
    }

    public PageWebView(@NonNull Context context) {
        super(context);
        this.cw = context;
        SSWebView sSWebView = new SSWebView(context);
        this.xt = sSWebView;
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.rn.rn.j(this.f30840r));
        addView(this.xt);
    }

    public static void j(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        f30838j.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            f30838j.remove(jSONObject.hashCode());
        }
    }

    public void j() {
        Map<String, Object> xt;
        if (this.xt == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f30840r);
        this.up = new rn(this.cw);
        ws wsVar = this.f30839m;
        if (wsVar != null && (xt = wsVar.xt()) != null && xt.containsKey("key_reward_page")) {
            Object obj = xt.get("key_reward_page");
            if (obj instanceof Map) {
                this.up.j((Map<String, Object>) obj);
            }
        }
        this.up.xt(this.xt).j(this.f30840r).cw(arrayList).xt(this.f30840r.fs()).cw(this.f30840r.os()).cw(7).j(uf.xt(this.f30840r)).r(uf.av(this.f30840r)).j(this.xt).j(true).xt(oq.j(this.f30840r)).j((r) this);
        this.xt.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.cw, this.up, this.f30840r.fs(), new com.bytedance.sdk.openadsdk.core.jy.r(this.f30840r, this.xt), null));
        this.xt.setWebChromeClient(new cw(this.up));
    }

    public void j(String str) {
        SSWebView sSWebView = this.xt;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
