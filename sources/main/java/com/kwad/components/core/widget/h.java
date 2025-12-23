package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends ViewOutlineProvider {
    private float ajn;

    @RequiresApi(api = 21)
    public static void b(View view, float f6) {
        if (f6 <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        } else {
            view.setOutlineProvider(new h(f6));
            view.setClipToOutline(true);
        }
    }

    private h(float f6) {
        this.ajn = f6;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.ajn);
    }
}
