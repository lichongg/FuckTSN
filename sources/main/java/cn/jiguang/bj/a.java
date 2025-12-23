package cn.jiguang.bj;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;

@TargetApi(21)
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    private NetworkRequest f2295a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2296b;

    /* renamed from: cn.jiguang.bj.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.bj.a$a, reason: collision with other inner class name */
    private static final class C0032a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2297a = new a(null);
    }

    private a() {
        this.f2296b = false;
        try {
            this.f2295a = new NetworkRequest.Builder().build();
        } catch (Throwable th) {
            f.i("ConnectionStateMonitor", "init network request error, " + th.getMessage());
        }
    }

    public static a a() {
        return C0032a.f2297a;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(Context context) {
        if (context == null || this.f2295a == null || this.f2296b) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(this.f2295a, this);
                this.f2296b = true;
                f.c("ConnectionStateMonitor", "start network listen...");
            }
        } catch (Throwable th) {
            f.i("ConnectionStateMonitor", "enable connectivity error, " + th.getMessage());
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        String str;
        String str2 = "";
        if (network != null) {
            try {
                str2 = network.toString();
            } catch (Throwable th) {
                f.i("ConnectionStateMonitor", "[onAvailable] error, " + th.getMessage());
                return;
            }
        }
        f.c("ConnectionStateMonitor", "[onAvailable] network is connected, netId: " + str2);
        Context a6 = d.a(null);
        if (a6 == null) {
            f.c("ConnectionStateMonitor", "[onAvailable] context is null, can not handle network change event");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) a6.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0))) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("connected", true);
                JCoreManager.onEvent(a6, "", 80, null, bundle, new Object[0]);
                return;
            } else {
                str = "[onAvailable] capabilities:" + networkCapabilities;
            }
        } else {
            str = "[onAvailable] connectivityManager null";
        }
        f.i("ConnectionStateMonitor", str);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str = "";
        if (network != null) {
            try {
                str = network.toString();
            } catch (Throwable th) {
                f.i("ConnectionStateMonitor", "[onLost] error, " + th.getMessage());
                return;
            }
        }
        f.j("ConnectionStateMonitor", "[onLost] network is disconnected, netId: " + str);
        Context a6 = d.a(null);
        if (a6 == null) {
            f.c("ConnectionStateMonitor", "[onLost] context is null, can not handle network change event");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("connected", false);
        JCoreManager.onEvent(a6, "", 80, null, bundle, new Object[0]);
    }
}
