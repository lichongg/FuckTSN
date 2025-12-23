package com.kwad.components.ad.c;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.components.core.widget.a.b {
    public f(@NonNull View view, int i6) {
        super(view, i6);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.Ho();
            if (com.kwad.sdk.core.c.b.isAppOnForeground() && super.ae()) {
                return true;
            }
            return false;
        }
        return super.ae();
    }
}
