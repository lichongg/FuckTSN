package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.au;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = au.b().b(au.f40905j);

    public static SharedPreferences getDefault(Context context) {
        if (context != null) {
            return context.getSharedPreferences(DEFAULT_PREFERENCE, 0);
        }
        return null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    private PreferenceWrapper() {
    }
}
