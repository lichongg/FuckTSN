package androidx.collection;

import java.util.Iterator;
import kotlin.sequences.p;
import m3.d;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1<E> implements Iterator<E>, d {
    private int current = -1;

    @NotNull
    private final Iterator<E> iterator;
    final /* synthetic */ MutableScatterSet<E> this$0;

    MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.this$0 = mutableScatterSet;
        this.iterator = p.a(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @NotNull
    public final Iterator<E> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i6 = this.current;
        if (i6 != -1) {
            this.this$0.removeElementAt(i6);
            this.current = -1;
        }
    }

    public final void setCurrent(int i6) {
        this.current = i6;
    }
}
