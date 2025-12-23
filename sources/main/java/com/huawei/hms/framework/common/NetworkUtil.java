package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class NetworkUtil {
    public static final int UNAVAILABLE = Integer.MAX_VALUE;

    /* renamed from: a, reason: collision with root package name */
    private static final String f33329a = "NetworkUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f33330b = 13;

    /* renamed from: c, reason: collision with root package name */
    private static final int f33331c = -127;

    /* renamed from: d, reason: collision with root package name */
    private static final String f33332d = "5G_NSA";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33333e = "5G_SA";
    public static volatile int networkTypeByReceiver;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
    }

    private static int d(int i6) {
        int i7 = -1;
        if (i6 != -1) {
            i7 = 1;
            if (i6 != 1) {
                return (i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5) ? 6 : 0;
            }
        }
        return i7;
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getPrimaryNetworkType(Context context) {
        return d(getNetworkType(getNetworkInfo(context), context));
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        int restrictBackgroundStatus;
        if (context != null && Build.VERSION.SDK_INT >= 24 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36042b)) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
                        return restrictBackgroundStatus;
                    }
                    Logger.v(f33329a, "ConnectType is not Mobile Network!");
                    return 0;
                } catch (RuntimeException e6) {
                    Logger.e(f33329a, "SystemServer error:", e6);
                }
            }
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    private static String[] a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (context != null && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                            Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().getHostAddress());
                            }
                        }
                    }
                }
            } catch (SecurityException e6) {
                Logger.i(f33329a, "getActiveNetworkInfo failed, exception:" + e6.getClass().getSimpleName());
            } catch (RuntimeException e7) {
                Logger.i(f33329a, "getActiveNetworkInfo failed, exception:" + e7.getClass().getSimpleName());
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static int b(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        List cellSignalStrengths2;
        List cellSignalStrengths3;
        int dbm;
        List cellSignalStrengths4;
        List cellSignalStrengths5;
        int dbm2;
        if (Build.VERSION.SDK_INT <= 28 || (c6 = c(context)) == null) {
            return Integer.MAX_VALUE;
        }
        int networkType = getNetworkType(context);
        try {
            if (networkType == 3) {
                cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthCdma.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthCdma) cellSignalStrengths.get(0)).getDbm();
                }
                cellSignalStrengths2 = c6.getCellSignalStrengths(g.a());
                if (cellSignalStrengths2.size() > 0) {
                    dbm = h.a(cellSignalStrengths2.get(0)).getDbm();
                    return dbm;
                }
                cellSignalStrengths3 = c6.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                if (cellSignalStrengths3.size() > 0) {
                    return ((CellSignalStrengthWcdma) cellSignalStrengths3.get(0)).getDbm();
                }
            } else if (networkType == 4) {
                cellSignalStrengths4 = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths4.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths4.get(0)).getDbm();
                }
            } else if (networkType == 5) {
                cellSignalStrengths5 = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths5.size() > 0) {
                    dbm2 = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths5.get(0)).getDbm();
                    return dbm2;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getMobileSingalStrength: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    private static SignalStrength c(Context context) {
        SignalStrength signalStrength;
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        signalStrength = getTrafficCardTelephonyManager(context).getSignalStrength();
        return signalStrength;
    }

    public static int getCurrentNetworkType() {
        return networkTypeByReceiver;
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return Integer.MAX_VALUE;
            }
            final Method declaredMethod = SignalStrength.class.getDeclaredMethod(str, null);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.NetworkUtil.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    declaredMethod.setAccessible(true);
                    return null;
                }
            });
            return ((Integer) declaredMethod.invoke(signalStrength, null)).intValue();
        } catch (IllegalAccessException unused) {
            Logger.i(f33329a, str + " : cannot access");
            return Integer.MAX_VALUE;
        } catch (NoSuchMethodException unused2) {
            Logger.i(f33329a, str + " : function not found");
            return Integer.MAX_VALUE;
        } catch (InvocationTargetException unused3) {
            Logger.i(f33329a, str + " : InvocationTargetException");
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, str + " : throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        List cellSignalStrengths;
        int rsrp;
        int rsrq;
        int rssnr;
        int cqi;
        int rssi;
        HashMap hashMap = new HashMap();
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    hashMap.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(c6, "getDbm")));
                    hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(c6, "getLteRsrp")));
                    hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(c6, "getLteRsrq")));
                    hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(c6, "getLteRssnr")));
                    hashMap.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(c6, "getLteCqi")));
                    return hashMap;
                }
                cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    hashMap.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                    rsrp = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
                    hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(rsrp));
                    rsrq = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
                    hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(rsrq));
                    rssnr = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
                    hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(rssnr));
                    cqi = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
                    hashMap.put(SignalType.LTE_CQI, Integer.valueOf(cqi));
                    rssi = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                    hashMap.put(SignalType.LTE_RSSI, Integer.valueOf(rssi));
                    return hashMap;
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRssi: throwable:" + th.getClass());
                return hashMap;
            }
        }
        return hashMap;
    }

    public static String getMNC(Context context) {
        if (context == null || !isSimReady(context)) {
            return "unknown";
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            Logger.e(f33329a, "getSubscriptionOperatorType: other error!");
            return "unknown";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? "China_Unicom" : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? "China_Mobile" : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "China_Telecom" : "other";
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36042b) && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (RuntimeException e6) {
                Logger.i(f33329a, "getActiveNetworkInfo failed, exception:" + e6.getClass().getSimpleName() + e6.getMessage());
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                try {
                    if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36042b)) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            return activeNetworkInfo.getDetailedState();
                        }
                        Logger.i(f33329a, "getNetworkStatus networkIsConnected netInfo is null!");
                        return detailedState;
                    }
                } catch (RuntimeException e6) {
                    Logger.i(f33329a, "getNetworkStatus exception" + e6.getClass().getSimpleName() + e6.getMessage());
                }
            } else {
                Logger.i(f33329a, "getNetworkStatus ConnectivityManager is null!");
            }
        }
        return detailedState;
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        List cellSignalStrengths;
        int dbm;
        int csiRsrp;
        int csiRsrq;
        int csiSinr;
        int ssRsrp;
        int ssRsrq;
        int ssSinr;
        HashMap hashMap = new HashMap();
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                    if (cellSignalStrengths.size() > 0) {
                        dbm = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getDbm();
                        hashMap.put(SignalType.NR_DBM, Integer.valueOf(dbm));
                        csiRsrp = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiRsrp();
                        hashMap.put(SignalType.NR_CSIRSRP, Integer.valueOf(csiRsrp));
                        csiRsrq = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiRsrq();
                        hashMap.put(SignalType.NR_CSIRSRQ, Integer.valueOf(csiRsrq));
                        csiSinr = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiSinr();
                        hashMap.put(SignalType.NR_CSISINR, Integer.valueOf(csiSinr));
                        ssRsrp = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsRsrp();
                        hashMap.put(SignalType.NR_SSRSRP, Integer.valueOf(ssRsrp));
                        ssRsrq = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsRsrq();
                        hashMap.put(SignalType.NR_SSRSRQ, Integer.valueOf(ssRsrq));
                        ssSinr = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsSinr();
                        hashMap.put(SignalType.NR_SSSINR, Integer.valueOf(ssSinr));
                        return hashMap;
                    }
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRssi: throwable:" + th.getClass());
                return hashMap;
            }
        }
        return hashMap;
    }

    public static TelephonyManager getTrafficCardTelephonyManager(Context context) {
        int defaultDataSubscriptionId;
        TelephonyManager createForSubscriptionId;
        if (context == null) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (!(systemService instanceof TelephonyManager)) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (Build.VERSION.SDK_INT < 24) {
            return telephonyManager;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        createForSubscriptionId = telephonyManager.createForSubscriptionId(defaultDataSubscriptionId);
        return createForSubscriptionId;
    }

    public static String getWifiGatewayIp(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(StubApp.getOrigApplicationContext(context.getApplicationContext()), "wifi");
            if (systemService instanceof WifiManager) {
                try {
                    int i6 = ((WifiManager) systemService).getDhcpInfo().gateway;
                    return InetAddress.getByAddress(new byte[]{(byte) (i6 & 255), (byte) ((i6 >> 8) & 255), (byte) ((i6 >> 16) & 255), (byte) ((i6 >> 24) & 255)}).getHostAddress();
                } catch (RuntimeException | UnknownHostException e6) {
                    Logger.i(f33329a, "getWifiGatewayIp error!" + e6.getClass().getSimpleName() + e6.getMessage());
                }
            }
        }
        return " ";
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        r4 = r4.getTransportInfo();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getWifiRssi(android.content.Context r6) {
        /*
            r0 = -127(0xffffffffffffff81, float:NaN)
            if (r6 == 0) goto L6d
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r1 < r2) goto L6d
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.RuntimeException -> L42
            android.content.Context r6 = com.stub.StubApp.getOrigApplicationContext(r6)     // Catch: java.lang.RuntimeException -> L42
            java.lang.String r1 = "connectivity"
            java.lang.Object r6 = r6.getSystemService(r1)     // Catch: java.lang.RuntimeException -> L42
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6     // Catch: java.lang.RuntimeException -> L42
            android.net.Network[] r1 = r6.getAllNetworks()     // Catch: java.lang.RuntimeException -> L42
            int r2 = r1.length     // Catch: java.lang.RuntimeException -> L42
            r3 = 0
        L20:
            if (r3 >= r2) goto L47
            r4 = r1[r3]     // Catch: java.lang.RuntimeException -> L42
            android.net.NetworkCapabilities r4 = r6.getNetworkCapabilities(r4)     // Catch: java.lang.RuntimeException -> L42
            if (r4 == 0) goto L44
            r5 = 1
            boolean r5 = r4.hasTransport(r5)     // Catch: java.lang.RuntimeException -> L42
            if (r5 == 0) goto L44
            android.net.TransportInfo r4 = com.huawei.hms.framework.common.u.a(r4)     // Catch: java.lang.RuntimeException -> L42
            if (r4 == 0) goto L44
            boolean r5 = r4 instanceof android.net.wifi.WifiInfo     // Catch: java.lang.RuntimeException -> L42
            if (r5 == 0) goto L44
            android.net.wifi.WifiInfo r4 = (android.net.wifi.WifiInfo) r4     // Catch: java.lang.RuntimeException -> L42
            int r0 = r4.getRssi()     // Catch: java.lang.RuntimeException -> L42
            goto L44
        L42:
            r6 = move-exception
            goto L48
        L44:
            int r3 = r3 + 1
            goto L20
        L47:
            return r0
        L48:
            java.lang.String r1 = com.huawei.hms.framework.common.NetworkUtil.f33329a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getWifiRssiLevel did not has permission!"
            r2.append(r3)
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.huawei.hms.framework.common.Logger.i(r1, r6)
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.NetworkUtil.getWifiRssi(android.content.Context):int");
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if ((networkInfo != null && networkInfo.isConnected()) || !networkInfo2.isConnected()) {
            return false;
        }
        Logger.v(f33329a, "Find network state changed to connected");
        return true;
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        Logger.v(f33329a, "Find activity network changed");
        return true;
    }

    public static boolean isForeground() {
        return ActivityUtil.getInstance().isForeground();
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36042b)) {
            return true;
        }
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isSimReady(Context context) {
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager;
        boolean isUserUnlocked;
        if (Build.VERSION.SDK_INT < 24 || (userManager = (UserManager) ContextCompat.getSystemService(context, au.f40908m)) == null) {
            return true;
        }
        try {
            isUserUnlocked = userManager.isUserUnlocked();
            return isUserUnlocked;
        } catch (RuntimeException e6) {
            Logger.e(f33329a, "dealType rethrowFromSystemServer:", e6);
            return true;
        }
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(a(context));
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.huawei.secure.android.common.webview.d.b(str);
    }

    public static int getLteCqi(Context context) {
        List cellSignalStrengths;
        int cqi;
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        cqi = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
                        return cqi;
                    }
                } else {
                    return getInfoWithReflect(c6, "getLteCqi");
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteCqi: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrp(Context context) {
        List cellSignalStrengths;
        int rsrp;
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        rsrp = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
                        return rsrp;
                    }
                } else {
                    return getInfoWithReflect(c6, "getLteRsrp");
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRsrp: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrq(Context context) {
        List cellSignalStrengths;
        int rsrq;
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        rsrq = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
                        return rsrq;
                    }
                } else {
                    return getInfoWithReflect(c6, "getLteRsrq");
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRsrq: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssi(Context context) {
        List cellSignalStrengths;
        int rssi;
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        rssi = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                        return rssi;
                    }
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRssi: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssnr(Context context) {
        List cellSignalStrengths;
        int rssnr;
        SignalStrength c6 = c(context);
        if (c6 != null) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    cellSignalStrengths = c6.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        rssnr = ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
                        return rssnr;
                    }
                } else {
                    return getInfoWithReflect(c6, "getLteRssnr");
                }
            } catch (Throwable th) {
                Logger.i(f33329a, "getLteRssnr: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getMobileRsrp(Context context) {
        SignalStrength c6 = c(context);
        if (c6 == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return b(context);
            }
            return getInfoWithReflect(c6, "getDbm");
        } catch (Throwable th) {
            Logger.i(f33329a, "getDbm: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static String getNetWorkNSAorSA() {
        try {
            HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            String str = f33329a;
            Logger.v(str, "phoneId " + default4GSlotId);
            boolean isNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            Logger.v(str, "isNsa " + isNsaState);
            if (isNsaState) {
                return f33332d;
            }
            return f33333e;
        } catch (Throwable unused) {
            Logger.v(f33329a, "isNsaState error");
            return null;
        }
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i6;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        int i7 = 1;
        if (1 != type && 13 != type) {
            i7 = 0;
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                Logger.v(f33329a, "getHwNetworkType return is: " + subtype);
                if (subtype == 0) {
                    subtype = networkInfo.getSubtype();
                }
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i6 = 2;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i6 = 3;
                            break;
                        case 13:
                            i6 = 4;
                            break;
                        default:
                            i6 = 0;
                            break;
                    }
                } else {
                    i6 = 5;
                }
                if (i6 != 0 || Build.VERSION.SDK_INT < 25) {
                    return i6;
                }
                if (subtype != 16) {
                    return subtype != 17 ? 0 : 3;
                }
                return 2;
            }
        }
        return i7;
    }

    public static int getNrCsiRsrp(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int csiRsrp;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    csiRsrp = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiRsrp();
                    return csiRsrp;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrCsiRsrp: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrCsiRsrq(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int csiRsrq;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    csiRsrq = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiRsrq();
                    return csiRsrq;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrCsiRsrq: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrCsiSinr(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int csiSinr;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    csiSinr = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getCsiSinr();
                    return csiSinr;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrCsiSinr: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrSsRsrp(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int ssRsrp;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    ssRsrp = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsRsrp();
                    return ssRsrp;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrSsRsrp: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrSsRsrq(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int ssRsrq;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    ssRsrq = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsRsrq();
                    return ssRsrq;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrSsRsrq: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getNrSsSinr(Context context) {
        SignalStrength c6;
        List cellSignalStrengths;
        int ssSinr;
        try {
            if (Build.VERSION.SDK_INT > 28 && (c6 = c(context)) != null) {
                cellSignalStrengths = c6.getCellSignalStrengths(a.a());
                if (cellSignalStrengths.size() > 0) {
                    ssSinr = com.autonavi.aps.amapapi.restruct.t.a(cellSignalStrengths.get(0)).getSsSinr();
                    return ssSinr;
                }
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            Logger.i(f33329a, "getNrSsSinr: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    public static int netWork(Context context) {
        int networkType = getNetworkType(context);
        Logger.v(f33329a, "networkType " + networkType);
        if (networkType == 4) {
            if (TextUtils.equals(f33332d, getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        }
        if (networkType == 5 && TextUtils.equals(f33333e, getNetWorkNSAorSA())) {
            return 8;
        }
        return networkType;
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }

    public static void updateCurrentNetworkType() {
        networkTypeByReceiver = netWork(ContextHolder.getResourceContext());
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        return d(getNetworkType(networkInfo));
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, null);
    }
}
