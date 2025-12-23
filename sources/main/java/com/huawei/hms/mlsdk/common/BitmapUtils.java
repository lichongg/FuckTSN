package com.huawei.hms.mlsdk.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.huawei.hms.ml.common.utils.StreamUtils;
import com.huawei.hms.mlsdk.common.MLFrame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class BitmapUtils {
    private static final String TAG = "BitmapUtils";

    public static Bitmap cut(Bitmap bitmap, Point[] pointArr, int i6) {
        if (bitmap == null || pointArr == null || pointArr.length != 4) {
            return null;
        }
        for (Point point : pointArr) {
            if (point == null) {
                return null;
            }
        }
        Point point2 = pointArr[0];
        Point point3 = pointArr[1];
        Point point4 = pointArr[2];
        double atan2 = Math.atan2(point3.y - point2.y, point3.x - point2.x);
        float degrees = (float) Math.toDegrees(atan2);
        if (Math.abs((int) degrees) <= 0) {
            return cutPaddingExtendRect(bitmap, point2, point4, 0, 0, i6);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i7 = width >> 1;
        int i8 = height >> 1;
        Point point5 = new Point(i7, i8);
        Matrix matrix = new Matrix();
        matrix.setRotate(-degrees, i7, i8);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return cutPaddingExtendRect(createBitmap, rotateCoordinate(bitmap, point5, point2, atan2), rotateCoordinate(bitmap, point5, point4, atan2), (createBitmap.getWidth() - width) >> 1, (createBitmap.getHeight() - height) >> 1, i6);
    }

    public static Bitmap getBitmap(ByteBuffer byteBuffer, MLFrame.Property property) {
        Throwable th;
        YuvImage yuvImage;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteBuffer.rewind();
            int limit = byteBuffer.limit();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            yuvImage = new YuvImage(bArr, 17, property.getWidth(), property.getHeight(), null);
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            yuvImage.compressToJpeg(new Rect(0, 0, property.getWidth(), property.getHeight()), 100, byteArrayOutputStream);
            Bitmap rotateBitmap = rotateBitmap(BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()), property.getQuadrant());
            StreamUtils.closeStreams(byteArrayOutputStream);
            return rotateBitmap;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            StreamUtils.closeStreams(byteArrayOutputStream2);
            throw th;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i6) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i6 != 1 ? i6 != 2 ? i6 != 3 ? 0 : 270 : 180 : 90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static Bitmap cutPaddingExtendRect(Bitmap bitmap, Point point, Point point2, int i6, int i7, int i8) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i9 = (point.x + i6) - i8;
        int i10 = 0;
        if (i9 < 0) {
            i9 = 0;
        }
        int i11 = (point.y + i7) - i8;
        if (i11 >= 0) {
            i10 = i11;
        }
        int i12 = point2.x + i6 + i8;
        if (i12 <= width) {
            width = i12;
        }
        int i13 = point2.y + i7 + i8;
        if (i13 <= height) {
            height = i13;
        }
        return Bitmap.createBitmap(bitmap, i9, i10, width - i9, height - i10);
    }

    private static Point rotateCoordinate(Bitmap bitmap, Point point, Point point2, double d6) {
        int height = bitmap.getHeight();
        int i6 = point2.x;
        int i7 = height - point2.y;
        int i8 = point.x;
        int i9 = height - point.y;
        double d7 = i6 - i8;
        double d8 = i7 - i9;
        return new Point((int) (((Math.cos(d6) * d7) - (Math.sin(d6) * d8)) + i8), height - ((int) (((d7 * Math.sin(d6)) + (d8 * Math.cos(d6))) + i9)));
    }
}
