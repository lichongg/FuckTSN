package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.b;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends b.a {

    /* renamed from: d, reason: collision with root package name */
    private String f40689d;

    @Override // com.tencent.open.b.a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    private void b(String str) {
        WebView webView = this.f40513a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f40689d);
            stringBuffer.append("){");
            stringBuffer.append(this.f40689d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.b.a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    public c(WebView webView, long j6, String str, String str2) {
        super(webView, j6, str);
        this.f40689d = str2;
    }

    @Override // com.tencent.open.b.a
    public void a(String str) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !d.f40557a ? -4 : 0);
            jSONObject.put("sn", this.f40514b);
            jSONObject.put("data", str);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
