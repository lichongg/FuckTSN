package com.ss.android.downloadlib.addownload.compliance;

import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.a;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37677a;

    /* renamed from: b, reason: collision with root package name */
    private a f37678b;

    /* renamed from: c, reason: collision with root package name */
    private int f37679c;

    /* renamed from: d, reason: collision with root package name */
    private int f37680d;

    /* renamed from: e, reason: collision with root package name */
    private int f37681e = 15;

    /* renamed from: f, reason: collision with root package name */
    private int f37682f;

    /* renamed from: g, reason: collision with root package name */
    private String f37683g;

    /* renamed from: h, reason: collision with root package name */
    private String f37684h;

    /* renamed from: i, reason: collision with root package name */
    private int f37685i;

    /* renamed from: j, reason: collision with root package name */
    private String f37686j;

    /* renamed from: k, reason: collision with root package name */
    private long f37687k;

    /* renamed from: l, reason: collision with root package name */
    private String f37688l;

    /* renamed from: m, reason: collision with root package name */
    private String f37689m;

    /* renamed from: n, reason: collision with root package name */
    private b f37690n;

    /* renamed from: o, reason: collision with root package name */
    private String f37691o;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f37692a;

        /* renamed from: b, reason: collision with root package name */
        private String f37693b;

        /* renamed from: c, reason: collision with root package name */
        private long f37694c;

        /* renamed from: d, reason: collision with root package name */
        private long f37695d;

        /* renamed from: e, reason: collision with root package name */
        private String f37696e;

        /* renamed from: f, reason: collision with root package name */
        private String f37697f;

        /* renamed from: g, reason: collision with root package name */
        private List<C0745a> f37698g;

        /* renamed from: h, reason: collision with root package name */
        private String f37699h;

        /* renamed from: i, reason: collision with root package name */
        private String f37700i;

        /* renamed from: j, reason: collision with root package name */
        private String f37701j;

        /* renamed from: k, reason: collision with root package name */
        private String f37702k;

        /* renamed from: l, reason: collision with root package name */
        private String f37703l;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.e$a$a, reason: collision with other inner class name */
        public static class C0745a {

            /* renamed from: a, reason: collision with root package name */
            private String f37704a;

            /* renamed from: b, reason: collision with root package name */
            private String f37705b;

            public void b(String str) {
                this.f37704a = str;
            }

            public void d(String str) {
                this.f37705b = str;
            }
        }

        public void b(String str) {
            this.f37701j = str;
        }

        public void d(String str) {
            this.f37696e = str;
        }

        public void f(String str) {
            this.f37703l = str;
        }

        public void h(long j6) {
            this.f37694c = j6;
        }

        public void i(String str) {
            this.f37692a = str;
        }

        public void j(List<C0745a> list) {
            this.f37698g = list;
        }

        public void l(String str) {
            this.f37700i = str;
        }

        public void p(String str) {
            this.f37697f = str;
        }

        public void r(String str) {
            this.f37702k = str;
        }

        public void t(String str) {
            this.f37699h = str;
        }

        public void v(long j6) {
            this.f37695d = j6;
        }

        public void w(String str) {
            this.f37693b = str;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f37706a;

        /* renamed from: b, reason: collision with root package name */
        private String f37707b;

        public void b(int i6) {
            this.f37706a = i6;
        }

        public void c(String str) {
            this.f37707b = str;
        }
    }

    public static e a(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a f6 = f(jSONObject);
            b t5 = t(jSONObject);
            eVar.j(f6);
            eVar.k(t5);
            eVar.n(jSONObject.optInt("show_auth", 0) == 1);
            eVar.h(jSONObject.optInt("download_permit"));
            eVar.x(jSONObject.optInt("appstore_permit"));
            eVar.c(jSONObject.optInt("market_online_status", 15));
            eVar.p(jSONObject.optInt("hijack_permit"));
            eVar.l(jSONObject.optString(bi.f40972o));
            eVar.y(jSONObject.optString("hijack_url"));
            eVar.r(jSONObject.optInt("code"));
            eVar.d(jSONObject.optString(CrashHianalyticsData.MESSAGE));
            eVar.i(jSONObject.optLong("request_duration", 0L));
            eVar.q(jSONObject.optString("back_web_url"));
            eVar.s(jSONObject.optString("hw_app_id"));
            eVar.o(jSONObject.optString("deep_link"));
            return eVar;
        } catch (Exception e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "ComplianceResult fromJson");
            return eVar;
        }
    }

    private static JSONArray b(a aVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<a.C0745a> list = aVar.f37698g;
        if (list != null && list.size() > 0) {
            for (a.C0745a c0745a : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0745a.f37704a);
                jSONObject.putOpt("permission_desc", c0745a.f37705b);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private static a f(JSONObject jSONObject) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                aVar.i(optJSONObject.optString("app_name"));
                aVar.w(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                aVar.h(a.h.j(optJSONObject, "update_time"));
                aVar.v(a.h.j(optJSONObject, "size"));
                aVar.d(optJSONObject.optString("developer_name"));
                aVar.p(optJSONObject.optString(bi.f40972o));
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    m(optJSONArray, arrayList);
                    aVar.j(arrayList);
                }
                aVar.t(optJSONObject.optString("permission_classify_url"));
                aVar.l(optJSONObject.optString("policy_url"));
                aVar.b(optJSONObject.optString("icon_url"));
                aVar.r(optJSONObject.optString("download_url"));
                aVar.f(optJSONObject.optString("desc_url"));
            }
            return aVar;
        } catch (Exception e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "ComplianceResult getAuthInfo");
            return aVar;
        }
    }

    public static String g(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(eVar.f37677a ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(eVar.f37679c));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(eVar.f37680d));
            jSONObject.putOpt("market_online_status", Integer.valueOf(eVar.f37681e));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(eVar.f37682f));
            jSONObject.putOpt(bi.f40972o, eVar.f37683g);
            jSONObject.putOpt("hijack_url", eVar.f37684h);
            jSONObject.putOpt("code", Integer.valueOf(eVar.f37685i));
            jSONObject.putOpt(CrashHianalyticsData.MESSAGE, eVar.f37686j);
            jSONObject.putOpt("request_duration", Long.valueOf(eVar.f37687k));
            jSONObject.putOpt("auth_info", v(eVar.f37678b));
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, w(eVar.f37690n));
            jSONObject.putOpt("back_web_url", eVar.f37691o);
            jSONObject.putOpt("hw_app_id", eVar.f37688l);
            jSONObject.putOpt("deep_link", eVar.f37689m);
        } catch (JSONException e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static void m(JSONArray jSONArray, List<a.C0745a> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                a.C0745a c0745a = new a.C0745a();
                c0745a.b(optJSONObject.optString("permission_name"));
                c0745a.d(optJSONObject.optString("permission_desc"));
                list.add(c0745a);
            }
        }
    }

    private static b t(JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS);
            if (optJSONObject == null) {
                return bVar;
            }
            bVar.b(optJSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
            bVar.c(optJSONObject.optString(CrashHianalyticsData.MESSAGE));
            return bVar;
        } catch (Exception e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "ComplianceResult getStatus");
            return bVar;
        }
    }

    private static JSONObject v(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("app_name", aVar.f37692a);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, aVar.f37693b);
            jSONObject.putOpt("update_time", Long.valueOf(aVar.f37694c));
            jSONObject.putOpt("size", Long.valueOf(aVar.f37695d));
            jSONObject.putOpt("developer_name", aVar.f37696e);
            jSONObject.putOpt("policy_url", aVar.f37700i);
            jSONObject.putOpt("icon_url", aVar.f37701j);
            jSONObject.putOpt("download_url", aVar.f37702k);
            jSONObject.putOpt("permissions", b(aVar));
            jSONObject.putOpt("permission_classify_url", aVar.f37699h);
            jSONObject.putOpt("desc_url", aVar.f37703l);
        }
        return jSONObject;
    }

    private static JSONObject w(b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bVar != null) {
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(bVar.f37706a));
            jSONObject.putOpt(CrashHianalyticsData.MESSAGE, bVar.f37707b);
        }
        return jSONObject;
    }

    public void c(int i6) {
        this.f37681e = i6;
    }

    public void d(String str) {
        this.f37686j = str;
    }

    public int e() {
        return this.f37685i;
    }

    public void h(int i6) {
        this.f37679c = i6;
    }

    public void i(long j6) {
        this.f37687k = j6;
    }

    public void j(a aVar) {
        this.f37678b = aVar;
    }

    public void k(b bVar) {
        this.f37690n = bVar;
    }

    public void l(String str) {
        this.f37683g = str;
    }

    public void n(boolean z5) {
        this.f37677a = z5;
    }

    public void o(String str) {
        this.f37689m = str;
    }

    public void p(int i6) {
        this.f37682f = i6;
    }

    public void q(String str) {
        this.f37691o = str;
    }

    public void r(int i6) {
        this.f37685i = i6;
    }

    public void s(String str) {
        this.f37688l = str;
    }

    public String u() {
        return this.f37689m;
    }

    public void x(int i6) {
        this.f37680d = i6;
    }

    public void y(String str) {
        this.f37684h = str;
    }

    public String toString() {
        return g(this);
    }
}
