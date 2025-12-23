package com.bxkj.student.v2.common.utils.safe;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f20947a = new g();

    private final boolean c() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            boolean z5 = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null;
            process.destroy();
            return z5;
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    private final boolean a() {
        String str = Build.TAGS;
        return str != null && u.l3(str, "test-keys", false, 2, null);
    }

    private final boolean b() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i6 = 0; i6 < 10; i6++) {
            if (new File(strArr[i6]).exists()) {
                return true;
            }
        }
        return false;
    }

    private g() {
    }

    public final boolean d() {
        if (!a() && !b() && !c()) {
            return false;
        }
        return true;
    }
}
