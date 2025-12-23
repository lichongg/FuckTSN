package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends TextureView {
    private int videoHeight;
    private int videoWidth;

    public final void adaptVideoSize(int i6, int i7) {
        if (this.videoWidth == i6 || this.videoHeight == i7) {
            return;
        }
        this.videoWidth = i6;
        this.videoHeight = i7;
        requestLayout();
    }

    public a(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onMeasure(int i6, int i7) {
        int i8;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i7 = i6;
            i6 = i7;
        }
        int defaultSize = View.getDefaultSize(this.videoWidth, i6);
        int defaultSize2 = View.getDefaultSize(this.videoHeight, i7);
        if (this.videoWidth > 0 && this.videoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            int size2 = View.MeasureSpec.getSize(i7);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i9 = this.videoWidth;
                int i10 = i9 * size2;
                int i11 = this.videoHeight;
                if (i10 < size * i11) {
                    defaultSize = (i9 * size2) / i11;
                } else if (i9 * size2 > size * i11) {
                    defaultSize2 = (i11 * size) / i9;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i12 = this.videoHeight;
                int i13 = this.videoWidth;
                int i14 = (size * i12) / i13;
                if (mode2 == Integer.MIN_VALUE && i14 > size2) {
                    defaultSize = (i13 * size2) / i12;
                    defaultSize2 = size2;
                } else {
                    defaultSize = size;
                    defaultSize2 = i14;
                }
            } else {
                if (mode2 == 1073741824) {
                    int i15 = this.videoWidth;
                    int i16 = this.videoHeight;
                    int i17 = (size2 * i15) / i16;
                    if (mode == Integer.MIN_VALUE && i17 > size) {
                        defaultSize2 = (i16 * size) / i15;
                    } else {
                        defaultSize2 = size2;
                        defaultSize = i17;
                    }
                } else {
                    int i18 = this.videoWidth;
                    int i19 = this.videoHeight;
                    if (mode2 == Integer.MIN_VALUE && i19 > size2) {
                        i8 = (size2 * i18) / i19;
                    } else {
                        i8 = i18;
                        size2 = i19;
                    }
                    if (mode == Integer.MIN_VALUE && i8 > size) {
                        defaultSize2 = (i19 * size) / i18;
                    } else {
                        defaultSize = i8;
                        defaultSize2 = size2;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f6) {
        if (f6 != getRotation()) {
            super.setRotation(f6);
            requestLayout();
        }
    }
}
