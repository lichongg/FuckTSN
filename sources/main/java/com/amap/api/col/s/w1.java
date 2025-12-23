package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.stub.StubApp;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8588a = j1.t("SYmFja3Vwcw");

    /* renamed from: b, reason: collision with root package name */
    public static final String f8589b = j1.t("SLmFkaXU");

    /* renamed from: c, reason: collision with root package name */
    public static final String f8590c = j1.t("JIw");

    private static String a(Context context) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 31 || (context.getApplicationInfo().targetSdkVersion >= 30 && i6 >= 30)) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getExternalFilesDir("").getAbsolutePath();
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName(j1.t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(j1.t("FZ2V0Vm9sdW1lTGlzdA"), null);
            Method method2 = cls.getMethod(j1.t("ZZ2V0UGF0aA"), null);
            Method method3 = cls.getMethod(j1.t("AaXNSZW1vdmFibGUK"), null);
            Object invoke = method.invoke(storageManager, null);
            int length = Array.getLength(invoke);
            for (int i7 = 0; i7 < length; i7++) {
                Object obj = Array.get(invoke, i7);
                String str = (String) method2.invoke(obj, null);
                if (!((Boolean) method3.invoke(obj, null)).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(14:22|(1:24)|25|26|27|28|29|(1:31)|(2:41|42)|34|35|36|37|38)|28|29|(0)|(0)|34|35|36|37|38) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:17|18|19|20|(10:(14:22|(1:24)|25|26|27|28|29|(1:31)|(2:41|42)|34|35|36|37|38)|28|29|(0)|(0)|34|35|36|37|38)|62|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a7, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:29:0x0082, B:31:0x0088), top: B:28:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<com.amap.api.col.s.w1> r0 = com.amap.api.col.s.w1.class
            monitor-enter(r0)
            if (r3 == 0) goto Lbf
            java.lang.String r1 = "EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U="
            java.lang.String r1 = com.amap.api.col.s.j1.t(r1)     // Catch: java.lang.Throwable -> L9b
            int r1 = r3.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L9b
            if (r1 != 0) goto Lbf
            java.lang.String r1 = "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="
            java.lang.String r1 = com.amap.api.col.s.j1.t(r1)     // Catch: java.lang.Throwable -> L9b
            int r1 = r3.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L1f
            goto Lbf
        L1f:
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L9b
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L2b
            monitor-exit(r0)
            return
        L2b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r1.<init>()     // Catch: java.lang.Throwable -> L9b
            r1.append(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = com.amap.api.col.s.w1.f8590c     // Catch: java.lang.Throwable -> L9b
            r1.append(r4)     // Catch: java.lang.Throwable -> L9b
            r1.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r5.<init>()     // Catch: java.lang.Throwable -> L9b
            r5.append(r3)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L9b
            r5.append(r3)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = com.amap.api.col.s.w1.f8588a     // Catch: java.lang.Throwable -> L9b
            r5.append(r3)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L9b
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L9b
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L9b
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = com.amap.api.col.s.w1.f8589b     // Catch: java.lang.Throwable -> L9b
            r3.<init>(r5, r1)     // Catch: java.lang.Throwable -> L9b
            r1 = 0
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L6f
            if (r2 == 0) goto L71
            boolean r2 = r5.isDirectory()     // Catch: java.lang.Throwable -> L6f
            if (r2 == 0) goto L74
            goto L71
        L6f:
            goto Laa
        L71:
            r5.mkdirs()     // Catch: java.lang.Throwable -> L6f
        L74:
            r3.createNewFile()     // Catch: java.lang.Throwable -> L6f
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "rws"
            r5.<init>(r3, r2)     // Catch: java.lang.Throwable -> L6f
            java.nio.channels.FileChannel r3 = r5.getChannel()     // Catch: java.lang.Throwable -> La7
            java.nio.channels.FileLock r1 = r3.tryLock()     // Catch: java.lang.Throwable -> La5
            if (r1 == 0) goto L95
            java.lang.String r2 = "UTF-8"
            byte[] r4 = r4.getBytes(r2)     // Catch: java.lang.Throwable -> La5
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch: java.lang.Throwable -> La5
            r3.write(r4)     // Catch: java.lang.Throwable -> La5
        L95:
            if (r1 == 0) goto L9d
            r1.release()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9d
            goto L9d
        L9b:
            r3 = move-exception
            goto Lbd
        L9d:
            r3.close()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> La0
        La0:
            c(r5)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r0)
            return
        La5:
            goto Lac
        La7:
            r3 = r1
            goto Lac
        Laa:
            r3 = r1
            r5 = r3
        Lac:
            if (r1 == 0) goto Lb3
            r1.release()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> Lb2
            goto Lb3
        Lb2:
        Lb3:
            if (r3 == 0) goto Lb8
            r3.close()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> Lb8
        Lb8:
            c(r5)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r0)
            return
        Lbd:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r3
        Lbf:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.w1.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
