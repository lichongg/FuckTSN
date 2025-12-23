package r2;

import android.app.Application;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static String a(Application application) {
        WifiManager wifiManager = (WifiManager) application.getSystemService("wifi");
        String str = null;
        if (wifiManager != null) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (scanResults != null && connectionInfo != null) {
                for (int i6 = 0; i6 < scanResults.size(); i6++) {
                    ScanResult scanResult = scanResults.get(i6);
                    if (!TextUtils.isEmpty(connectionInfo.getBSSID()) && connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        }
        return str;
    }

    public static String d() {
        return e.b("cat /sys/class/net/wlan0/address", false).f37544b;
    }

    public static String b(Context context) {
        String d6 = d();
        if (!TextUtils.isEmpty(d6)) {
            return d6;
        }
        String c6 = c(context);
        if (!TextUtils.isEmpty(c6)) {
            return c6;
        }
        String a6 = a.a(context);
        if (!TextUtils.isEmpty(a6)) {
            return a6;
        }
        return "";
    }

    public static String c(Context context) {
        Enumeration<NetworkInterface> enumeration;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e6) {
            e6.printStackTrace();
            enumeration = null;
        }
        while (enumeration.hasMoreElements()) {
            NetworkInterface nextElement = enumeration.nextElement();
            byte[] bArr = new byte[0];
            try {
                bArr = nextElement.getHardwareAddress();
            } catch (SocketException e7) {
                e7.printStackTrace();
            }
            if (nextElement.getDisplayName().equals(e(context, "wifi.interface")) && bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b6 : bArr) {
                    sb.append(String.format("%02X:", Byte.valueOf(b6)));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        }
        return "";
    }

    private static String e(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            Method declaredMethod = loadClass.getDeclaredMethod("native_get", String.class);
            Object[] objArr = {str};
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(loadClass, objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
