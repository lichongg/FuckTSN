package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ImageConvertUtils {
    private static final ImageConvertUtils zza = new ImageConvertUtils();

    @NonNull
    @KeepForSdk
    public static Bitmap yv12ToBitmap(@NonNull ByteBuffer byteBuffer, int i6, int i7, int i8) throws MlKitException {
        byte[] zzb = zzb(yv12ToNv21Buffer(byteBuffer, true).array(), i6, i7);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzb, 0, zzb.length);
        return zza(decodeByteArray, i8, decodeByteArray.getWidth(), decodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public static ImageConvertUtils getInstance() {
        return zza;
    }

    @NonNull
    public static Bitmap zza(@NonNull Bitmap bitmap, int i6, int i7, int i8) {
        if (i6 == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i7, i8);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i6);
        return Bitmap.createBitmap(bitmap, 0, 0, i7, i8, matrix, true);
    }

    private static byte[] zzb(@NonNull byte[] bArr, int i6, int i7) throws MlKitException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i6, i7, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i6, i7), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e6) {
            throw new MlKitException("Image conversion error from NV21 format", 13, e6);
        }
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer convertToNv21Buffer(@NonNull InputImage inputImage, boolean z5) throws MlKitException {
        Bitmap.Config config;
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format == 17) {
                return z5 ? bufferWithBackingArray((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())) : (ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer());
            }
            if (format == 35) {
                return yuv420ThreePlanesToNV21((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight());
            }
            if (format == 842094169) {
                return yv12ToNv21Buffer((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), z5);
            }
            throw new MlKitException("Unsupported image format", 13);
        }
        Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal());
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config2 = bitmap.getConfig();
            config = Bitmap.Config.HARDWARE;
            if (config2 == config) {
                bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
            }
        }
        Bitmap bitmap2 = bitmap;
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i6 = width * height;
        int[] iArr = new int[i6];
        bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
        int ceil = (int) Math.ceil(height / 2.0d);
        int ceil2 = ((ceil + ceil) * ((int) Math.ceil(width / 2.0d))) + i6;
        ByteBuffer allocate = z5 ? ByteBuffer.allocate(ceil2) : ByteBuffer.allocateDirect(ceil2);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < height; i9++) {
            int i10 = 0;
            while (i10 < width) {
                int i11 = iArr[i8];
                int i12 = i11 >> 16;
                int i13 = i11 >> 8;
                int i14 = i11 & 255;
                int i15 = i7 + 1;
                int i16 = i12 & 255;
                int i17 = i13 & 255;
                allocate.put(i7, (byte) Math.min(255, (((((i16 * 66) + (i17 * 129)) + (i14 * 25)) + 128) >> 8) + 16));
                if (i9 % 2 == 0 && i8 % 2 == 0) {
                    int i18 = ((((i16 * 112) - (i17 * 94)) - (i14 * 18)) + 128) >> 8;
                    int i19 = (((((i16 * (-38)) - (i17 * 74)) + (i14 * 112)) + 128) >> 8) + 128;
                    int i20 = i6 + 1;
                    allocate.put(i6, (byte) Math.min(255, i18 + 128));
                    i6 += 2;
                    allocate.put(i20, (byte) Math.min(255, i19));
                }
                i8++;
                i10++;
                i7 = i15;
            }
        }
        return allocate;
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer yuv420ThreePlanesToNV21(@NonNull Image.Plane[] planeArr, int i6, int i7) {
        int i8 = i6 * i7;
        int i9 = i8 / 4;
        byte[] bArr = new byte[i9 + i9 + i8];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        int i10 = (i8 + i8) / 4;
        boolean z5 = buffer2.remaining() == i10 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        if (z5) {
            planeArr[0].getBuffer().get(bArr, 0, i8);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i8, 1);
            buffer3.get(bArr, i8 + 1, i10 - 1);
        } else {
            zzc(planeArr[0], i6, i7, bArr, 0, 1);
            zzc(planeArr[1], i6, i7, bArr, i8 + 1, 2);
            zzc(planeArr[2], i6, i7, bArr, i8, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    private ImageConvertUtils() {
    }

    @NonNull
    @KeepForSdk
    public static ByteBuffer bufferWithBackingArray(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return byteBuffer;
        }
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return ByteBuffer.wrap(bArr);
    }

    @NonNull
    @KeepForSdk
    public static ByteBuffer yv12ToNv21Buffer(@NonNull ByteBuffer byteBuffer, boolean z5) {
        ByteBuffer allocateDirect;
        int i6;
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        int i7 = limit / 6;
        if (z5) {
            allocateDirect = ByteBuffer.allocate(limit);
        } else {
            allocateDirect = ByteBuffer.allocateDirect(limit);
        }
        int i8 = 0;
        while (true) {
            i6 = i7 * 4;
            if (i8 >= i6) {
                break;
            }
            allocateDirect.put(i8, byteBuffer.get(i8));
            i8++;
        }
        for (int i9 = 0; i9 < i7 + i7; i9++) {
            allocateDirect.put(i6 + i9, byteBuffer.get(((i9 % 2) * i7) + i6 + (i9 / 2)));
        }
        return allocateDirect;
    }

    private static final void zzc(Image.Plane plane, int i6, int i7, byte[] bArr, int i8, int i9) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit != 0) {
            int i10 = i6 / (i7 / limit);
            int i11 = 0;
            for (int i12 = 0; i12 < limit; i12++) {
                int i13 = i11;
                for (int i14 = 0; i14 < i10; i14++) {
                    bArr[i8] = buffer.get(i13);
                    i8 += i9;
                    i13 += plane.getPixelStride();
                }
                i11 += plane.getRowStride();
            }
        }
    }

    @NonNull
    @KeepForSdk
    public byte[] byteBufferToByteArray(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer cloneByteBuffer(@NonNull ByteBuffer byteBuffer) {
        ByteBuffer allocate;
        Preconditions.checkNotNull(byteBuffer);
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            allocate = ByteBuffer.allocateDirect(capacity);
        } else {
            allocate = ByteBuffer.allocate(capacity);
        }
        allocate.limit(byteBuffer.limit());
        allocate.put((ByteBuffer) byteBuffer.rewind());
        allocate.position(position);
        byteBuffer.position(position);
        return allocate;
    }

    @NonNull
    @KeepForSdk
    public Bitmap convertJpegToUpRightBitmap(@NonNull Image image, int i6) {
        boolean z5;
        if (image.getFormat() == 256) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Only JPEG is supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes != null && planes.length == 1) {
            ByteBuffer buffer = planes[0].getBuffer();
            buffer.rewind();
            int remaining = buffer.remaining();
            byte[] bArr = new byte[remaining];
            buffer.get(bArr);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, remaining);
            return zza(decodeByteArray, i6, decodeByteArray.getWidth(), decodeByteArray.getHeight());
        }
        throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
    }

    @NonNull
    @KeepForSdk
    public Bitmap convertToUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format != 35) {
                    if (format == 842094169) {
                        return yv12ToBitmap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
                    }
                    throw new MlKitException("Unsupported image format", 13);
                }
                return nv21ToBitmap(yuv420ThreePlanesToNV21((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
            }
            return nv21ToBitmap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        return zza((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
    }

    @NonNull
    @KeepForSdk
    public Bitmap getUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        Bitmap bitmapInternal = inputImage.getBitmapInternal();
        if (bitmapInternal != null) {
            return zza(bitmapInternal, inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        return convertToUpRightBitmap(inputImage);
    }

    @NonNull
    @KeepForSdk
    public Bitmap nv21ToBitmap(@NonNull ByteBuffer byteBuffer, int i6, int i7, int i8) throws MlKitException {
        byte[] zzb = zzb(byteBufferToByteArray(byteBuffer), i6, i7);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzb, 0, zzb.length);
        return zza(decodeByteArray, i8, decodeByteArray.getWidth(), decodeByteArray.getHeight());
    }
}
