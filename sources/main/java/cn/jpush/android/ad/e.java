package cn.jpush.android.ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.jpush.android.helper.Logger;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {
    private static int a(int i6, int i7) {
        if (i6 % 2 == 1) {
            i6++;
        }
        if (i7 % 2 == 1) {
            i7++;
        }
        int max = Math.max(i6, i7);
        float min = Math.min(i6, i7) / max;
        if (min > 1.0f || min <= 0.5625d) {
            double d6 = min;
            if (d6 > 0.5625d || d6 <= 0.5d) {
                return (int) Math.ceil(max / (1280.0d / d6));
            }
            int i8 = max / PredefinedCaptureConfigurations.f35648o;
            if (i8 == 0) {
                return 1;
            }
            return i8;
        }
        if (max < 1664) {
            return 1;
        }
        if (max < 4990) {
            return 2;
        }
        if (max > 4990 && max < 10240) {
            return 4;
        }
        int i9 = max / PredefinedCaptureConfigurations.f35648o;
        if (i9 == 0) {
            return 1;
        }
        return i9;
    }

    private static Bitmap.CompressFormat a(String str) {
        str.getClass();
        return !str.equals("image/png") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    public static Bitmap a(String str, int i6, int i7) {
        return BitmapFactory.decodeFile(str, new BitmapFactory.Options());
    }

    public static void a(String str, String str2) {
        String str3;
        if (str == null || str2 == null) {
            str3 = "File path or URL is null.";
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeFile(str, options);
            int a6 = a(options.outWidth, options.outHeight);
            Logger.d("ImageUtils", "compressImage computeSize=" + a6);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = a6;
            options2.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
            if (decodeFile != null) {
                String a7 = a.a(str2);
                Logger.d("ImageUtils", "compressImage file type=" + a7);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        boolean compress = decodeFile.compress(a(a7), 60, byteArrayOutputStream);
                        Logger.d("ImageUtils", "compressImage compress=" + compress);
                        if (!compress) {
                            byteArrayOutputStream.close();
                            return;
                        }
                        File file = new File(str);
                        if (file.exists() && !file.delete()) {
                            Logger.d("ImageUtils", "Failed to delete original file: " + str);
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        try {
                            fileOutputStream.write(byteArrayOutputStream.toByteArray());
                            fileOutputStream.close();
                            byteArrayOutputStream.close();
                            return;
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    Logger.d("ImageUtils", "compressImage IOException=" + e6.getMessage());
                    return;
                } finally {
                    decodeFile.recycle();
                }
            }
            str3 = "compressImage tagBitmap is null";
        }
        Logger.d("ImageUtils", str3);
    }
}
