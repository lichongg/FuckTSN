package org.apache.commons.net.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50861a = 1024;

    public static final long h(InputStream inputStream, OutputStream outputStream, int i6, long j6, c cVar) throws CopyStreamException {
        return i(inputStream, outputStream, i6, j6, cVar, true);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void b(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final long c(Reader reader, Writer writer) throws CopyStreamException {
        return d(reader, writer, 1024);
    }

    public static final long d(Reader reader, Writer writer, int i6) throws CopyStreamException {
        return e(reader, writer, i6, -1L, null);
    }

    public static final long e(Reader reader, Writer writer, int i6, long j6, c cVar) throws CopyStreamException {
        IOException iOException;
        long j7;
        if (i6 <= 0) {
            i6 = 1024;
        }
        char[] cArr = new char[i6];
        long j8 = 0;
        while (true) {
            try {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                if (read == 0) {
                    int read2 = reader.read();
                    if (read2 < 0) {
                        break;
                    }
                    writer.write(read2);
                    writer.flush();
                    long j9 = j8 + 1;
                    if (cVar != null) {
                        try {
                            cVar.c(j9, 1, j6);
                        } catch (IOException e6) {
                            iOException = e6;
                            j8 = j9;
                            throw new CopyStreamException("IOException caught while copying.", j8, iOException);
                        }
                    }
                    j8 = j9;
                } else {
                    writer.write(cArr, 0, read);
                    writer.flush();
                    long j10 = j8 + read;
                    if (cVar != null) {
                        j7 = j10;
                        try {
                            cVar.c(j7, read, j6);
                        } catch (IOException e7) {
                            iOException = e7;
                            j8 = j7;
                            throw new CopyStreamException("IOException caught while copying.", j8, iOException);
                        }
                    } else {
                        j7 = j10;
                    }
                    j8 = j7;
                }
            } catch (IOException e8) {
                iOException = e8;
            }
        }
        return j8;
    }

    public static final long f(InputStream inputStream, OutputStream outputStream) throws CopyStreamException {
        return g(inputStream, outputStream, 1024);
    }

    public static final long g(InputStream inputStream, OutputStream outputStream, int i6) throws CopyStreamException {
        return h(inputStream, outputStream, i6, -1L, null);
    }

    public static final long i(InputStream inputStream, OutputStream outputStream, int i6, long j6, c cVar, boolean z5) throws CopyStreamException {
        IOException iOException;
        long j7;
        if (i6 <= 0) {
            i6 = 1024;
        }
        byte[] bArr = new byte[i6];
        long j8 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                if (read == 0) {
                    int read2 = inputStream.read();
                    if (read2 < 0) {
                        break;
                    }
                    outputStream.write(read2);
                    if (z5) {
                        outputStream.flush();
                    }
                    long j9 = j8 + 1;
                    if (cVar != null) {
                        try {
                            cVar.c(j9, 1, j6);
                        } catch (IOException e6) {
                            iOException = e6;
                            j8 = j9;
                            throw new CopyStreamException("IOException caught while copying.", j8, iOException);
                        }
                    }
                    j8 = j9;
                } else {
                    outputStream.write(bArr, 0, read);
                    if (z5) {
                        outputStream.flush();
                    }
                    long j10 = j8 + read;
                    if (cVar != null) {
                        j7 = j10;
                        try {
                            cVar.c(j7, read, j6);
                        } catch (IOException e7) {
                            iOException = e7;
                            j8 = j7;
                            throw new CopyStreamException("IOException caught while copying.", j8, iOException);
                        }
                    } else {
                        j7 = j10;
                    }
                    j8 = j7;
                }
            } catch (IOException e8) {
                iOException = e8;
            }
        }
        return j8;
    }

    private l() {
    }
}
