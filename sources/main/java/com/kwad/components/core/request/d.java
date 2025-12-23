package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends c {
    @Override // com.kwad.components.core.request.c
    public void a(@NonNull AdResultData adResultData, boolean z5) {
        b(adResultData);
    }

    @Override // com.kwad.components.core.request.c
    public void a(int i6, String str, boolean z5) {
        onError(i6, str);
    }

    @Override // com.kwad.components.core.request.l
    public void b(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.request.l
    public void onError(int i6, String str) {
    }
}
