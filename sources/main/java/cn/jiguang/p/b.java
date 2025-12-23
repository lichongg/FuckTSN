package cn.jiguang.p;

import android.annotation.TargetApi;
import android.os.ParcelUuid;

@TargetApi(19)
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static String a(Object[] objArr) {
        int length;
        if (objArr == null || objArr.length - 1 == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i6 = 0;
        while (true) {
            sb.append(String.valueOf(objArr[i6]));
            if (i6 == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            i6++;
        }
    }

    public static String[] a(ParcelUuid[] parcelUuidArr) {
        if (parcelUuidArr == null || parcelUuidArr.length == 0) {
            return null;
        }
        int length = parcelUuidArr.length;
        String[] strArr = new String[length];
        for (int i6 = 0; i6 < length; i6++) {
            strArr[i6] = parcelUuidArr[i6].toString();
        }
        return strArr;
    }
}
