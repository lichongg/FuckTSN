package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SearchUtils {
    public static String getVersion() {
        return "9.7.0";
    }

    public static String getPkgName(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        } catch (Throwable th) {
            j4.i(th, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                String upperCase = Integer.toHexString(b6 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            j4.i(th, "SearchUtils", "getSHA1");
            return null;
        }
    }
}
