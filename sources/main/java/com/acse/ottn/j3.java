package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import com.tencent.mmkv.MMKV;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j3 {

    /* renamed from: b, reason: collision with root package name */
    public static j3 f4662b;

    /* renamed from: a, reason: collision with root package name */
    public MMKV f4663a;

    public static synchronized j3 a() {
        synchronized (j3.class) {
            try {
                if (HelpShopAppUtil.getContext() == null) {
                    return null;
                }
                if (f4662b == null) {
                    f4662b = new j3(HelpShopAppUtil.getContext());
                }
                return f4662b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(String str, String str2) {
        this.f4663a.encode(str, str2);
    }

    public float b(String str) {
        return this.f4663a.decodeFloat(str, 0.0f);
    }

    public int c(String str) {
        return this.f4663a.decodeInt(str, 0);
    }

    public long d(String str) {
        return this.f4663a.decodeLong(str, 0L);
    }

    public String e(String str) {
        return this.f4663a.decodeString(str, "");
    }

    public String[] f(String str) {
        String decodeString = this.f4663a.decodeString(str, "");
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        return decodeString.substring(1, decodeString.length() - 1).split(",");
    }

    public j3(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(HelpShopAppUtil.getContext().getPackageName() + "_info", 0);
        if (this.f4663a == null) {
            this.f4663a = MMKV.mmkvWithID("ID", 2);
        }
        if (!sharedPreferences.getAll().isEmpty()) {
            this.f4663a.importFromSharedPreferences(sharedPreferences);
            sharedPreferences.edit().clear().apply();
        }
    }

    public String a(String str, String str2) {
        return this.f4663a.decodeString(str, str2);
    }

    public void a(String str, int i6) {
        this.f4663a.encode(str, i6);
    }

    public void a(String str, long j6) {
        this.f4663a.encode(str, j6);
    }

    public long a(String str, Long l6) {
        return this.f4663a.decodeLong(str, l6.longValue());
    }

    public void a(String str, Boolean bool) {
        this.f4663a.encode(str, bool.booleanValue());
    }

    public boolean a(String str) {
        return this.f4663a.decodeBool(str, false);
    }

    public void a(String str, Float f6) {
        this.f4663a.encode(str, f6.floatValue());
    }

    public void a(String str, String[] strArr) {
        this.f4663a.encode(str, Arrays.toString(strArr));
    }
}
