package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41828a = au.b().b(au.f40913r);

    /* renamed from: b, reason: collision with root package name */
    private static final String f41829b = "um_common_strength";

    /* renamed from: c, reason: collision with root package name */
    private static final String f41830c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41828a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f41830c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41828a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f41830c, str).commit();
    }
}
