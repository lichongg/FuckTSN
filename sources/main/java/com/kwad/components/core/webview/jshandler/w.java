package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private Vibrator gZ;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.gZ = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        bw.a(ServiceProvider.getContext(), this.gZ);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
