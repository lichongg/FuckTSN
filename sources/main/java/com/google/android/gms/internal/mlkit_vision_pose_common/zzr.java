package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzr {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            length = objArr.length;
            if (i7 >= length) {
                break;
            }
            Object obj = objArr[i7];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e6) {
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), (Throwable) e6);
                    str2 = "<" + str3 + " threw " + e6.getClass().getName() + ">";
                }
            }
            objArr[i7] = str2;
            i7++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i8 = 0;
        while (true) {
            length2 = objArr.length;
            if (i6 >= length2 || (indexOf = str.indexOf("%s", i8)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i8, indexOf);
            sb.append(objArr[i6]);
            i6++;
            i8 = indexOf + 2;
        }
        sb.append((CharSequence) str, i8, str.length());
        if (i6 < length2) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i9 = i6 + 1; i9 < objArr.length; i9++) {
                sb.append(", ");
                sb.append(objArr[i9]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
