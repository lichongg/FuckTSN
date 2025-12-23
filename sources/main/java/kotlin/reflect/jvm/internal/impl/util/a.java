package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a<K, V> implements Iterable<V>, m3.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0924a<K, V, T extends V> {

        /* renamed from: a, reason: collision with root package name */
        private final int f47381a;

        @Nullable
        protected final T c(@NotNull a<K, V> thisRef) {
            g0.p(thisRef, "thisRef");
            return thisRef.a().get(this.f47381a);
        }

        public AbstractC0924a(int i6) {
            this.f47381a = i6;
        }
    }

    @NotNull
    protected abstract c<V> a();

    @NotNull
    protected abstract z<K, V> d();

    protected abstract void e(@NotNull String str, @NotNull V v5);

    protected final void f(@NotNull kotlin.reflect.d<? extends K> tClass, @NotNull V value) {
        g0.p(tClass, "tClass");
        g0.p(value, "value");
        String x5 = tClass.x();
        g0.m(x5);
        e(x5, value);
    }

    public final boolean isEmpty() {
        if (a().a() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<V> iterator() {
        return a().iterator();
    }
}
