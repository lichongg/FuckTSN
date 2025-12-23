package xyz.adscope.common.v2.encrypt.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class GzipUtil implements IBaseEncrypt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.encrypt.impl.GzipUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static GzipUtil instance = new GzipUtil(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ GzipUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable, java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static byte[] compress(byte[] bArr) {
        ?? r22;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                r22 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    r22.write(bArr);
                    r22.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    closeStream(r22);
                    closeStream(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException e6) {
                    e = e6;
                    try {
                        SDKLog.stack(e);
                        closeStream(r22);
                        closeStream(byteArrayOutputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        r22 = r22;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        byteArrayOutputStream2 = r22;
                        closeStream(byteArrayOutputStream2);
                        closeStream(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = r22;
                    closeStream(byteArrayOutputStream2);
                    closeStream(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                r22 = 0;
            } catch (Throwable th3) {
                th = th3;
                closeStream(byteArrayOutputStream2);
                closeStream(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
            r22 = 0;
        } catch (Throwable th4) {
            th = th4;
            r22 = 0;
            byteArrayOutputStream = byteArrayOutputStream2;
            byteArrayOutputStream2 = r22;
            closeStream(byteArrayOutputStream2);
            closeStream(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.ByteArrayInputStream, java.io.Closeable, java.io.InputStream] */
    public static byte[] uncompress(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6 = null;
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ?? byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int read = gZIPInputStream2.read(bArr2);
                            if (read < 0) {
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                closeStream(gZIPInputStream2);
                                closeStream(byteArrayInputStream);
                                closeStream(byteArrayOutputStream2);
                                return byteArray;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                    } catch (IOException e6) {
                        e = e6;
                        byteArrayOutputStream3 = byteArrayInputStream;
                        try {
                            SDKLog.stack(e);
                            closeStream(gZIPInputStream2);
                            closeStream(byteArrayOutputStream3);
                            closeStream(byteArrayOutputStream2);
                            return null;
                        } catch (Throwable th2) {
                            ByteArrayOutputStream byteArrayOutputStream7 = byteArrayOutputStream2;
                            gZIPInputStream = gZIPInputStream2;
                            th = th2;
                            byteArrayOutputStream6 = byteArrayOutputStream7;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            GZIPInputStream gZIPInputStream3 = gZIPInputStream;
                            th = th;
                            gZIPInputStream2 = gZIPInputStream3;
                            ByteArrayOutputStream byteArrayOutputStream8 = byteArrayOutputStream;
                            byteArrayOutputStream4 = byteArrayOutputStream6;
                            byteArrayOutputStream6 = byteArrayOutputStream8;
                            closeStream(gZIPInputStream2);
                            closeStream(byteArrayOutputStream6);
                            closeStream(byteArrayOutputStream4);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        byteArrayOutputStream5 = byteArrayOutputStream2;
                        th = th3;
                        byteArrayOutputStream6 = byteArrayInputStream;
                        byteArrayOutputStream4 = byteArrayOutputStream5;
                        closeStream(gZIPInputStream2);
                        closeStream(byteArrayOutputStream6);
                        closeStream(byteArrayOutputStream4);
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    gZIPInputStream2 = null;
                    byteArrayOutputStream3 = byteArrayInputStream;
                } catch (Throwable th4) {
                    byteArrayOutputStream5 = byteArrayOutputStream2;
                    th = th4;
                    gZIPInputStream2 = null;
                }
            } catch (IOException e8) {
                e = e8;
                gZIPInputStream2 = null;
                byteArrayOutputStream3 = null;
            } catch (Throwable th5) {
                byteArrayOutputStream4 = byteArrayOutputStream2;
                th = th5;
                gZIPInputStream2 = null;
            }
        } catch (IOException e9) {
            e = e9;
            gZIPInputStream2 = null;
            byteArrayOutputStream2 = null;
            byteArrayOutputStream3 = null;
        } catch (Throwable th6) {
            th = th6;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
            GZIPInputStream gZIPInputStream32 = gZIPInputStream;
            th = th;
            gZIPInputStream2 = gZIPInputStream32;
            ByteArrayOutputStream byteArrayOutputStream82 = byteArrayOutputStream;
            byteArrayOutputStream4 = byteArrayOutputStream6;
            byteArrayOutputStream6 = byteArrayOutputStream82;
            closeStream(gZIPInputStream2);
            closeStream(byteArrayOutputStream6);
            closeStream(byteArrayOutputStream4);
            throw th;
        }
    }

    private GzipUtil() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                SDKLog.stack(e6);
            }
        }
    }

    static GzipUtil getInstance() {
        return InstanceHolder.instance;
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] decode(byte[] bArr) {
        try {
            return uncompress(bArr);
        } catch (IOException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] encode(byte[] bArr) {
        try {
            return compress(bArr);
        } catch (IOException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }
}
