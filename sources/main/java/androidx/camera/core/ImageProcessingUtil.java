package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    public static boolean convertYuvToJpegBytesIntoSurface(@NonNull ImageProxy imageProxy, @IntRange(from = 1, to = 100) int i6, int i7, @NonNull Surface surface) {
        try {
            return writeJpegBytesToSurface(surface, ImageUtil.yuvImageToJpegByteArray(imageProxy, null, i6, i7));
        } catch (ImageUtil.CodecFailedException e6) {
            Logger.e(TAG, "Failed to encode YUV to JPEG", e6);
            return false;
        }
    }

    private static native int nativeConvertAndroid420ToABGR(@NonNull ByteBuffer byteBuffer, int i6, @NonNull ByteBuffer byteBuffer2, int i7, @NonNull ByteBuffer byteBuffer3, int i8, int i9, int i10, @Nullable Surface surface, @Nullable ByteBuffer byteBuffer4, int i11, int i12, int i13, int i14, int i15, int i16);

    private static native int nativeConvertAndroid420ToBitmap(@NonNull ByteBuffer byteBuffer, int i6, @NonNull ByteBuffer byteBuffer2, int i7, @NonNull ByteBuffer byteBuffer3, int i8, int i9, int i10, @NonNull Bitmap bitmap, int i11, int i12, int i13);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i6, int i7, int i8, int i9, boolean z5);

    private static native int nativeRotateYUV(@NonNull ByteBuffer byteBuffer, int i6, @NonNull ByteBuffer byteBuffer2, int i7, @NonNull ByteBuffer byteBuffer3, int i8, int i9, @NonNull ByteBuffer byteBuffer4, int i10, int i11, @NonNull ByteBuffer byteBuffer5, int i12, int i13, @NonNull ByteBuffer byteBuffer6, int i14, int i15, @NonNull ByteBuffer byteBuffer7, @NonNull ByteBuffer byteBuffer8, @NonNull ByteBuffer byteBuffer9, int i16, int i17, int i18);

    private static native int nativeShiftPixel(@NonNull ByteBuffer byteBuffer, int i6, @NonNull ByteBuffer byteBuffer2, int i7, @NonNull ByteBuffer byteBuffer3, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    private static native int nativeWriteJpegToSurface(@NonNull byte[] bArr, @NonNull Surface surface);

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static /* synthetic */ void a(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    public static /* synthetic */ void b(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    private static boolean isSupportedRotationDegrees(@IntRange(from = 0, to = 359) int i6) {
        return i6 == 0 || i6 == 90 || i6 == 180 || i6 == 270;
    }

    private ImageProcessingUtil() {
    }

    public static boolean applyPixelShiftForYUV(@NonNull ImageProxy imageProxy) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return false;
        }
        if (applyPixelShiftInternal(imageProxy) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "One pixel shift for YUV failure");
            return false;
        }
        return true;
    }

    @NonNull
    private static Result applyPixelShiftInternal(@NonNull ImageProxy imageProxy) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (nativeShiftPixel(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, width, height, pixelStride, pixelStride2, pixelStride2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    @Nullable
    public static ImageProxy convertJpegBytesToImage(@NonNull ImageReaderProxy imageReaderProxy, @NonNull byte[] bArr) {
        boolean z5;
        if (imageReaderProxy.getImageFormat() == 256) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        Preconditions.checkNotNull(bArr);
        Surface surface = imageReaderProxy.getSurface();
        Preconditions.checkNotNull(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.e(TAG, "Failed to enqueue JPEG image.");
            return null;
        }
        ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage == null) {
            Logger.e(TAG, "Failed to get acquire JPEG image.");
        }
        return acquireLatestImage;
    }

    @NonNull
    public static Bitmap convertYUVToBitmap(@NonNull ImageProxy imageProxy) {
        if (imageProxy.getFormat() == 35) {
            int width = imageProxy.getWidth();
            int height = imageProxy.getHeight();
            int rowStride = imageProxy.getPlanes()[0].getRowStride();
            int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
            int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
            int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
            int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
            Bitmap createBitmap = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
            if (nativeConvertAndroid420ToBitmap(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, createBitmap, createBitmap.getRowBytes(), width, height) == 0) {
                return createBitmap;
            }
            throw new UnsupportedOperationException("YUV to RGB conversion failed");
        }
        throw new IllegalArgumentException("Input image format must be YUV_420_888");
    }

    @Nullable
    public static ImageProxy convertYUVToRGB(@NonNull final ImageProxy imageProxy, @NonNull ImageReaderProxy imageReaderProxy, @Nullable ByteBuffer byteBuffer, @IntRange(from = 0, to = 359) int i6, boolean z5) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!isSupportedRotationDegrees(i6)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (convertYUVToRGBInternal(imageProxy, imageReaderProxy.getSurface(), byteBuffer, i6, z5) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            Logger.d(TAG, String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(sImageCount)));
            sImageCount++;
        }
        final ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage == null) {
            Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
            return null;
        }
        SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
        singleCloseImageProxy.addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.d0
            @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
            public final void onImageClose(ImageProxy imageProxy2) {
                ImageProcessingUtil.b(ImageProxy.this, imageProxy, imageProxy2);
            }
        });
        return singleCloseImageProxy;
    }

    @NonNull
    private static Result convertYUVToRGBInternal(@NonNull ImageProxy imageProxy, @NonNull Surface surface, @Nullable ByteBuffer byteBuffer, int i6, boolean z5) {
        int i7;
        int i8;
        int i9;
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (z5) {
            i7 = pixelStride;
        } else {
            i7 = 0;
        }
        if (z5) {
            i8 = pixelStride2;
        } else {
            i8 = 0;
        }
        if (z5) {
            i9 = pixelStride2;
        } else {
            i9 = 0;
        }
        if (nativeConvertAndroid420ToABGR(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, surface, byteBuffer, width, height, i7, i8, i9, i6) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    public static void copyBitmapToByteBuffer(@NonNull Bitmap bitmap, @NonNull ByteBuffer byteBuffer, int i6) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i6, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void copyByteBufferToBitmap(@NonNull Bitmap bitmap, @NonNull ByteBuffer byteBuffer, int i6) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i6, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    private static boolean isSupportedYUVFormat(@NonNull ImageProxy imageProxy) {
        if (imageProxy.getFormat() == 35 && imageProxy.getPlanes().length == 3) {
            return true;
        }
        return false;
    }

    @Nullable
    public static ImageProxy rotateYUV(@NonNull final ImageProxy imageProxy, @NonNull ImageReaderProxy imageReaderProxy, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, @IntRange(from = 0, to = 359) int i6) {
        Result result;
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for rotate YUV");
            return null;
        }
        if (!isSupportedRotationDegrees(i6)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        Result result2 = Result.ERROR_CONVERSION;
        if (Build.VERSION.SDK_INT >= 23 && i6 > 0) {
            result = rotateYUVInternal(imageProxy, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i6);
        } else {
            result = result2;
        }
        if (result == result2) {
            Logger.e(TAG, "rotate YUV failure");
            return null;
        }
        final ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage == null) {
            Logger.e(TAG, "YUV rotation acquireLatestImage failure");
            return null;
        }
        SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
        singleCloseImageProxy.addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.e0
            @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
            public final void onImageClose(ImageProxy imageProxy2) {
                ImageProcessingUtil.a(ImageProxy.this, imageProxy, imageProxy2);
            }
        });
        return singleCloseImageProxy;
    }

    @Nullable
    @RequiresApi(23)
    private static Result rotateYUVInternal(@NonNull ImageProxy imageProxy, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, int i6) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[1].getPixelStride();
        Image dequeueInputImage = ImageWriterCompat.dequeueInputImage(imageWriter);
        if (dequeueInputImage == null) {
            return Result.ERROR_CONVERSION;
        }
        if (nativeRotateYUV(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, dequeueInputImage.getPlanes()[0].getBuffer(), dequeueInputImage.getPlanes()[0].getRowStride(), dequeueInputImage.getPlanes()[0].getPixelStride(), dequeueInputImage.getPlanes()[1].getBuffer(), dequeueInputImage.getPlanes()[1].getRowStride(), dequeueInputImage.getPlanes()[1].getPixelStride(), dequeueInputImage.getPlanes()[2].getBuffer(), dequeueInputImage.getPlanes()[2].getRowStride(), dequeueInputImage.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i6) != 0) {
            return Result.ERROR_CONVERSION;
        }
        ImageWriterCompat.queueInputImage(imageWriter, dequeueInputImage);
        return Result.SUCCESS;
    }

    public static boolean writeJpegBytesToSurface(@NonNull Surface surface, @NonNull byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.e(TAG, "Failed to enqueue JPEG image.");
            return false;
        }
        return true;
    }
}
