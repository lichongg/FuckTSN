package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cq f10960a;

    public static cq a() {
        if (f10960a == null) {
            synchronized (cq.class) {
                try {
                    if (f10960a == null) {
                        f10960a = new cq();
                    }
                } finally {
                }
            }
        }
        return f10960a;
    }

    private cq() {
    }

    private NetworkCapabilities c(Context context) {
        Network activeNetwork;
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36042b) == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) origApplicationContext.getSystemService("connectivity");
                activeNetwork = connectivityManager.getActiveNetwork();
                return connectivityManager.getNetworkCapabilities(activeNetwork);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36042b) == 0) {
                return ((ConnectivityManager) origApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z5 = false;
            if (bn.a(context).a() < 29) {
                NetworkInfo b6 = b(context);
                if (b6 != null && b6.isConnected() && b6.getType() == 1) {
                    z5 = true;
                }
                return Boolean.valueOf(z5);
            }
            NetworkCapabilities c6 = c(context);
            if (c6 != null && c6.hasCapability(12) && c6.hasCapability(16) && c6.hasTransport(1)) {
                z5 = true;
            }
            return Boolean.valueOf(z5);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
