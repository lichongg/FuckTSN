package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class CctTransportBackend$$Lambda$1 implements Function {
    private final CctTransportBackend arg$1;

    public static Function lambdaFactory$(CctTransportBackend cctTransportBackend) {
        return new CctTransportBackend$$Lambda$1(cctTransportBackend);
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) {
        CctTransportBackend.HttpResponse doSend;
        doSend = this.arg$1.doSend((CctTransportBackend.HttpRequest) obj);
        return doSend;
    }

    private CctTransportBackend$$Lambda$1(CctTransportBackend cctTransportBackend) {
        this.arg$1 = cctTransportBackend;
    }
}
