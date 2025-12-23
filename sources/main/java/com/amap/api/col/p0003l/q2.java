package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q2 {
    private static void f(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) i7;
        bArr[i6 + 1] = (byte) (i7 >> 8);
        bArr[i6 + 2] = (byte) (i7 >> 16);
        bArr[i6 + 3] = (byte) (i7 >> 24);
    }

    private static int a(byte[] bArr, int i6) {
        byte b6 = bArr[i6];
        byte b7 = bArr[i6 + 1];
        byte b8 = bArr[i6 + 2];
        return (bArr[i6 + 3] << 24) | (b6 & 255) | (b7 << 8) | (b8 << 16);
    }

    private static void d(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth();
        int i6 = width - 2;
        int[] iArr = new int[i6];
        bitmap.getPixels(iArr, 0, i6, 1, bitmap.getHeight() - 1, i6, 1);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= i6) {
                break;
            }
            if (-16777216 == iArr[i8]) {
                f(bArr, 12, i8);
                break;
            }
            i8++;
        }
        int i9 = width - 3;
        while (true) {
            if (i9 < 0) {
                break;
            }
            if (-16777216 == iArr[i9]) {
                f(bArr, 16, (i6 - i9) - 2);
                break;
            }
            i9--;
        }
        int height = bitmap.getHeight();
        int i10 = height - 2;
        int[] iArr2 = new int[i10];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, i10);
        while (true) {
            if (i7 >= i10) {
                break;
            }
            if (-16777216 == iArr2[i7]) {
                f(bArr, 20, i7);
                break;
            }
            i7++;
        }
        for (int i11 = height - 3; i11 >= 0; i11--) {
            if (-16777216 == iArr2[i11]) {
                f(bArr, 24, (i10 - i11) - 2);
                return;
            }
        }
    }

    private static void e(OutputStream outputStream, int i6) throws IOException {
        outputStream.write(i6 & 255);
        outputStream.write((i6 >> 8) & 255);
        outputStream.write((i6 >> 16) & 255);
        outputStream.write((i6 >> 24) & 255);
    }

    private static void g(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static Bitmap b(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] h6 = h(decodeStream);
        if (NinePatch.isNinePatchChunk(h6)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            b3.B(decodeStream);
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(createBitmap, h6);
                return createBitmap;
            }
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, h6);
            return createBitmap;
        }
        return decodeStream;
    }

    public static Drawable c(Context context, String str) throws Exception {
        Bitmap i6 = i(context, str);
        if (i6.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), i6);
        }
        Rect rect = new Rect();
        g(i6.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), i6, i6.getNinePatchChunk(), rect, null);
    }

    private static byte[] h(Bitmap bitmap) throws IOException {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i6 = 0; i6 < 32; i6++) {
            byteArrayOutputStream.write(0);
        }
        int i7 = width - 2;
        int[] iArr = new int[i7];
        bitmap.getPixels(iArr, 0, width, 1, 0, i7, 1);
        if (iArr[0] == -16777216) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (iArr[width - 3] == -16777216) {
            z6 = true;
        } else {
            z6 = false;
        }
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            if (i8 != iArr[i10]) {
                i9++;
                e(byteArrayOutputStream, i10);
                i8 = iArr[i10];
            }
        }
        if (z6) {
            i9++;
            e(byteArrayOutputStream, i7);
        }
        int i11 = i9;
        int i12 = i11 + 1;
        if (z5) {
            i12 = i11;
        }
        if (z6) {
            i12--;
        }
        int i13 = height - 2;
        int[] iArr2 = new int[i13];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i13);
        if (iArr2[0] == -16777216) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (iArr2[height - 3] == -16777216) {
            z8 = true;
        } else {
            z8 = false;
        }
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < i13; i16++) {
            if (i14 != iArr2[i16]) {
                i15++;
                e(byteArrayOutputStream, i16);
                i14 = iArr2[i16];
            }
        }
        if (z8) {
            i15++;
            e(byteArrayOutputStream, i13);
        }
        int i17 = i15 + 1;
        if (z7) {
            i17 = i15;
        }
        if (z8) {
            i17--;
        }
        int i18 = 0;
        while (true) {
            int i19 = i12 * i17;
            if (i18 < i19) {
                e(byteArrayOutputStream, 1);
                i18++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i11;
                byteArray[2] = (byte) i15;
                byteArray[3] = (byte) i19;
                d(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static Bitmap i(Context context, String str) throws Exception {
        InputStream open = v2.b(context).open(str);
        Bitmap b6 = b(open);
        open.close();
        return b6;
    }
}
