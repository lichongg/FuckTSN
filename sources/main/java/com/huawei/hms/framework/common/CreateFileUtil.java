package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class CreateFileUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33277a = "CreateFileUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33278b = "com.huawei.libcore.io.ExternalStorageFile";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33279c = "com.huawei.libcore.io.ExternalStorageFileInputStream";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33280d = "com.huawei.libcore.io.ExternalStorageFileOutputStream";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33281e = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f33282f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f33282f;
            cArr[i6] = cArr2[(b6 >>> 4) & 15];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Logger.w(f33277a, "deleteSecure exception");
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e6) {
            Logger.w(f33277a, "the canonicalPath has IOException", e6);
            return str;
        } catch (SecurityException e7) {
            Logger.w(f33277a, "the canonicalPath has securityException", e7);
            return str;
        } catch (Exception e8) {
            Logger.w(f33277a, "the canonicalPath has other Exception", e8);
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
    
        if (r10 == null) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "CreateFileUtil"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch: java.lang.Throwable -> L44 java.lang.IndexOutOfBoundsException -> L46 java.lang.IllegalArgumentException -> L49 java.io.IOException -> L4c java.io.FileNotFoundException -> L4f java.security.NoSuchAlgorithmException -> L52
            java.io.FileInputStream r10 = newSafeFileInputStream(r10)     // Catch: java.lang.Throwable -> L44 java.lang.IndexOutOfBoundsException -> L46 java.lang.IllegalArgumentException -> L49 java.io.IOException -> L4c java.io.FileNotFoundException -> L4f java.security.NoSuchAlgorithmException -> L52
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            r4 = 0
            r6 = r4
        L14:
            int r8 = r10.read(r3)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            r9 = -1
            if (r8 == r9) goto L30
            r9 = 0
            r11.update(r3, r9, r8)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            long r6 = r6 + r8
            goto L14
        L22:
            r11 = move-exception
            r2 = r10
            goto L7e
        L26:
            r11 = move-exception
            goto L55
        L28:
            r11 = move-exception
            goto L5d
        L2a:
            r11 = move-exception
            goto L65
        L2c:
            r11 = move-exception
            goto L6d
        L2e:
            r11 = move-exception
            goto L75
        L30:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L3c
            byte[] r11 = r11.digest()     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            java.lang.String r2 = byteArrayToHex(r11)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
        L3c:
            r10.close()     // Catch: java.io.IOException -> L40
            goto L7d
        L40:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
            goto L7d
        L44:
            r11 = move-exception
            goto L7e
        L46:
            r11 = move-exception
            r10 = r2
            goto L55
        L49:
            r11 = move-exception
            r10 = r2
            goto L5d
        L4c:
            r11 = move-exception
            r10 = r2
            goto L65
        L4f:
            r11 = move-exception
            r10 = r2
            goto L6d
        L52:
            r11 = move-exception
            r10 = r2
            goto L75
        L55:
            java.lang.String r3 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7d
            goto L3c
        L5d:
            java.lang.String r3 = "getFileHashData IllegalArgumentException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7d
            goto L3c
        L65:
            java.lang.String r3 = "getFileHashData IOException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7d
            goto L3c
        L6d:
            java.lang.String r3 = "getFileHashData FileNotFoundException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7d
            goto L3c
        L75:
            java.lang.String r3 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7d
            goto L3c
        L7d:
            return r2
        L7e:
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.io.IOException -> L84
            goto L87
        L84:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
        L87:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.CreateFileUtil.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(f33278b)) ? new ExternalStorageFile(str) : new File(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(f33279c)) ? new ExternalStorageFileInputStream(str) : new FileInputStream(str);
        }
        Logger.w(f33277a, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(f33280d)) ? new ExternalStorageFileOutputStream(file) : new FileOutputStream(file);
        }
        Logger.e(f33277a, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(f33281e)) ? new ExternalStorageRandomAccessFile(str, str2) : new RandomAccessFile(str, str2);
        }
        Logger.w(f33277a, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File newFile = newFile(str);
            return !newFile.exists() ? new File(str) : newFile;
        } catch (RuntimeException unused) {
            Logger.w(f33277a, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(f33277a, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(f33277a, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(f33277a, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(f33277a, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(f33277a, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(f33277a, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(f33277a, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(f33277a, "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
        try {
            return newRandomAccessFile(str, str2);
        } catch (FileNotFoundException unused) {
            Logger.w(f33277a, "newRandomAccessFile is fileNotFoundException");
            return new RandomAccessFile(str, str2);
        } catch (RuntimeException unused2) {
            Logger.w(f33277a, "newRandomAccessFile is runtimeException");
            return new RandomAccessFile(str, str2);
        } catch (Throwable unused3) {
            Logger.w(f33277a, "newRandomAccessFile is Throwable");
            return new RandomAccessFile(str, str2);
        }
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }
}
