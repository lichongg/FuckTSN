package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected ExifInfo defineExifOrientation(String str) {
        boolean z5 = true;
        int i6 = 0;
        try {
        } catch (IOException unused) {
            L.w("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z5 = false;
                break;
            case 2:
                break;
            case 3:
                z5 = false;
                i6 = 180;
                break;
            case 4:
                i6 = 180;
                break;
            case 5:
                i6 = 270;
                break;
            case 6:
                z5 = false;
                i6 = 90;
                break;
            case 7:
                i6 = 90;
                break;
            case 8:
                z5 = false;
                i6 = 270;
                break;
        }
        return new ExifInfo(i6, z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    private boolean canDefineExifParams(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i6, boolean z5) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i6);
            float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(computeImageScale, 1.0f) != 0) {
                matrix.setScale(computeImageScale, computeImageScale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z5) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i6 != 0) {
            matrix.postRotate(i6);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(i6), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.kwad.sdk.core.imageloader.core.decode.ImageDecoder
    public DecodedResult decode(ImageDecodingInfo imageDecodingInfo) {
        DecodedResult decodedResult = new DecodedResult();
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            if (imageDecodingInfo.getLoadListener() != null && imageDecodingInfo.getLoadListener().onDecode(imageDecodingInfo.getImageUri(), imageStream, decodedResult)) {
                return decodedResult;
            }
            ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
            imageStream = resetStream(imageStream, imageDecodingInfo);
            decodedResult.mBitmap = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
            b.closeQuietly(imageStream);
            Bitmap bitmap = decodedResult.mBitmap;
            if (bitmap == null && decodedResult.mFrameSequence == null) {
                L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
                return decodedResult;
            }
            ExifInfo exifInfo = defineImageSizeAndRotation.exif;
            decodedResult.mBitmap = considerExactScaleAndOrientatiton(bitmap, imageDecodingInfo, exifInfo.rotation, exifInfo.flipHorizontal);
            return decodedResult;
        } finally {
            b.closeQuietly(imageStream);
        }
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        ExifInfo defineExifOrientation = (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) ? defineExifOrientation(imageUri) : new ExifInfo();
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, defineExifOrientation.rotation), defineExifOrientation);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i6, boolean z5) {
            this.rotation = i6;
            this.flipHorizontal = z5;
        }
    }

    public BaseImageDecoder(boolean z5) {
        this.loggingEnabled = z5;
    }

    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        boolean z5;
        int computeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            computeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            computeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            ImageSize targetSize = imageDecodingInfo.getTargetSize();
            if (imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
                z5 = true;
            } else {
                z5 = false;
            }
            computeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, targetSize, imageDecodingInfo.getViewScaleType(), z5);
        }
        if (computeImageSampleSize > 1 && this.loggingEnabled) {
            L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(computeImageSampleSize), Integer.valueOf(computeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = computeImageSampleSize;
        return decodingOptions;
    }

    protected InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        b.closeQuietly(inputStream);
        return getImageStream(imageDecodingInfo);
    }
}
