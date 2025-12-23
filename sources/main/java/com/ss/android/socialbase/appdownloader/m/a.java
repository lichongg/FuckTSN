package com.ss.android.socialbase.appdownloader.m;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.az.m;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(m.j(str), 0));
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            byte[] decode = Base64.decode(m.j(str), 0);
            int length = str2.length();
            StringBuilder sb = new StringBuilder();
            int i6 = 0;
            for (byte b6 : decode) {
                if (i6 >= length) {
                    i6 %= length;
                }
                sb.append((char) (b6 ^ str2.charAt(i6)));
                i6++;
            }
            return sb.toString();
        }
        return null;
    }
}
