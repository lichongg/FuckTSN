package com.acse.ottn;

import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c2 {
    public static void a(String str, String str2) {
        if (j3.a() == null || !j3.a().a("debug_state") || TextUtils.isEmpty(str2)) {
            return;
        }
        Process.myPid();
    }

    public static void b(String str, String str2) {
        if (j3.a() != null && j3.a().a("debug_state") && !TextUtils.isEmpty(str2)) {
            Process.myPid();
        }
    }

    public static void c(String str, String str2) {
        if (j3.a() != null && j3.a().a("debug_state") && !TextUtils.isEmpty(str2)) {
            Process.myPid();
        }
    }

    public static void d(String str, String str2) {
        if (j3.a() != null && j3.a().a("debug_state") && !TextUtils.isEmpty(str2)) {
            Process.myPid();
        }
    }

    public static void a(String str, String str2, IOException iOException) {
        if (j3.a() != null && j3.a().a("debug_state")) {
            TextUtils.isEmpty(str2);
        }
    }
}
