package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    public static final String f40884a = "cl_count";

    /* renamed from: b, reason: collision with root package name */
    public static final String f40885b = "interval_";

    /* renamed from: c, reason: collision with root package name */
    public static final String f40886c = "config_ts";

    /* renamed from: d, reason: collision with root package name */
    public static final String f40887d = "iucc_s1";

    /* renamed from: e, reason: collision with root package name */
    public static final String f40888e = "iucc_s2";

    /* renamed from: f, reason: collision with root package name */
    public static final String f40889f = "sdk_type_ver";

    /* renamed from: g, reason: collision with root package name */
    public static final String f40890g = "should_fetch";

    /* renamed from: h, reason: collision with root package name */
    private static final String f40891h = "ccg_sp_config_file";

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f40891h, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private ar() {
    }
}
