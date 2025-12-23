package cn.jiguang.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.bz.o;
import cn.jiguang.bz.p;
import cn.jiguang.bz.y;
import cn.jiguang.m.c;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.google.common.base.Ascii;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f extends cn.jiguang.m.a {

    /* renamed from: c, reason: collision with root package name */
    private String f3219c;

    /* renamed from: d, reason: collision with root package name */
    private Context f3220d;

    /* renamed from: e, reason: collision with root package name */
    private String f3221e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3222g;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3217b = l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 106, 124, 119, 101, 69, 83, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 115, 112, 57, 39, 81, 69, 46, 57, 117});

    /* renamed from: a, reason: collision with root package name */
    public static String f3216a = "";

    /* renamed from: f, reason: collision with root package name */
    private static int f3218f = 0;

    /* renamed from: cn.jiguang.r.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f3223a = new f(null);
    }

    private f() {
    }

    public static f a() {
        return a.f3223a;
    }

    public synchronized String b(Context context) {
        if (!this.f3222g && !cn.jiguang.g.a.a().e(2800)) {
            return "";
        }
        this.f3219c = cn.jiguang.bz.a.a().a(this.f3222g);
        if (!TextUtils.isEmpty(this.f3221e)) {
            return this.f3221e;
        }
        HttpResponse h6 = h(context);
        if (h6.getResponseCode() != 200) {
            return "";
        }
        try {
            String a6 = y.a(h6.getResponseBody(), true);
            cn.jiguang.bb.f.c("JDeviceIp", "request i config success,response body:" + a6);
            String optString = new JSONObject(a6).optString("ipv6", "");
            this.f3221e = optString;
            return optString;
        } catch (JSONException unused) {
            return "";
        }
    }

    /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    private HttpResponse h(Context context) {
        String str;
        HttpResponse httpResponse = new HttpResponse();
        try {
            String a6 = cn.jiguang.ba.a.a(context);
            if (TextUtils.isEmpty(a6)) {
                str = "request i config failed because can't get appKey";
            } else {
                long f6 = cn.jiguang.d.a.f(context);
                if (f6 == 0) {
                    str = "request i config failed because can't get uid";
                } else if (TextUtils.isEmpty(cn.jiguang.d.a.j(context))) {
                    str = "request i config failed because need register first";
                } else {
                    if (!cn.jiguang.g.a.a().e(1035) || o.e()) {
                        String j6 = cn.jiguang.bz.a.j(context);
                        PackageInfo a7 = p.a(context, 0);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("appKey", a6);
                        jSONObject.put("uid", f6);
                        jSONObject.put("appName", j6);
                        jSONObject.put("appVersion", a7 == null ? "" : a7.versionName);
                        jSONObject.put("appChannel", cn.jiguang.ba.a.c(context));
                        jSONObject.put("appPackage", p.a(context));
                        String str2 = f3217b;
                        if (c.a.f3097a && !TextUtils.isEmpty(f3216a)) {
                            str2 = f3216a;
                        }
                        cn.jiguang.bb.f.c("JDeviceIp", "request i config, url: " + str2 + ", paramJson: " + jSONObject);
                        HttpRequest httpRequest = new HttpRequest(str2);
                        httpRequest.setRequestProperty("Content-Type", "text/plain");
                        httpRequest.setRequestProperty("Accept", "application/json");
                        httpRequest.setRequestProperty("Charset", "UTF-8");
                        httpRequest.setBody(y.b(jSONObject.toString(), true));
                        HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                        int responseCode = httpPost.getResponseCode();
                        cn.jiguang.bb.f.c("JDeviceIp", "responseCode: " + responseCode);
                        if (200 == responseCode) {
                            String responseBody = httpPost.getResponseBody();
                            cn.jiguang.bb.f.c("JDeviceIp", "request i config code:" + responseCode);
                            TextUtils.isEmpty(responseBody);
                        }
                        return httpPost;
                    }
                    str = "current network is not support ipv6";
                }
            }
            cn.jiguang.bb.f.i("JDeviceIp", str);
            return httpResponse;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JDeviceIp", "request i config failed, " + th.getMessage());
            return httpResponse;
        }
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3220d = context;
        return "JDeviceIp";
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        if (!this.f3222g) {
            return super.b(context, str);
        }
        cn.jiguang.bb.f.c("JDeviceIp", "isReportEnable isCmd true");
        return true;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        try {
            a(false);
            if (TextUtils.isEmpty(this.f3221e) && TextUtils.isEmpty(this.f3219c)) {
                cn.jiguang.bb.f.c("JDeviceIp", "no data report");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("itime", cn.jiguang.d.b.b(context));
            jSONObject.put("type", "ip_info");
            jSONObject.put("ipv6", TextUtils.isEmpty(this.f3221e) ? "" : this.f3221e);
            if (!TextUtils.isEmpty(this.f3219c)) {
                jSONObject.put("ip2", this.f3219c);
            }
            cn.jiguang.bb.f.c("JDeviceIp", "reportJSON=" + jSONObject);
            cn.jiguang.bd.f.a(context, jSONObject);
            super.d(context, str);
            this.f3221e = null;
            this.f3219c = null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JDeviceIp", "ip info report failed, " + th.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected boolean e(Context context, String str) {
        if (!this.f3222g) {
            return super.e(context, str);
        }
        cn.jiguang.bb.f.c("JDeviceIp", "isProtectionTime isCmd true");
        return true;
    }

    public void a(boolean z5) {
        this.f3222g = z5;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        int i6;
        b(context);
        if (!TextUtils.isEmpty(this.f3221e)) {
            i6 = 2;
        } else {
            i6 = f3218f + 1;
            f3218f = i6;
        }
        f3218f = i6;
        if (i6 >= 2) {
            super.c(context, str);
        }
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (!this.f3222g) {
            return super.a(context, str);
        }
        cn.jiguang.bb.f.c("JDeviceIp", "isProtectionTime isCmd true");
        return true;
    }
}
