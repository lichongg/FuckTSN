package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.g;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e<V> extends g<V> implements Collection<V>, m3.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final MapBuilder<?, V> f43624a;

    public e(@NotNull MapBuilder<?, V> backing) {
        g0.p(backing, "backing");
        this.f43624a = backing;
    }

    @Override // kotlin.collections.g
    public int a() {
        return this.f43624a.size();
    }

    @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends V> elements) {
        g0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f43624a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f43624a.containsValue(obj);
    }

    @NotNull
    public final MapBuilder<?, V> d() {
        return this.f43624a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f43624a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<V> iterator() {
        return this.f43624a.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f43624a.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        this.f43624a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        this.f43624a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
