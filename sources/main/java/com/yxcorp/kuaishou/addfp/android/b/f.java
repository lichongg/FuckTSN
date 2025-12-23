package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f42935a;

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    public static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                th3.printStackTrace();
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    public static void a(boolean z5) {
        f42935a = z5;
    }

    public static boolean a(Context context, String[] strArr) {
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
