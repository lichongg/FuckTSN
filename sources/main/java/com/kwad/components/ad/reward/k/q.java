package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q extends z {
    private WeakReference<com.kwad.components.ad.reward.g> AK;
    private long yU;

    @Override // com.kwad.components.core.webview.jshandler.z
    public final a.C0616a a(a.C0616a c0616a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long j6;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.AK;
        if (weakReference == null || weakReference.get() == null) {
            j6 = this.yU;
            if (j6 <= 0) {
                j6 = 0;
            }
        } else {
            j6 = this.AK.get().rE.getPlayDuration();
        }
        return super.a(c0616a, aVar, adTemplate).B(j6);
    }

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.components.ad.reward.g gVar, long j6, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.yU = j6;
        if (gVar != null) {
            this.AK = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final void kr() {
        super.kr();
        if (this.acw != null) {
            com.kwad.components.ad.reward.c.a.hV().c(this.acw.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}
