package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.internal.JConstants;
import cn.jiguang.m.b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1651a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f1652b;

    /* renamed from: c, reason: collision with root package name */
    private String f1653c = "";

    /* renamed from: d, reason: collision with root package name */
    private int f1654d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f1655e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f1656f = 0;

    /* renamed from: cn.jiguang.ap.a$a, reason: collision with other inner class name */
    public static class C0025a {
        public static int a(int i6, int i7, int i8) {
            return ((i6 & 15) << 6) | ((i7 & 255) << 2) | (i8 & 255);
        }
    }

    public static int a() {
        return !TextUtils.isEmpty(JConstants.SDK_NAME) ? 2 : 0;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        JSONObject a6 = a(this.f1653c, this.f1654d, this.f1655e);
        if (a6 == null) {
            f.i("JType", "there are no data to report");
            return;
        }
        cn.jiguang.bd.f.a(context, a6);
        b.h(context, "JType" + this.f1653c);
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f1651a = context;
        return "JType";
    }

    @Override // cn.jiguang.m.a
    protected boolean d() {
        Bundle bundle = this.f1652b;
        if (bundle == null) {
            return false;
        }
        this.f1653c = bundle.getString(CommonNetImpl.NAME);
        this.f1654d = this.f1652b.getInt("custom", 0);
        this.f1655e = this.f1652b.getInt("dynamic", 0);
        this.f1656f = this.f1652b.getInt("sdk_v", 0);
        f.c("JType", "parseBundle type:" + this.f1653c + ",custom:" + this.f1654d + ",dynamic:" + this.f1655e + ",sdkVersion:" + this.f1656f);
        boolean a6 = a(this.f1651a, this.f1653c, this.f1654d, this.f1655e, this.f1656f);
        if (!a6) {
            f.c("JType", "type [" + this.f1653c + "] data not change");
            return a6;
        }
        String str = this.f1654d + "," + this.f1655e;
        b.a(this.f1651a, this.f1653c, this.f1656f);
        b.a(this.f1651a, this.f1653c, str);
        return a6;
    }

    private JSONObject a(String str, int i6, int i7) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i6);
            jSONArray.put(i7);
            if ("core".equals(str)) {
                jSONArray.put(JConstants.SDK_VERSION_INT);
            } else {
                if (!"push".equals(str)) {
                    "JAD".equals(str);
                    jSONObject2.put(str, jSONArray);
                    jSONObject.put("type", "sdk_type");
                    jSONObject.put("itime", cn.jiguang.d.b.b(this.f1651a));
                    jSONObject.put("sdk", jSONObject2);
                    return jSONObject;
                }
                jSONArray.put(cn.jiguang.d.a.c());
            }
            jSONArray.put(this.f1656f);
            jSONObject2.put(str, jSONArray);
            jSONObject.put("type", "sdk_type");
            jSONObject.put("itime", cn.jiguang.d.b.b(this.f1651a));
            jSONObject.put("sdk", jSONObject2);
            return jSONObject;
        } catch (JSONException e6) {
            f.i("JType", "package json exception: " + e6.getMessage());
            return null;
        }
    }

    public static int e() {
        if (cn.jiguang.a.a.b()) {
            return 1;
        }
        if (cn.jiguang.a.a.f1445c != JConstants.SDK_VERSION_INT) {
            return 2;
        }
        return 0;
    }

    @Override // cn.jiguang.m.a
    protected void a(String str, Bundle bundle) {
        this.f1652b = bundle;
    }

    private static boolean a(Context context, String str, int i6, int i7, int i8) {
        if (TextUtils.isEmpty(str) || i6 < 0 || i7 < 0) {
            return false;
        }
        int q5 = b.q(context, str);
        f.c("JType", "[isTypeReportEnable],lastversion:" + q5 + ",curversion:" + i8 + ",type:" + str);
        if (q5 != i8) {
            return true;
        }
        if (Math.abs(System.currentTimeMillis() - b.i(context, "JType" + str)) > 15724800000L) {
            return true;
        }
        String p5 = b.p(context, str);
        return !p5.equals(i6 + "," + i7);
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
    }
}
