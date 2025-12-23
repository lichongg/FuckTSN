package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f41868a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f41869b = new Object();

    public static boolean a(long j6, long j7) {
        return j6 > j7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
    
        if (r2 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e2, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
    
        if (r2 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r7, java.lang.String r8, java.lang.String r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f41869b) {
                try {
                    String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + a.f41846f;
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    synchronized (f41869b) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                                @Override // java.util.Comparator
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public int compare(File file2, File file3) {
                                    long lastModified = file2.lastModified() - file3.lastModified();
                                    if (lastModified > 0) {
                                        return 1;
                                    }
                                    if (lastModified == 0) {
                                        return 0;
                                    }
                                    return -1;
                                }
                            });
                            return listFiles;
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return null;
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        if (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0067, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0065, code lost:
    
        if (r1 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L7a
            r1 = 0
            java.lang.Object r2 = com.umeng.commonsdk.stateless.d.f41869b     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            java.io.File r5 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L2f
            r4.append(r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L2f
            r4.append(r5)     // Catch: java.lang.Throwable -> L2f
            r4.append(r7)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L2f
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L2f
            boolean r7 = r3.isDirectory()     // Catch: java.lang.Throwable -> L2f
            if (r7 != 0) goto L31
            r3.mkdir()     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r7 = move-exception
            goto L5c
        L31:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L2f
            r4.append(r3)     // Catch: java.lang.Throwable -> L2f
            r4.append(r5)     // Catch: java.lang.Throwable -> L2f
            r4.append(r8)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L2f
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L2f
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2f
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L2f
            r8.write(r9)     // Catch: java.lang.Throwable -> L5a
            r8.close()     // Catch: java.lang.Throwable -> L5a
            r0 = 0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            return r0
        L5a:
            r7 = move-exception
            r1 = r8
        L5c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            throw r7     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
        L5e:
            r7 = move-exception
            goto L62
        L60:
            r7 = move-exception
            goto L6d
        L62:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L73
        L67:
            r1.close()     // Catch: java.lang.Throwable -> L73
            goto L73
        L6b:
            r6 = move-exception
            goto L74
        L6d:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L73
            goto L67
        L73:
            return r0
        L74:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.lang.Throwable -> L79
        L79:
            throw r6
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(String str) throws IOException {
        Throwable th;
        IOException iOException;
        byte[] bArr;
        synchronized (f41869b) {
            FileChannel fileChannel = null;
            try {
                try {
                    FileChannel channel = new RandomAccessFile(str, t.f36150k).getChannel();
                    try {
                        MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                        bArr = new byte[(int) channel.size()];
                        if (load.remaining() > 0) {
                            load.get(bArr, 0, load.remaining());
                        }
                        try {
                            channel.close();
                        } catch (Throwable unused) {
                        }
                    } catch (IOException e6) {
                        iOException = e6;
                        fileChannel = channel;
                        ULog.i("walle", "[stateless] write envelope, e is " + iOException.getMessage());
                        throw iOException;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = channel;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                                throw th;
                            } catch (Throwable unused2) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e7) {
                iOException = e7;
            }
        }
        return bArr;
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f41869b) {
                try {
                    String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + a.f41846f;
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    synchronized (f41869b) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                                @Override // java.util.Comparator
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public int compare(File file2, File file3) {
                                    long lastModified = file2.lastModified() - file3.lastModified();
                                    if (lastModified > 0) {
                                        return 1;
                                    }
                                    if (lastModified == 0) {
                                        return 0;
                                    }
                                    return -1;
                                }
                            });
                            return listFiles[0];
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return null;
        }
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f41869b) {
                try {
                    ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                    if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                        String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + a.f41845e;
                        if (!TextUtils.isEmpty(str)) {
                            File file2 = new File(str);
                            if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                                for (File file3 : listFiles) {
                                    if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                        Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                            @Override // java.util.Comparator
                                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                            public int compare(File file4, File file5) {
                                                long lastModified = file4.lastModified() - file5.lastModified();
                                                if (lastModified > 0) {
                                                    return 1;
                                                }
                                                if (lastModified == 0) {
                                                    return 0;
                                                }
                                                return -1;
                                            }
                                        });
                                        File file4 = listFiles2[0];
                                        if (file4 != null) {
                                            if (file != null && file.lastModified() <= file4.lastModified()) {
                                            }
                                            file = file4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return file;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return file;
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b6)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, boolean z5) {
        if (context == null) {
            return null;
        }
        try {
            if (z5) {
                return StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + a.f41845e;
            }
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + a.f41846f;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, String str, int i6) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f41869b) {
                try {
                    File[] listFiles = file.listFiles();
                    ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                    if (listFiles.length >= i6) {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i6) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                                @Override // java.util.Comparator
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i7)).getPath());
                                }
                            }
                            for (int i8 = 0; i8 <= arrayList.size() - i6; i8++) {
                                if (arrayList.get(i8) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i8)).getPath());
                                    try {
                                        ((File) arrayList.get(i8)).delete();
                                        arrayList.remove(i8);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                } finally {
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(Context context, String str, final String str2, int i6) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f41869b) {
                    try {
                        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                            @Override // java.io.FilenameFilter
                            public boolean accept(File file2, String str3) {
                                return str3.startsWith(str2);
                            }
                        });
                        if (listFiles != null && listFiles.length >= i6) {
                            ULog.i("AmapLBS", "[lbs-build] file size >= max");
                            ArrayList arrayList = new ArrayList();
                            for (File file2 : listFiles) {
                                if (file2 != null) {
                                    arrayList.add(file2);
                                }
                            }
                            if (arrayList.size() >= i6) {
                                Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                    @Override // java.util.Comparator
                                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                    public int compare(File file3, File file4) {
                                        if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                            return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                        }
                                        return -1;
                                    }
                                });
                                if (ULog.DEBUG) {
                                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i7)).getPath());
                                    }
                                }
                                for (int i8 = 0; i8 <= arrayList.size() - i6; i8++) {
                                    if (arrayList.get(i8) != null) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i8)).getPath());
                                        try {
                                            ((File) arrayList.get(i8)).delete();
                                            arrayList.remove(i8);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        } else {
                            ULog.i("AmapLBS", "[lbs-build] file size < max");
                        }
                        ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f41868a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f41868a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
