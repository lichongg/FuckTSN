package cn.jpush.android.z;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static byte[] a(int i6) {
        d dVar = new d(128);
        dVar.a(i6);
        return dVar.a();
    }

    public static byte[] a(int i6, byte b6, long j6, String str) {
        d dVar = new d(128);
        dVar.b(i6);
        dVar.a((int) b6);
        dVar.a(j6);
        if (!TextUtils.isEmpty(str)) {
            dVar.a(b(str));
        }
        return dVar.a();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            Logger.ee("PushPackage", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static byte[] c(String str) {
        d dVar = new d(8192);
        dVar.a(b(str));
        return dVar.a();
    }

    public static byte[] a(int i6, String str) {
        d dVar = new d(8192);
        dVar.a(i6);
        dVar.a(str);
        return dVar.a();
    }

    public static byte[] a(String str) {
        d dVar = new d(128);
        dVar.a(7);
        dVar.a(1);
        dVar.a(str != null ? b(str) : new byte[0]);
        return dVar.a();
    }

    public static byte[] a(String str, byte b6, boolean z5) {
        d dVar = new d(8192);
        dVar.a(TextUtils.isEmpty(str) ? new byte[0] : b(str));
        dVar.a((int) b6);
        dVar.a(!z5 ? 1 : 0);
        return dVar.a();
    }

    public static byte[] a(String str, int i6, String str2) {
        d dVar = new d(8192);
        if (i6 == 10) {
            dVar.a(b(str));
        }
        dVar.a(b(str2));
        return dVar.a();
    }
}
