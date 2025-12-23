package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.core.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageUtil {
    public static final int DEFAULT_RGBA_PIXEL_STRIDE = 4;
    private static final String TAG = "ImageUtil";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(@NonNull String str) {
            super(str);
            this.mFailureType = FailureType.UNKNOWN;
        }

        @NonNull
        public FailureType getFailureType() {
            return this.mFailureType;
        }

        CodecFailedException(@NonNull String str, @NonNull FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }
    }

    @NonNull
    public static Bitmap createBitmapFromPlane(@NonNull ImageProxy.PlaneProxy[] planeProxyArr, int i6, int i7) {
        Preconditions.checkArgument(planeProxyArr.length == 1, "Expect a single plane");
        Preconditions.checkArgument(planeProxyArr[0].getPixelStride() == 4, "Expect pixelStride=4");
        Preconditions.checkArgument(planeProxyArr[0].getRowStride() == i6 * 4, "Expect rowStride=width*4");
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        planeProxyArr[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, planeProxyArr[0].getBuffer(), planeProxyArr[0].getRowStride());
        return createBitmap;
    }

    public static boolean isAspectRatioValid(@Nullable Rational rational) {
        return (rational == null || rational.floatValue() <= 0.0f || rational.isNaN()) ? false : true;
    }

    @NonNull
    public static byte[] jpegImageToJpegByteArray(@NonNull ImageProxy imageProxy) {
        if (imageProxy.getFormat() != 256) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
        }
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }

    public static boolean shouldCropImage(int i6, int i7, int i8, int i9) {
        return (i6 == i8 && i7 == i9) ? false : true;
    }

    @NonNull
    public static Rect computeCropRectFromDispatchInfo(@NonNull Rect rect, int i6, @NonNull Size size, int i7) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i7 - i6);
        float[] sizeToVertexes = sizeToVertexes(size);
        matrix.mapPoints(sizeToVertexes);
        matrix.postTranslate(-min(sizeToVertexes[0], sizeToVertexes[2], sizeToVertexes[4], sizeToVertexes[6]), -min(sizeToVertexes[1], sizeToVertexes[3], sizeToVertexes[5], sizeToVertexes[7]));
        matrix.invert(matrix);
        RectF rectF = new RectF();
        matrix.mapRect(rectF, new RectF(rect));
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static byte[] cropJpegByteArray(@NonNull byte[] bArr, @NonNull Rect rect, @IntRange(from = 1, to = 100) int i6) throws CodecFailedException {
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, new BitmapFactory.Options());
            newInstance.recycle();
            if (decodeRegion == null) {
                throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!decodeRegion.compress(Bitmap.CompressFormat.JPEG, i6, byteArrayOutputStream)) {
                throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
            }
            decodeRegion.recycle();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IllegalArgumentException e6) {
            throw new CodecFailedException("Decode byte array failed with illegal argument." + e6, CodecFailedException.FailureType.DECODE_FAILED);
        }
    }

    @NonNull
    public static Rational getRotatedAspectRatio(@IntRange(from = 0, to = 359) int i6, @NonNull Rational rational) {
        return (i6 == 90 || i6 == 270) ? inverseRational(rational) : new Rational(rational.getNumerator(), rational.getDenominator());
    }

    private static Rational inverseRational(@Nullable Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean isAspectRatioValid(@NonNull Size size, @Nullable Rational rational) {
        return rational != null && rational.floatValue() > 0.0f && isCropAspectRatioHasEffect(size, rational) && !rational.isNaN();
    }

    public static boolean shouldCropImage(@NonNull ImageProxy imageProxy) {
        return shouldCropImage(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy.getCropRect().width(), imageProxy.getCropRect().height());
    }

    private ImageUtil() {
    }

    @Nullable
    public static Rect computeCropRectFromAspectRatio(@NonNull Size size, @NonNull Rational rational) {
        int i6;
        if (!isAspectRatioValid(rational)) {
            Logger.w(TAG, "Invalid view ratio.");
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f6 = width;
        float f7 = height;
        float f8 = f6 / f7;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        int i7 = 0;
        if (rational.floatValue() > f8) {
            int round = Math.round((f6 / numerator) * denominator);
            i6 = (height - round) / 2;
            height = round;
        } else {
            int round2 = Math.round((f7 / denominator) * numerator);
            i7 = (width - round2) / 2;
            width = round2;
            i6 = 0;
        }
        return new Rect(i7, i6, width + i7, height + i6);
    }

    @NonNull
    public static Bitmap createBitmapFromImageProxy(@NonNull ImageProxy imageProxy) {
        int format = imageProxy.getFormat();
        if (format != 1) {
            if (format != 35) {
                if (format == 256) {
                    return createBitmapFromJpegImage(imageProxy);
                }
                throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
            }
            return ImageProcessingUtil.convertYUVToBitmap(imageProxy);
        }
        return createBitmapFromRgbaImage(imageProxy);
    }

    @NonNull
    private static Bitmap createBitmapFromJpegImage(@NonNull ImageProxy imageProxy) {
        byte[] jpegImageToJpegByteArray = jpegImageToJpegByteArray(imageProxy);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(jpegImageToJpegByteArray, 0, jpegImageToJpegByteArray.length, null);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    @NonNull
    private static Bitmap createBitmapFromRgbaImage(@NonNull ImageProxy imageProxy) {
        Bitmap createBitmap = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
        imageProxy.getPlanes()[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, imageProxy.getPlanes()[0].getBuffer(), imageProxy.getPlanes()[0].getRowStride());
        return createBitmap;
    }

    @NonNull
    public static ByteBuffer createDirectByteBuffer(@NonNull Bitmap bitmap) {
        boolean z5;
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.copyBitmapToByteBuffer(bitmap, allocateDirect, bitmap.getRowBytes());
        allocateDirect.rewind();
        return allocateDirect;
    }

    private static boolean isCropAspectRatioHasEffect(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        float numerator = rational.getNumerator();
        float denominator = rational.getDenominator();
        if (height == Math.round((width / numerator) * denominator) && width == Math.round((height / denominator) * numerator)) {
            return false;
        }
        return true;
    }

    public static float min(float f6, float f7, float f8, float f9) {
        return Math.min(Math.min(f6, f7), Math.min(f8, f9));
    }

    @NonNull
    public static float[] sizeToVertexes(@NonNull Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    @NonNull
    public static byte[] yuvImageToJpegByteArray(@NonNull ImageProxy imageProxy, @Nullable Rect rect, @IntRange(from = 1, to = 100) int i6, int i7) throws CodecFailedException {
        if (imageProxy.getFormat() == 35) {
            YuvImage yuvImage = new YuvImage(yuv_420_888toNv21(imageProxy), 17, imageProxy.getWidth(), imageProxy.getHeight(), null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ExifOutputStream exifOutputStream = new ExifOutputStream(byteArrayOutputStream, ExifData.create(imageProxy, i7));
            if (rect == null) {
                rect = new Rect(0, 0, imageProxy.getWidth(), imageProxy.getHeight());
            }
            if (yuvImage.compressToJpeg(rect, i6, exifOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    @NonNull
    public static byte[] yuv_420_888toNv21(@NonNull ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[2];
        ByteBuffer buffer = planeProxy.getBuffer();
        ByteBuffer buffer2 = planeProxy2.getBuffer();
        ByteBuffer buffer3 = planeProxy3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + remaining];
        int i6 = 0;
        for (int i7 = 0; i7 < imageProxy.getHeight(); i7++) {
            buffer.get(bArr, i6, imageProxy.getWidth());
            i6 += imageProxy.getWidth();
            buffer.position(Math.min(remaining, (buffer.position() - imageProxy.getWidth()) + planeProxy.getRowStride()));
        }
        int height = imageProxy.getHeight() / 2;
        int width = imageProxy.getWidth() / 2;
        int rowStride = planeProxy3.getRowStride();
        int rowStride2 = planeProxy2.getRowStride();
        int pixelStride = planeProxy3.getPixelStride();
        int pixelStride2 = planeProxy2.getPixelStride();
        byte[] bArr2 = new byte[rowStride];
        byte[] bArr3 = new byte[rowStride2];
        for (int i8 = 0; i8 < height; i8++) {
            buffer3.get(bArr2, 0, Math.min(rowStride, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(rowStride2, buffer2.remaining()));
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < width; i11++) {
                int i12 = i6 + 1;
                bArr[i6] = bArr2[i9];
                i6 += 2;
                bArr[i12] = bArr3[i10];
                i9 += pixelStride;
                i10 += pixelStride2;
            }
        }
        return bArr;
    }

    @NonNull
    public static byte[] jpegImageToJpegByteArray(@NonNull ImageProxy imageProxy, @NonNull Rect rect, @IntRange(from = 1, to = 100) int i6) throws CodecFailedException {
        if (imageProxy.getFormat() == 256) {
            return cropJpegByteArray(jpegImageToJpegByteArray(imageProxy), rect, i6);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }
}
