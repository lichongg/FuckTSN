package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes3.dex */
final class qo {

    static class j implements Runnable {
        private final String cw = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        /* renamed from: j, reason: collision with root package name */
        private final Runnable f24038j;
        private final String xt;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f24038j.run();
            } catch (Exception e6) {
                uc.cw("Thread:" + this.xt + " exception\n" + this.cw, e6);
            }
        }

        j(Runnable runnable, String str) {
            this.f24038j = runnable;
            this.xt = str;
        }
    }

    static boolean j(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }

    static boolean j(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        }
        return true;
    }

    static void j(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.oq.r.cw(new j(runnable, str), str).start();
    }
}
