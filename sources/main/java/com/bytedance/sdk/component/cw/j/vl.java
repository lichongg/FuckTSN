package com.bytedance.sdk.component.cw.j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class vl {

    /* renamed from: j, reason: collision with root package name */
    static final Logger f26107j = Logger.getLogger(vl.class.getName());

    public static w cw(File file) throws FileNotFoundException {
        if (file != null) {
            return j(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static up j(mi miVar) {
        return new ws(miVar);
    }

    public static w xt(File file) throws FileNotFoundException {
        if (file != null) {
            return j(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static r j(w wVar) {
        return new jy(wVar);
    }

    private vl() {
    }

    private static j cw(final Socket socket) {
        return new j() { // from class: com.bytedance.sdk.component.cw.j.vl.4
            @Override // com.bytedance.sdk.component.cw.j.j
            protected void m_() {
                try {
                    socket.close();
                } catch (AssertionError e6) {
                    if (!vl.j(e6)) {
                        throw e6;
                    }
                    vl.f26107j.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e6);
                } catch (Exception e7) {
                    vl.f26107j.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e7);
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.j
            protected IOException xt(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }

    public static w j(OutputStream outputStream) {
        return j(outputStream, new kt());
    }

    public static mi xt(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                j cw = cw(socket);
                return cw.j(j(socket.getInputStream(), cw));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static w j(final OutputStream outputStream, final kt ktVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (ktVar != null) {
            return new w() { // from class: com.bytedance.sdk.component.cw.j.vl.1
                @Override // com.bytedance.sdk.component.cw.j.w
                public void a_(cw cwVar, long j6) throws IOException {
                    try {
                        tj.j(cwVar.xt, 0L, j6);
                        long j7 = j6;
                        while (j7 > 0) {
                            kt.this.ae();
                            az azVar = cwVar.f26087j;
                            int min = (int) Math.min(j7, azVar.cw - azVar.xt);
                            outputStream.write(azVar.f26084j, azVar.xt, min);
                            int i6 = azVar.xt + min;
                            azVar.xt = i6;
                            long j8 = min;
                            j7 -= j8;
                            cwVar.xt -= j8;
                            if (i6 == azVar.cw) {
                                cwVar.f26087j = azVar.xt();
                                av.j(azVar);
                            }
                        }
                    } catch (IOException | Exception unused) {
                    }
                }

                @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.bytedance.sdk.component.cw.j.w
                public kt j() {
                    return kt.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static w j(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                j cw = cw(socket);
                return cw.j(j(socket.getOutputStream(), cw));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static mi j(InputStream inputStream) {
        return j(inputStream, new kt());
    }

    private static mi j(final InputStream inputStream, final kt ktVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (ktVar != null) {
            return new mi() { // from class: com.bytedance.sdk.component.cw.j.vl.2
                @Override // com.bytedance.sdk.component.cw.j.mi
                public long j(cw cwVar, long j6) throws IOException {
                    if (j6 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
                    }
                    if (j6 == 0) {
                        return 0L;
                    }
                    try {
                        kt.this.ae();
                        az up = cwVar.up(1);
                        int read = inputStream.read(up.f26084j, up.cw, (int) Math.min(j6, 8192 - up.cw));
                        if (read == -1) {
                            return -1L;
                        }
                        up.cw += read;
                        long j7 = read;
                        cwVar.xt += j7;
                        return j7;
                    } catch (AssertionError e6) {
                        if (vl.j(e6)) {
                            throw new IOException(e6);
                        }
                        throw e6;
                    } catch (Throwable th) {
                        throw new IOException(th.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }

                @Override // com.bytedance.sdk.component.cw.j.mi
                public kt j() {
                    return kt.this;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static mi j(File file) throws FileNotFoundException {
        if (file != null) {
            return j(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static w j() {
        return new w() { // from class: com.bytedance.sdk.component.cw.j.vl.3
            @Override // com.bytedance.sdk.component.cw.j.w
            public kt j() {
                return kt.cw;
            }

            @Override // com.bytedance.sdk.component.cw.j.w
            public void a_(cw cwVar, long j6) throws IOException {
                cwVar.tl(j6);
            }

            @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    static boolean j(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
