package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cb;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends WebView {
    private boolean aMS;
    private com.kwad.sdk.core.webview.a.a aMT;

    public c(Context context) {
        super(bT(context));
        this.aMS = true;
        init();
    }

    private static Context bT(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context el = m.el(context);
        if (m.eo(el)) {
            return el;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + el.getClass().getName() + "--classloader:" + el.getClass().getClassLoader() + "--context2:" + m.el(ServiceProvider.Pp()).getClass().getName()));
        return m.el(ServiceProvider.Pp());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aMS) {
            release();
        }
    }

    public void setEnableDestroy(boolean z5) {
        this.aMS = z5;
    }

    public void setNeedHybridLoad(boolean z5) {
        this.aMT.setNeedHybridLoad(z5);
    }

    private void init() {
        cb.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aMT = aVar;
        setWebViewClient(aVar);
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bT(context), attributeSet);
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i6) {
        super(bT(context), attributeSet, i6);
        this.aMS = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(bT(context), attributeSet, i6, i7);
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i6, boolean z5) {
        super(bT(context), attributeSet, i6, z5);
        this.aMS = true;
        init();
    }
}
