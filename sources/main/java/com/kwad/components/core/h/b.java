package com.kwad.components.core.h;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends KSFrameLayout {
    private ImageView cm;

    private ImageView qk() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public final void a(String str, ImageLoadingListener imageLoadingListener) {
        ImageView imageView = this.cm;
        if (imageView != null) {
            ImageLoaderProxy.INSTANCE.load(imageView, str, imageLoadingListener);
        }
    }

    public final void setImageGravity(int i6) {
        FrameLayout.LayoutParams layoutParams;
        ImageView imageView = this.cm;
        if (imageView == null || (layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.gravity = i6;
        this.cm.setLayoutParams(layoutParams);
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.cm;
        if (imageView == null || scaleType == null) {
            return;
        }
        imageView.setScaleType(scaleType);
    }

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.cm = qk();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.cm, layoutParams);
    }
}
