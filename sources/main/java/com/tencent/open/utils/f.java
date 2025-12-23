package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f40651a;

    /* renamed from: b, reason: collision with root package name */
    private String f40652b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.utils.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f40653a = new f(null);
    }

    /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static f a() {
        return a.f40653a;
    }

    public String b(Context context) {
        return this.f40651a;
    }

    private f() {
        this.f40651a = "";
        this.f40652b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f40652b;
        if (str == null || str.trim().isEmpty()) {
            this.f40652b = sharedPreferences.getString("build_model", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f40652b);
        }
        String str2 = this.f40651a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f40651a = sharedPreferences.getString("build_device", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.f40651a);
        }
    }

    public String b() {
        return this.f40652b;
    }

    public String c(Context context) {
        return this.f40652b;
    }

    public void a(Context context, String str) {
        SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f40652b;
            if (str2 != null && str2.equals(str)) {
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f40652b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f40652b).commit();
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f40652b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}
