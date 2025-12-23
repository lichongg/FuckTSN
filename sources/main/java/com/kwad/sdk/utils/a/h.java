package com.kwad.sdk.utils.a;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        static final SecureRandom bcO = new SecureRandom();
        static final char[] bcP = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    static void a(File file, byte[] bArr, int i6) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i7 = 0;
        while (i7 < i6) {
            try {
                int read = randomAccessFile.read(bArr, i7, i6 - i7);
                if (read < 0) {
                    break;
                } else {
                    i7 += read;
                }
            } finally {
                closeQuietly(randomAccessFile);
            }
        }
    }

    static int binarySearch(int[] iArr, int i6) {
        int length = (iArr.length >> 1) - 1;
        int i7 = 0;
        while (i7 <= length) {
            int i8 = (i7 + length) >>> 1;
            int i9 = iArr[i8 << 1];
            if (i9 < i6) {
                i7 = i8 + 1;
            } else {
                if (i9 <= i6) {
                    return i8;
                }
                length = i8 - 1;
            }
        }
        return length;
    }

    static String SL() {
        byte[] bArr = new byte[16];
        a.bcO.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i6 = 0; i6 < 16; i6++) {
            byte b6 = bArr[i6];
            int i7 = i6 << 1;
            char[] cArr2 = a.bcP;
            cArr[i7] = cArr2[(b6 >> 4) & 15];
            cArr[i7 + 1] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    static int SM() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), null)).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static boolean ae(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            if ((parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile()) {
                return true;
            }
            return false;
        }
        return false;
    }

    static byte[] af(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i6 = (int) length;
            byte[] bArr = new byte[i6];
            a(file, bArr, i6);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    private static void ag(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                ag(file2);
            }
        }
        file.delete();
    }

    static void h(File file) {
        try {
            if (file.exists()) {
                ag(file);
            }
        } catch (Exception unused) {
        }
    }

    static boolean a(File file, byte[] bArr) {
        File file2;
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception unused) {
        }
        if (!ae(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            closeQuietly(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th) {
            closeQuietly(randomAccessFile);
            throw th;
        }
    }
}
