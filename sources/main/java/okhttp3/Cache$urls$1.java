package okhttp3;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.internal.cache.DiskLruCache;
import okio.Okio;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cache.kt\nokhttp3/Cache$urls$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,838:1\n1#2:839\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Cache$urls$1 implements Iterator<String>, m3.d {
    private boolean canRemove;
    private final Iterator<DiskLruCache.Snapshot> delegate;
    private String nextUrl;

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextUrl != null) {
            return true;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            try {
                DiskLruCache.Snapshot next = this.delegate.next();
                try {
                    continue;
                    this.nextUrl = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                    kotlin.io.b.a(next, null);
                    return true;
                } finally {
                    try {
                        continue;
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.nextUrl;
        g0.m(str);
        this.nextUrl = null;
        this.canRemove = true;
        return str;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("remove() before next()");
        }
        this.delegate.remove();
    }

    Cache$urls$1(Cache cache) {
        this.delegate = cache.getCache$okhttp().snapshots();
    }
}
