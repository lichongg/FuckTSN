package com.kwad.sdk.mobileid.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private ConnectivityManager.NetworkCallback aTn;
    private ConnectivityManager aTo;
    private volatile boolean aTp = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0705a {
        void Ny();
    }

    public final void Nt() {
        synchronized (this) {
            ConnectivityManager.NetworkCallback networkCallback = this.aTn;
            if (networkCallback == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aTo;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                }
            } catch (Exception e6) {
                ServiceProvider.reportSdkCaughtException(e6);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.aTo.bindProcessToNetwork(null);
            }
            this.aTn = null;
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.aTp = true;
        return true;
    }

    private static ConnectivityManager ck(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    @SuppressLint({"MissingPermission"})
    public final void a(Context context, final InterfaceC0705a interfaceC0705a) {
        synchronized (this) {
            try {
                this.aTo = ck(context);
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                        if (this.aTn == null) {
                            this.aTn = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onAvailable(Network network) {
                                    a.this.aTo.bindProcessToNetwork(network);
                                    if (interfaceC0705a != null && !a.this.aTp) {
                                        interfaceC0705a.Ny();
                                    }
                                    a.a(a.this, true);
                                }

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onLost(Network network) {
                                    a.this.aTo.bindProcessToNetwork(null);
                                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                                    a.this.Nt();
                                }

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onUnavailable() {
                                    a.this.aTo.bindProcessToNetwork(null);
                                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                                    a.this.Nt();
                                }
                            };
                        }
                        if (!this.aTp) {
                            this.aTo.requestNetwork(build, this.aTn);
                        } else {
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                            Nt();
                        }
                    }
                } catch (Exception e6) {
                    ServiceProvider.reportSdkCaughtException(e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
