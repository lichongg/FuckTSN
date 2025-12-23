package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzms;
import com.google.android.gms.internal.mlkit_vision_common.zzmu;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.android.odml.image.BitmapExtractor;
import com.google.android.odml.image.ByteBufferExtractor;
import com.google.android.odml.image.ImageProperties;
import com.google.android.odml.image.MediaImageExtractor;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class CommonConvertUtils {
    @KeepForSdk
    public static void transformPointArray(@NonNull Point[] pointArr, @NonNull Matrix matrix) {
        int length = pointArr.length;
        float[] fArr = new float[length + length];
        for (int i6 = 0; i6 < pointArr.length; i6++) {
            Point point = pointArr[i6];
            int i7 = i6 + i6;
            fArr[i7] = point.x;
            fArr[i7 + 1] = point.y;
        }
        matrix.mapPoints(fArr);
        for (int i8 = 0; i8 < pointArr.length; i8++) {
            int i9 = i8 + i8;
            pointArr[i8].set((int) fArr[i9], (int) fArr[i9 + 1]);
        }
    }

    @KeepForSdk
    public static int convertToAndroidImageFormat(@InputImage.ImageFormat int i6) {
        int i7 = 17;
        if (i6 != 17) {
            i7 = 35;
            if (i6 != 35) {
                i7 = 842094169;
                if (i6 != 842094169) {
                    return 0;
                }
            }
        }
        return i7;
    }

    @KeepForSdk
    public static int convertToMVRotation(int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 == 90) {
            return 1;
        }
        if (i6 == 180) {
            return 2;
        }
        if (i6 == 270) {
            return 3;
        }
        throw new IllegalArgumentException("Invalid rotation: " + i6);
    }

    @KeepForSdk
    public static void transformPointF(@NonNull PointF pointF, @NonNull Matrix matrix) {
        float[] fArr = {pointF.x, pointF.y};
        matrix.mapPoints(fArr);
        pointF.set(fArr[0], fArr[1]);
    }

    @KeepForSdk
    public static void transformRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    private static void zza(int i6, int i7, long j6, int i8, int i9, int i10, int i11) {
        zzmu.zzb(zzms.zzb("vision-common"), i6, i7, j6, i8, i9, i10, i11);
    }

    @Nullable
    @KeepForSdk
    public static InputImage convertMlImagetoInputImage(@NonNull MlImage mlImage) {
        InputImage fromBitmap;
        Integer num;
        int limit;
        ImageProperties imageProperties = mlImage.getContainedImageProperties().get(0);
        int storageType = imageProperties.getStorageType();
        if (storageType != 1) {
            fromBitmap = null;
            if (storageType != 2) {
                if (storageType == 3) {
                    Image extract = MediaImageExtractor.extract(mlImage);
                    if (extract.getFormat() == 256) {
                        limit = extract.getPlanes()[0].getBuffer().limit();
                    } else {
                        limit = (extract.getPlanes()[0].getBuffer().limit() * 3) / 2;
                    }
                    zza(extract.getFormat(), 5, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), limit, mlImage.getRotation());
                    fromBitmap = InputImage.fromMediaImage(extract, mlImage.getRotation());
                }
            } else {
                ByteBuffer extract2 = ByteBufferExtractor.extract(mlImage);
                int imageFormat = imageProperties.getImageFormat();
                if (imageFormat != 4) {
                    if (imageFormat != 5) {
                        num = null;
                    } else {
                        num = 842094169;
                    }
                } else {
                    num = 17;
                }
                if (num != null) {
                    zza(num.intValue(), 3, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), extract2.limit(), mlImage.getRotation());
                    fromBitmap = InputImage.fromByteBuffer(extract2, mlImage.getWidth(), mlImage.getHeight(), mlImage.getRotation(), num.intValue());
                }
            }
        } else {
            Bitmap extract3 = BitmapExtractor.extract(mlImage);
            zza(-1, 1, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), extract3.getAllocationByteCount(), mlImage.getRotation());
            fromBitmap = InputImage.fromBitmap(extract3, mlImage.getRotation());
        }
        if (fromBitmap != null) {
            zzmw.zza();
        }
        return fromBitmap;
    }

    @KeepForSdk
    public static void transformPointList(@NonNull List<PointF> list, @NonNull Matrix matrix) {
        int size = list.size();
        float[] fArr = new float[size + size];
        for (int i6 = 0; i6 < list.size(); i6++) {
            int i7 = i6 + i6;
            fArr[i7] = list.get(i6).x;
            fArr[i7 + 1] = list.get(i6).y;
        }
        matrix.mapPoints(fArr);
        for (int i8 = 0; i8 < list.size(); i8++) {
            int i9 = i8 + i8;
            list.get(i8).set(fArr[i9], fArr[i9 + 1]);
        }
    }
}
