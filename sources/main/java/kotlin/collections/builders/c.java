package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final MapBuilder<K, V> f43622a;

    public c(@NotNull MapBuilder<K, V> backing) {
        g0.p(backing, "backing");
        this.f43622a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> elements) {
        g0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f43622a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        return this.f43622a.containsAllEntries$kotlin_stdlib(elements);
    }

    @Override // kotlin.collections.builders.a
    public boolean d(@NotNull Map.Entry<? extends K, ? extends V> element) {
        g0.p(element, "element");
        return this.f43622a.containsEntry$kotlin_stdlib(element);
    }

    @Override // kotlin.collections.builders.a
    public boolean e(@NotNull Map.Entry<K, V> element) {
        g0.p(element, "element");
        return this.f43622a.removeEntry$kotlin_stdlib(element);
    }

    @Override // kotlin.collections.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(@NotNull Map.Entry<K, V> element) {
        g0.p(element, "element");
        throw new UnsupportedOperationException();
    }

    @NotNull
    public final MapBuilder<K, V> g() {
        return this.f43622a;
    }

    @Override // kotlin.collections.j
    public int getSize() {
        return this.f43622a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f43622a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f43622a.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        this.f43622a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<?> elements) {
        g0.p(elements, "elements");
        this.f43622a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
