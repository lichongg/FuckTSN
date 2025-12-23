package com.oplus.omes.stdsco.probe;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ProbeClient {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f36400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.oplus.omes.stdsco.probe.a f36401b;

        a(final Context val$listener, final com.oplus.omes.stdsco.probe.a val$ctx) {
            this.f36400a = val$listener;
            this.f36401b = val$ctx;
        }

        @Override // java.lang.Runnable
        public void run() {
            String probeRespStr = ProbeClient.getProbeRespStr(this.f36400a);
            com.oplus.omes.stdsco.probe.a aVar = this.f36401b;
            if (aVar == null) {
                return;
            }
            if (probeRespStr != null) {
                aVar.onSuccess(probeRespStr);
            } else {
                aVar.onError("error");
            }
        }
    }

    public static native String getProbeRespStr(Object ctx);

    public static void a(final Context ctx, final com.oplus.omes.stdsco.probe.a listener) {
        new Thread(new a(ctx, listener)).start();
    }
}
