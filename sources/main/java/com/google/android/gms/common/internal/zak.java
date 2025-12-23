package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zak implements Handler.Callback {

    @NotOnlyInitialized
    private final zaj zab;
    private final Handler zah;
    private final ArrayList zac = new ArrayList();

    @VisibleForTesting
    final ArrayList zaa = new ArrayList();
    private final ArrayList zad = new ArrayList();
    private volatile boolean zae = false;
    private final AtomicInteger zaf = new AtomicInteger(0);
    private boolean zag = false;
    private final Object zai = new Object();

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zab() {
        this.zae = true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i6 = message.what;
        if (i6 != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i6, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.zai) {
            try {
                if (this.zae && this.zab.isConnected() && this.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @VisibleForTesting
    public final void zac(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.zah, "onConnectionFailure must only be called on the Handler thread");
        this.zah.removeMessages(1);
        synchronized (this.zai) {
            try {
                ArrayList arrayList = new ArrayList(this.zad);
                int i6 = this.zaf.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                    if (this.zae && this.zaf.get() == i6) {
                        if (this.zad.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                    return;
                }
            } finally {
            }
        }
    }

    @VisibleForTesting
    public final void zad(@Nullable Bundle bundle) {
        Preconditions.checkHandlerThread(this.zah, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zai) {
            try {
                Preconditions.checkState(!this.zag);
                this.zah.removeMessages(1);
                this.zag = true;
                Preconditions.checkState(this.zaa.isEmpty());
                ArrayList arrayList = new ArrayList(this.zac);
                int i6 = this.zaf.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                    if (!this.zae || !this.zab.isConnected() || this.zaf.get() != i6) {
                        break;
                    } else if (!this.zaa.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                this.zaa.clear();
                this.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final void zae(int i6) {
        Preconditions.checkHandlerThread(this.zah, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.zah.removeMessages(1);
        synchronized (this.zai) {
            try {
                this.zag = true;
                ArrayList arrayList = new ArrayList(this.zac);
                int i7 = this.zaf.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                    if (!this.zae || this.zaf.get() != i7) {
                        break;
                    } else if (this.zac.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i6);
                    }
                }
                this.zaa.clear();
                this.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zak(Looper looper, zaj zajVar) {
        this.zab = zajVar;
        this.zah = new com.google.android.gms.internal.base.zau(looper, this);
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            try {
                if (this.zac.contains(connectionCallbacks)) {
                    String.valueOf(connectionCallbacks);
                } else {
                    this.zac.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.zab.isConnected()) {
            Handler handler = this.zah;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void zag(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            try {
                if (this.zad.contains(onConnectionFailedListener)) {
                    String.valueOf(onConnectionFailedListener);
                } else {
                    this.zad.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            try {
                if (!this.zac.remove(connectionCallbacks)) {
                    String.valueOf(connectionCallbacks);
                } else if (this.zag) {
                    this.zaa.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            try {
                if (!this.zad.remove(onConnectionFailedListener)) {
                    String.valueOf(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaj(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            contains = this.zac.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean zak(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            contains = this.zad.contains(onConnectionFailedListener);
        }
        return contains;
    }
}
