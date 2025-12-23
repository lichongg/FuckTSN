package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aHV = new AtomicLong(-1);
    protected final l<T> aGg;
    protected final b<T, R> aHW;
    protected final AtomicInteger aHX;
    protected final Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void IH();
    }

    protected final void IG() {
        long RR = br.RR();
        if (RR >= aHV.get() * 2) {
            try {
                List<T> dE = this.aGg.dE(200);
                if (dE.isEmpty()) {
                    return;
                }
                this.aHW.a(dE, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    @Override // com.kwad.sdk.core.report.u.a
                    public final void IH() {
                        u.this.IG();
                    }
                });
            } catch (OutOfMemoryError e6) {
                aHV.set(RR);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e6);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aHX.get() > 0 || !ao.isNetworkConnected(this.mContext)) {
            return;
        }
        IG();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.aGg = lVar;
        this.aHW = bVar;
        this.aHX = atomicInteger;
    }
}
