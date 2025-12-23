package com.kwad.sdk.core.imageloader.core.display;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public final void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(decodedResult.mBitmap);
    }
}
