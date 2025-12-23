package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f42102b = "lastReqTime";

    /* renamed from: c, reason: collision with root package name */
    private static final int f42103c = 48;

    /* renamed from: d, reason: collision with root package name */
    private static final int f42104d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f42105e = 720;

    /* renamed from: f, reason: collision with root package name */
    private static final String f42106f = "iss";

    /* renamed from: g, reason: collision with root package name */
    private static final String f42107g = "sinr";

    /* renamed from: h, reason: collision with root package name */
    private static final String f42108h = "clean";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f42109i;

    /* renamed from: j, reason: collision with root package name */
    private static int f42110j;

    /* renamed from: a, reason: collision with root package name */
    private static final String f42101a = au.b().b(au.f40921z);

    /* renamed from: k, reason: collision with root package name */
    private static Object f42111k = new Object();

    private static int a(int i6) {
        if (i6 > 720) {
            return 720;
        }
        if (i6 < 1) {
            return 1;
        }
        return i6;
    }

    public static boolean a() {
        boolean z5;
        synchronized (f42111k) {
            z5 = f42109i;
        }
        return z5;
    }

    static {
        f42109i = false;
        f42110j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f42106f, "");
            if (!TextUtils.isEmpty(imprintProperty) && "1".equals(imprintProperty)) {
                synchronized (f42111k) {
                    f42109i = true;
                }
                String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f42107g, "");
                if (!TextUtils.isEmpty(imprintProperty)) {
                    try {
                        f42110j = a(Integer.parseInt(imprintProperty2));
                        return;
                    } catch (Throwable unused) {
                        f42110j = 48;
                        return;
                    }
                }
                f42110j = 48;
            }
        }
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f42101a, 0);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(f42102b, 0L);
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f42101a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f42108h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f42101a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f42108h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f42101a, 0);
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(f42108h, false);
    }

    public static int a(Context context) {
        int i6;
        synchronized (f42111k) {
            i6 = f42110j;
        }
        return i6;
    }

    public static boolean a(long j6, long j7, int i6) {
        Date date = new Date(j7);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j6));
        calendar.add(10, i6);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j6) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f42101a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f42102b, j6).commit();
        }
    }
}
