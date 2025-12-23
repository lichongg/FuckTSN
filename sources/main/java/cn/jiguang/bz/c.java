package cn.jiguang.bz;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    private static int a(int i6) {
        if (i6 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 < -140 || i6 > 0) {
            return 0;
        }
        return i6;
    }

    private static int b(int i6) {
        if (i6 == -1 || i6 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 < 0 || i6 >= 65535) {
            return 0;
        }
        return i6;
    }

    private static long a(long j6, boolean z5) {
        if (j6 == -1 || j6 == 2147483647L || j6 == Long.MAX_VALUE || j6 == -2147483648L || j6 == Long.MIN_VALUE || j6 < 0) {
            return 0L;
        }
        if (z5) {
            if (j6 >= 68719476735L) {
                return 0L;
            }
        } else if (j6 >= 268435455) {
            return 0L;
        }
        return j6;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0256 A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #0 {Exception -> 0x0052, blocks: (B:7:0x0012, B:10:0x001b, B:12:0x0046, B:13:0x0069, B:15:0x0073, B:16:0x007d, B:17:0x0081, B:18:0x0252, B:20:0x0256, B:38:0x0055, B:39:0x0089, B:41:0x008d, B:43:0x00b8, B:44:0x00d8, B:46:0x00e2, B:47:0x00ec, B:48:0x00c4, B:49:0x00f1, B:52:0x00f7, B:54:0x0122, B:55:0x0142, B:57:0x014b, B:58:0x0155, B:59:0x012e, B:60:0x015b, B:62:0x015f, B:64:0x0194, B:65:0x019e, B:68:0x01a6, B:70:0x01ac, B:72:0x0200, B:74:0x0206), top: B:6:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.al.d a(android.telephony.CellInfo r11) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.c.a(android.telephony.CellInfo):cn.jiguang.al.d");
    }

    private static int c(int i6) {
        if (i6 != Integer.MAX_VALUE && i6 != -1 && i6 >= 1 && i6 <= 999) {
            return i6;
        }
        return 0;
    }

    private static int d(int i6) {
        if (i6 != Integer.MAX_VALUE && i6 != -1 && i6 >= 0 && i6 <= 999) {
            return i6;
        }
        return 0;
    }

    private static String a(int i6, int i7) {
        if (i6 <= 0 || i7 < 0) {
            return "";
        }
        if (i6 == 460) {
            return i7 == 11 ? "46011" : String.format("%03d%02d", Integer.valueOf(i6), Integer.valueOf(i7));
        }
        return String.format("%03d", Integer.valueOf(i6)) + i7;
    }

    private static String a(CharSequence charSequence) {
        return (charSequence == null || TextUtils.isEmpty(charSequence.toString())) ? "" : charSequence.toString().trim();
    }

    private static void a(cn.jiguang.al.d dVar, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                dVar.f1583d = 0;
            } else {
                dVar.f1583d = Integer.parseInt(str);
            }
            if (TextUtils.isEmpty(str2)) {
                dVar.f1584e = 0;
            } else {
                dVar.f1584e = Integer.parseInt(str2);
            }
        } catch (NumberFormatException unused) {
            dVar.f1583d = 0;
            dVar.f1584e = 0;
        }
    }
}
