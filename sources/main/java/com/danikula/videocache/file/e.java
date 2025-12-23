package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class e implements com.danikula.videocache.file.a {

    /* renamed from: b, reason: collision with root package name */
    private static final org.slf4j.c f32167b = org.slf4j.d.j("LruDiskUsage");

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f32168a = Executors.newSingleThreadExecutor();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        private final File f32169a;

        public a(File file) {
            this.f32169a = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            e.this.e(this.f32169a);
            return null;
        }
    }

    protected abstract boolean b(File file, long j6, int i6);

    @Override // com.danikula.videocache.file.a
    public void a(File file) throws IOException {
        this.f32168a.submit(new a(file));
    }

    private long d(List<File> list) {
        Iterator<File> it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().length();
        }
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(File file) throws IOException {
        d.e(file);
        f(d.a(file.getParentFile()));
    }

    private void f(List<File> list) {
        long d6 = d(list);
        int size = list.size();
        for (File file : list) {
            if (!b(file, d6, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    d6 -= length;
                    f32167b.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    f32167b.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }
}
