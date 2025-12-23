package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16896a = "/MyPhoto";

    /* renamed from: b, reason: collision with root package name */
    public static final String f16897b = "yyyyMMddHHmmss";

    /* renamed from: c, reason: collision with root package name */
    public static final String f16898c = ".png";

    public static int e(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0041 A[Catch: Exception -> 0x003d, TRY_LEAVE, TryCatch #1 {Exception -> 0x003d, blocks: (B:39:0x0039, B:32:0x0041), top: B:38:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r4, android.graphics.Bitmap r5) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r3 = 100
            r5.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r1.close()     // Catch: java.lang.Exception -> L14
            r5.recycle()     // Catch: java.lang.Exception -> L14
            return r4
        L14:
            r5 = move-exception
            r5.printStackTrace()
            return r4
        L19:
            r4 = move-exception
            r0 = r1
            goto L37
        L1c:
            r4 = move-exception
            goto L22
        L1e:
            r4 = move-exception
            goto L37
        L20:
            r4 = move-exception
            r1 = r0
        L22:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.lang.Exception -> L2b
            goto L2d
        L2b:
            r4 = move-exception
            goto L33
        L2d:
            if (r5 == 0) goto L36
            r5.recycle()     // Catch: java.lang.Exception -> L2b
            goto L36
        L33:
            r4.printStackTrace()
        L36:
            return r0
        L37:
            if (r0 == 0) goto L3f
            r0.close()     // Catch: java.lang.Exception -> L3d
            goto L3f
        L3d:
            r5 = move-exception
            goto L45
        L3f:
            if (r5 == 0) goto L48
            r5.recycle()     // Catch: java.lang.Exception -> L3d
            goto L48
        L45:
            r5.printStackTrace()
        L48:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.g0.g(java.lang.String, android.graphics.Bitmap):java.lang.String");
    }

    public static Bitmap b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 10;
        return BitmapFactory.decodeFile(str, options);
    }

    public static String d(Context context) {
        File file = new File(c(context) + f16896a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file + ("/" + new SimpleDateFormat(f16897b, Locale.getDefault()).format(new Date(System.currentTimeMillis())) + f16898c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap f(int r7, android.graphics.Bitmap r8) {
        /*
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            float r7 = (float) r7
            r5.postRotate(r7)
            int r3 = r8.getWidth()     // Catch: java.lang.OutOfMemoryError -> L1a
            int r4 = r8.getHeight()     // Catch: java.lang.OutOfMemoryError -> L1a
            r6 = 1
            r1 = 0
            r2 = 0
            r0 = r8
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.OutOfMemoryError -> L1b
            goto L1c
        L1a:
            r0 = r8
        L1b:
            r7 = 0
        L1c:
            if (r7 != 0) goto L1f
            r7 = r0
        L1f:
            if (r0 == r7) goto L24
            r0.recycle()
        L24:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.g0.f(int, android.graphics.Bitmap):android.graphics.Bitmap");
    }

    private g0() {
    }

    public static String a(String str, Context context) {
        return h(f(e(str), b(str)), context);
    }

    private static String c(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted") && Environment.isExternalStorageRemovable()) {
            return context.getCacheDir().getPath();
        }
        return context.getExternalCacheDir().getPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0045 A[Catch: Exception -> 0x0041, TRY_LEAVE, TryCatch #6 {Exception -> 0x0041, blocks: (B:39:0x003d, B:32:0x0045), top: B:38:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h(android.graphics.Bitmap r4, android.content.Context r5) {
        /*
            java.lang.String r5 = d(r5)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            r1.close()     // Catch: java.lang.Exception -> L18
            r4.recycle()     // Catch: java.lang.Exception -> L18
            return r5
        L18:
            r4 = move-exception
            r4.printStackTrace()
            return r5
        L1d:
            r5 = move-exception
            r0 = r1
            goto L3b
        L20:
            r5 = move-exception
            goto L26
        L22:
            r5 = move-exception
            goto L3b
        L24:
            r5 = move-exception
            r1 = r0
        L26:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.lang.Exception -> L2f
            goto L31
        L2f:
            r4 = move-exception
            goto L37
        L31:
            if (r4 == 0) goto L3a
            r4.recycle()     // Catch: java.lang.Exception -> L2f
            goto L3a
        L37:
            r4.printStackTrace()
        L3a:
            return r0
        L3b:
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.lang.Exception -> L41
            goto L43
        L41:
            r4 = move-exception
            goto L49
        L43:
            if (r4 == 0) goto L4c
            r4.recycle()     // Catch: java.lang.Exception -> L41
            goto L4c
        L49:
            r4.printStackTrace()
        L4c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.g0.h(android.graphics.Bitmap, android.content.Context):java.lang.String");
    }
}
