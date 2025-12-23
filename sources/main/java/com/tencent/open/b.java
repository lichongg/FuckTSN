package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, C0813b> f40511a = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.b$b, reason: collision with other inner class name */
    public static class C0813b {
        public boolean customCallback() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x0148, code lost:
        
            r20.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x014c, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r18, java.util.List<java.lang.String> r19, com.tencent.open.b.a r20) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.C0813b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }
    }

    public void a(C0813b c0813b, String str) {
        this.f40511a.put(str, c0813b);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<WebView> f40513a;

        /* renamed from: b, reason: collision with root package name */
        protected long f40514b;

        /* renamed from: c, reason: collision with root package name */
        protected String f40515c;

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f40513a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f40514b + ",{'r':0,'result':" + obj2 + "});");
        }

        public a(WebView webView, long j6, String str) {
            this.f40513a = new WeakReference<>(webView);
            this.f40514b = j6;
            this.f40515c = str;
        }

        public void a() {
            WebView webView = this.f40513a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f40514b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f40513a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                list.set(i6, URLDecoder.decode(list.get(i6), "UTF-8"));
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        C0813b c0813b = this.f40511a.get(str);
        if (c0813b != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            c0813b.call(str2, list, aVar);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, aVar);
        return true;
    }
}
