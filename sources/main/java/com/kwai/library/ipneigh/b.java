package com.kwai.library.ipneigh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class b {
    private static final Pattern bfl = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"DefaultLocale"})
    public static String fl(int i6) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i6 & 255), Integer.valueOf((i6 >> 8) & 255), Integer.valueOf((i6 >> 16) & 255), Integer.valueOf((i6 >> 24) & 255));
    }

    private static boolean hS(String str) {
        if (str == null) {
            return false;
        }
        return bfl.matcher(str).matches();
    }

    public static String hT(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\s+");
        return (split.length >= 5 && hS(split[4])) ? split[4] : "";
    }
}
