package r2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f51988a = "02:00:00:00:00:00";

    @SuppressLint({"MissingPermission"})
    private static String b(Context context) {
        WifiInfo wifiInfo = null;
        try {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            String macAddress = connectionInfo != null ? connectionInfo.getMacAddress() : null;
            try {
                if (TextUtils.isEmpty(macAddress)) {
                    if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                        wifiManager.setWifiEnabled(false);
                    }
                    if (wifiManager != null) {
                        wifiInfo = wifiManager.getConnectionInfo();
                    }
                    if (wifiInfo != null) {
                        return wifiInfo.getMacAddress();
                    }
                }
                return macAddress;
            } catch (Exception unused) {
                return macAddress;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    private static String c(Context context) {
        String str = null;
        try {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            Field declaredField = wifiManager.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(wifiManager);
            Method declaredMethod = obj.getClass().getDeclaredMethod("getConnectionInfo", null);
            declaredMethod.setAccessible(true);
            WifiInfo wifiInfo = (WifiInfo) declaredMethod.invoke(obj, null);
            if (wifiInfo == null && !wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
                wifiManager.setWifiEnabled(false);
                wifiInfo = (WifiInfo) declaredMethod.invoke(obj, null);
            }
            try {
                Field declaredField2 = wifiInfo.getClass().getDeclaredField("mMacAddress");
                declaredField2.setAccessible(true);
                String str2 = (String) declaredField2.get(wifiInfo);
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } catch (Exception unused) {
                }
                str = str2;
            } catch (Exception unused2) {
            }
            return wifiInfo != null ? wifiInfo.getMacAddress() : str;
        } catch (Exception unused3) {
            return null;
        }
    }

    public static String a(Context context) {
        String c6 = c(context);
        if (!TextUtils.isEmpty(c6) && !f51988a.endsWith(c6)) {
            return c6;
        }
        String b6 = b(context);
        if (!TextUtils.isEmpty(b6)) {
            f51988a.endsWith(b6);
        }
        return b6;
    }
}
