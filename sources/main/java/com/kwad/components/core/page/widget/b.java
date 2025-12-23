package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 14)
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
