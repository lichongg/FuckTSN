package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static o f33620b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Long> f33621c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Context f33622a;

    private static synchronized o h() {
        o oVar;
        synchronized (o.class) {
            try {
                if (f33620b == null) {
                    f33620b = new o();
                }
                oVar = f33620b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    public void b(Context context) {
        this.f33622a = context;
        i(context);
        d1.e().d().q(s0.c());
    }

    public void c(String str, int i6) {
        if (this.f33622a == null) {
            j1.l("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            j1.h("hmsSdk", "onReport: Before calling runtaskhandler()");
            g(str, q0.c(i6), y0.m());
        }
    }

    public void e(String str, int i6, String str2, JSONObject jSONObject, long j6) {
        new a0(str, q0.c(i6), str2, jSONObject.toString(), j6).a();
    }

    public void g(String str, String str2, String str3) {
        Context context = this.f33622a;
        if (context == null) {
            j1.l("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String d6 = b1.d(context);
        if (c.f(str, str2) && !"WIFI".equals(d6)) {
            j1.h("hmsSdk", "strNetworkType is :" + d6);
            return;
        }
        if ("unknown".equals(d6) || "none".equals(d6) || "2G".equals(d6)) {
            j1.l("hmsSdk", "The network is bad.");
        } else {
            e.d().b(new i1(str, str2, str3));
        }
    }

    public static o a() {
        return h();
    }

    private void i(Context context) {
        String j6 = s0.j(context);
        y0.b(j6);
        if (z0.b().a()) {
            String b6 = l.b(context, "global_v2", Constants.PARAM_APP_VER, "");
            l.g(context, "global_v2", Constants.PARAM_APP_VER, j6);
            y0.d(b6);
            if (TextUtils.isEmpty(b6)) {
                j1.h("hmsSdk", "app ver is first save!");
                return;
            } else {
                if (!b6.equals(j6)) {
                    j1.h("hmsSdk", "the appVers are different!");
                    a().g("", "alltype", b6);
                    return;
                }
                return;
            }
        }
        j1.h("hmsSdk", "userManager.isUserUnlocked() == false");
    }

    public void d(String str, int i6, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i6) {
            currentTimeMillis = q0.a("yyyy-MM-dd", currentTimeMillis);
        }
        e.d().b(new b(str2, jSONObject, str, q0.c(i6), currentTimeMillis));
    }

    public void f(String str, String str2) {
        if (c.b(str, str2)) {
            long k6 = c.k(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - k6 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                j1.b("hmsSdk", "begin to call onReport!");
                c.a(str, str2, currentTimeMillis);
                g(str, str2, y0.m());
                return;
            }
            j1.m("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        j1.h("hmsSdk", "auto report is closed tag:" + str);
    }
}
