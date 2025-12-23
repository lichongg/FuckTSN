package com.kwad.components.core.o.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i implements INetworkManager {
    private List<INetworkChangeListener> RN = new CopyOnWriteArrayList();
    private NetworkMonitor.a RO;

    private void ay(final Context context) {
        if (this.RO != null) {
            return;
        }
        this.RO = new NetworkMonitor.a() { // from class: com.kwad.components.core.o.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.o.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = i.this.getNetworkType(context);
                        Iterator it = i.this.RN.iterator();
                        while (it.hasNext()) {
                            ((INetworkChangeListener) it.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.RO);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ay(context);
            this.RN.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.RN.remove(iNetworkChangeListener);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return ao.df(context);
    }
}
