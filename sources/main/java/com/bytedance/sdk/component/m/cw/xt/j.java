package com.bytedance.sdk.component.m.cw.xt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static final ImageView.ScaleType f26591j = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config xt = Bitmap.Config.ARGB_4444;
    private final int ae;
    private final Bitmap.Config cw;

    /* renamed from: m, reason: collision with root package name */
    private final int f26593m;

    /* renamed from: r, reason: collision with root package name */
    private int f26594r;
    private final ImageView.ScaleType tl;
    private int up;

    /* renamed from: g, reason: collision with root package name */
    private final int f26592g = PredefinedCaptureConfigurations.D;
    private final int oq = 104857600;

    static int j(int i6, int i7, int i8, int i9, int i10, int i11) {
        double min = Math.min(i6 / i8, i7 / i9);
        if (i10 > 0 && i11 > 0) {
            min = Math.max(min, Math.min(Math.max(i6, i7) / Math.max(i10, i11), Math.min(i6, i7) / Math.min(i10, i11)));
        }
        float f6 = 1.0f;
        while (true) {
            float f7 = 2.0f * f6;
            if (f7 > min) {
                return (int) f6;
            }
            f6 = f7;
        }
    }

    public j(int i6, int i7, ImageView.ScaleType scaleType, Bitmap.Config config, int i8, int i9) {
        this.cw = config;
        this.f26594r = i6;
        this.up = i7;
        this.tl = scaleType;
        this.f26593m = i8;
        this.ae = i9;
        j(i6, i7);
    }

    private static int j(int i6, int i7, int i8, int i9, ImageView.ScaleType scaleType) {
        if (i6 != 0 || i7 != 0) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (i6 == 0) {
                    return (int) (i8 * (i7 / i9));
                }
                if (i7 == 0) {
                    return i6;
                }
                double d6 = i9 / i8;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d7 = i7;
                    return ((double) i6) * d6 < d7 ? (int) (d7 / d6) : i6;
                }
                double d8 = i7;
                return ((double) i6) * d6 > d8 ? (int) (d8 / d6) : i6;
            }
            if (i6 != 0) {
                return i6;
            }
        }
        return i8;
    }

    public Bitmap j(byte[] bArr) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f26594r == 0 && this.up == 0) {
            options.inPreferredConfig = this.cw;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i6 = options.outWidth;
            int i7 = options.outHeight;
            int j6 = j(this.f26594r, this.up, i6, i7, this.tl);
            int j7 = j(this.up, this.f26594r, i7, i6, this.tl);
            options.inJustDecodeBounds = false;
            options.inSampleSize = j(i6, i7, j6, j7, this.f26593m, this.ae);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > j6 || decodeByteArray.getHeight() > j7)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, j6, j7, true);
                if (createScaledBitmap != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray != null && decodeByteArray.getByteCount() > 104857600) {
            int width = decodeByteArray.getWidth() / 2;
            int height = decodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeByteArray, width, height, true);
                if (createScaledBitmap2 != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return decodeByteArray;
    }

    private void j(int i6, int i7) {
        if (i6 > 3840 && i7 > 3840) {
            if (i6 > i7) {
                this.f26594r = PredefinedCaptureConfigurations.D;
                this.up = (i7 * PredefinedCaptureConfigurations.D) / i6;
                return;
            } else {
                this.f26594r = (i6 * PredefinedCaptureConfigurations.D) / i7;
                this.up = PredefinedCaptureConfigurations.D;
                return;
            }
        }
        if (i6 > 3840) {
            this.f26594r = PredefinedCaptureConfigurations.D;
            this.up = (i7 * PredefinedCaptureConfigurations.D) / i6;
        } else if (i7 > 3840) {
            this.f26594r = (i6 * PredefinedCaptureConfigurations.D) / i7;
            this.up = PredefinedCaptureConfigurations.D;
        }
    }
}
