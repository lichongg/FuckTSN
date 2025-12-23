package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cm {

    /* renamed from: a, reason: collision with root package name */
    private String f35897a;

    /* renamed from: b, reason: collision with root package name */
    private String f35898b;

    /* renamed from: c, reason: collision with root package name */
    private String f35899c;

    /* renamed from: d, reason: collision with root package name */
    private String f35900d;

    /* renamed from: e, reason: collision with root package name */
    private String f35901e;

    /* renamed from: f, reason: collision with root package name */
    private String f35902f;

    /* renamed from: g, reason: collision with root package name */
    private String f35903g;

    /* renamed from: h, reason: collision with root package name */
    private String f35904h;

    /* renamed from: i, reason: collision with root package name */
    private String f35905i;

    /* renamed from: j, reason: collision with root package name */
    private String f35906j;

    /* renamed from: k, reason: collision with root package name */
    private String f35907k;

    /* renamed from: l, reason: collision with root package name */
    private String f35908l;

    public String a() {
        return this.f35897a;
    }

    public String b() {
        return this.f35898b;
    }

    public String c() {
        return this.f35899c;
    }

    public String d() {
        return this.f35900d;
    }

    public String e() {
        return this.f35901e;
    }

    public String f() {
        return this.f35902f;
    }

    public String g() {
        return this.f35903g;
    }

    public String h() {
        return this.f35904h;
    }

    public String i() {
        return this.f35905i;
    }

    public String j() {
        return this.f35906j;
    }

    public String k() {
        return this.f35907k;
    }

    public String l() {
        return this.f35908l;
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f35897a);
            jSONObject.put("2", this.f35898b);
            jSONObject.put("3", this.f35899c);
            jSONObject.put("4", this.f35900d);
            jSONObject.put("5", this.f35901e);
            jSONObject.put("6", this.f35902f);
            jSONObject.put("7", this.f35903g);
            jSONObject.put("8", this.f35904h);
            jSONObject.put("9", this.f35905i);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, this.f35906j);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, this.f35908l);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "com.kuaishou.weapon");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.f35897a = str;
    }

    public void b(String str) {
        this.f35898b = str;
    }

    public void c(String str) {
        this.f35899c = str;
    }

    public void d(String str) {
        this.f35900d = str;
    }

    public void e(String str) {
        this.f35901e = str;
    }

    public void f(String str) {
        this.f35902f = str;
    }

    public void g(String str) {
        this.f35903g = str;
    }

    public void h(String str) {
        this.f35904h = str;
    }

    public void i(String str) {
        this.f35905i = str;
    }

    public void j(String str) {
        this.f35906j = str;
    }

    public void k(String str) {
        this.f35907k = str;
    }

    public void l(String str) {
        this.f35908l = str;
    }

    public cm(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f35905i = sb.toString();
        this.f35899c = str;
        this.f35903g = str2;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.f35789v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a6 = h.a(context, "re_po_rt");
            boolean e6 = a6.e("a1_p_s_p_s");
            boolean e7 = a6.e("a1_p_s_p_s_c_b");
            if (e6 || e7) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                if (!TextUtils.isEmpty(str2)) {
                    bi.f35789v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.f35789v = 4;
        return "";
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.9");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
