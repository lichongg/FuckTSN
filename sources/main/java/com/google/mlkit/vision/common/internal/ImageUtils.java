package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    @NonNull
    @KeepForSdk
    public static ImageUtils getInstance() {
        return zzb;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix(int i6, int i7, int i8) {
        if (i8 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i6) / 2.0f, (-i7) / 2.0f);
        matrix.postRotate(i8 * 90);
        int i9 = i8 % 2;
        int i10 = i9 != 0 ? i7 : i6;
        if (i9 == 0) {
            i6 = i7;
        }
        matrix.postTranslate(i10 / 2.0f, i6 / 2.0f);
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008f A[PHI: r5
  0x008f: PHI (r5v3 android.graphics.Matrix) = (r5v0 android.graphics.Matrix), (r5v1 android.graphics.Matrix) binds: [B:10:0x008c, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:36:0x0071, B:42:0x005f, B:65:0x00cb, B:66:0x00d2), top: B:2:0x0004 }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap zza(@androidx.annotation.NonNull android.content.ContentResolver r11, @androidx.annotation.NonNull android.net.Uri r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }

    private ImageUtils() {
    }

    @NonNull
    @KeepForSdk
    public IObjectWrapper getImageDataWrapper(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format != 35) {
                    if (format != 842094169) {
                        throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
                    }
                } else {
                    return ObjectWrapper.wrap(inputImage.getMediaImage());
                }
            }
            return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
        }
        return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
    }

    @KeepForSdk
    public int getMobileVisionImageFormat(@NonNull InputImage inputImage) {
        return inputImage.getFormat();
    }

    @KeepForSdk
    public int getMobileVisionImageSize(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() != 17 && inputImage.getFormat() != 842094169) {
            if (inputImage.getFormat() != 35) {
                return 0;
            }
            return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
        }
        return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
    }
}
