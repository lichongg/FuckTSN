package cn.jiguang.bz;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2722a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f2723b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f2724c;

    public static void a(final Context context) {
        cn.jiguang.bb.f.c("AuthUtils", " sync status");
        cn.jiguang.by.d.a("DELAY_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bz.b.1
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    if (Math.abs(System.currentTimeMillis() - ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.J())).longValue()) < 432000000) {
                        cn.jiguang.bb.f.c("AuthUtils", "sync status no need report");
                        return;
                    }
                    cn.jiguang.bb.f.c("AuthUtils", "start sync status");
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(System.currentTimeMillis());
                    jSONArray2.put(System.currentTimeMillis());
                    jSONObject2.put("duration", jSONArray2);
                    jSONObject2.put("c_type", "set_auth");
                    JSONArray jSONArray3 = new JSONArray();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", "" + (!b.f2724c ? 1 : 0));
                    jSONObject3.put("s_type", "set_auth");
                    jSONArray3.put(jSONObject3);
                    jSONObject2.put("statistics", jSONArray3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("slice_index", 1);
                    jSONObject.put("slice_count", 1);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                    cn.jiguang.bb.f.c("AuthUtils", "reportJSON=" + jSONObject);
                    cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.J().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                    cn.jiguang.be.b.a(context, jSONObject, "collect_statistic");
                } catch (Throwable th) {
                    cn.jiguang.bb.f.c("AuthUtils", "sync status  throwable=" + th);
                }
            }
        }, AVMDLDataLoader.KeyIsLiveSetLoaderType);
    }

    public static void b(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "enableipv6 priority status: " + z5);
        f(context, z5);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_ci_priority", z5);
        cn.jiguang.a.a.a(context, "a11", bundle);
    }

    public static void c(Context context, boolean z5) {
    }

    public static void d(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "enableAutoWakeup config status: " + z5);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.f().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
    }

    public static void e(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "setDynamicLoad config enable: " + z5);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.h().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
    }

    public static void a(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "enableAutoWakeup status: " + z5);
        d(context, z5);
        cn.jiguang.bi.a.a(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_auto_wakeup", z5);
        cn.jiguang.a.a.a(context, "a8", bundle);
    }

    public static boolean b() {
        return f2724c;
    }

    public static boolean d(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.i())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean e(Context context) {
        try {
            if (f2723b == null) {
                f2723b = (Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.g());
            }
            return f2723b.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "IPV6First config enable: " + z5);
        f2723b = Boolean.valueOf(z5);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.g().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
    }

    public static void g(Context context, boolean z5) {
        cn.jiguang.bb.f.c("AuthUtils", "setAppTerminate config enable: " + z5);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.i().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
    }

    public static void a(boolean z5, boolean z6) {
        f2724c = z6;
        f2722a = z5;
    }

    public static boolean b(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.f())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean c(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.h())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean a() {
        return f2722a;
    }
}
