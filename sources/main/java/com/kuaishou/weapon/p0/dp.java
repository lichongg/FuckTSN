package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dp {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36022a = "plc001_t_re";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36023b = "wlpauct2";

    /* renamed from: c, reason: collision with root package name */
    public static final String f36024c = "plc001_pd_ptip_pi";

    /* renamed from: d, reason: collision with root package name */
    public static final String f36025d = "wiipaot";

    /* renamed from: e, reason: collision with root package name */
    public static final int f36026e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final String f36027f = "a1_p_s_p_s";

    /* renamed from: g, reason: collision with root package name */
    public static final String f36028g = "a1_p_s_p_s_c_b";

    /* renamed from: j, reason: collision with root package name */
    private static dp f36029j;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f36030h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f36031i;

    public static synchronized dp a(Context context) {
        dp dpVar;
        synchronized (dp.class) {
            try {
                if (f36029j == null) {
                    f36029j = new dp(context);
                }
                dpVar = f36029j;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dpVar;
    }

    public boolean b(String str) {
        return this.f36030h.getBoolean(str, false);
    }

    public void b(String str, String str2) {
        try {
            this.f36031i.putString(str, str2);
            this.f36031i.apply();
        } catch (Exception unused) {
        }
    }

    private dp(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bi.f35785r, 4);
            this.f36030h = sharedPreferences;
            this.f36031i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static dp a() {
        return f36029j;
    }

    public long a(String str) {
        return this.f36030h.getLong(str, 0L);
    }

    public void a(String str, long j6, boolean z5) {
        try {
            this.f36031i.putLong(str, j6);
            if (z5) {
                this.f36031i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int a(String str, int i6) {
        try {
            return this.f36030h.getInt(str, i6);
        } catch (Throwable unused) {
            return i6;
        }
    }

    public void a(String str, int i6, boolean z5) {
        try {
            this.f36031i.putInt(str, i6);
            if (z5) {
                this.f36031i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z5) {
        try {
            SharedPreferences.Editor editor = this.f36031i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z5) {
                    this.f36031i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str, String str2) {
        return this.f36030h.getString(str, str2);
    }
}
