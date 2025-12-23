package com.bytedance.sdk.openadsdk.core.gq.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f29111j;
    private Network cw;

    /* renamed from: r, reason: collision with root package name */
    private xt f29112r;
    private boolean up;
    private ConnectivityManager xt;

    public interface j {
        void j(Network network);
    }

    static class xt extends ConnectivityManager.NetworkCallback {
        private AtomicBoolean cw = new AtomicBoolean(false);

        /* renamed from: j, reason: collision with root package name */
        private j f29113j;
        private final cw xt;

        public void j(j jVar) {
            this.f29113j = jVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.cw.compareAndSet(false, true)) {
                try {
                    this.xt.cw = network;
                    this.f29113j.j(network);
                    this.xt.up = false;
                } catch (Exception unused) {
                    this.xt.cw = null;
                    this.f29113j.j(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.xt.up = true;
        }

        public xt(j jVar, cw cwVar) {
            this.f29113j = jVar;
            this.xt = cwVar;
        }
    }

    public synchronized void xt() {
        ConnectivityManager connectivityManager = this.xt;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                xt xtVar = this.f29112r;
                if (xtVar == null) {
                    return;
                }
                connectivityManager.unregisterNetworkCallback(xtVar);
            } finally {
                this.f29112r = null;
                this.cw = null;
            }
        } catch (Exception unused) {
        }
    }

    private cw(Context context) {
        try {
            this.xt = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static cw j(Context context) {
        if (f29111j == null) {
            synchronized (cw.class) {
                try {
                    if (f29111j == null) {
                        f29111j = new cw(context);
                    }
                } finally {
                }
            }
        }
        return f29111j;
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

    public int j() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.xt;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = this.xt.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.xt.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean hasTransport = networkCapabilities.hasTransport(4);
                        boolean hasTransport2 = networkCapabilities.hasTransport(0);
                        boolean hasTransport3 = networkCapabilities.hasTransport(1);
                        if (hasTransport) {
                            return 4;
                        }
                        if (j(this.xt) && hasTransport3) {
                            return 3;
                        }
                        if (hasTransport3) {
                            return 1;
                        }
                        return hasTransport2 ? 2 : 5;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    return type == 1 ? j(this.xt) ? 3 : 1 : type == 0 ? 2 : 5;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public void j(j jVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.xt;
        if (connectivityManager == null) {
            jVar.j(null);
            return;
        }
        Network network = this.cw;
        if (network != null && !this.up && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            jVar.j(this.cw);
            return;
        }
        xt xtVar = this.f29112r;
        if (xtVar != null) {
            xtVar.j(jVar);
            return;
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        xt xtVar2 = new xt(jVar, f29111j);
        this.f29112r = xtVar2;
        try {
            this.xt.requestNetwork(build, xtVar2);
        } catch (Exception unused) {
            jVar.j(null);
        }
    }
}
