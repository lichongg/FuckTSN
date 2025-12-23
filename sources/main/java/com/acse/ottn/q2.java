package com.acse.ottn;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ObjectStreamException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q2 {

    /* renamed from: a, reason: collision with root package name */
    public static q2 f5025a;

    public static q2 a() {
        if (f5025a == null) {
            synchronized (q2.class) {
                try {
                    if (f5025a == null) {
                        f5025a = new q2();
                    }
                } finally {
                }
            }
        }
        return f5025a;
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public final Object c() throws ObjectStreamException {
        return f5025a;
    }

    public static boolean e(Context context) {
        return ((LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS);
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public String c(Context context) {
        NetworkInfo networkInfo;
        NetworkInfo networkInfo2;
        if (context == null) {
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkInfo = connectivityManager.getNetworkInfo(0);
            networkInfo2 = connectivityManager.getNetworkInfo(1);
        } catch (Exception unused) {
            c2.a("getIpAddress", "getIpAddress is null");
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return b();
        }
        if (networkInfo2 != null && networkInfo2.isConnected()) {
            return d(context);
        }
        return "";
    }

    public final String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return a(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception e6) {
            c2.a("WifiManager", e6.getMessage());
            return "";
        }
    }

    public final String b() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
            return 4;
        }
        int i6 = 3;
        if (subtype != 3 && subtype != 8 && (subtype != 5 || telephonyManager.isNetworkRoaming())) {
            i6 = 2;
            if (subtype != 1 && subtype != 2 && subtype == 4) {
                telephonyManager.isNetworkRoaming();
            }
        }
        return i6;
    }

    public final String a(int i6) {
        return (i6 & 255) + "." + ((i6 >> 8) & 255) + "." + ((i6 >> 16) & 255) + "." + ((i6 >> 24) & 255);
    }
}
