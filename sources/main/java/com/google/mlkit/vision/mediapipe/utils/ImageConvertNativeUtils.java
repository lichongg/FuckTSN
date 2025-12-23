package com.google.mlkit.vision.mediapipe.utils;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zziq;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ImageConvertNativeUtils {
    @UsedByNative("image_native_utils_jni.cc")
    private static native byte[] byteArrayToRgb(byte[] bArr, int i6, int i7, int i8, @InputImage.ImageFormat int i9);

    @UsedByNative("image_native_utils_jni.cc")
    private static native byte[] yuvPlanesToRgb(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i6, int i7, int i8, int i9, int i10, int i11);

    @Nullable
    @KeepForSdk
    public static byte[] getRgbBuffer(@NonNull InputImage inputImage) throws MlKitException {
        byte[] bArr;
        zziq zze = zziq.zze("ImageConvertNativeUtils#getRgbBuffer");
        zze.zzb();
        try {
            ByteBuffer byteBuffer = inputImage.getByteBuffer();
            if (byteBuffer == null || (inputImage.getFormat() != 17 && inputImage.getFormat() != 842094169)) {
                if (inputImage.getFormat() == 35 && inputImage.getPlanes() != null && ((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes())).length == 3) {
                    Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                    bArr = yuvPlanesToRgb(planeArr[0].getBuffer(), planeArr[1].getBuffer(), planeArr[2].getBuffer(), inputImage.getWidth(), inputImage.getHeight(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[1].getPixelStride(), inputImage.getRotationDegrees());
                } else {
                    bArr = null;
                }
                zze.close();
                return bArr;
            }
            bArr = byteArrayToRgb(ImageConvertUtils.getInstance().byteBufferToByteArray(byteBuffer), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees(), inputImage.getFormat());
            zze.close();
            return bArr;
        } catch (Throwable th) {
            try {
                zze.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    private ImageConvertNativeUtils() {
    }
}
