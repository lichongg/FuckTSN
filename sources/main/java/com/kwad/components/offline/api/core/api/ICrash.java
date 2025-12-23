package com.kwad.components.offline.api.core.api;

import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(TKExceptionUploadParams tKExceptionUploadParams);

    void gatherException(Throwable th);
}
