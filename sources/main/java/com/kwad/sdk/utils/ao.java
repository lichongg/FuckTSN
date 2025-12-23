package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.stub.StubApp;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ao {
    private static int aZT;
    private static boolean aZU;

    public static int df(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36042b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36043c)) {
            try {
                NetworkInfo de = de(context);
                if (de != null && de.isConnected()) {
                    if (1 == de.getType()) {
                        return 100;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
                    if (telephonyManager != null) {
                        int n6 = n(context, telephonyManager.getNetworkType());
                        if (n6 == 20) {
                            return 5;
                        }
                        switch (n6) {
                        }
                        return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo de = de(context);
            if (de == null) {
                return -1;
            }
            return de.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo de = de(context);
            if (de != null && de.isConnected()) {
                if (de.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo de = de(context);
            if (de != null) {
                if (de.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo de = de(context);
            if (de != null && de.isConnected()) {
                return 1 == de.getType();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        if (r9.equals("46001") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        if (r9.equals("46000") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009a, code lost:
    
        if (r9.equals("46011") != false) goto L48;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x003d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0040. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ao.d(android.content.Context, java.lang.String, boolean):int");
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo de(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36042b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static int getSubId() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        return defaultDataSubscriptionId;
    }

    private static boolean hb(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean hc(String str) {
        return s(str, 3000);
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i6) {
        ServiceState serviceState;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.f36042b)) {
            return i6;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                int subId = getSubId();
                if (subId == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else if (context.getApplicationInfo().targetSdkVersion < 29 || i7 < 29) {
                    try {
                        serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                    } catch (Throwable unused) {
                        serviceState = telephonyManager.getServiceState();
                    }
                } else {
                    serviceState = telephonyManager.getServiceState();
                }
                if (serviceState != null) {
                    if (bb.Rk()) {
                        Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                        return num != null ? num.intValue() : i6;
                    }
                    if (hb(serviceState.toString())) {
                        return 20;
                    }
                    return i6;
                }
            }
            return i6;
        } catch (Exception unused2) {
            return i6;
        }
    }

    @WorkerThread
    private static boolean s(String str, int i6) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
