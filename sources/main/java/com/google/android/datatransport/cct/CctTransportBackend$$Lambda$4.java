package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class CctTransportBackend$$Lambda$4 implements RetryStrategy {
    private static final CctTransportBackend$$Lambda$4 instance = new CctTransportBackend$$Lambda$4();

    @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
    public Object shouldRetry(Object obj, Object obj2) {
        return CctTransportBackend.lambda$send$0((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
    }

    private CctTransportBackend$$Lambda$4() {
    }
}
