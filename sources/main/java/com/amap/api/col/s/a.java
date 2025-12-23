package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f7832a;

    private static String b() {
        return "ANDA0605000";
    }

    private static String c() {
        return "";
    }

    private String d() {
        return c1.j(this.f7832a);
    }

    private static String e() {
        return "9.7.0";
    }

    private static String f() {
        return "";
    }

    private static String h() {
        return "";
    }

    private static String i() {
        return "";
    }

    private static String j() {
        return "";
    }

    private static String k() {
        return "";
    }

    private static String l() {
        return "";
    }

    private static String m() {
        return "";
    }

    private static String n() {
        return "";
    }

    private static String o() {
        return "ANDH070308";
    }

    private static String p() {
        return FaceEnvironment.OS;
    }

    private static String q() {
        return "";
    }

    private static String r() {
        return "";
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("");
        sb.append("personal_switch=false");
        sb.append("&autodiv=");
        sb.append(b());
        String c6 = c();
        if (!TextUtils.isEmpty(c6)) {
            sb.append("&tid=");
            sb.append(c6);
        }
        String d6 = d();
        if (!TextUtils.isEmpty(d6)) {
            sb.append("&adiu=");
            sb.append(d6);
        }
        String e6 = e();
        if (!TextUtils.isEmpty(e6)) {
            sb.append("&app_version=");
            sb.append(e6);
        }
        String f6 = f();
        if (!TextUtils.isEmpty(f6)) {
            sb.append("&cifa=");
            sb.append(f6);
        }
        String g6 = g();
        if (!TextUtils.isEmpty(g6)) {
            sb.append("&deviceid=");
            sb.append(g6);
        }
        String h6 = h();
        if (!TextUtils.isEmpty(h6)) {
            sb.append("&did=");
            sb.append(h6);
        }
        String i6 = i();
        if (!TextUtils.isEmpty(i6)) {
            sb.append("&didv=");
            sb.append(i6);
        }
        String j6 = j();
        if (!TextUtils.isEmpty(j6)) {
            sb.append("&dic=");
            sb.append(j6);
        }
        String k6 = k();
        if (!TextUtils.isEmpty(k6)) {
            sb.append("&dip=");
            sb.append(k6);
        }
        String l6 = l();
        if (!TextUtils.isEmpty(l6)) {
            sb.append("&diu=");
            sb.append(l6);
        }
        String m6 = m();
        if (!TextUtils.isEmpty(m6)) {
            sb.append("&diu2=");
            sb.append(m6);
        }
        String n6 = n();
        if (!TextUtils.isEmpty(n6)) {
            sb.append("&diu3=");
            sb.append(n6);
        }
        String o5 = o();
        if (!TextUtils.isEmpty(o5)) {
            sb.append("&div=");
            sb.append(o5);
        }
        String p5 = p();
        if (!TextUtils.isEmpty(p5)) {
            sb.append("&os=");
            sb.append(p5);
        }
        String q5 = q();
        if (!TextUtils.isEmpty(q5)) {
            sb.append("&stepid=");
            sb.append(q5);
        }
        String r5 = r();
        if (!TextUtils.isEmpty(r5)) {
            sb.append("&session=");
            sb.append(r5);
        }
        return sb.toString();
    }

    public a(Context context) {
        this.f7832a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static String g() {
        return c1.H();
    }
}
