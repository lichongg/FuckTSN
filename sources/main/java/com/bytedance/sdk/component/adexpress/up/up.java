package com.bytedance.sdk.component.adexpress.up;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.j.ch;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private static int ae = 10;

    /* renamed from: g, reason: collision with root package name */
    private static volatile up f25858g = null;

    /* renamed from: m, reason: collision with root package name */
    private static int f25859m = 10;
    private static final byte[] up = new byte[0];
    private final AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private final List<SSWebView> f25860j = new ArrayList();
    private final List<SSWebView> xt = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.jy.cw, cw> cw = new WeakHashMap<>();

    /* renamed from: r, reason: collision with root package name */
    private final WeakHashMap<com.bytedance.sdk.component.jy.cw, r> f25861r = new WeakHashMap<>();

    public static up j() {
        if (f25858g == null) {
            synchronized (up.class) {
                try {
                    if (f25858g == null) {
                        f25858g = new up();
                    }
                } finally {
                }
            }
        }
        return f25858g;
    }

    @UiThread
    public void cw(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        m(sSWebView);
        r(sSWebView);
    }

    public void r(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.f25860j.size() >= f25859m) {
            sSWebView.destroy();
        } else {
            if (this.f25860j.contains(sSWebView)) {
                return;
            }
            this.f25860j.add(sSWebView);
            cw();
        }
    }

    public boolean up(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    @UiThread
    public void xt(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        m(sSWebView);
        j(sSWebView);
    }

    public void m(SSWebView sSWebView) {
        cw cwVar;
        if (sSWebView == null || (cwVar = this.cw.get(sSWebView)) == null) {
            return;
        }
        cwVar.j(null);
    }

    public int up() {
        return this.f25860j.size() + r();
    }

    private up() {
        com.bytedance.sdk.component.adexpress.j.j.cw cw = com.bytedance.sdk.component.adexpress.j.j.j.j().cw();
        if (cw != null) {
            f25859m = cw.tl();
            ae = cw.g();
        }
    }

    public int cw() {
        return this.f25860j.size();
    }

    public SSWebView xt(Context context, String str) {
        SSWebView remove;
        if (cw() <= 0 || (remove = this.f25860j.remove(0)) == null) {
            return null;
        }
        cw();
        return remove;
    }

    public int r() {
        return this.xt.size();
    }

    public SSWebView j(Context context, String str) {
        SSWebView remove;
        if (r() <= 0 || (remove = this.xt.remove(0)) == null) {
            return null;
        }
        this.xt.size();
        return remove;
    }

    public void xt() {
        for (SSWebView sSWebView : this.f25860j) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.f25860j.clear();
        for (SSWebView sSWebView2 : this.xt) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.xt.clear();
        synchronized (this.f25861r) {
            this.f25861r.clear();
        }
    }

    public void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.xt.size() >= ae) {
            sSWebView.destroy();
        } else {
            if (this.xt.contains(sSWebView)) {
                return;
            }
            this.xt.add(sSWebView);
            this.xt.size();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void j(SSWebView sSWebView, xt xtVar) {
        if (sSWebView == null || xtVar == null) {
            return;
        }
        cw cwVar = this.cw.get(sSWebView);
        if (cwVar != null) {
            cwVar.j(xtVar);
        } else {
            cwVar = new cw(xtVar);
            this.cw.put(sSWebView, cwVar);
        }
        sSWebView.addJavascriptInterface(cwVar, "SDK_INJECT_GLOBAL");
    }

    private static void j(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            tl.xt().post(runnable);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void j(final com.bytedance.sdk.component.jy.cw cwVar, ch chVar, final String str) {
        final r rVar;
        if (cwVar == null || chVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f25861r) {
            try {
                rVar = this.f25861r.get(cwVar);
                if (rVar != null) {
                    rVar.j(chVar);
                } else {
                    rVar = new r(chVar);
                    this.f25861r.put(cwVar, rVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.up.up.1
            @Override // java.lang.Runnable
            public void run() {
                cwVar.addJavascriptInterface(rVar, str);
            }
        });
    }

    public void j(final com.bytedance.sdk.component.jy.cw cwVar, final String str) {
        if (cwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f25861r) {
            try {
                r rVar = this.f25861r.get(cwVar);
                if (rVar != null) {
                    rVar.j(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.up.up.2
            @Override // java.lang.Runnable
            public void run() {
                cwVar.removeJavascriptInterface(str);
            }
        });
    }
}
