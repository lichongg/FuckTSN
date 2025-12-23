package com.huawei.hms.ml.common.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ImageConvertUtils {
    public static final int INDEX_PLANE_U = 1;
    public static final int INDEX_PLANE_V = 2;
    public static final int INDEX_PLANE_Y = 0;
    private static final ImageConvertUtils INSTANCE = new ImageConvertUtils();
    public static final int YUV_FORMAT_I420 = 1;
    public static final int YUV_FORMAT_NV21 = 2;

    public static byte[] byteToNv21(byte[] bArr) {
        int length = bArr.length;
        int i6 = (length * 2) / 3;
        int i7 = length - i6;
        int i8 = length / 6;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        for (int i9 = 0; i9 < i7; i9++) {
            if (i9 % 2 == 0) {
                bArr2[i6 + i9] = bArr[(i9 / 2) + i6];
            } else {
                bArr2[i6 + i9] = bArr[i6 + i8 + (i9 / 2)];
            }
        }
        return bArr2;
    }

    private static void checkFormat(Image image, int i6) {
        if (i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("only support YUV_FORMAT_I420 and YUV_FORMAT_NV21");
        }
        if (isImageFormatSupported(image)) {
            return;
        }
        throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
    }

    private static int getOutputStride(int i6, int i7) {
        return (i6 == 0 || i7 == 1) ? 1 : 2;
    }

    public static byte[] nv21ToJpeg(byte[] bArr, int i6, int i7) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new YuvImage(bArr, 17, i6, i7, null).compressToJpeg(new Rect(0, 0, i6, i7), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    private static byte[] argbToNv21(int[] iArr, int i6, int i7) {
        int i8 = i6 * i7;
        int i9 = (i8 * 3) / 2;
        byte[] bArr = new byte[i9];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i7; i12++) {
            int i13 = 0;
            while (i13 < i6) {
                int i14 = iArr[i11];
                int i15 = (16711680 & i14) >> 16;
                int i16 = (65280 & i14) >> 8;
                int i17 = 255;
                int i18 = i14 & 255;
                int i19 = (((((i15 * 66) + (i16 * 129)) + (i18 * 25)) + 128) >> 8) + 16;
                int i20 = (((((i15 * (-38)) - (i16 * 74)) + (i18 * 112)) + 128) >> 8) + 128;
                int i21 = (((((i15 * 112) - (i16 * 94)) - (i18 * 18)) + 128) >> 8) + 128;
                int i22 = i10 + 1;
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 255) {
                    i19 = 255;
                }
                bArr[i10] = (byte) i19;
                if (i12 % 2 == 0 && i11 % 2 == 0 && i8 < i9 - 2) {
                    int i23 = i8 + 1;
                    if (i21 < 0) {
                        i21 = 0;
                    } else if (i21 > 255) {
                        i21 = 255;
                    }
                    bArr[i8] = (byte) i21;
                    i8 += 2;
                    if (i20 < 0) {
                        i17 = 0;
                    } else if (i20 <= 255) {
                        i17 = i20;
                    }
                    bArr[i23] = (byte) i17;
                }
                i11++;
                i13++;
                i10 = i22;
            }
        }
        return bArr;
    }

    public static byte[] bitmap2Jpeg(Bitmap bitmap, int i6) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i6, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    public static byte[] bitmapToNv21(Bitmap bitmap, int i6, int i7) {
        if (bitmap == null || bitmap.getWidth() < i6 || bitmap.getHeight() < i7) {
            return new byte[0];
        }
        int[] iArr = new int[i6 * i7];
        bitmap.getPixels(iArr, 0, i6, 0, 0, i6, i7);
        return argbToNv21(iArr, i6, i7);
    }

    private static int getChannelOffset(int i6, int i7, int i8) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 != 1) {
            if (i7 == 1) {
                return (int) (i8 * 1.25d);
            }
        } else if (i7 != 1) {
            return i8 + 1;
        }
        return i8;
    }

    @TargetApi(21)
    public static byte[] getDataFromImage(Image image, int i6) {
        int i7;
        byte[] bArr;
        int i8 = i6;
        checkFormat(image, i6);
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i9 = width * height;
        byte[] bArr2 = new byte[(ImageFormat.getBitsPerPixel(format) * i9) / 8];
        byte[] bArr3 = new byte[planes[0].getRowStride()];
        int i10 = 0;
        while (i10 < planes.length) {
            ByteBuffer buffer = planes[i10].getBuffer();
            int rowStride = planes[i10].getRowStride();
            int pixelStride = planes[i10].getPixelStride();
            int channelOffset = getChannelOffset(i10, i8, i9);
            int outputStride = getOutputStride(i10, i8);
            int i11 = i10 == 0 ? 0 : 1;
            int i12 = width >> i11;
            int i13 = height >> i11;
            buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
            int i14 = 0;
            while (i14 < i13) {
                Rect rect = cropRect;
                if (pixelStride == 1 && outputStride == 1) {
                    buffer.get(bArr2, channelOffset, i12);
                    channelOffset += i12;
                    bArr = bArr2;
                    i7 = i12;
                } else {
                    i7 = ((i12 - 1) * pixelStride) + 1;
                    bArr = bArr2;
                    buffer.get(bArr3, 0, i7);
                    for (int i15 = 0; i15 < i12; i15++) {
                        bArr[channelOffset] = bArr3[i15 * pixelStride];
                        channelOffset += outputStride;
                    }
                }
                if (i14 < i13 - 1) {
                    buffer.position((buffer.position() + rowStride) - i7);
                }
                i14++;
                cropRect = rect;
                bArr2 = bArr;
            }
            i10++;
            i8 = i6;
        }
        return bArr2;
    }

    public static ImageConvertUtils getInstance() {
        return INSTANCE;
    }

    public static byte[] nv21ToGray(byte[] bArr, int i6, int i7) {
        int i8 = i6 * i7;
        int i9 = i8 / 2;
        byte[] bArr2 = new byte[i9];
        Arrays.fill(bArr2, Byte.MIN_VALUE);
        System.arraycopy(bArr2, 0, bArr, i8, i9);
        return bArr;
    }

    private ImageConvertUtils() {
    }

    public static byte[] buffer2Byte(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    private static boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        if (format != 35 && format != 17 && format != 842094169) {
            return false;
        }
        return true;
    }

    public static byte[] yuv2Buffer(Image image) {
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        int remaining3 = buffer3.remaining();
        int i6 = remaining + remaining2 + remaining3;
        byte[] bArr = new byte[i6];
        buffer.get(bArr, 0, remaining);
        buffer3.get(bArr, remaining, remaining3);
        buffer2.get(bArr, i6 - remaining2, remaining2);
        return bArr;
    }
}
