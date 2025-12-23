package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n {
    private static boolean asQ;
    private static long asy;

    public static boolean aT(Context context) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean("initFail", false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    public static void CO() {
        if (asQ) {
            return;
        }
        asQ = true;
        asy = SystemClock.elapsedRealtime();
    }

    public static void a(Throwable th, String str) {
        try {
            m.a(com.kwai.adclient.kscommerciallogger.model.a.beF, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        aR(ServiceProvider.Pp());
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onInitError revert");
    }

    private static void aR(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString("curversion", "").putBoolean("initFail", true).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static void aS(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("initFail", false).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private static SdkConfig aU(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(b(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        return sdkConfig == null ? new SdkConfig.Builder().build() : sdkConfig;
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void aQ(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - asy;
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < 10000) {
            aR(context);
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (l.Cf().Bn()) {
                return;
            }
            KsAdSDK.init(context, aU(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }
}
