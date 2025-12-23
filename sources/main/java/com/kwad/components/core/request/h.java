package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean WZ = false;
    private static final List<a> Xa = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void d(@NonNull SdkConfigData sdkConfigData);

        void ss();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b extends a {
        void st();
    }

    public static synchronized void a(a aVar) {
        synchronized (h.class) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
            if (sHasInit.get()) {
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
            } else {
                Xa.add(aVar);
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.request.h.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        Context Pp = ServiceProvider.Pp();
                        ag.l(Pp, ag.cV(Pp) + 1);
                        com.kwad.sdk.core.config.e.bs(Pp);
                        h.so();
                        h.sn();
                    }
                });
            }
        }
    }

    static /* synthetic */ boolean access$102(boolean z5) {
        WZ = true;
        return true;
    }

    public static void b(a aVar) {
        try {
            Xa.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.ss();
            }
            if (WZ) {
                aVar.d(com.kwad.sdk.core.config.e.Fw());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(int i6, String str) {
        for (a aVar : Xa) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).st();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void sn() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            @NonNull
            private static SdkConfigData aD(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ag.am(ServiceProvider.Pp(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                    return sdkConfigData;
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                    return sdkConfigData;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: sr, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.IO();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return aD(str);
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            private static void c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.T("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bq(ServiceProvider.Pp());
                    com.kwad.sdk.core.config.e.f(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    af.Qm();
                    af.Qg();
                    ag.l(ServiceProvider.Pp(), 0);
                    if (ag.Qr() != com.kwad.sdk.core.config.e.Gk()) {
                        ag.f(ServiceProvider.Pp(), com.kwad.sdk.core.config.e.Gk());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull g gVar, int i6, String str) {
                super.onError(gVar, i6, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i6 + " errorMsg=" + str);
                h.m(i6, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void so() {
        Iterator<a> it = Xa.iterator();
        while (it.hasNext()) {
            try {
                it.next().ss();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull SdkConfigData sdkConfigData) {
        Iterator<a> it = Xa.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
