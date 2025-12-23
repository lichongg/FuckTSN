package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class bo {
    static final String TAG = "bo";

    static void a(String str, String str2, long j6) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return;
        }
        ho.edit().putLong(str2, j6).apply();
    }

    static void b(String str, String str2, int i6) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return;
        }
        ho.edit().putInt(str2, i6).apply();
    }

    static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    static void a(String str, String str2, String str3, boolean z5) {
        try {
            SharedPreferences ho = ho(str);
            if (ho == null) {
                return;
            }
            if (z5 && !com.kwad.sdk.core.a.c.isEncodeKsSdk(str3)) {
                ho.edit().putString(str2, com.kwad.sdk.core.a.c.encodeKsSdk(str3)).apply();
            } else {
                ho.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    static void ay(String str, String str2) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return;
        }
        ho.edit().remove(str2).apply();
    }

    static long b(String str, String str2, long j6) {
        SharedPreferences ho = ho(str);
        return ho == null ? j6 : ho.getLong(str2, j6);
    }

    static int c(String str, String str2, int i6) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return i6;
        }
        return ho.getInt(str2, i6);
    }

    static String h(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences ho = ho(str);
            if (ho != null && (string = ho.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                if (!TextUtils.equals(string, str3) && com.kwad.sdk.core.a.c.isEncodeKsSdk(string)) {
                    return com.kwad.sdk.core.a.c.decodeKsSdk(string);
                }
                return string;
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    @Nullable
    public static SharedPreferences ho(String str) {
        try {
            return ServiceProvider.Pp().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    static void i(String str, String str2, String str3) {
        if (!com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
            g(str2, str3, com.kwad.sdk.core.a.c.encodeKsSdk(str));
        }
    }

    static void l(String str, String str2, boolean z5) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return;
        }
        ho.edit().putBoolean(str2, z5).apply();
    }

    static boolean m(String str, String str2, boolean z5) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return z5;
        }
        return ho.getBoolean(str2, z5);
    }

    static <T> void a(String str, Map<String, T> map) {
        SharedPreferences ho = ho(str);
        if (ho == null) {
            return;
        }
        SharedPreferences.Editor edit = ho.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
