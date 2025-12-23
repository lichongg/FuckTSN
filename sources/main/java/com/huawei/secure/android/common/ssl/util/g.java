package com.huawei.secure.android.common.ssl.util;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35238a = "IOUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f35239b = 4096;

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return b(inputStream, outputStream, new byte[4096]);
    }

    public static long b(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j6 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j6;
            }
            outputStream.write(bArr, 0, read);
            j6 += read;
        }
    }

    public static InputStream c(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    public static void d(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                h.d(f35238a, "closeSecure IOException");
            }
        }
    }

    public static void f(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        h.d(f35238a, "deleteSecure exception");
    }

    public static byte[] l(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void g(InputStream inputStream) {
        e(inputStream);
    }

    public static void h(OutputStream outputStream) {
        e(outputStream);
    }

    public static void i(Reader reader) {
        e(reader);
    }

    public static void j(Writer writer) {
        e(writer);
    }

    public static void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            f(new File(str));
        }
    }
}
