package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static Context aHU;
    private static String aOV;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File LA() {
        File file;
        if (TextUtils.isEmpty(aOV)) {
            Context context = aHU;
            if (context == null) {
                context = ServiceProvider.Pp();
            }
            if (context == null) {
                try {
                    context = z.Dl();
                } catch (Throwable unused) {
                }
            }
            file = context != null ? new File(getDataDir(context), "kwad_ex") : null;
        } else {
            file = new File(aOV);
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File LB() {
        return new File(LA(), "java_crash/dump");
    }

    public static File LC() {
        return new File(LA(), "anr_log/dump");
    }

    public static File LD() {
        return new File(LA(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i6 >= 24 ? context.getDataDir() : null;
        if (dataDir != null) {
            return dataDir;
        }
        File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
        if (file.exists()) {
            return file;
        }
        return new File("/data/data/" + context.getPackageName());
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        aHU = context;
        aOV = str;
        aOV = w.P(context, "kwad_ex");
    }
}
