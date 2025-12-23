package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class k<E> extends b<E> implements Set<E>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f43651a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final boolean a(@NotNull Set<?> c6, @NotNull Set<?> other) {
            kotlin.jvm.internal.g0.p(c6, "c");
            kotlin.jvm.internal.g0.p(other, "other");
            if (c6.size() != other.size()) {
                return false;
            }
            return c6.containsAll(other);
        }

        public final int b(@NotNull Collection<?> c6) {
            kotlin.jvm.internal.g0.p(c6, "c");
            Iterator<?> it = c6.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i6 += next != null ? next.hashCode() : 0;
            }
            return i6;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return f43651a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f43651a.b(this);
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected k() {
    }
}
