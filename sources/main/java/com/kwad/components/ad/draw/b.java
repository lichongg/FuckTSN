package com.kwad.components.ad.draw;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bz;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.core.widget.a.b {
    private View mRootView;

    private static int aG() {
        int FI;
        try {
            FI = ((int) e.FI()) * 100;
        } catch (Throwable unused) {
        }
        if (FI < 0 || FI > 100) {
            return 70;
        }
        return FI;
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }

    public b(@NonNull View view) {
        super(view, aG());
        this.mRootView = view;
    }
}
