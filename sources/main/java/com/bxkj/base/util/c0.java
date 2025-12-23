package com.bxkj.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c0 {
    public static String a(String str) {
        String str2;
        String str3 = "";
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (b(charAt)) {
                try {
                    str2 = URLEncoder.encode(charAt + "", "UTF-8");
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                    str2 = null;
                }
                str3 = str3 + str2;
            } else {
                str3 = str3 + charAt;
            }
        }
        return str3;
    }

    private static boolean b(char c6) {
        return String.valueOf(c6).matches("[一-龥]");
    }
}
