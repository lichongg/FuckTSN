package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FileLockUtil {
    private final Object lockObject = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.channels.FileLock getFileLock(java.lang.String r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L18
            java.lang.String r2 = "rw"
            r1.<init>(r3, r2)     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L18
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L18
            java.nio.channels.FileLock r3 = r3.lock()     // Catch: java.io.IOException -> L11 java.io.FileNotFoundException -> L13
            return r3
        L11:
            r1 = move-exception
            goto L1b
        L13:
            r1 = move-exception
            goto L1f
        L15:
            r1 = move-exception
            r3 = r0
            goto L1b
        L18:
            r1 = move-exception
            r3 = r0
            goto L1f
        L1b:
            r1.printStackTrace()
            goto L22
        L1f:
            r1.printStackTrace()
        L22:
            if (r3 == 0) goto L2c
            r3.close()     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r3 = move-exception
            r3.printStackTrace()
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.FileLockUtil.getFileLock(java.lang.String):java.nio.channels.FileLock");
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        FileChannel channel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName(), obj);
                                fileLock.release();
                                channel = fileLock.channel();
                            } finally {
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            fileLock.release();
                            channel = fileLock.channel();
                        }
                        channel.close();
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i6) {
        FileChannel channel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file, i6);
                                fileLock.release();
                                channel = fileLock.channel();
                            } finally {
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            fileLock.release();
                            channel = fileLock.channel();
                        }
                        channel.close();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        FileChannel channel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName());
                                fileLock.release();
                                channel = fileLock.channel();
                            } finally {
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            fileLock.release();
                            channel = fileLock.channel();
                        }
                        channel.close();
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        FileChannel channel;
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName());
                                fileLock.release();
                                channel = fileLock.channel();
                            } finally {
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            fileLock.release();
                            channel = fileLock.channel();
                        }
                        channel.close();
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }
}
