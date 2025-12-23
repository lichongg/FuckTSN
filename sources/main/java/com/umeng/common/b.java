package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f41594a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f41595b;

    /* renamed from: c, reason: collision with root package name */
    private static String f41596c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f41597d = au.b().b(au.f40908m);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f41598a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f41595b == null && context != null) {
                    f41595b = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                if (f41595b != null) {
                    f41596c = context.getPackageName();
                }
                bVar = a.f41598a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private SharedPreferences e() {
        Context context = f41595b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f41597d + f41596c, 0);
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41595b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41595b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void b() {
        SharedPreferences e6 = e();
        if (e6 != null) {
            e6.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e6 = e();
        if (e6 != null) {
            String string = e6.getString("au_p", null);
            String string2 = e6.getString("au_u", null);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                return new String[]{string, string2};
            }
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41595b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i6) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41595b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i6).commit();
        }
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null) {
            return "";
        }
        return sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0).edit();
        edit.remove(AnalyticsConfig.DEBUG_KEY);
        edit.remove(AnalyticsConfig.RTD_PERIOD);
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
