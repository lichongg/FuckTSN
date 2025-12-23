package androidx.collection;

import java.util.Iterator;
import kotlin.sequences.p;
import m3.d;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1<V> implements Iterator<V>, d {
    private int current = -1;

    @NotNull
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$values$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = p.a(new MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        int intValue = this.iterator.next().intValue();
        this.current = intValue;
        return (V) this.this$0.values[intValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i6 = this.current;
        if (i6 >= 0) {
            this.this$0.removeValueAt(i6);
            this.current = -1;
        }
    }
}
