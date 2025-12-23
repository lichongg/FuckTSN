package com.bytedance.sdk.component.panglearmor.xt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.panglearmor.m;
import com.umeng.analytics.pro.bi;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f26709j;
    private ConnectivityManager cw;

    /* renamed from: r, reason: collision with root package name */
    private volatile int f26710r = -1;
    private TelephonyManager up;
    private volatile int xt;

    public static j j() {
        if (f26709j == null) {
            synchronized (j.class) {
                try {
                    if (f26709j == null) {
                        f26709j = new j();
                    }
                } finally {
                }
            }
        }
        return f26709j;
    }

    private int m() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.cw;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = this.cw.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.cw.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean hasTransport = networkCapabilities.hasTransport(0);
                        boolean hasTransport2 = networkCapabilities.hasTransport(1);
                        if (j(this.cw) && hasTransport2) {
                            return 3;
                        }
                        if (hasTransport2) {
                            return 1;
                        }
                        return hasTransport ? 2 : 0;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return j(this.cw) ? 3 : 1;
                    }
                    if (type == 0) {
                        return 2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @NonNull
    public int[] cw() {
        int[] iArr = new int[this.xt];
        LinkedList<JSONObject> j6 = xt.j().j("sp_screen");
        if (j6 != null && j6.size() > 0) {
            int currentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            Iterator<JSONObject> it = j6.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong(bi.aL, 0L);
                int optInt = next.optInt("val", 0);
                int i6 = currentTimeMillis - ((int) (((optLong / 1000) / 60) / 60));
                if (i6 >= 0 && i6 < this.xt) {
                    iArr[i6] = optInt;
                }
            }
        }
        return iArr;
    }

    public int up() {
        TelephonyManager telephonyManager = this.up;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }

    @NonNull
    public int[] xt() {
        int[] iArr = new int[this.xt];
        LinkedList<JSONObject> j6 = xt.j().j("sp_net");
        if (j6 != null && j6.size() > 0) {
            int optLong = (int) (((j6.getLast().optLong(bi.aL, 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = j6.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong2 = next.optLong(bi.aL, 0L);
                int optInt = next.optInt("val", 0);
                int i6 = optLong - ((int) (((optLong2 / 1000) / 60) / 60));
                if (i6 >= 0 && i6 < this.xt) {
                    iArr[i6] = optInt;
                }
            }
        }
        return iArr;
    }

    public j() {
        this.cw = null;
        this.up = null;
        Context r5 = m.r();
        if (r5 != null) {
            this.cw = (ConnectivityManager) r5.getSystemService("connectivity");
            this.up = (TelephonyManager) r5.getSystemService("phone");
        }
        j((int) (((up.j().cw() / 1000) / 60) / 60));
    }

    public int r() {
        this.f26710r = m();
        return this.f26710r;
    }

    private static boolean j(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void j(int i6) {
        if (i6 <= 0) {
            this.xt = 1;
        } else if (i6 > 168) {
            this.xt = 168;
        } else {
            this.xt = i6;
        }
    }
}
