package com.danikula.videocache.file;

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
/* loaded from: D:\Downloads\app\classes4.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f32166a = org.slf4j.d.j("Files");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements Comparator<File> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private int b(long j6, long j7) {
            if (j6 < j7) {
                return -1;
            }
            return j6 == j7 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return b(file.lastModified(), file2.lastModified());
        }
    }

    static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new b(null));
        return asList;
    }

    d() {
    }

    static void b(File file) throws IOException {
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

    static void c(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            d(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j6 = length - 1;
        randomAccessFile.seek(j6);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j6);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void d(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    static void e(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                c(file);
                if (file.lastModified() < currentTimeMillis) {
                    f32166a.warn("Last modified date {} is not set for file {}", new Date(file.lastModified()), file.getAbsolutePath());
                }
            }
        }
    }
}
