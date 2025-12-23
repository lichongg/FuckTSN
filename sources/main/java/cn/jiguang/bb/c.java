package cn.jiguang.bb;

import androidx.exifinterface.media.ExifInterface;
import cn.jiguang.internal.JConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    public static void a(String str, String str2, boolean z5, int i6, String str3, Throwable th) {
        boolean z6;
        String str4;
        StringBuilder sb;
        try {
            if (cn.jiguang.a.a.f1449g) {
                if (i6 == 2) {
                    str4 = ExifInterface.GPS_DIRECTION_TRUE;
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i6 == 3) {
                    str4 = "D";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i6 == 4) {
                    str4 = "I";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i6 == 5) {
                    str4 = ExifInterface.LONGITUDE_WEST;
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i6 == 6) {
                    str4 = ExifInterface.LONGITUDE_EAST;
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                }
                e.a(str4, sb.toString(), str2, str3, null);
            }
            try {
                z6 = JConstants.CMD_TO_PRINT_ALL_LOG;
            } catch (Throwable unused) {
                z6 = false;
            }
            if (z6) {
                return;
            }
            if (JConstants.DEBUG_MODE || i6 >= 5) {
                if (!z5 || i6 >= 6) {
                    a(i6);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static boolean a(int i6) {
        return i6 >= 2;
    }
}
