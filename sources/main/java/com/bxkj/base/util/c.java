package com.bxkj.base.util;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0022: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:35), block:B:43:0x0022 */
    public static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (IOException e6) {
                    e = e6;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return null;
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return null;
                    }
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return encodeToString;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }
}
