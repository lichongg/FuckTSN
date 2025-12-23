package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f41911a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f41912b;

    /* renamed from: c, reason: collision with root package name */
    private static String f41913c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f41914d = au.b().b(au.f40908m);

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                f41912b = StubApp.getOrigApplicationContext(context.getApplicationContext());
                f41913c = context.getPackageName();
                if (f41911a == null) {
                    f41911a = new d(context);
                }
                dVar = f41911a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public String[] d() {
        try {
            SharedPreferences f6 = f();
            String string = f6.getString("au_p", null);
            String string2 = f6.getString("au_u", null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception unused) {
            return null;
        }
    }

    private SharedPreferences f() {
        return f41912b.getSharedPreferences(f41914d + f41913c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41912b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f41912b) > 0;
    }

    public d(Context context) {
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i6) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41912b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i6).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41912b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41912b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
