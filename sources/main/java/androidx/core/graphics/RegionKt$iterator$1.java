package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, m3.a {
    private boolean hasMore;

    @NotNull
    private final RegionIterator iterator;

    @NotNull
    private final Rect rect;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasMore;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public Rect next() {
        if (!this.hasMore) {
            throw new IndexOutOfBoundsException();
        }
        Rect rect = new Rect(this.rect);
        this.hasMore = this.iterator.next(this.rect);
        return rect;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    RegionKt$iterator$1(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        this.iterator = regionIterator;
        Rect rect = new Rect();
        this.rect = rect;
        this.hasMore = regionIterator.next(rect);
    }
}
