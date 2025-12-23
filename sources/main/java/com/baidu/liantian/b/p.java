package com.baidu.liantian.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private static String f10378a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f10378a)) {
            new p();
            f10378a = b(context);
        }
        return f10378a;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5 A[Catch: all -> 0x00f8, TryCatch #2 {all -> 0x00f8, blocks: (B:25:0x00bd, B:27:0x00d5, B:29:0x00db, B:30:0x00e5, B:51:0x00e2), top: B:24:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2 A[Catch: all -> 0x00f8, TryCatch #2 {all -> 0x00f8, blocks: (B:25:0x00bd, B:27:0x00d5, B:29:0x00db, B:30:0x00e5, B:51:0x00e2), top: B:24:0x00bd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.p.b(android.content.Context):java.lang.String");
    }

    private static String c(Context context) {
        try {
            return new com.baidu.liantian.e(context).f10458b.getString("rpnewuid", "");
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    private static String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    private static String e(Context context) {
        try {
        } catch (Throwable unused) {
            e.a();
        }
        if (!b(context, com.kuaishou.weapon.p0.g.f36049i)) {
            return "";
        }
        File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
        if (file.exists()) {
            return a(file);
        }
        return "";
    }

    private static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    private static String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read > 0) {
                        charArrayWriter.write(cArr, 0, read);
                    } else {
                        String charArrayWriter2 = charArrayWriter.toString();
                        try {
                            fileReader.close();
                            return charArrayWriter2;
                        } catch (Throwable unused) {
                            e.a();
                            return charArrayWriter2;
                        }
                    }
                }
            } catch (Throwable unused2) {
                try {
                    e.a();
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
            fileReader = null;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable unused) {
            e.a();
            return false;
        }
    }

    private static boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable unused) {
            e.a();
            return false;
        }
    }
}
