package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.jy.cw;
import com.bytedance.sdk.component.jy.j;
import com.bytedance.sdk.component.jy.xt;
import com.bytedance.sdk.component.utils.tl;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.jy.j {

    /* renamed from: r, reason: collision with root package name */
    public static com.bytedance.sdk.component.widget.j f27177r = null;
    private static int up = 1;
    private j.InterfaceC0411j ae;
    protected WebViewImpl cw;

    /* renamed from: g, reason: collision with root package name */
    private Map<cw, Set<String>> f27178g;

    /* renamed from: j, reason: collision with root package name */
    protected final AtomicInteger f27179j;

    /* renamed from: m, reason: collision with root package name */
    private long f27180m;
    private Deque<cw> tl;
    protected volatile cw xt;

    public MultiWebview(Context context) {
        this(context, null);
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cw ae() {
        if (this.tl.size() < 2) {
            this.xt = this.cw;
            return null;
        }
        cw pollLast = this.tl.pollLast();
        if (pollLast != null) {
            removeView(pollLast.getView());
            pollLast.destroy();
            this.f27178g.remove(pollLast);
        }
        cw last = this.tl.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.xt = last;
        }
        return pollLast;
    }

    private cw cw() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.j jVar = f27177r;
            if (jVar == null) {
                return null;
            }
            jVar.j(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.cw == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.cw.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.cw.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.tl.add(this.cw);
        this.xt = this.cw;
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.j jVar) {
        f27177r = jVar;
    }

    public static void setMaxWebViewCount(int i6) {
        up = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cw xt(String str) {
        cw cw = cw();
        if (cw != null) {
            cw cwVar = this.xt;
            this.tl.add(cw);
            this.xt = cw;
            addView(cw.getView(), new FrameLayout.LayoutParams(-1, -1));
            j(cw);
            cw.loadUrl(str);
            if (cwVar != null) {
                cwVar.onPause();
                cwVar.setVisibility(8);
            }
        }
        return cw;
    }

    public void G_() {
        this.f27178g.clear();
        this.ae = null;
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.m();
            }
        });
    }

    public void destroy() {
        while (true) {
            cw pollLast = this.tl.pollLast();
            if (pollLast == null) {
                this.cw = null;
                this.xt = null;
                this.f27178g.clear();
                this.ae = null;
                return;
            }
            pollLast.destroy();
        }
    }

    public long getCreateDuration() {
        return this.f27180m;
    }

    public cw getCurrentWebView() {
        return this.xt;
    }

    public int getWebViewCount() {
        return this.tl.size();
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i6) {
        super(context, attributeSet, i6);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f27179j = atomicInteger;
        this.tl = new LinkedList();
        this.f27178g = new ConcurrentHashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (up()) {
            this.cw = j(context, attributeSet, i6);
            r();
            this.f27180m = System.currentTimeMillis() - currentTimeMillis;
            return;
        }
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.cw = multiWebview.j(context, attributeSet, i6);
                MultiWebview.this.r();
                MultiWebview.this.f27180m = System.currentTimeMillis() - currentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        while (true) {
            cw j6 = j();
            if (j6 == null) {
                break;
            } else {
                removeView(j6.getView());
            }
        }
        WebViewImpl webViewImpl = this.cw;
        if (webViewImpl != null) {
            webViewImpl.xt();
        }
    }

    protected boolean up() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl j(Context context, AttributeSet attributeSet, int i6) {
        WebViewImpl webViewImpl;
        try {
            this.f27179j.set(2);
            if (i6 == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i6);
            }
            this.f27179j.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.f27179j.set(4);
            if (f27177r == null) {
                return null;
            }
            f27177r.j(Thread.currentThread().getName(), th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.jy.j
    public void xt(cw cwVar, String str) {
        Set<String> set;
        if (cwVar == null || str == null || (set = this.f27178g.get(cwVar)) == null) {
            return;
        }
        set.remove(str);
    }

    @Override // com.bytedance.sdk.component.jy.j
    public int j(final String str) {
        cw cwVar;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (up == 1) {
            return 2;
        }
        if (getWebViewCount() >= up) {
            return 1;
        }
        if (up()) {
            cwVar = xt(str);
        } else {
            final cw[] cwVarArr = new cw[1];
            final Object obj = new Object();
            j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    cwVarArr[0] = MultiWebview.this.xt(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (cwVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            cwVar = cwVarArr[0];
        }
        return cwVar != null ? 0 : -999;
    }

    private void j(cw cwVar) {
        j jVar;
        Object j6;
        WebViewImpl webViewImpl = this.cw;
        if (webViewImpl == null || cwVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            cwVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            cwVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            cwVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            cwVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            cwVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            cwVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            cwVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            cwVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            cwVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            cwVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            cwVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            cwVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            cwVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            cwVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            cwVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            cwVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            cwVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            cwVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            cwVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            cwVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            cwVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            cwVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            cwVar.setUserAgentString(userAgentString);
        }
        xt.j onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            cwVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            cwVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            cwVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.xt client = webViewImpl.getClient();
        if (client != null) {
            cwVar.setWebViewClient(client.j());
        }
        Map<String, j> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (jVar = javascriptInterfaces.get(str)) != null && (j6 = jVar.j()) != null) {
                    cwVar.addJavascriptInterface(j6, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.jy.j
    public cw j() {
        if (up()) {
            return ae();
        }
        final cw[] cwVarArr = new cw[1];
        final Object obj = new Object();
        j(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                cwVarArr[0] = MultiWebview.this.ae();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (cwVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return cwVarArr[0];
    }

    @Override // com.bytedance.sdk.component.jy.j
    public void j(cw cwVar, String str, String str2, Object obj) {
        if (str2 == null || cwVar == null) {
            return;
        }
        for (cw cwVar2 : this.f27178g.keySet()) {
            if (cwVar2 != null && cwVar != cwVar2) {
                Set<String> set = this.f27178g.get(cwVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    cwVar2.j(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.jy.j
    public void j(cw cwVar, String str) {
        if (cwVar == null || str == null) {
            return;
        }
        Set<String> set = this.f27178g.get(cwVar);
        if (set == null) {
            set = new HashSet<>();
            this.f27178g.put(cwVar, set);
        }
        set.add(str);
    }

    protected void j(Runnable runnable) {
        j(runnable, false);
    }

    protected void j(final Runnable runnable, boolean z5) {
        if (up()) {
            runnable.run();
        } else if (z5) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.up()) {
                        runnable.run();
                    } else {
                        tl.xt().post(runnable);
                    }
                }
            });
        } else {
            tl.xt().post(runnable);
        }
    }
}
