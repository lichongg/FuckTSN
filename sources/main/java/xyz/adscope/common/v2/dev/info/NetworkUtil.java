package xyz.adscope.common.v2.dev.info;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NetworkUtil {
    private static final String PROXY_HOST = "http.proxyHost";
    private static final String PROXY_PORT = "http.proxyPort";
    private static final String VPN_MARK_PPP = "ppp0";
    private static final String VPN_MARK_TUN = "tun0";

    @SuppressLint({"MissingPermission"})
    public static boolean isNetworkValid(Context context) {
        Network activeNetwork;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && PermissionUtil.isPermissionGranted(context, g.f36042b)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = connectivityManager.getActiveNetwork();
                    return activeNetwork != null;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getConnectType(android.content.Context r2) {
        /*
            if (r2 != 0) goto L9
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_UNKNOWN
            int r2 = r2.getCode()
            return r2
        L9:
            android.content.Context r0 = r2.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L28
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r2 = xyz.adscope.common.v2.dev.info.PermissionUtil.isPermissionGranted(r2, r1)     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L28
            android.net.NetworkInfo r2 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L28
            goto L29
        L28:
            r2 = 0
        L29:
            if (r2 != 0) goto L32
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_UNKNOWN
            int r2 = r2.getCode()
            return r2
        L32:
            int r0 = r2.getType()
            r1 = 1
            if (r0 != r1) goto L40
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_WIFI
            int r2 = r2.getCode()
            return r2
        L40:
            if (r0 != 0) goto L90
            int r0 = r2.getSubtype()
            java.lang.String r2 = r2.getSubtypeName()
            switch(r0) {
                case 1: goto L89;
                case 2: goto L89;
                case 3: goto L82;
                case 4: goto L89;
                case 5: goto L82;
                case 6: goto L82;
                case 7: goto L89;
                case 8: goto L82;
                case 9: goto L82;
                case 10: goto L82;
                case 11: goto L89;
                case 12: goto L82;
                case 13: goto L7b;
                case 14: goto L82;
                case 15: goto L82;
                case 16: goto L89;
                case 17: goto L82;
                case 18: goto L7b;
                case 19: goto L4d;
                case 20: goto L74;
                default: goto L4d;
            }
        L4d:
            java.lang.String r0 = "TD-SCDMA"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L6d
            java.lang.String r0 = "WCDMA"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L6d
            java.lang.String r0 = "CDMA2000"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L66
            goto L6d
        L66:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_UNKNOWN
            int r2 = r2.getCode()
            return r2
        L6d:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_3G
            int r2 = r2.getCode()
            return r2
        L74:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_5G
            int r2 = r2.getCode()
            return r2
        L7b:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_4G
            int r2 = r2.getCode()
            return r2
        L82:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_3G
            int r2 = r2.getCode()
            return r2
        L89:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_2G
            int r2 = r2.getCode()
            return r2
        L90:
            xyz.adscope.common.v2.dev.DeviceInfoConstants$ConnectType r2 = xyz.adscope.common.v2.dev.DeviceInfoConstants.ConnectType.CONNECT_TYPE_UNKNOWN
            int r2 = r2.getCode()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.v2.dev.info.NetworkUtil.getConnectType(android.content.Context):int");
    }

    public static boolean isProxyConnected(Context context) {
        return (TextUtils.isEmpty(System.getProperty(PROXY_HOST)) || TextUtils.isEmpty(System.getProperty(PROXY_PORT))) ? false : true;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiConnected(Context context) {
        Network activeNetwork;
        if (PermissionUtil.isPermissionGranted(context, g.f36042b)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                return networkCapabilities != null && networkCapabilities.hasTransport(1);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && "wifi".equalsIgnoreCase(activeNetworkInfo.getTypeName().trim())) {
                return true;
            }
        }
        return false;
    }

    private NetworkUtil() {
    }

    public static boolean isVPNConnected() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                String name = ((NetworkInterface) it.next()).getName();
                if (VPN_MARK_TUN.equals(name) || VPN_MARK_PPP.equals(name)) {
                    return true;
                }
            }
            return false;
        } catch (SocketException e6) {
            SDKLog.stack(e6);
            return false;
        }
    }
}
