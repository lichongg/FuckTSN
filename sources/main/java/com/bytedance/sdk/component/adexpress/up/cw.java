package com.bytedance.sdk.component.adexpress.up;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<xt> f25850j;

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<xt> weakReference = this.f25850j;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f25850j.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<xt> weakReference = this.f25850j;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f25850j.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<xt> weakReference = this.f25850j;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f25850j.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f25850j.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<xt> weakReference = this.f25850j;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f25850j.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().initRenderFinish();
    }

    public void j(xt xtVar) {
        if (xtVar == null) {
            this.f25850j = null;
        } else {
            this.f25850j = new WeakReference<>(xtVar);
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<xt> weakReference = this.f25850j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25850j.get().skipVideo();
    }

    public cw(xt xtVar) {
        this.f25850j = new WeakReference<>(xtVar);
    }
}
