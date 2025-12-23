package xyz.adscope.common.network.util;

import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IOUtils {
    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) {
        BufferedInputStream bufferedInputStream = toBufferedInputStream(inputStream);
        BufferedInputStream bufferedInputStream2 = toBufferedInputStream(inputStream2);
        for (int read = bufferedInputStream.read(); -1 != read; read = bufferedInputStream.read()) {
            if (read != bufferedInputStream2.read()) {
                return false;
            }
        }
        return bufferedInputStream2.read() == -1;
    }

    public static boolean createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFolder(new File(str));
    }

    public static boolean createNewFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createNewFile(new File(str));
    }

    public static boolean createNewFolder(String str) {
        return delFileOrFolder(str) && createFolder(str);
    }

    public static boolean delFileOrFolder(String str) {
        return delFileOrFolder(new File(str));
    }

    public static List<String> readLines(InputStream inputStream, String str) {
        return readLines(inputStream, Charset.forName(str));
    }

    public static byte[] toByteArray(CharSequence charSequence) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes();
    }

    public static char[] toCharArray(CharSequence charSequence) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(charArrayWriter, charSequence);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return new ByteArrayInputStream(charSequence.toString().getBytes());
    }

    public static String toString(InputStream inputStream) {
        return new String(toByteArray(inputStream));
    }

    public static void write(OutputStream outputStream, byte[] bArr) {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }

    public static boolean canRead(String str) {
        return new File(str).canRead();
    }

    public static boolean canWrite(String str) {
        return new File(str).canWrite();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean createNewFolder(File file) {
        return delFileOrFolder(file) && createFolder(file);
    }

    public static boolean delFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                delFileOrFolder(file2);
            }
        }
        file.delete();
        return true;
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception unused) {
            }
        }
    }

    public static long getDirSize(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) {
        return readLines(new InputStreamReader(inputStream, charset));
    }

    public static BufferedInputStream toBufferedInputStream(InputStream inputStream) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream toBufferedOutputStream(OutputStream outputStream) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedWriter toBufferedWriter(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charset.forName(str));
    }

    public static String toString(InputStream inputStream, String str) {
        return new String(toByteArray(inputStream), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        if (r0.equals(r1) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean contentEqualsIgnoreEOL(java.io.Reader r3, java.io.Reader r4) {
        /*
            java.io.BufferedReader r3 = toBufferedReader(r3)
            java.io.BufferedReader r4 = toBufferedReader(r4)
            java.lang.String r0 = r3.readLine()
            java.lang.String r1 = r4.readLine()
        L10:
            if (r0 == 0) goto L23
            if (r1 == 0) goto L23
            boolean r2 = r0.equals(r1)
            if (r2 == 0) goto L23
            java.lang.String r0 = r3.readLine()
            java.lang.String r1 = r4.readLine()
            goto L10
        L23:
            if (r0 == 0) goto L2f
            if (r1 == 0) goto L2d
            boolean r3 = r0.equals(r1)
            if (r3 == 0) goto L2f
        L2d:
            r3 = 1
            return r3
        L2f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.network.util.IOUtils.contentEqualsIgnoreEOL(java.io.Reader, java.io.Reader):boolean");
    }

    public static byte[] toByteArray(CharSequence charSequence, String str) {
        return toByteArray(charSequence, Charset.forName(str));
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return new ByteArrayInputStream(charSequence.toString().getBytes(charset));
    }

    public static String toString(InputStream inputStream, Charset charset) {
        return new String(toByteArray(inputStream), charset);
    }

    public static void write(Writer writer, byte[] bArr) {
        if (bArr != null) {
            writer.write(new String(bArr));
            writer.flush();
        }
    }

    public static boolean createFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createFolder(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean createNewFile(File file) {
        if (file.exists()) {
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static List<String> readLines(InputStream inputStream) {
        return readLines(new InputStreamReader(inputStream));
    }

    public static byte[] toByteArray(CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            return new byte[0];
        }
        return charSequence.toString().getBytes(charset);
    }

    public static char[] toCharArray(InputStream inputStream) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static String toString(Reader reader) {
        return new String(toByteArray(reader));
    }

    public static String toString(Reader reader, String str) {
        return new String(toByteArray(reader), str);
    }

    public static void write(Writer writer, byte[] bArr, String str) {
        write(writer, bArr, Charset.forName(str));
    }

    public static List<String> readLines(Reader reader) {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(Reader reader, Charset charset) {
        return new String(toByteArray(reader), charset);
    }

    public static void write(Writer writer, byte[] bArr, Charset charset) {
        if (bArr != null) {
            writer.write(new String(bArr, charset));
            writer.flush();
        }
    }

    public static boolean contentEquals(Reader reader, Reader reader2) {
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        for (int read = bufferedReader.read(); -1 != read; read = bufferedReader.read()) {
            if (read != bufferedReader2.read()) {
                return false;
            }
        }
        return bufferedReader2.read() == -1;
    }

    public static char[] toCharArray(InputStream inputStream, String str) {
        return toCharArray(inputStream, Charset.forName(str));
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static String toString(byte[] bArr, String str) {
        return toString(bArr, Charset.forName(str));
    }

    public static void write(Writer writer, char[] cArr) {
        if (cArr != null) {
            writer.write(cArr);
            writer.flush();
        }
    }

    public static String toString(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    public static byte[] toByteArray(InputStream inputStream, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i6);
        }
        int i7 = 0;
        if (i6 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i6];
        while (i7 < i6) {
            int read = inputStream.read(bArr, i7, i6 - i7);
            if (read == -1) {
                break;
            }
            i7 += read;
        }
        if (i7 == i6) {
            return bArr;
        }
        throw new IOException("Unexpected byte count size. current: " + i7 + ", excepted: " + i6);
    }

    public static void write(OutputStream outputStream, char[] cArr) {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
            outputStream.flush();
        }
    }

    public static char[] toCharArray(Reader reader) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static void write(OutputStream outputStream, char[] cArr, String str) {
        write(outputStream, cArr, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, char[] cArr, Charset charset) {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(charset));
            outputStream.flush();
        }
    }

    public static byte[] toByteArray(Reader reader) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void write(Writer writer, CharSequence charSequence) {
        if (charSequence != null) {
            writer.write(charSequence.toString());
            writer.flush();
        }
    }

    public static void write(OutputStream outputStream, CharSequence charSequence) {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes());
            outputStream.flush();
        }
    }

    public static byte[] toByteArray(Reader reader, String str) {
        return toByteArray(reader, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, String str) {
        write(outputStream, charSequence, Charset.forName(str));
    }

    public static byte[] toByteArray(Reader reader, Charset charset) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream, charset);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, Charset charset) {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(charset));
            outputStream.flush();
        }
    }

    public static void write(Reader reader, OutputStream outputStream) {
        write(reader, new OutputStreamWriter(outputStream));
    }

    public static void write(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            outputStream.flush();
        }
    }

    public static void write(InputStream inputStream, Writer writer) {
        write(new InputStreamReader(inputStream), writer);
    }

    public static void write(Reader reader, OutputStream outputStream, String str) {
        write(reader, outputStream, Charset.forName(str));
    }

    public static void write(Reader reader, OutputStream outputStream, Charset charset) {
        write(reader, new OutputStreamWriter(outputStream, charset));
    }

    public static void write(InputStream inputStream, OutputStream outputStream, String str) {
        write(inputStream, outputStream, Charset.forName(str));
    }

    public static void write(InputStream inputStream, OutputStream outputStream, Charset charset) {
        write(new InputStreamReader(inputStream, charset), outputStream);
    }

    public static void write(InputStream inputStream, Writer writer, String str) {
        write(inputStream, writer, Charset.forName(str));
    }

    public static void write(InputStream inputStream, Writer writer, Charset charset) {
        write(new InputStreamReader(inputStream, charset), writer);
    }

    public static void write(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
            writer.flush();
        }
    }
}
