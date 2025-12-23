package xyz.adscope.common.v2.tool.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IOUtils {
    private static final int DEFAULT_BYTE_BUFFER = 8192;
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String read(InputStream inputStream) {
        return read(inputStream, "UTF-8");
    }

    private static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void write(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            outputStream.flush();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception unused) {
            }
        }
    }

    public static String read(InputStream inputStream, String str) {
        return new String(toByteArray(inputStream), str);
    }

    private IOUtils() {
    }

    public static String read(Reader reader) {
        return read(reader, "UTF-8");
    }

    public static String read(Reader reader, String str) {
        return new String(toByteArray(reader), str);
    }

    private static byte[] toByteArray(Reader reader) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void write(Reader reader, OutputStream outputStream) {
        write(reader, new OutputStreamWriter(outputStream));
    }

    public static void write(Reader reader, Writer writer) {
        char[] cArr = new char[8192];
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
            writer.flush();
        }
    }

    public static void write(OutputStream outputStream, byte[] bArr) {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }

    public static void write(Writer writer, byte[] bArr) {
        write(writer, bArr, "UTF-8");
    }

    public static void write(Writer writer, byte[] bArr, String str) {
        write(writer, bArr, Charset.forName(str));
    }

    public static void write(Writer writer, byte[] bArr, Charset charset) {
        if (bArr != null) {
            writer.write(new String(bArr, charset));
            writer.flush();
        }
    }
}
