package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import com.acse.ottn.util.HelpShopAppUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4633a = j1.c().b() + "_info";

    /* renamed from: b, reason: collision with root package name */
    public static SharedPreferences f4634b;

    /* renamed from: c, reason: collision with root package name */
    public static i1 f4635c;

    /* renamed from: d, reason: collision with root package name */
    public static SharedPreferences.Editor f4636d;

    public i1(Context context) {
        b();
    }

    public static synchronized i1 a() {
        synchronized (i1.class) {
            try {
                try {
                    if (HelpShopAppUtil.getContext() == null) {
                        return null;
                    }
                    if (f4635c == null) {
                        f4635c = new i1(HelpShopAppUtil.getContext());
                    }
                    return f4635c;
                } catch (Exception unused) {
                    if (f4635c == null) {
                        f4635c = new i1();
                    }
                    return f4635c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        try {
            if (f4634b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences(f4633a, 0);
                f4634b = sharedPreferences;
                if (sharedPreferences != null) {
                    f4636d = sharedPreferences.edit();
                }
            }
        } catch (Exception unused) {
            if (f4634b == null) {
                SharedPreferences sharedPreferences2 = HelpShopAppUtil.getContext().getSharedPreferences(HelpShopAppUtil.getContext().getPackageName() + "_info", 0);
                f4634b = sharedPreferences2;
                if (sharedPreferences2 != null) {
                    f4636d = sharedPreferences2.edit();
                }
            }
        }
    }

    public Long c(String str) {
        SharedPreferences sharedPreferences = f4634b;
        if (sharedPreferences == null || f4635c == null) {
            return 0L;
        }
        return Long.valueOf(sharedPreferences.getLong(str, 0L));
    }

    public String d(String str) {
        SharedPreferences sharedPreferences = f4634b;
        return (sharedPreferences == null || f4635c == null) ? "" : sharedPreferences.getString(str, "");
    }

    public i1() {
        try {
            if (f4634b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences("acse_info", 0);
                f4634b = sharedPreferences;
                if (sharedPreferences != null) {
                    f4636d = sharedPreferences.edit();
                }
            }
        } catch (Exception e6) {
            c2.a("preferences", e6.getMessage());
        }
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editor = f4636d;
        if (editor == null) {
            return;
        }
        editor.putString(str, str2).apply();
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = f4634b;
        return (sharedPreferences == null || f4635c == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public void b(String str, int i6) {
        SharedPreferences.Editor editor = f4636d;
        if (editor == null) {
            return;
        }
        editor.putInt(str, i6).apply();
    }

    public void a(String str, long j6) {
        SharedPreferences.Editor editor = f4636d;
        if (editor == null) {
            return;
        }
        editor.putLong(str, j6).apply();
    }

    public int b(String str) {
        SharedPreferences sharedPreferences = f4634b;
        if (sharedPreferences == null || f4635c == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public int a(String str, int i6) {
        SharedPreferences sharedPreferences = f4634b;
        return (sharedPreferences == null || f4635c == null) ? i6 : sharedPreferences.getInt(str, i6);
    }

    public void a(String str, boolean z5) {
        SharedPreferences.Editor editor = f4636d;
        if (editor == null) {
            return;
        }
        editor.putBoolean(str, z5).apply();
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = f4634b;
        if (sharedPreferences == null || f4635c == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }
}
