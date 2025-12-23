package okhttp3.internal.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import m3.d;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\nokhttp3/internal/cache/DiskLruCache$snapshots$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1120:1\n1#2:1121\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, d {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    final /* synthetic */ DiskLruCache this$0;

    DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        Iterator<DiskLruCache.Entry> it = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
        g0.o(it, "iterator(...)");
        this.delegate = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        DiskLruCache.Snapshot snapshot$okhttp;
        if (this.nextSnapshot != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (diskLruCache.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                if (next != null && (snapshot$okhttp = next.snapshot$okhttp()) != null) {
                    this.nextSnapshot = snapshot$okhttp;
                    return true;
                }
            }
            n1 n1Var = n1.f44123a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public DiskLruCache.Snapshot next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        DiskLruCache.Snapshot snapshot = this.nextSnapshot;
        this.removeSnapshot = snapshot;
        this.nextSnapshot = null;
        g0.m(snapshot);
        return snapshot;
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot == null) {
            throw new IllegalStateException("remove() before next()");
        }
        try {
            this.this$0.remove(snapshot.key());
        } catch (IOException unused) {
        } finally {
            this.removeSnapshot = null;
        }
    }
}
