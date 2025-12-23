package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.jy.cw;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt extends j {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.component.jy.j f27253j;
    private final WebViewImpl xt;

    private boolean j(JSONObject jSONObject) {
        JSONObject xt = xt(jSONObject, "addWebviewListener");
        if (xt == null) {
            return false;
        }
        String optString = xt.optString("event");
        if (optString == null || optString.length() <= 0) {
            return true;
        }
        this.f27253j.j(this.xt, optString);
        return true;
    }

    private boolean xt(JSONObject jSONObject) {
        JSONObject xt = xt(jSONObject, "removeWebviewListener");
        if (xt == null) {
            return false;
        }
        String optString = xt.optString("event");
        if (optString == null || optString.length() <= 0) {
            return true;
        }
        this.f27253j.xt(this.xt, optString);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.j
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            if (up(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("pushWebview")) {
            if (r(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("addWebviewListener")) {
            if (j(new JSONObject(str))) {
                return null;
            }
        } else {
            if (!str.contains("removeWebviewListener")) {
                if (str.contains("sendWebviewEvent")) {
                    if (cw(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
            if (xt(new JSONObject(str))) {
                return null;
            }
        }
        return super.invokeMethod(str);
    }

    private boolean cw(JSONObject jSONObject) {
        JSONObject xt = xt(jSONObject, "sendWebviewEvent");
        if (xt == null) {
            return false;
        }
        String optString = xt.optString("event");
        if (optString == null) {
            return true;
        }
        this.f27253j.j(this.xt, xt(), optString, xt.opt("param"));
        return true;
    }

    private boolean r(JSONObject jSONObject) {
        JSONObject xt = xt(jSONObject, "pushWebview");
        if (xt == null) {
            return false;
        }
        int j6 = this.f27253j.j(xt.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(j6));
            jSONObject2.putOpt("result", Boolean.valueOf(j6 == 0));
        } catch (Exception unused) {
        }
        this.xt.j(xt(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean up(JSONObject jSONObject) {
        if (!j(jSONObject, "popWebview")) {
            return false;
        }
        cw j6 = this.f27253j.j();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(j6 == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(j6 != null));
        } catch (Exception unused) {
        }
        this.xt.j(xt(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    public xt(Object obj, String str, com.bytedance.sdk.component.jy.j jVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.f27253j = jVar;
        this.xt = webViewImpl;
    }

    private boolean j(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject xt(JSONObject jSONObject, String str) {
        if (j(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }
}
