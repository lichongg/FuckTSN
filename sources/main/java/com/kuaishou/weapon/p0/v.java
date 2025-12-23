package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class v {

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f36188h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f36189i = "1";

    /* renamed from: j, reason: collision with root package name */
    public static final String f36190j = "2";

    /* renamed from: k, reason: collision with root package name */
    public static final String f36191k = "3";

    /* renamed from: l, reason: collision with root package name */
    public static final String f36192l = "4";

    /* renamed from: m, reason: collision with root package name */
    public static final String f36193m = "5";

    /* renamed from: n, reason: collision with root package name */
    public static final String f36194n = "6";

    /* renamed from: o, reason: collision with root package name */
    public static final String f36195o = "7";

    /* renamed from: a, reason: collision with root package name */
    public int f36196a;

    /* renamed from: b, reason: collision with root package name */
    public long f36197b;

    /* renamed from: c, reason: collision with root package name */
    public long f36198c;

    /* renamed from: d, reason: collision with root package name */
    public String f36199d;

    /* renamed from: e, reason: collision with root package name */
    public String f36200e;

    /* renamed from: f, reason: collision with root package name */
    public String f36201f;

    /* renamed from: g, reason: collision with root package name */
    public int f36202g;

    /* renamed from: p, reason: collision with root package name */
    private PackageInfo f36203p;

    /* renamed from: q, reason: collision with root package name */
    private ApplicationInfo f36204q;

    /* renamed from: r, reason: collision with root package name */
    private Context f36205r;

    public v(PackageInfo packageInfo, Context context) {
        this.f36203p = packageInfo;
        this.f36205r = context;
    }

    public int a() {
        return this.f36196a;
    }

    public String b() {
        return this.f36200e;
    }

    public String c() {
        return this.f36201f;
    }

    public void a(int i6) {
        this.f36196a = i6;
    }

    public void b(String str) {
        this.f36201f = str;
    }

    public void c(String str) {
        this.f36199d = str;
    }

    public long d() {
        return this.f36197b;
    }

    public String e() {
        return this.f36199d;
    }

    public long f() {
        return this.f36198c;
    }

    public int g() {
        return this.f36202g;
    }

    public void h() {
        PackageInfo packageInfo = this.f36203p;
        if (packageInfo == null && this.f36204q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f36204q != null) {
                    this.f36203p = this.f36205r.getPackageManager().getPackageInfo(this.f36204q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f36203p;
        a(packageInfo2 == null ? this.f36204q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f36203p;
        a((packageInfo3 == null ? this.f36204q : packageInfo3.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.f36203p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f36203p.lastUpdateTime);
            c(this.f36203p.versionName);
            b(this.f36203p.versionCode);
        }
    }

    public void i() {
        PackageInfo packageInfo = this.f36203p;
        if (packageInfo == null && this.f36204q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f36204q != null) {
                    this.f36203p = this.f36205r.getPackageManager().getPackageInfo(this.f36204q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f36203p;
        a(packageInfo2 == null ? this.f36204q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f36203p;
        a((packageInfo3 == null ? this.f36204q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.f36203p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f36203p.lastUpdateTime);
            c(this.f36203p.versionName);
            b(this.f36203p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.f36203p;
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                ApplicationInfo applicationInfo2 = this.f36204q;
                if (applicationInfo2 != null) {
                    String charSequence = applicationInfo2.loadLabel(this.f36205r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                }
            } else {
                String charSequence2 = applicationInfo.loadLabel(this.f36205r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence2)) {
                    return charSequence2;
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.f36200e = str;
    }

    public void b(long j6) {
        this.f36198c = j6;
    }

    public v(ApplicationInfo applicationInfo, Context context) {
        this.f36204q = applicationInfo;
        this.f36205r = context;
    }

    public void a(long j6) {
        this.f36197b = j6;
    }

    public void b(int i6) {
        this.f36202g = i6;
    }
}
