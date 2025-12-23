package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    private static final class j implements Comparator<File> {
        private j() {
        }

        private int j(long j6, long j7) {
            if (j6 < j7) {
                return -1;
            }
            return j6 == j7 ? 0 : 1;
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return j(file.lastModified(), file2.lastModified());
        }
    }

    private static String cw(Context context) {
        File xt;
        if (context == null || (xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context)) == null) {
            return null;
        }
        return xt.getPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File j(android.content.Context r1, boolean r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = xt(r1)
            if (r2 == 0) goto L1f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = j(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            goto L29
        L1f:
            java.lang.String r1 = "/"
            java.lang.String r2 = java.lang.String.valueOf(r3)
            java.lang.String r1 = r1.concat(r2)
        L29:
            if (r0 == 0) goto L43
            java.lang.String r2 = java.io.File.separator
            boolean r3 = r0.endsWith(r2)
            if (r3 != 0) goto L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L45
        L43:
            java.lang.String r2 = ""
        L45:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L62
            r2.mkdirs()
        L62:
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.m.j(android.content.Context, boolean, java.lang.String, java.lang.String):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r4 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] r(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L4a
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L4a
            boolean r1 = r7.exists()
            if (r1 == 0) goto L4a
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L4a
            long r1 = r7.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4a
            long r1 = r7.length()     // Catch: java.lang.Throwable -> L45
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L45
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L45
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L45
            int r7 = r3.intValue()     // Catch: java.lang.Throwable -> L43
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L43
            int r3 = r4.read(r7)     // Catch: java.lang.Throwable -> L43
            long r5 = (long) r3
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L3f
            r4.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            return r7
        L3f:
            r4.close()     // Catch: java.lang.Throwable -> L4a
            goto L4a
        L43:
            goto L47
        L45:
            r4 = r0
        L47:
            if (r4 == 0) goto L4a
            goto L3f
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.m.r(java.io.File):byte[]");
    }

    public static File xt(Context context, boolean z5, String str, String str2) {
        String cw = cw(context);
        if (z5) {
            str = j(context) + "-" + str;
        }
        if (cw != null) {
            String str3 = File.separator;
            if (!cw.endsWith(str3)) {
                cw = cw + str3;
            }
        }
        String str4 = cw + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    /* renamed from: com.bytedance.sdk.component.utils.m$1, reason: invalid class name */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long lastModified = file2.lastModified() - file.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            if (lastModified < 0) {
                return -1;
            }
            return 1;
        }
    }

    public static void cw(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        cw(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    private static void m(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
        } else {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    private static void up(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j6;
        long length = file.length();
        if (length == 0) {
            m(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j6 = length - 1;
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek(j6);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j6);
            randomAccessFile.write(readByte);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public static File xt(Context context, boolean z5, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context).getAbsolutePath();
        if (z5) {
            str = j(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File j(android.content.Context r1, boolean r2, java.lang.String r3) {
        /*
            java.lang.String r0 = xt(r1)
            if (r2 == 0) goto L1e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = j(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
        L1e:
            if (r0 == 0) goto L38
            java.lang.String r1 = java.io.File.separator
            boolean r2 = r0.endsWith(r1)
            if (r2 != 0) goto L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L3a
        L38:
            java.lang.String r1 = ""
        L3a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L57
            r2.mkdirs()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.m.j(android.content.Context, boolean, java.lang.String):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (android.os.Environment.isExternalStorageRemovable() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String xt(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "mounted"
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L18
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L1a
            boolean r2 = android.os.Environment.isExternalStorageRemovable()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L1f
            goto L1a
        L18:
            r2 = move-exception
            goto L1c
        L1a:
            r1 = 1
            goto L1f
        L1c:
            com.bytedance.sdk.component.utils.vl.j(r2)
        L1f:
            if (r1 == 0) goto L29
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.xt.cw(r4)     // Catch: java.lang.Throwable -> L26
            goto L2a
        L26:
            r1 = r0
            goto L32
        L29:
            r1 = r0
        L2a:
            if (r1 != 0) goto L32
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(r4)     // Catch: java.lang.Throwable -> L31
            goto L32
        L31:
        L32:
            if (r1 != 0) goto L35
            return r0
        L35:
            java.lang.String r4 = r1.getPath()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.m.xt(android.content.Context):java.lang.String");
    }

    public static List<File> j(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new j(null));
        return asList;
    }

    public static void xt(File file) throws IOException {
        if (file.exists()) {
            vl.r("splashLoadAd", "update file modify time");
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            up(file);
            if (file.lastModified() < currentTimeMillis) {
                vl.xt("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static String j(Context context) {
        String j6 = w.j(context);
        return (TextUtils.isEmpty(j6) || !j6.contains(":")) ? j6 : j6.replace(":", "-");
    }
}
