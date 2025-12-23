package cn.jiguang.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bz.p;
import cn.jiguang.bz.w;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private String f3204a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3205b;

    /* renamed from: c, reason: collision with root package name */
    private String f3206c;

    /* renamed from: cn.jiguang.r.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f3207a;

        private a(Context context) {
            this.f3207a = context;
            this.f2653h = "JDevice#RegisterAction";
        }

        /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                Context context = this.f3207a;
                cn.jiguang.u.a.a(context, cn.jiguang.u.a.c(context));
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JDevice", "RegisterAction failed:" + th.getMessage());
            }
        }
    }

    /* renamed from: cn.jiguang.r.b$b, reason: collision with other inner class name */
    private static final class C0050b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f3208a = new b(null);
    }

    private b() {
    }

    public static b a() {
        return C0050b.f3208a;
    }

    private String b(Context context) {
        StringBuilder sb;
        String str;
        if (context == null) {
            cn.jiguang.bb.f.i("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String k6 = cn.jiguang.bz.a.a().k(context);
            Object obj = "";
            if (TextUtils.isEmpty(k6)) {
                k6 = "";
            }
            jSONObject.put("resolution", k6);
            jSONObject.put("screensize", cn.jiguang.u.a.a(context));
            jSONObject.put("os_version", cn.jiguang.bz.a.a().D(context));
            jSONObject.put(bn.f10753i, cn.jiguang.bz.a.a().y(context));
            jSONObject.put(bn.f10754j, cn.jiguang.bz.a.a().z(context));
            jSONObject.put("product", cn.jiguang.bz.a.a().t(context));
            jSONObject.put("font", cn.jiguang.bz.a.a().u(context));
            String.format(Locale.ENGLISH, Build.FINGERPRINT, new Object[0]);
            jSONObject.put("fingerprint", cn.jiguang.bz.a.a().v(context));
            jSONObject.put("language", cn.jiguang.bz.a.a().A(context));
            jSONObject.put("manufacturer", cn.jiguang.bz.a.a().B(context));
            jSONObject.put(bi.M, cn.jiguang.bz.a.a().C(context));
            String a6 = cn.jiguang.u.e.a(context);
            if (TextUtils.isEmpty(a6)) {
                a6 = "";
            }
            jSONObject.put("romversion", a6);
            String b6 = cn.jiguang.bz.a.a().b(context, "", false);
            if (TextUtils.isEmpty(b6)) {
                b6 = "";
            }
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, b6);
            jSONObject.put("meid", cn.jiguang.u.c.a(context));
            jSONObject.put("sim_slots", cn.jiguang.u.a.b(context));
            String o5 = cn.jiguang.bz.a.a().o(context);
            if (!TextUtils.isEmpty(o5)) {
                obj = o5;
            }
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, obj);
            Object a7 = cn.jiguang.x.a.a(context);
            if (a7 != null) {
                jSONObject.put("ids", a7);
            }
            jSONObject.put("root_state", cn.jiguang.bz.a.a().p(context) ? 1 : 0);
            jSONObject.put("simulator_state", cn.jiguang.bz.a.a().q(context) ? 1 : 0);
            Object e6 = cn.jiguang.u.a.e(context);
            if (e6 != null) {
                jSONObject.put("cid_box", e6);
            }
            jSONObject.put("ncid_box", cn.jiguang.u.a.f(context));
            jSONObject.put("boot_id", cn.jiguang.bz.a.a().E(context));
            jSONObject.put("media_drm_id", cn.jiguang.bz.a.a().F(context));
            jSONObject.put("first_boot", cn.jiguang.bz.a.a().G(context));
            jSONObject.put("android_ver", Build.VERSION.SDK_INT);
            jSONObject.put("android_target_ver", context.getApplicationInfo().targetSdkVersion);
            return jSONObject.toString();
        } catch (JSONException e7) {
            e = e7;
            sb = new StringBuilder();
            str = "package json exception: ";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JDevice", sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "getDeviceInfo exception: ";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JDevice", sb.toString());
            return null;
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static String h(Context context) {
        try {
            String c6 = cn.jiguang.ba.a.c(context);
            String a6 = cn.jiguang.ba.a.a(context);
            PackageInfo a7 = p.a(context, 0);
            String str = a7 == null ? "" : a7.versionName;
            String valueOf = a7 == null ? "" : String.valueOf(a7.versionCode);
            String str2 = cn.jiguang.a.a.f1444b;
            String valueOf2 = String.valueOf(cn.jiguang.a.a.f1445c);
            StringBuilder sb = new StringBuilder();
            sb.append(c6);
            sb.append(",");
            if (TextUtils.isEmpty(a6)) {
                a6 = "";
            }
            sb.append(a6);
            sb.append(",");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "";
            }
            sb.append(valueOf);
            sb.append(",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(",");
            if (TextUtils.isEmpty(valueOf2)) {
                valueOf2 = "";
            }
            sb.append(valueOf2);
            sb.append(",");
            TextUtils.isEmpty("");
            sb.append("");
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JDevice", "getCurrentCondition throwable: " + th.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3205b = context;
        return "JDevice";
    }

    public void b(Context context, int i6) {
        cn.jiguang.be.b.a(new a(context, null), i6);
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        String str2 = this.f3204a;
        if (str2 == null) {
            cn.jiguang.bb.f.c("JDevice", "there are no data to report");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            cn.jiguang.d.a.a(context, jSONObject, "device_info");
            cn.jiguang.bd.f.a(context, jSONObject, new cn.jiguang.r.a(context, this.f3206c, str));
        } catch (Throwable unused) {
        }
        this.f3204a = null;
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        if (!cn.jiguang.m.b.c(context, str)) {
            return false;
        }
        String str2 = this.f3204a;
        if (str2 == null) {
            cn.jiguang.bb.f.i("JDevice", "there are no data to report");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        this.f3206c = w.k(str2 + h(context));
        String j6 = cn.jiguang.m.b.j(context);
        if (TextUtils.isEmpty(this.f3206c) || TextUtils.equals(this.f3206c, j6)) {
            cn.jiguang.bb.f.c("JDevice", "device detail is not change");
            return false;
        }
        cn.jiguang.bb.f.c("JDevice", "device detail is change");
        return super.b(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (!cn.jiguang.g.a.a().a(1000)) {
            cn.jiguang.bb.f.c("JDevice", "will not report");
            return;
        }
        String b6 = b(context);
        this.f3204a = b6;
        if (b6 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("de_inf", b6);
            cn.jiguang.ba.g.a().a("get_loc_info", bundle);
            cn.jiguang.bb.f.c("JDevice", "collect success:" + b6);
            super.c(context, str);
            return;
        }
        cn.jiguang.bb.f.i("JDevice", "collect failed");
    }

    @Override // cn.jiguang.m.a
    public Object g(Context context) {
        String b6 = b(context);
        if (b6 != null) {
            try {
                return new JSONObject(b6);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
