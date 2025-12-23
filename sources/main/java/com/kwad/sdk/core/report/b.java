package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService aGh;
    private static volatile Handler iK;
    private T aGk;
    private Context mContext;
    private volatile long YL = 120000;
    protected l aGg = new m();
    private AtomicInteger aGi = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int aGj = 5;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aF(long j6) {
        if (iK == null) {
            return;
        }
        iK.removeMessages(R.attr.childDivider);
        Message obtain = Message.obtain(iK, a(this.mContext, this.aGg, this.aGi));
        obtain.what = R.attr.childDivider;
        iK.sendMessageDelayed(obtain, j6);
    }

    protected abstract R A(List<T> list);

    public synchronized void j(Context context, int i6) {
        this.mContext = context;
        if (iK == null) {
            iK = com.kwad.sdk.core.threads.a.Ji();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.aGj) {
            if (andIncrement > 0) {
                this.YL *= 2;
            }
            aF(this.YL);
        }
    }

    private void c(@NonNull final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @NonNull
            private static BatchReportResult ew(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                e Io = kVar.Io();
                b.this.aGk = Io;
                return (R) b.this.a((b) Io);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aGh;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return ew(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aGk + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r5, int i6, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i6 + " errorMsg:" + str + "\naction=" + b.this.aGk);
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    @NonNull
                    public final T Io() {
                        return (T) b.this.aGk;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    protected final boolean Ij() {
        int i6 = this.mRetryCount.get();
        if (i6 > 16) {
            i6 = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.aGg.size() >= (sVar != null ? (long) (sVar.Bh() << i6) : 20L);
    }

    public final void Ik() {
        aF(0L);
    }

    protected final void aE(long j6) {
        if (j6 < 60) {
            this.YL = 60000L;
        } else {
            this.YL = j6 * 1000;
        }
    }

    public final void b(@NonNull k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    protected b() {
        if (aGh == null) {
            aGh = GlobalThreadPools.Jr();
        }
    }

    protected final void a(l lVar) {
        this.aGg = lVar;
    }

    public final void a(@NonNull final k<T> kVar) {
        aGh.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.iK != null && !b.iK.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.aF(bVar.YL);
                }
                e Io = kVar.Io();
                if (Io != null) {
                    b.this.aGg.l(Io);
                }
                if (b.this.Ij()) {
                    b.this.Ik();
                }
            }
        });
    }

    protected Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean, final u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.aGi.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @NonNull
            private static BatchReportResult ew(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.A(list);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aGh;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return ew(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.aGg.B(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.IH();
                }
                if (b.this.aGi.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.Il();
                }
                b.this.aE(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.aF(bVar.YL);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r5, int i6, String str) {
                atomicBoolean.set(true);
                if (b.this.aGi.decrementAndGet() == 0) {
                    b.this.Il();
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    protected R a(T t5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t5);
        return A(arrayList);
    }
}
