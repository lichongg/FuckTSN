package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class ViewAware implements ImageAware {
    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    protected boolean checkActualViewSize;
    protected Reference<View> viewRef;

    public ViewAware(View view) {
        this(view, true);
    }

    protected abstract void setImageBitmapInto(Bitmap bitmap, View view);

    protected abstract void setImageDrawableInto(Drawable drawable, View view);

    public ViewAware(View view, boolean z5) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.viewRef = new WeakReference(view);
        this.checkActualViewSize = z5;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        View view = this.viewRef.get();
        int i6 = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
                i6 = view.getHeight();
            }
            if (i6 <= 0 && layoutParams != null) {
                return layoutParams.height;
            }
        }
        return i6;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getId() {
        View view = this.viewRef.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        View view = this.viewRef.get();
        int i6 = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
                i6 = view.getWidth();
            }
            if (i6 <= 0 && layoutParams != null) {
                return layoutParams.width;
            }
        }
        return i6;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.viewRef.get() == null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageBitmapInto(bitmap, view);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_BITMAP, new Object[0]);
        }
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageDrawableInto(drawable, view);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_DRAWABLE, new Object[0]);
        }
        return false;
    }
}
