package com.beizi.ad.internal.i.a;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
abstract class e implements com.beizi.ad.internal.i.a.a {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f12202a = Executors.newSingleThreadExecutor();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Callable<Void> {

        /* renamed from: b, reason: collision with root package name */
        private final File f12204b;

        public a(File file) {
            this.f12204b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            e.this.b(this.f12204b);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    protected abstract boolean a(File file, long j6, int i6);

    @Override // com.beizi.ad.internal.i.a.a
    public void a(File file) throws IOException {
        this.f12202a.submit(new a(file));
    }

    e() {
    }

    private void a(List<File> list) {
        long b6 = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b6, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b6 -= length;
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().length();
        }
        return j6;
    }
}
