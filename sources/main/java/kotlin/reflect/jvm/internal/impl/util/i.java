package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i extends c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f47405a = new i();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator, m3.a {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a() {
        }
    }

    private i() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public int a() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Void get(int i6) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(int i6, @NotNull Void value) {
        g0.p(value, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c, java.lang.Iterable
    @NotNull
    public Iterator iterator() {
        return new a();
    }
}
