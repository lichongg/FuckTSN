package com.kwad.sdk.core.webview.a;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    @Nullable
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            createBitmap.eraseColor(0);
            return createBitmap;
        }
        return defaultVideoPoster;
    }
}
