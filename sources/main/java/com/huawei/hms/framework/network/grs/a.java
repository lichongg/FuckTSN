package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f33391e = "a";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f33392a;

    /* renamed from: b, reason: collision with root package name */
    private o1.a f33393b;

    /* renamed from: c, reason: collision with root package name */
    private g f33394c;

    /* renamed from: d, reason: collision with root package name */
    private o1.c f33395d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    private static class C0543a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f33396a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f33397b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlsCallBack f33398c;

        /* renamed from: d, reason: collision with root package name */
        Context f33399d;

        /* renamed from: e, reason: collision with root package name */
        GrsBaseInfo f33400e;

        /* renamed from: f, reason: collision with root package name */
        o1.a f33401f;

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f33397b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f33396a, StringUtils.anonymizeMessage(new JSONObject(this.f33397b).toString()));
                this.f33398c.onCallBackSuccess(this.f33397b);
                return;
            }
            if (this.f33397b != null) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f33396a);
                this.f33398c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> c6 = com.huawei.hms.framework.network.grs.f.b.a(this.f33399d.getPackageName()).c(this.f33399d, this.f33401f, this.f33400e, this.f33396a, true);
            if (c6 == null || c6.isEmpty()) {
                Logger.e(a.f33391e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f33396a);
            }
            if (c6 == null) {
                c6 = new ConcurrentHashMap<>();
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f33396a, StringUtils.anonymizeMessage(new JSONObject(c6).toString()));
            this.f33398c.onCallBackSuccess(c6);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String y5 = dVar.y();
            Map<String, String> g6 = a.g(y5, this.f33396a);
            if (!g6.isEmpty()) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f33396a, StringUtils.anonymizeMessage(new JSONObject(g6).toString()));
                this.f33398c.onCallBackSuccess(g6);
                return;
            }
            Map<String, String> map = this.f33397b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f33396a, StringUtils.anonymizeMessage(new JSONObject(this.f33397b).toString()));
                this.f33398c.onCallBackSuccess(this.f33397b);
                return;
            }
            if (this.f33397b != null) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f33396a);
                this.f33398c.onCallBackFail(-5);
                return;
            }
            if (!TextUtils.isEmpty(y5)) {
                Logger.e(a.f33391e, "The serviceName[%s] is not configured on the GRS server.", this.f33396a);
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> c6 = com.huawei.hms.framework.network.grs.f.b.a(this.f33399d.getPackageName()).c(this.f33399d, this.f33401f, this.f33400e, this.f33396a, true);
            if (c6 == null || c6.isEmpty()) {
                Logger.e(a.f33391e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f33396a);
            }
            if (c6 == null) {
                c6 = new ConcurrentHashMap<>();
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f33396a, StringUtils.anonymizeMessage(new JSONObject(c6).toString()));
            this.f33398c.onCallBackSuccess(c6);
        }

        C0543a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, o1.a aVar) {
            this.f33396a = str;
            this.f33397b = map;
            this.f33398c = iQueryUrlsCallBack;
            this.f33399d = context;
            this.f33400e = grsBaseInfo;
            this.f33401f = aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f33402a;

        /* renamed from: b, reason: collision with root package name */
        String f33403b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlCallBack f33404c;

        /* renamed from: d, reason: collision with root package name */
        String f33405d;

        /* renamed from: e, reason: collision with root package name */
        Context f33406e;

        /* renamed from: f, reason: collision with root package name */
        GrsBaseInfo f33407f;

        /* renamed from: g, reason: collision with root package name */
        o1.a f33408g;

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f33405d)) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f33402a, this.f33403b, StringUtils.anonymizeMessage(this.f33405d));
                this.f33404c.onCallBackSuccess(this.f33405d);
                return;
            }
            if (!TextUtils.isEmpty(this.f33405d)) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f33402a, this.f33403b);
                this.f33404c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String b6 = com.huawei.hms.framework.network.grs.f.b.a(this.f33406e.getPackageName()).b(this.f33406e, this.f33408g, this.f33407f, this.f33402a, this.f33403b, true);
            if (b6 == null || b6.isEmpty()) {
                Logger.e(a.f33391e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f33402a, this.f33403b);
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f33402a, this.f33403b, StringUtils.anonymizeMessage(b6));
            this.f33404c.onCallBackSuccess(b6);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String y5 = dVar.y();
            Map<String, String> g6 = a.g(y5, this.f33402a);
            if (g6.containsKey(this.f33403b)) {
                String str = a.f33391e;
                String str2 = this.f33402a;
                String str3 = this.f33403b;
                Logger.i(str, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str2, str3, StringUtils.anonymizeMessage(g6.get(str3)));
                this.f33404c.onCallBackSuccess(g6.get(this.f33403b));
                return;
            }
            if (!TextUtils.isEmpty(this.f33405d)) {
                String str4 = a.f33391e;
                String str5 = this.f33402a;
                String str6 = this.f33403b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", str5, str6, StringUtils.anonymizeMessage(g6.get(str6)));
                this.f33404c.onCallBackSuccess(this.f33405d);
                return;
            }
            if (!TextUtils.isEmpty(this.f33405d)) {
                Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f33402a, this.f33403b);
                this.f33404c.onCallBackFail(-5);
                return;
            }
            if (!TextUtils.isEmpty(y5)) {
                Logger.e(a.f33391e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f33402a, this.f33403b);
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String b6 = com.huawei.hms.framework.network.grs.f.b.a(this.f33406e.getPackageName()).b(this.f33406e, this.f33408g, this.f33407f, this.f33402a, this.f33403b, true);
            if (b6 == null || b6.isEmpty()) {
                Logger.e(a.f33391e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f33402a, this.f33403b);
            }
            Logger.i(a.f33391e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f33402a, this.f33403b, StringUtils.anonymizeMessage(b6));
            this.f33404c.onCallBackSuccess(b6);
        }

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, o1.a aVar) {
            this.f33402a = str;
            this.f33403b = str2;
            this.f33404c = iQueryUrlCallBack;
            this.f33405d = str3;
            this.f33406e = context;
            this.f33407f = grsBaseInfo;
            this.f33408g = aVar;
        }
    }

    public static CountryCodeBean a(Context context, boolean z5) {
        return new CountryCodeBean(context, z5);
    }

    public static Map<String, Map<String, String>> e(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f33391e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, i(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e6) {
            Logger.w(f33391e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return concurrentHashMap;
        }
    }

    public static Map<String, String> g(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f33391e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f33391e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e6) {
            Logger.w(f33391e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return hashMap;
        }
    }

    private Map<String, String> h(String str, o1.b bVar, Context context) {
        Map<String, String> a6 = this.f33393b.a(this.f33392a, str, bVar, context);
        if (a6 != null && !a6.isEmpty()) {
            Logger.i(f33391e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return a6;
        }
        Map<String, String> c6 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).c(context, this.f33393b, this.f33392a, str, false);
        Logger.i(f33391e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return c6 != null ? c6 : new HashMap();
    }

    public static Map<String, String> i(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e6) {
            Logger.w(f33391e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return concurrentHashMap;
        }
    }

    public String c(Context context, String str, int i6) {
        com.huawei.hms.framework.network.grs.g.d a6 = this.f33394c.a(new q1.c(this.f33392a, context), str, this.f33395d, i6);
        return a6 == null ? "" : a6.B() ? this.f33393b.b().a(this.f33392a.getGrsParasKey(true, true, context), "") : a6.y();
    }

    public String d(String str, String str2, Context context, int i6) {
        o1.b bVar = new o1.b();
        String str3 = h(str, bVar, context).get(str2);
        if (bVar.b() && !TextUtils.isEmpty(str3)) {
            Logger.i(f33391e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        String c6 = c(context, str, i6);
        String str4 = g(c6, str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.i(f33391e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str4));
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(c6)) {
                Logger.e(f33391e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str5 = f33391e;
            Logger.i(str5, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).b(context, this.f33393b, this.f33392a, str, str2, true);
            if (str3 == null || str3.isEmpty()) {
                Logger.e(str5, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.i(f33391e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
        return str3;
    }

    public Map<String, String> f(String str, Context context, int i6) {
        String str2;
        o1.b bVar = new o1.b();
        Map<String, String> h6 = h(str, bVar, context);
        if (bVar.b() && !h6.isEmpty()) {
            Logger.i(f33391e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(h6).toString()));
            return h6;
        }
        String c6 = c(context, str, i6);
        Map<String, String> g6 = g(c6, str);
        if (!g6.isEmpty()) {
            Logger.i(f33391e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(g6).toString()));
            return g6;
        }
        if (h6.isEmpty()) {
            if (!TextUtils.isEmpty(c6)) {
                Logger.e(f33391e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str3 = f33391e;
            Logger.i(str3, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            str2 = str;
            h6 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).c(context, this.f33393b, this.f33392a, str2, true);
            if (h6 == null || h6.isEmpty()) {
                Logger.e(str3, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str2);
            }
        } else {
            str2 = str;
        }
        Logger.i(f33391e, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", str2, StringUtils.anonymizeMessage(h6 != null ? new JSONObject(h6).toString() : ""));
        return h6;
    }

    public void j(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i6) {
        o1.b bVar = new o1.b();
        Map<String, String> h6 = h(str, bVar, context);
        if (!bVar.b()) {
            this.f33394c.h(new q1.c(this.f33392a, context), new C0543a(str, h6, iQueryUrlsCallBack, context, this.f33392a, this.f33393b), str, this.f33395d, i6);
            return;
        }
        if (h6.isEmpty()) {
            Logger.i(f33391e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f33391e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(h6).toString()));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(h6).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(h6);
        }
    }

    public void k(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i6) {
        o1.b bVar = new o1.b();
        String str3 = h(str, bVar, context).get(str2);
        if (!bVar.b()) {
            this.f33394c.h(new q1.c(this.f33392a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f33392a, this.f33393b), str, this.f33395d, i6);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f33391e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f33391e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, o1.a aVar, g gVar, o1.c cVar) {
        this.f33392a = grsBaseInfo;
        this.f33393b = aVar;
        this.f33394c = gVar;
        this.f33395d = cVar;
    }
}
