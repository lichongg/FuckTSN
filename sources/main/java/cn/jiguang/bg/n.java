package cn.jiguang.bg;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public int f2126a;

    /* renamed from: b, reason: collision with root package name */
    public String f2127b;

    /* renamed from: c, reason: collision with root package name */
    public String f2128c;

    /* renamed from: d, reason: collision with root package name */
    public long f2129d;

    /* renamed from: e, reason: collision with root package name */
    public String f2130e;

    /* renamed from: f, reason: collision with root package name */
    public double f2131f;

    /* renamed from: g, reason: collision with root package name */
    public double f2132g;

    /* renamed from: h, reason: collision with root package name */
    public long f2133h;

    /* renamed from: i, reason: collision with root package name */
    private int f2134i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f2135j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f2136k = 0;

    public n a(int i6) {
        this.f2136k = i6;
        return this;
    }

    public JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f2126a);
            jSONObject.put("appkey", this.f2127b);
            jSONObject.put("sdkver", this.f2128c);
            jSONObject.put("platform", 0);
            long j6 = this.f2129d;
            if (j6 != 0) {
                jSONObject.put("uid", j6);
            }
            String str = this.f2130e;
            if (str != null) {
                jSONObject.put("opera", str);
            }
            if (a(this.f2131f, this.f2132g)) {
                jSONObject.put(com.umeng.analytics.pro.d.C, this.f2131f);
                jSONObject.put(com.umeng.analytics.pro.d.D, this.f2132g);
                jSONObject.put("time", this.f2133h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            int i6 = this.f2134i;
            if (i6 != 0) {
                jSONObject.put("ips_flag", i6);
            }
            int i7 = this.f2135j;
            if (i7 != 0) {
                jSONObject.put("report_flag", i7);
            }
            int i8 = this.f2136k;
            if (i8 >= 0) {
                if (i8 == 0) {
                    i8 = 1;
                }
                jSONObject.put("cert_ver", i8);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public n(int i6, String str, String str2, long j6, String str3, double d6, double d7, long j7) {
        this.f2126a = i6;
        this.f2127b = str;
        this.f2128c = str2;
        this.f2129d = j6;
        this.f2130e = str3;
        this.f2131f = d6;
        this.f2132g = d7;
        this.f2133h = j7;
    }

    private static boolean a(double d6, double d7) {
        return d6 > -90.0d && d6 < 90.0d && d7 > -180.0d && d7 < 180.0d;
    }
}
