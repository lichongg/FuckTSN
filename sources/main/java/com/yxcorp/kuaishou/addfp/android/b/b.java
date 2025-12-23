package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static File a(Context context, boolean z5) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", null);
            Method method2 = cls.getMethod("getPath", null);
            Method method3 = cls.getMethod("isRemovable", null);
            Object invoke = method.invoke(storageManager, null);
            int length = Array.getLength(invoke);
            for (int i6 = 0; i6 < length; i6++) {
                Object obj = Array.get(invoke, i6);
                String str = (String) method2.invoke(obj, null);
                if (z5 == ((Boolean) method3.invoke(obj, null)).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a6 = a(bArr, bArr2);
                    if (a6 == null) {
                        return a6;
                    }
                    int length = a6.length;
                    return a6;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a6 = a(bArr, bArr2);
                    if (a6 == null) {
                        return a6;
                    }
                    int length = a6.length;
                    return a6;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i6 = 0; i6 < 256; i6++) {
            bArr3[i6] = (byte) i6;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < 256; i9++) {
                int i10 = bArr2[i7] & 255;
                byte b6 = bArr3[i9];
                i8 = (i10 + (b6 & 255) + i8) & 255;
                bArr3[i9] = bArr3[i8];
                bArr3[i8] = b6;
                i7 = (i7 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < bArr.length; i13++) {
            i11 = (i11 + 1) & 255;
            byte b7 = bArr3[i11];
            i12 = ((b7 & 255) + i12) & 255;
            bArr3[i11] = bArr3[i12];
            bArr3[i12] = b7;
            int i14 = ((bArr3[i11] & 255) + (b7 & 255)) & 255;
            byte b8 = (byte) (bArr3[i14] ^ bArr[i13]);
            bArr4[i13] = b8;
            bArr4[i13] = (byte) (b8 ^ 42);
        }
        return bArr4;
    }
}
