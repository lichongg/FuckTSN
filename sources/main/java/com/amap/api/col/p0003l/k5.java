package com.amap.api.col.p0003l;

import android.content.Context;
import java.io.Closeable;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k5 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6688a = q4.u("SYmFja3Vwcw");

    /* renamed from: b, reason: collision with root package name */
    public static final String f6689b = q4.u("SLmFkaXU");

    /* renamed from: c, reason: collision with root package name */
    public static final String f6690c = q4.u("JIw");

    /* JADX WARN: Can't wrap try/catch for region: R(16:17|18|(14:20|(1:22)|23|25|26|27|28|(1:30)|(2:40|41)|33|34|35|36|37)|60|23|25|26|27|28|(0)|(0)|33|34|35|36|37) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:17|18|(10:(14:20|(1:22)|23|25|26|27|28|(1:30)|(2:40|41)|33|34|35|36|37)|27|28|(0)|(0)|33|34|35|36|37)|60|23|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #4 {all -> 0x0099, blocks: (B:28:0x0076, B:30:0x007c), top: B:27:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<com.amap.api.col.3l.k5> r0 = com.amap.api.col.p0003l.k5.class
            monitor-enter(r0)
            if (r3 == 0) goto Lb3
            java.lang.String r1 = "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="
            java.lang.String r1 = com.amap.api.col.p0003l.q4.u(r1)     // Catch: java.lang.Throwable -> L8f
            int r1 = r3.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L13
            goto Lb3
        L13:
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L1f
            monitor-exit(r0)
            return
        L1f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r1.<init>()     // Catch: java.lang.Throwable -> L8f
            r1.append(r4)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r4 = com.amap.api.col.p0003l.k5.f6690c     // Catch: java.lang.Throwable -> L8f
            r1.append(r4)     // Catch: java.lang.Throwable -> L8f
            r1.append(r5)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L8f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r5.<init>()     // Catch: java.lang.Throwable -> L8f
            r5.append(r3)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L8f
            r5.append(r3)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = com.amap.api.col.p0003l.k5.f6688a     // Catch: java.lang.Throwable -> L8f
            r5.append(r3)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L8f
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L8f
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L8f
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = com.amap.api.col.p0003l.k5.f6689b     // Catch: java.lang.Throwable -> L8f
            r3.<init>(r5, r1)     // Catch: java.lang.Throwable -> L8f
            r1 = 0
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L65
            boolean r2 = r5.isDirectory()     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L68
            goto L65
        L63:
            goto L9e
        L65:
            r5.mkdirs()     // Catch: java.lang.Throwable -> L63
        L68:
            r3.createNewFile()     // Catch: java.lang.Throwable -> L63
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = "rws"
            r5.<init>(r3, r2)     // Catch: java.lang.Throwable -> L63
            java.nio.channels.FileChannel r3 = r5.getChannel()     // Catch: java.lang.Throwable -> L9b
            java.nio.channels.FileLock r1 = r3.tryLock()     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L89
            java.lang.String r2 = "UTF-8"
            byte[] r4 = r4.getBytes(r2)     // Catch: java.lang.Throwable -> L99
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch: java.lang.Throwable -> L99
            r3.write(r4)     // Catch: java.lang.Throwable -> L99
        L89:
            if (r1 == 0) goto L91
            r1.release()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            goto L91
        L8f:
            r3 = move-exception
            goto Lb1
        L91:
            r3.close()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L94
        L94:
            c(r5)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return
        L99:
            goto La0
        L9b:
            r3 = r1
            goto La0
        L9e:
            r3 = r1
            r5 = r3
        La0:
            if (r1 == 0) goto La7
            r1.release()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> La6
            goto La7
        La6:
        La7:
            if (r3 == 0) goto Lac
            r3.close()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> Lac
        Lac:
            c(r5)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return
        Lb1:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r3
        Lb3:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.k5.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
