package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        n nVar = new n(10211L);
        nVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.g.a2(nVar);
    }
}
