package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.IFlowUuid;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements IFlowUuid {
    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final long decryptLongFromBase64(String str) {
        try {
            return com.kwad.components.core.e.b.a.ai(str);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return 0L;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final String encryptLongToBase64(long j6) {
        try {
            return com.kwad.components.core.e.b.a.y(j6);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }
}
