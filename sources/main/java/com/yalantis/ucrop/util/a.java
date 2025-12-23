package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42783a = "BitmapLoadUtils";

    public static int f(int i6) {
        return (i6 == 2 || i6 == 7 || i6 == 4 || i6 == 5) ? -1 : 1;
    }

    public static int g(@NonNull Context context, @NonNull Uri uri) {
        int i6 = 0;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            i6 = new f(openInputStream).c();
            c(openInputStream);
            return i6;
        } catch (IOException unused) {
            uri.toString();
            return i6;
        }
    }

    public static int a(@NonNull BitmapFactory.Options options, int i6, int i7) {
        int i8 = options.outHeight;
        int i9 = options.outWidth;
        int i10 = 1;
        if (i8 <= i7 && i9 <= i6) {
            return 1;
        }
        while (true) {
            if (i8 / i10 <= i7 && i9 / i10 <= i6) {
                return i10;
            }
            i10 *= 2;
        }
    }

    public static int b(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int c6 = c.c();
        return c6 > 0 ? Math.min(sqrt, c6) : sqrt;
    }

    public static void c(@Nullable Closeable closeable) {
        if (closeable == null || !(closeable instanceof Closeable)) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void d(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i6, int i7, f3.b bVar) {
        new com.yalantis.ucrop.task.b(context, uri, uri2, i6, i7, bVar).execute(new Void[0]);
    }

    public static int e(int i6) {
        switch (i6) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap h(@NonNull Bitmap bitmap, @NonNull Matrix matrix) {
        try {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap.sameAs(createBitmap)) {
                    return bitmap;
                }
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                return bitmap;
            }
        } catch (OutOfMemoryError unused2) {
            return bitmap;
        }
    }
}
