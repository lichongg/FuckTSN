package com.kwad.sdk.core.imageloader.core.display;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FadeInBitmapDisplayer implements BitmapDisplayer {
    private final boolean animateFromDisk;
    private final boolean animateFromMemory;
    private final boolean animateFromNetwork;
    private final int durationMillis;

    public FadeInBitmapDisplayer(int i6) {
        this(i6, true, true, true);
    }

    public FadeInBitmapDisplayer(int i6, boolean z5, boolean z6, boolean z7) {
        this.durationMillis = i6;
        this.animateFromNetwork = z5;
        this.animateFromDisk = z6;
        this.animateFromMemory = z7;
    }

    public static void animate(View view, int i6) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i6);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(decodedResult.mBitmap);
        if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
            animate(imageAware.getWrappedView(), this.durationMillis);
        }
    }
}
