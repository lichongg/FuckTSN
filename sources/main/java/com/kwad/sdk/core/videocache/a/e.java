package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService aLE = GlobalThreadPools.Jm();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: GF, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    protected abstract boolean aL(long j6);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aLE.submit(new a(file));
    }

    private void E(List<File> list) {
        long F = F(list);
        list.size();
        for (File file : list) {
            if (!aL(F)) {
                long length = file.length();
                if (file.delete()) {
                    F -= length;
                } else {
                    com.kwad.sdk.core.d.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long F(List<File> list) {
        Iterator<File> it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().length();
        }
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        d.w(file);
        E(d.v(file.getParentFile()));
    }
}
