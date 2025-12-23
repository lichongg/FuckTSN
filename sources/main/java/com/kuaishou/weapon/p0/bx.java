package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static String f35824a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b, reason: collision with root package name */
    private static String f35825b = c.b(f35825b, 2);

    /* renamed from: b, reason: collision with root package name */
    private static String f35825b = c.b(f35825b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c6 = c(context);
        if (TextUtils.isEmpty(c6)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c6);
        return str2;
    }

    public static String b(Context context) {
        String c6 = c(context);
        String d6 = d(context);
        if (!TextUtils.isEmpty(c6) && TextUtils.equals(c6, d6)) {
            return c6;
        }
        if (!TextUtils.isEmpty(c6)) {
            b(context, c6);
            return c6;
        }
        if (TextUtils.isEmpty(d6)) {
            return "";
        }
        a(context, d6);
        return d6;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f35824a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        boolean canWrite;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                canWrite = Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                if (!canWrite) {
                    return;
                }
            }
            Settings.System.putString(context.getContentResolver(), f35824a, str);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}
