package com.kwad.components.offline.d;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.core.o.b.a<ITkOfflineCompo> {
    private static long akg;
    private final List<com.kwad.components.core.o.a.e.a> akf;
    private final AtomicBoolean akh;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.offline.d.c$1, reason: invalid class name */
    final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo aki;
        final /* synthetic */ boolean akj;
        final /* synthetic */ long akk;
        final /* synthetic */ long akl;
        final /* synthetic */ Context dq;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z5, long j6, long j7, Context context) {
            this.aki = iTkOfflineCompo;
            this.akj = z5;
            this.akk = j6;
            this.akl = j7;
            this.dq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i6) {
            c.this.aJ(i6);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z5) {
            try {
                final b bVar = new b(this.aki);
                com.kwad.sdk.components.d.a(com.kwad.components.core.o.a.e.c.class, bVar);
                c.this.akh.set(true);
                int i6 = z5 ? 2 : 1;
                int i7 = this.akj ? 2 : 1;
                c.this.b(i6, i7, SystemClock.elapsedRealtime() - this.akk, this.akl);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.akl).setSoLoadTime(SystemClock.elapsedRealtime() - this.akk).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - l.Cf().CH()).setThreadPoolCoreSize(i.zS().zM().An()).setOfflineSource(i7).setSoSource(i6).toJson());
                c.this.qx();
                h.b(new com.kwad.components.core.request.i() { // from class: com.kwad.components.offline.d.c.1.1
                    @Override // com.kwad.components.core.request.i, com.kwad.components.core.request.h.a
                    public final void d(@NonNull final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.offline.d.c.1.1.1
                            @Override // com.kwad.sdk.utils.bg
                            public final void doTask() {
                                C06511 c06511 = C06511.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.dq, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final c akr = new c(0);
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    private c() {
        this.akf = new CopyOnWriteArrayList();
        this.akh = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.o.a.e.a aVar) {
        if (aVar == null) {
            return;
        }
        this.akf.remove(aVar);
    }

    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "4.5.20.1";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-4.4.20.2-634ee5d43a-104.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "91ef97cd6a396acd3eaffce69d31b5c5";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_tk_45201";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return ITkOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "TK";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.o.b.b.class, methodId = "initOC")
    public static void aF(Context context) {
        akg = SystemClock.elapsedRealtime();
        wx().init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6, int i7, long j6, long j7) {
        Iterator<com.kwad.components.core.o.a.e.a> it = this.akf.iterator();
        while (it.hasNext()) {
            int i8 = i6;
            int i9 = i7;
            long j8 = j6;
            long j9 = j7;
            try {
                it.next().a(i8, i9, j8, j9);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
            i6 = i8;
            i7 = i9;
            j6 = j8;
            j7 = j9;
        }
    }

    public static c wx() {
        return a.akr;
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return com.kwad.sdk.core.h.a.JO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.o.b.a
    public void a(Context context, boolean z5, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z5, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - akg, context));
    }

    public final void a(com.kwad.components.core.o.a.e.a aVar) {
        com.kwad.components.core.o.a.e.a aVar2;
        if (aVar == null) {
            return;
        }
        try {
            if (this.akh.get()) {
                aVar2 = aVar;
                aVar2.a(1, 1, 0L, 0L);
            } else {
                aVar2 = aVar;
            }
            this.akf.add(aVar2);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
