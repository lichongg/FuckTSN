package com.huawei.hms.framework.common;

import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class IoUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f33309a = 4096;

    /* renamed from: b, reason: collision with root package name */
    private static final int f33310b = 16777216;

    public static void closeSecure(Reader reader) {
        closeSecure((Closeable) reader);
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(Writer writer) {
        closeSecure((Closeable) writer);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private IoUtils() {
    }

    public static void closeSecure(InputStream inputStream) {
        closeSecure((Closeable) inputStream);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        String str;
        if (ContextHolder.getAppContext() != null) {
            str = ContextHolder.getAppContext().getPackageName();
        } else {
            str = "";
        }
        byte[] bArr = new byte[4096];
        long j6 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                if (j6 > 16777216 && !"com.huawei.health".equals(str)) {
                    throw new IOException("input data too large for byte.");
                }
                outputStream.write(bArr, 0, read);
                j6 += read;
            } else {
                return j6;
            }
        }
    }

    public static void closeSecure(OutputStream outputStream) {
        closeSecure((Closeable) outputStream);
    }

    public static void closeSecure(Closeable closeable) {
        if (closeable == null) {
            Logger.w("IOUtil", "closeable is null");
            return;
        }
        try {
            closeable.close();
        } catch (IOException e6) {
            Logger.w("IOUtil", "closeSecure IOException", e6);
        }
    }
}
