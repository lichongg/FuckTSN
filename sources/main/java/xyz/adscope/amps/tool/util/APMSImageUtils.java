package xyz.adscope.amps.tool.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class APMSImageUtils {
    private static int calculateInSampleSize(BitmapFactory.Options options, int i6, int i7) {
        int i8 = options.outHeight;
        int i9 = options.outWidth;
        int i10 = 1;
        if (i8 <= i7 && i9 <= i6) {
            return 1;
        }
        int i11 = i8 / 2;
        int i12 = i9 / 2;
        while (i11 / i10 >= i7 && i12 / i10 >= i6) {
            i10 *= 2;
        }
        return i10;
    }

    public static float calculateSimilarityBalanced(Bitmap bitmap, Bitmap bitmap2) {
        return compareHistograms(calculateHistogram(createThumbnail(bitmap, 64)), calculateHistogram(createThumbnail(bitmap2, 64)));
    }

    public static float calculateSimilarityFast(Bitmap bitmap, Bitmap bitmap2) {
        return comparePixels(createThumbnail(bitmap, 32), createThumbnail(bitmap2, 32));
    }

    private static float compareHistograms(int[] iArr, int[] iArr2) {
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            d7 += iArr[i6];
            d8 += iArr2[i6];
        }
        if (d7 == 0.0d || d8 == 0.0d) {
            return 0.0f;
        }
        for (int i7 = 0; i7 < iArr.length; i7++) {
            d6 += Math.sqrt((iArr[i7] / d7) * (iArr2[i7] / d8));
        }
        return (float) d6;
    }

    public static Bitmap decodeSampledBitmap(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            options.inSampleSize = calculateInSampleSize(options, 1024, 1024);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inMutable = false;
            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    private static int[] calculateHistogram(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[64];
        int i6 = width * height;
        int[] iArr2 = new int[i6];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr2[i7];
            int i9 = ((i8 & 255) >> 6) | ((((i8 >> 16) & 255) >> 6) << 4) | ((((i8 >> 8) & 255) >> 6) << 2);
            iArr[i9] = iArr[i9] + 1;
        }
        return iArr;
    }

    private static float comparePixels(Bitmap bitmap, Bitmap bitmap2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i6 = width * height;
        if (width == bitmap2.getWidth() && height == bitmap2.getHeight()) {
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = iArr[i8];
                int i10 = (i9 >> 16) & 255;
                int i11 = (i9 >> 8) & 255;
                int i12 = iArr2[i8];
                if (Math.abs(i10 - ((i12 >> 16) & 255)) + Math.abs(i11 - ((i12 >> 8) & 255)) + Math.abs((i9 & 255) - (i12 & 255)) > 25) {
                    i7++;
                }
            }
            return 1.0f - (i7 / i6);
        }
        return 0.0f;
    }

    private static Bitmap createThumbnail(Bitmap bitmap, int i6) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f6 = i6;
        float min = Math.min(f6 / width, f6 / height);
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
