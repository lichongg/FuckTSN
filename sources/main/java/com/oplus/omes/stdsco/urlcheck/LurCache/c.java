package com.oplus.omes.stdsco.urlcheck.LurCache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f36454a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f36455b = Charset.forName("UTF-8");

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    static String c(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    String stringWriter2 = stringWriter.toString();
                    reader.close();
                    return stringWriter2;
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (Throwable th) {
            reader.close();
            throw th;
        }
    }

    private c() {
    }

    static void b(File dir) throws IOException {
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    b(file);
                }
                if (!file.delete()) {
                    throw new IOException("failed to delete file: " + file);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + dir);
    }
}
