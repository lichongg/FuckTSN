package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static int considerMaxTextureSize(int i6, int i7, int i8, boolean z5) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i6 / i8 <= width && i7 / i8 <= height) {
                return i8;
            }
            i8 = z5 ? i8 * 2 : i8 + 1;
        }
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z5) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i6 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        int i7 = 1;
        if (i6 != 1) {
            if (i6 != 2) {
                max = 1;
            } else if (z5) {
                int i8 = width / 2;
                int i9 = height / 2;
                max = 1;
                while (i8 / max > width2 && i9 / max > height2) {
                    max *= 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z5) {
            int i10 = width / 2;
            int i11 = height / 2;
            max = 1;
            while (true) {
                if (i10 / max <= width2 && i11 / max <= height2) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        if (max > 0) {
            i7 = max;
        }
        return considerMaxTextureSize(width, height, i7, z5);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z5) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f6 = width;
        float f7 = f6 / width2;
        float f8 = height;
        float f9 = f8 / height2;
        if ((viewScaleType == ViewScaleType.FIT_INSIDE && f7 >= f9) || (viewScaleType == ViewScaleType.CROP && f7 < f9)) {
            height2 = (int) (f8 / f7);
        } else {
            width2 = (int) (f6 / f9);
        }
        if ((!z5 && width2 < width && height2 < height) || (z5 && width2 != width && height2 != height)) {
            return width2 / f6;
        }
        return 1.0f;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
