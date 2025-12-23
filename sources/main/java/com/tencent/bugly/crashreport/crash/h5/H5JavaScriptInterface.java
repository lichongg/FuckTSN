package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.snail.antifake.deviceid.e;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f39665a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private String f39666b = null;

    /* renamed from: c, reason: collision with root package name */
    private Thread f39667c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f39668d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f39669e = null;

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string2 = jSONObject.getString("projectRoot");
                bbVar.f39940a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString(d.X);
                bbVar.f39941b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                bbVar.f39942c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                bbVar.f39943d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                bbVar.f39944e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString(CommonNetImpl.NAME);
                bbVar.f39945f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf(e.f37542d);
                if (indexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f39947h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                bbVar.f39946g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    bbVar.f39946g = bbVar.f39946g.substring(indexOf2 + 1);
                }
                bbVar.f39948i = jSONObject.getString(b.f50156c);
                if (bbVar.f39945f == null) {
                    return null;
                }
                long j6 = jSONObject.getLong("lineNumber");
                bbVar.f39949j = j6;
                if (j6 < 0) {
                    return null;
                }
                long j7 = jSONObject.getLong("columnNumber");
                bbVar.f39950k = j7;
                if (j7 < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.f39940a, new Object[0]);
                al.a("[context]: " + bbVar.f39941b, new Object[0]);
                al.a("[url]: " + bbVar.f39942c, new Object[0]);
                al.a("[userAgent]: " + bbVar.f39943d, new Object[0]);
                al.a("[language]: " + bbVar.f39944e, new Object[0]);
                al.a("[name]: " + bbVar.f39945f, new Object[0]);
                al.a("[message]: " + bbVar.f39946g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f39947h, new Object[0]);
                al.a("[file]: " + bbVar.f39948i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f39949j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f39950k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String str = null;
        if (aVar == null || f39665a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f39665a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f39667c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.f37542d);
            for (int i6 = 2; i6 < currentThread.getStackTrace().length; i6++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i6];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append(e.f37542d);
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f39668d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) aVar.c());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f39669e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c6 = ap.c(str.getBytes());
        String str2 = this.f39666b;
        if (str2 != null && str2.equals(c6)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f39666b = c6;
        al.d("Handling JS exception ...", new Object[0]);
        bb a6 = a(str);
        if (a6 == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a6.f39940a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a6.f39941b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a6.f39942c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a6.f39943d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a6.f39948i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j6 = a6.f39949j;
        if (j6 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j6));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f39669e);
        linkedHashMap.put("Java Stack", this.f39668d);
        InnerApi.postH5CrashAsync(this.f39667c, a6.f39945f, a6.f39946g, a6.f39947h, linkedHashMap);
    }

    private H5JavaScriptInterface() {
    }
}
