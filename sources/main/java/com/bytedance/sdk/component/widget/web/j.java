package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    private final Object f27252j;
    private final String xt;

    @JavascriptInterface
    public void adAnalysisData(String str) {
        j("adAnalysisData", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object j6 = j("adInfo", new Object[0]);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object j6 = j("appInfo", new Object[0]);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        j("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        j("clickEvent", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        j("dynamicTrack", str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object j6 = j("getCurrentVideoState", new Object[0]);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public String getData(String str) {
        Object j6 = j("getData", str);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object j6 = j("getTemplateInfo", new Object[0]);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public void getUrl(String str) {
        j("getUrl", str);
    }

    @JavascriptInterface
    public void initRenderFinish() {
        j("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return j("invokeMethod", str);
    }

    public Object j() {
        return this.f27252j;
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        j("muteVideo", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        j("readHtml", str, str2);
    }

    @JavascriptInterface
    public void readPercent(String str) {
        j("readPercent", str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        j("renderDidFinish", str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        j("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object j6 = j("sendNetworkSwitch", str);
        return j6 != null ? j6.toString() : "";
    }

    @JavascriptInterface
    public void skipVideo() {
        j("skipVideo", new Object[0]);
    }

    private Object j(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i6 = 0; i6 < objArr.length; i6++) {
                        clsArr[i6] = objArr[i6].getClass();
                    }
                    declaredMethod = this.f27252j.getClass().getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(this.f27252j, objArr);
                }
            } catch (Exception e6) {
                vl.xt("JavascriptInterfaceProxy", "invokeMethod name= ".concat(String.valueOf(str)), e6);
                return null;
            }
        }
        declaredMethod = this.f27252j.getClass().getDeclaredMethod(str, null);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.f27252j, objArr);
    }

    public String xt() {
        return this.xt;
    }

    public j(Object obj, String str) {
        this.f27252j = obj;
        this.xt = str;
    }
}
