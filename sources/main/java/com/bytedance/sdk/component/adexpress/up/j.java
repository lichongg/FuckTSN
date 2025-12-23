package com.bytedance.sdk.component.adexpress.up;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xt.ae;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.adexpress.xt.qv;
import com.bytedance.sdk.component.adexpress.xt.tl;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.widget.SSWebView;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements com.bytedance.sdk.component.adexpress.j, com.bytedance.sdk.component.adexpress.theme.j, qv, com.bytedance.sdk.component.adexpress.xt.r<SSWebView> {
    private String ae;
    protected SSWebView cw;

    /* renamed from: g, reason: collision with root package name */
    private volatile ae f25851g;

    /* renamed from: j, reason: collision with root package name */
    protected JSONObject f25852j;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private Context f25853m;
    private boolean oq;
    private tl qv;
    private String tl;
    private jy vl;
    private int ws;
    protected boolean xt;

    /* renamed from: r, reason: collision with root package name */
    protected int f25854r = 8;
    protected AtomicBoolean up = new AtomicBoolean(false);
    private boolean az = false;

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public int cw() {
        return 0;
    }

    protected void j(boolean z5, int i6) {
    }

    public abstract void m();

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public SSWebView ae() {
        return j();
    }

    public abstract void xt(int i6);

    private SSWebView jy() {
        return this.vl.s() ? up.j().j(this.f25853m, this.ae) : up.j().xt(this.f25853m, this.ae);
    }

    private void vl() {
        if (this.f25853m == null && com.bytedance.sdk.component.adexpress.r.getContext() != null) {
            this.f25853m = com.bytedance.sdk.component.adexpress.r.getContext();
        }
        if (this.f25853m != null) {
            SSWebView jy = jy();
            this.cw = jy;
            if (jy == null) {
                this.cw = new SSWebView(new MutableContextWrapper(StubApp.getOrigApplicationContext(this.f25853m.getApplicationContext())));
            } else {
                this.oq = true;
            }
        }
    }

    private void ws() {
        if (this.vl.s()) {
            up.j().xt(this.cw);
        } else {
            up.j().cw(this.cw);
        }
    }

    private int xt(Activity activity) {
        return activity.hashCode();
    }

    public void j(String str) {
        this.tl = str;
    }

    public jy qv() {
        return this.vl;
    }

    public void r() {
        if (this.up.get()) {
            return;
        }
        this.up.set(true);
        m();
        if (this.cw.getParent() != null) {
            ((ViewGroup) this.cw.getParent()).removeView(this.cw);
        }
        if (this.xt) {
            ws();
        } else {
            up.j().up(this.cw);
        }
    }

    public j(Context context, jy jyVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.oq = false;
        this.f25853m = context;
        this.vl = jyVar;
        this.ae = jyVar.m();
        themeStatusBroadcastReceiver.j(this);
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            vl();
            return;
        }
        SSWebView jy = jy();
        this.cw = jy;
        if (jy == null) {
            if (com.bytedance.sdk.component.adexpress.r.getContext() != null) {
                this.cw = new SSWebView(com.bytedance.sdk.component.adexpress.r.getContext());
                return;
            }
            return;
        }
        this.oq = true;
    }

    public SSWebView j() {
        return this.cw;
    }

    public void tl() {
        g();
        Activity j6 = com.bytedance.sdk.component.utils.xt.j(this.cw);
        if (j6 != null) {
            this.ws = xt(j6);
        }
    }

    public void up() {
        if (j() != null) {
            try {
                j().getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public void j(tl tlVar) {
        this.qv = tlVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public void j(ae aeVar) {
        this.f25851g = aeVar;
        if (j() != null && j().getWebView() != null) {
            if (TextUtils.isEmpty(this.tl)) {
                this.f25851g.j(102, "url is empty");
                return;
            }
            if (!this.vl.s()) {
                if (!this.az && !com.bytedance.sdk.component.adexpress.j.xt.xt.j(this.f25852j)) {
                    ae aeVar2 = this.f25851g;
                    StringBuilder sb = new StringBuilder("data null is ");
                    sb.append(this.f25852j == null);
                    aeVar2.j(103, sb.toString());
                    return;
                }
                if (this.az && !com.bytedance.sdk.component.adexpress.j.xt.xt.cw(this.f25852j)) {
                    ae aeVar3 = this.f25851g;
                    StringBuilder sb2 = new StringBuilder("choice ad data null is ");
                    sb2.append(this.f25852j == null);
                    aeVar3.j(103, sb2.toString());
                    return;
                }
            } else if (cw() == 9 && !com.bytedance.sdk.component.adexpress.j.xt.xt.xt(this.f25852j)) {
                ae aeVar4 = this.f25851g;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.f25852j == null);
                aeVar4.j(103, sb3.toString());
                return;
            }
            this.vl.ae().xt(this.oq);
            if (this.oq) {
                try {
                    this.cw.clearView();
                    this.vl.ae().ae();
                    com.bytedance.sdk.component.utils.qv.j(this.cw.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception e6) {
                    up.j().up(this.cw);
                    this.f25851g.j(102, "load exception is " + e6.getMessage());
                    return;
                }
            }
            SSWebView j6 = j();
            j6.clearView();
            this.vl.ae().ae();
            j6.loadUrl(this.tl);
            return;
        }
        ae aeVar5 = this.f25851g;
        StringBuilder sb4 = new StringBuilder("SSWebview null is ");
        sb4.append(j() == null);
        sb4.append(" or Webview is null");
        aeVar5.j(102, sb4.toString());
    }

    protected void g() {
    }

    protected void oq() {
    }

    public void j(boolean z5) {
        this.jy = z5;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(final ws wsVar) {
        if (wsVar == null) {
            if (this.f25851g != null) {
                this.f25851g.j(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean cw = wsVar.cw();
        final float r5 = (float) wsVar.r();
        final float up = (float) wsVar.up();
        if (cw() == 0 && (r5 <= 0.0f || up <= 0.0f)) {
            if (this.f25851g != null) {
                this.f25851g.j(105, "width is " + r5 + "height is " + up);
                return;
            }
            return;
        }
        this.xt = cw;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            j(wsVar, r5, up);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.up.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.j(wsVar, r5, up);
                }
            });
        }
    }

    protected void j(ws wsVar, float f6, float f7) {
        j(this.xt, wsVar.qv());
        boolean z5 = this.xt;
        if (z5 && !this.jy) {
            j(f6, f7);
            xt(this.f25854r);
            if (this.f25851g != null) {
                this.f25851g.j(j(), wsVar);
                return;
            }
            return;
        }
        if (!z5) {
            up.j().up(this.cw);
        }
        j(wsVar.qv(), wsVar.oq());
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
        tl tlVar = this.qv;
        if (tlVar != null) {
            tlVar.j(view, i6, cwVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.qv
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
        tl tlVar = this.qv;
        if (tlVar != null) {
            tlVar.j(view, i6, cwVar, i7);
        }
    }

    @UiThread
    protected void j(float f6, float f7) {
        this.vl.ae().tl();
        if (com.bytedance.sdk.component.adexpress.r.j() && cw() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) j().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            j().setLayoutParams(layoutParams);
            return;
        }
        int j6 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.f25853m, f6);
        int j7 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.f25853m, f7);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) j().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(j6, j7);
        }
        layoutParams2.width = j6;
        layoutParams2.height = j7;
        j().setLayoutParams(layoutParams2);
    }

    private void j(int i6, String str) {
        if (this.f25851g != null) {
            this.f25851g.j(i6, str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.j
    public void j(Activity activity) {
        if (this.ws == 0 || activity == null || activity.hashCode() != this.ws) {
            return;
        }
        r();
        oq();
    }
}
