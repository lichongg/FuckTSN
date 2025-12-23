package com.bytedance.sdk.openadsdk.jy.xt;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.utils.vl;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f31550j = {71, 73, 70, 56, 55, 97};
    private static final byte[] xt = {71, 73, 70, 56, 57, 97};
    private static final byte[] cw = {-1, -40, -1};

    /* renamed from: r, reason: collision with root package name */
    private static final byte[] f31551r = {-119, 80, 78, 71, 13, 10, 26, 10};

    public static byte[] j(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return j(new FileInputStream(file));
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static void xt(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (listFiles[i6].isDirectory()) {
                    xt(listFiles[i6].getAbsolutePath());
                } else {
                    listFiles[i6].delete();
                }
            }
            file.delete();
        }
    }

    public static boolean j(InputStream inputStream, String str, String str2, long j6) {
        File file;
        File file2;
        FileOutputStream fileOutputStream;
        if (inputStream == null) {
            return false;
        }
        long j7 = j6 != -2147483648L ? j6 * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : 1099511627776L;
        FileOutputStream fileOutputStream2 = null;
        long j8 = 0;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                    vl.j(e6);
                }
                return false;
            }
            file2 = new File(file3, str2);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                file = file2;
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j8 += read;
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                try {
                    inputStream.close();
                    if (j6 == -2147483648L || j8 <= j7) {
                        return true;
                    }
                    file2.delete();
                    return false;
                } catch (Exception e7) {
                    vl.j(e7);
                    return true;
                }
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                        vl.j(e8);
                    }
                }
                try {
                    inputStream.close();
                    if (j6 != -2147483648L && j8 > j7 && file2 != null) {
                        file2.delete();
                        return false;
                    }
                } catch (Exception e9) {
                    vl.j(e9);
                }
                return false;
            } catch (Throwable th2) {
                file = file2;
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e10) {
                        vl.j(e10);
                    }
                }
                try {
                    inputStream.close();
                    if (j6 == -2147483648L) {
                        throw th;
                    }
                    if (j8 <= j7) {
                        throw th;
                    }
                    if (file != null) {
                        file.delete();
                        return false;
                    }
                    throw th;
                } catch (Exception e11) {
                    vl.j(e11);
                    throw th;
                }
            }
        } catch (Exception unused3) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
    }

    public static byte[] j(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                j(bufferedInputStream, byteArrayOutputStream, 2048);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e6) {
                vl.j(e6);
                try {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return new byte[0];
            }
        } finally {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
        }
    }

    private static long j(InputStream inputStream, OutputStream outputStream, int i6) throws IOException {
        byte[] bArr = new byte[i6];
        int read = inputStream.read(bArr);
        long j6 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j6 += read;
            read = inputStream.read(bArr);
        }
        return j6;
    }
}
