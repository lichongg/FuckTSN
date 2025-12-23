package xyz.adscope.amps.tool.util;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSFileUtils {
    public static boolean deleteDirectory(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!deleteDirectory(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        if (r6 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] fileToByteArray(java.io.File r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L62
            boolean r1 = r6.exists()
            if (r1 == 0) goto L62
            boolean r1 = r6.isFile()
            if (r1 != 0) goto L11
            goto L62
        L11:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            r6.<init>()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        L1f:
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r4 = -1
            if (r3 == r4) goto L2f
            r4 = 0
            r6.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            goto L1f
        L2b:
            r0 = move-exception
            goto L4b
        L2d:
            goto L58
        L2f:
            byte[] r0 = r6.toByteArray()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r1.close()     // Catch: java.io.IOException -> L36
        L36:
            r6.close()     // Catch: java.io.IOException -> L62
            goto L62
        L3a:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L4b
        L3f:
            r6 = r0
            goto L58
        L42:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L4b
        L47:
            r6 = r0
            r1 = r6
            goto L58
        L4b:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L51
            goto L52
        L51:
        L52:
            if (r6 == 0) goto L57
            r6.close()     // Catch: java.io.IOException -> L57
        L57:
            throw r0
        L58:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5e
            goto L5f
        L5e:
        L5f:
            if (r6 == 0) goto L62
            goto L36
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.tool.util.AMPSFileUtils.fileToByteArray(java.io.File):byte[]");
    }

    public static File renameFile(File file, String str) {
        if (file.exists() && file.isFile()) {
            File file2 = new File(file.getParent(), str);
            file.renameTo(file2);
            return file2;
        }
        return null;
    }
}
