package xyz.adscope.common.tool.security;

import android.util.Base64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Base64Util {
    public static String decode(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
