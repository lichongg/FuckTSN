package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,527:1\n1740#2,3:528\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n*L\n65#1:528,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class l<T> implements Collection<T>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f43653a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43654b;

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        return (T[]) kotlin.jvm.internal.u.b(this, array);
    }

    public l(@NotNull T[] values, boolean z5) {
        kotlin.jvm.internal.g0.p(values, "values");
        this.f43653a = values;
        this.f43654b = z5;
    }

    public int a() {
        return this.f43653a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return a0.B8(this.f43653a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<?> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<?> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final T[] d() {
        return this.f43653a;
    }

    public final boolean e() {
        return this.f43654b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f43653a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.h.a(this.f43653a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    @NotNull
    public final Object[] toArray() {
        return g0.i(this.f43653a, this.f43654b);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
