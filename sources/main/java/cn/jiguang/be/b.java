package cn.jiguang.be;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import cn.jiguang.bd.d;
import cn.jiguang.bi.g;
import cn.jiguang.bz.h;
import cn.jiguang.internal.JConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f2035a;

    /* renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f2036b = new AtomicBoolean();

    public static void a(Context context) {
        cn.jiguang.e.b.a(context, "cn.jiguang.sdk.user.profile");
    }

    public static void b(Context context) {
        d.a(context);
    }

    public static void a(Context context, int i6) {
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.G().a((cn.jiguang.e.a<Integer>) Integer.valueOf(i6))});
    }

    public static void b(Context context, JSONObject jSONObject, String str) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, cn.jiguang.d.a.a(context, jSONObject, str));
    }

    public static void c(Runnable runnable) {
        cn.jiguang.by.d.a("MAJOR_TASK", runnable);
    }

    public static void d(Runnable runnable) {
        cn.jiguang.by.d.a("NORMAL_TASK", runnable);
    }

    public static void e(Runnable runnable) {
        cn.jiguang.by.d.a("FUTURE_TASK", runnable);
    }

    public static void a(Context context, long j6) {
        if (j6 > 0) {
            cn.jiguang.d.b.b(context, j6);
        }
    }

    public static void b(Runnable runnable) {
        cn.jiguang.by.d.a("SCHEDULE_TASK", runnable);
    }

    public static void a(Context context, long j6, String str, String str2) {
        cn.jiguang.e.b.b(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.B().a((cn.jiguang.e.a<Long>) Long.valueOf(j6)), cn.jiguang.e.a.E().a((cn.jiguang.e.a<String>) str), cn.jiguang.e.a.C().a((cn.jiguang.e.a<String>) str2), cn.jiguang.e.a.D().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle != null) {
            f2036b.set(bundle.getBoolean("foreground"));
            int i6 = bundle.getInt("user_type");
            f2035a = i6;
            if (i6 == -1) {
                f2035a = f2036b.get() ? 1 : 0;
            }
            boolean z5 = JConstants.isCallInit.get();
            f.c("JCoreManagerInternal", "changeForeGroundStat:" + f2036b.get() + ", userActiveType:" + f2035a + " isCallInit=" + z5);
            if (f2036b.get()) {
                if (!z5) {
                    return;
                }
                if (g.a().f() >= 120) {
                    g.a().i();
                }
            }
            cn.jiguang.v.a.a(context, "foreground_state_change", bundle);
        }
    }

    public static void a(Context context, Object obj) {
        cn.jiguang.bd.f.a(context, obj);
    }

    public static void a(Context context, String str) {
        h.a(context, str);
    }

    public static void a(Context context, JSONObject jSONObject, String str) {
        cn.jiguang.bd.f.a(context, cn.jiguang.d.a.a(context, jSONObject, str));
    }

    public static void a(Runnable runnable) {
        cn.jiguang.by.d.a("NORMAL_TASK", runnable);
    }

    public static void a(Runnable runnable, int i6) {
        cn.jiguang.by.d.a("DELAY_TASK", runnable, i6);
    }
}
