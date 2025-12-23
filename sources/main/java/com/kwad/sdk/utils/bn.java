package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bn {
    public static boolean RH() {
        return ag.m("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void RI() {
        ag.l("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void RJ() {
        ag.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean RK() {
        return ag.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void RL() {
        ag.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean RM() {
        return ag.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String ax(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String J = com.kwad.sdk.crash.utils.h.J(file);
            return TextUtils.isEmpty(J) ? "" : J;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(final Context context, final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.bn.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                bn.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        if (context != null) {
            com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
            RI();
        }
    }
}
