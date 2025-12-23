package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NonViewAware implements ImageAware {
    protected final ImageSize imageSize;
    protected final String imageUri;
    protected final ViewScaleType scaleType;

    public NonViewAware(ImageSize imageSize, ViewScaleType viewScaleType) {
        this(null, imageSize, viewScaleType);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    public NonViewAware(String str, ImageSize imageSize, ViewScaleType viewScaleType) {
        if (imageSize == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewScaleType == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        }
        this.imageUri = str;
        this.imageSize = imageSize;
        this.scaleType = viewScaleType;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        return this.imageSize.getHeight();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getId() {
        return TextUtils.isEmpty(this.imageUri) ? super.hashCode() : this.imageUri.hashCode();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        return this.imageSize.getWidth();
    }
}
