package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.utils.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ImageViewAware extends ViewAware {
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    public ImageViewAware(ImageView imageView, boolean z5) {
        super(imageView, z5);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.viewRef.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            int intValue = ((Integer) z.getField(obj, str)).intValue();
            if (intValue > 0 && intValue < Integer.MAX_VALUE) {
                return intValue;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        if (height <= 0 && (imageView = (ImageView) this.viewRef.get()) != null) {
            return getImageViewFieldValue(imageView, "mMaxHeight");
        }
        return height;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        if (width <= 0 && (imageView = (ImageView) this.viewRef.get()) != null) {
            return getImageViewFieldValue(imageView, "mMaxWidth");
        }
        return width;
    }
}
