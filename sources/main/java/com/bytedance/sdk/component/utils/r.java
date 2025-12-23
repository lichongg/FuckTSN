package com.bytedance.sdk.component.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L28
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L26
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L26
            r1.flush()     // Catch: java.lang.Throwable -> L26
            r1.close()     // Catch: java.lang.Throwable -> L26
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Throwable -> L26
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch: java.lang.Throwable -> L26
        L1f:
            r1.flush()     // Catch: java.lang.Throwable -> L2d
            r1.close()     // Catch: java.lang.Throwable -> L2d
            goto L2d
        L26:
            goto L2a
        L28:
            r1 = r0
        L2a:
            if (r1 == 0) goto L2d
            goto L1f
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.r.j(android.graphics.Bitmap):java.lang.String");
    }

    public static byte[] xt(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
            return null;
        }
    }
}
