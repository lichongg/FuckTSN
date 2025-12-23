package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T f47414a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47415b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f47416a = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o<T> f47417b;

        a(o<T> oVar) {
            this.f47417b = oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47416a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f47416a) {
                throw new NoSuchElementException();
            }
            this.f47416a = false;
            return this.f47417b.f();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public int a() {
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull T value, int i6) {
        super(null);
        g0.p(value, "value");
        this.f47414a = value;
        this.f47415b = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public void d(int i6, @NotNull T value) {
        g0.p(value, "value");
        throw new IllegalStateException();
    }

    public final int e() {
        return this.f47415b;
    }

    @NotNull
    public final T f() {
        return this.f47414a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    @Nullable
    public T get(int i6) {
        if (i6 == this.f47415b) {
            return this.f47414a;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
