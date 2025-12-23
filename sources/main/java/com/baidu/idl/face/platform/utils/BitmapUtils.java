package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.core.view.ViewCompat;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BitmapUtils {
    public static final int IMAGEBOUND = 128;
    public static final int MAXLENTH = 1024;
    public static final int PIC_COMPRESS_SIZE = 4;
    private static final int QUALITY = 100;
    public static final int ROTATE0 = 0;
    public static final int ROTATE180 = 180;
    public static final int ROTATE270 = 270;
    public static final int ROTATE360 = 360;
    public static final int ROTATE90 = 90;
    private static final String TAG = "ImageUtils";

    public static byte[] bitmapCompress(Bitmap bitmap, int i6) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i6, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return byteArray;
                }
            } catch (Exception unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, float f6) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(f6, bitmap);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(f6, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static int decodeImageDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static boolean saveBitmap(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return true;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static Bitmap scale(Bitmap bitmap, float f6) {
        Matrix matrix = new Matrix();
        matrix.postScale(f6, f6);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap BGR2Bitmap(byte[] bArr, int i6, int i7) {
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        int i8 = i6 * i7;
        byte[] bArr2 = new byte[i8 * 4];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9 * 3;
            byte b6 = bArr[i10];
            byte b7 = bArr[i10 + 1];
            int i11 = i9 * 4;
            bArr2[i11] = bArr[i10 + 2];
            bArr2[i11 + 1] = b7;
            bArr2[i11 + 2] = b6;
            bArr2[i11 + 3] = -1;
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        return createBitmap;
    }

    public static Bitmap Depth2Bitmap(byte[] bArr, int i6, int i7) {
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        int i8 = i6 * i7;
        int[] iArr = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9 * 2;
            byte b6 = bArr[i10];
            byte b7 = bArr[i10 + 1];
            iArr[i9] = ((((b6 + (b7 * 256)) / 10) & 255) << 16) | ((((b7 * 256) + b6) / 10) & 255) | (((((b7 * 256) + b6) / 10) & 255) << 8) | ViewCompat.MEASURED_STATE_MASK;
        }
        createBitmap.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        return createBitmap;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i6, int i7) {
        int min;
        double d6 = options.outWidth;
        double d7 = options.outHeight;
        int ceil = i7 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d6 * d7) / i7));
        if (i6 == -1) {
            min = 128;
        } else {
            double d8 = i6;
            min = (int) Math.min(Math.floor(d6 / d8), Math.floor(d7 / d8));
        }
        if (min >= ceil) {
            if (i7 == -1 && i6 == -1) {
                return 1;
            }
            if (i6 != -1) {
                return min;
            }
        }
        return ceil;
    }

    public static Bitmap getInstaceBmp(BDFaceImageInstance bDFaceImageInstance) {
        BDFaceSDKCommon.BDFaceImageType bDFaceImageType = bDFaceImageInstance.imageType;
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_RGBA) {
            Bitmap createBitmap = Bitmap.createBitmap(bDFaceImageInstance.width, bDFaceImageInstance.height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bDFaceImageInstance.data));
            return createBitmap;
        }
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGR) {
            return BGR2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
        }
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21) {
            return yuv2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
        }
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_GRAY) {
            return Depth2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
        }
        return null;
    }

    public static Bitmap rotateBitmap(float f6, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (f6 == 0.0f) {
            return bitmap;
        }
        matrix.setRotate(f6);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap yuv2Bitmap(byte[] bArr, int i6, int i7) {
        int i8 = i6 * i7;
        int[] iArr = new int[i8];
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = (i9 * i6) + i10;
                int i12 = 255;
                int i13 = bArr[i11] & 255;
                int i14 = ((i9 >> 1) * i6) + i8 + (i10 & (-2));
                int i15 = bArr[i14] & 255;
                int i16 = bArr[i14 + 1] & 255;
                if (i13 < 16) {
                    i13 = 16;
                }
                float f6 = (i13 - 16) * 1.164f;
                float f7 = i16 - 128;
                int round = Math.round((1.596f * f7) + f6);
                float f8 = i15 - 128;
                int round2 = Math.round((f6 - (f7 * 0.813f)) - (0.391f * f8));
                int round3 = Math.round(f6 + (f8 * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    i12 = 0;
                } else if (round3 <= 255) {
                    i12 = round3;
                }
                iArr[i11] = (i12 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        return createBitmap;
    }

    private BitmapUtils() {
    }

    public static String bitmapToJpegBase64(Bitmap bitmap, int i6, float f6) {
        try {
            float max = f6 / Math.max(bitmap.getWidth(), bitmap.getHeight());
            if (max < 1.0f) {
                bitmap = scale(bitmap, max);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i6, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return Base64Utils.encodeToString(byteArray, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap calculateInSampleSize(Bitmap bitmap, int i6, int i7) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height <= i7 && width <= i6) {
            return bitmap;
        }
        float f6 = i7 / height;
        float f7 = i6 / width;
        if (f6 >= f7) {
            f6 = f7;
        }
        return scale(bitmap, f6);
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i6, int i7) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i6, i7);
        if (computeInitialSampleSize <= 8) {
            int i8 = 1;
            while (i8 < computeInitialSampleSize) {
                i8 <<= 1;
            }
            return i8;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    public static Bitmap scale(Bitmap bitmap, int i6, int i7) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i6 / width, i7 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap createBitmap(Context context, String str, int i6) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
            rotateBitmap = rotateBitmap(i6, bitmap);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
            rotateBitmap = rotateBitmap(i6, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, int i6) {
        Bitmap rotateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = null;
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            rotateBitmap = rotateBitmap(i6, bitmap);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
            if (bitmap != null) {
                bitmap.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            rotateBitmap = rotateBitmap(i6, bitmap);
        }
        if (rotateBitmap != bitmap && bitmap != null) {
            bitmap.recycle();
        }
        return rotateBitmap;
    }

    public static Bitmap createBitmap(Context context, int i6, int i7, int[] iArr) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = Bitmap.createBitmap(iArr, i6, i7, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null && bitmap != null) {
            bitmap.recycle();
        }
        return null;
    }
}
