package cn.jiguang.be;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bi.g;
import cn.jiguang.bz.d;
import cn.jiguang.internal.JConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2034a;

    private static void a() {
        if (f2034a) {
            return;
        }
        f2034a = true;
        f.c("JCoreActionImpl", "init jcore impl ,version:" + cn.jiguang.a.a.f1444b + ",local version:" + JConstants.SDK_VERSION_INT);
        cn.jiguang.bi.c.a(d.a());
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            try {
                int a6 = cn.jiguang.ap.a.a();
                int e6 = cn.jiguang.ap.a.e();
                f.c("JCoreActionImpl", "custom:" + a6 + ",dynamic:" + e6);
                cn.jiguang.c.b.a(context, "core", a6, e6, cn.jiguang.a.a.f1445c);
                cn.jiguang.bi.c.b(d.a());
            } finally {
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        StringBuilder sb;
        a();
        if (TextUtils.isEmpty(str)) {
            f.j("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        boolean z5 = JConstants.isCallInit.get();
        f.c("JCoreActionImpl", " isCallInit=" + z5);
        f.c("JCoreActionImpl", "handleAction action:" + str);
        String string = bundle != null ? bundle.getString("sdk_type") : "";
        String str2 = null;
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    str2 = bundle.getString("report_data");
                } catch (Throwable th) {
                    th = th;
                    sb = new StringBuilder();
                }
            }
            b.a(context, (Object) str2);
            return;
        }
        if (str.equals("a12")) {
            if (bundle != null) {
                try {
                    str2 = bundle.getString("save_data");
                } catch (Throwable th2) {
                    th = th2;
                    sb = new StringBuilder();
                }
            }
            cn.jiguang.bq.b.a().a(str2);
            return;
        }
        if (str.startsWith("tcp_")) {
            if (z5) {
                g.a().a(context, str, bundle);
                return;
            }
            return;
        } else if (str.equals("a2")) {
            if (z5) {
                cn.jiguang.bi.f.a().a(context, true);
                return;
            }
            return;
        } else if (str.equals("a3")) {
            cn.jiguang.bi.b.a().a(context, string, bundle);
            return;
        } else {
            if (str.equals("a4")) {
                b.a(context, bundle);
                return;
            }
            return;
        }
        sb.append("report failed:");
        sb.append(th.getMessage());
        f.i("JCoreActionImpl", sb.toString());
    }
}
