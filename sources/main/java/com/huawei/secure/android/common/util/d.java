package com.huawei.secure.android.common.util;

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
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35265a = "IOUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f35266b = 4096;

    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long g(InputStream inputStream, OutputStream outputStream) throws IOException {
        return h(inputStream, outputStream, new byte[4096]);
    }

    public static long h(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
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

    public static void i(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    public static byte[] k(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream l(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    public static void c(InputStream inputStream) {
        b(inputStream);
    }

    public static void d(OutputStream outputStream) {
        b(outputStream);
    }

    public static void e(Reader reader) {
        b(reader);
    }

    public static void f(Writer writer) {
        b(writer);
    }

    public static void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            i(new File(str));
        }
    }
}
