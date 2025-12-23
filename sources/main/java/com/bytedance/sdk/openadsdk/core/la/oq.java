package com.bytedance.sdk.openadsdk.core.la;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    public static String[] j(boolean z5) {
        String[] strArr = {"", ""};
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (z5 && nextElement.getName().toLowerCase().contains("wlan")) {
                }
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                        String hostAddress = nextElement2.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (nextElement2 instanceof Inet6Address) {
                                sb.append(hostAddress);
                                sb.append(",");
                            } else if (nextElement2 instanceof Inet4Address) {
                                sb2.append(hostAddress);
                                sb2.append(",");
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(sb)) {
                sb = sb.delete(sb.length() - 1, sb.length());
            }
            if (!TextUtils.isEmpty(sb2)) {
                sb2 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            strArr[0] = sb2.toString();
            strArr[1] = sb.toString();
            return strArr;
        } catch (Throwable th) {
            vl.j(th);
            return strArr;
        }
    }
}
