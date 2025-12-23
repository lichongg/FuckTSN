package com.bxkj.base.v2.h5;

import android.webkit.WebView;
import com.bxkj.base.v2.data.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class n {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WebView webView) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        String J = aVar.a().J();
        String g6 = aVar.a().g();
        String R = aVar.a().R();
        String S = aVar.a().S();
        String m6 = aVar.a().m();
        String str = "window.localStorage.setItem('uniIdToken','" + g6 + "');window.localStorage.setItem('userid','" + R + "');window.localStorage.setItem('school','" + J + "');window.localStorage.setItem('username','" + S + "');window.localStorage.setItem('login_type','online');window.localStorage.setItem('category','" + m6 + "');";
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function({ var localStorage = window.localStorage;localStorage.setItem('uniIdToken','");
        sb.append(g6);
        sb.append("');localStorage.setItem('userid','");
        sb.append(R);
        sb.append("');localStorage.setItem('school','");
        sb.append(J);
        sb.append("');localStorage.setItem('username','");
        sb.append(S);
        sb.append("');localStorage.setItem('login_type','");
        sb.append("online");
        sb.append("');localStorage.setItem('category','");
        sb.append(m6);
        sb.append("'); })()");
        if (webView != null) {
            webView.evaluateJavascript(str, null);
        }
    }
}
