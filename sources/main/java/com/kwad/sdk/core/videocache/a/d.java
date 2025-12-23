package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Comparator<File> {
        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        private static int compareLong(long j6, long j7) {
            if (j6 < j7) {
                return -1;
            }
            return j6 == j7 ? 0 : 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    static List<File> v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a((byte) 0));
        return asList;
    }

    static void u(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
            return;
        }
        if (file.mkdirs()) {
        } else {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    static void w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                x(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.kwad.sdk.core.d.c.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
                }
            }
        }
    }

    private static void x(File file) {
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j6 = length - 1;
                try {
                    randomAccessFile2.seek(j6);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j6);
                    randomAccessFile2.write(readByte);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                } catch (IOException e6) {
                    e = e6;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void y(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
