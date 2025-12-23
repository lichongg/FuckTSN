package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36052a = "re_po_rt";

    /* renamed from: e, reason: collision with root package name */
    private static h f36053e;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f36054b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f36055c;

    /* renamed from: d, reason: collision with root package name */
    private Context f36056d;

    public h(Context context, String str) {
        try {
            this.f36056d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f36054b = sharedPreferences;
            this.f36055c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized h a(Context context, String str) {
        h hVar;
        synchronized (h.class) {
            try {
                if (f36053e == null) {
                    synchronized (h.class) {
                        try {
                            if (f36053e == null) {
                                f36053e = new h(context, str);
                            }
                        } finally {
                        }
                    }
                }
                hVar = f36053e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public Context b() {
        return this.f36056d;
    }

    public void c(String str, String str2) {
        try {
            this.f36055c.putString(str, str2);
            this.f36055c.apply();
        } catch (Exception unused) {
        }
    }

    public void d(String str, int i6) {
        this.f36055c.putInt(str, i6);
        this.f36055c.apply();
    }

    public int b(String str) {
        try {
            return this.f36054b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean e(String str) {
        return this.f36054b.getBoolean(str, false);
    }

    public int b(String str, int i6) {
        try {
            return this.f36054b.getInt(str, i6);
        } catch (Exception unused) {
            return i6;
        }
    }

    public void c(String str, String str2, boolean z5) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z5) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f36055c.putString(str, str2);
            this.f36055c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.f36054b.getLong(str, 0L);
    }

    public String b(String str, String str2) {
        return this.f36054b.getString(str, str2);
    }

    public h(Context context) {
        try {
            this.f36056d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f36054b = sharedPreferences;
            this.f36055c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public String b(String str, String str2, boolean z5) {
        String b6 = b(str, "");
        return !TextUtils.isEmpty(b6) ? z5 ? c.b(b6, 2) : b6 : str2;
    }

    public static h a() {
        return f36053e;
    }

    public int c(String str, int i6) {
        try {
            return this.f36054b.getInt(str, i6);
        } catch (Exception unused) {
            return i6;
        }
    }

    public void a(Context context) {
        this.f36056d = context;
    }

    public void b(String str, long j6) {
        this.f36055c.putLong(str, j6);
        this.f36055c.apply();
    }

    public int c(String str) {
        try {
            return this.f36054b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f36055c.putString(str, str2);
            this.f36055c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.f36055c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z5) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f36055c.putString(str, str2);
            if (z5) {
                this.f36055c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        return this.f36054b.getString(str, "");
    }

    public void a(String str, int i6) {
        try {
            this.f36055c.putInt(str, i6);
            this.f36055c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i6, boolean z5) {
        try {
            this.f36055c.putInt(str, i6);
            if (z5) {
                this.f36055c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public long a(String str, long j6) {
        return this.f36054b.getLong(str, j6);
    }

    public void a(String str, Boolean bool) {
        this.f36055c.putBoolean(str, bool.booleanValue());
        this.f36055c.apply();
    }
}
