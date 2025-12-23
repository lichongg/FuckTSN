package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class n<T> extends o<T> implements Iterator<T>, kotlin.coroutines.e<n1>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    private int f47764a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private T f47765b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Iterator<? extends T> f47766c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private kotlin.coroutines.e<? super n1> f47767d;

    private final Throwable i() {
        int i6 = this.f47764a;
        if (i6 == 4) {
            return new NoSuchElementException();
        }
        if (i6 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f47764a);
    }

    @Override // kotlin.sequences.o
    @Nullable
    public Object c(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        this.f47765b = t5;
        this.f47764a = 3;
        this.f47767d = eVar;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        if (l6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return l6 == kotlin.coroutines.intrinsics.a.l() ? l6 : n1.f44123a;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i6 = this.f47764a;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2 || i6 == 3) {
                        return true;
                    }
                    if (i6 == 4) {
                        return false;
                    }
                    throw i();
                }
                Iterator<? extends T> it = this.f47766c;
                kotlin.jvm.internal.g0.m(it);
                if (it.hasNext()) {
                    this.f47764a = 2;
                    return true;
                }
                this.f47766c = null;
            }
            this.f47764a = 5;
            kotlin.coroutines.e<? super n1> eVar = this.f47767d;
            kotlin.jvm.internal.g0.m(eVar);
            this.f47767d = null;
            n1 n1Var = n1.f44123a;
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(n1Var));
        }
    }

    @Nullable
    public final kotlin.coroutines.e<n1> j() {
        return this.f47767d;
    }

    public final void m(@Nullable kotlin.coroutines.e<? super n1> eVar) {
        this.f47767d = eVar;
    }

    @Override // java.util.Iterator
    public T next() {
        int i6 = this.f47764a;
        if (i6 == 0 || i6 == 1) {
            return k();
        }
        if (i6 == 2) {
            this.f47764a = 1;
            Iterator<? extends T> it = this.f47766c;
            kotlin.jvm.internal.g0.m(it);
            return it.next();
        }
        if (i6 != 3) {
            throw i();
        }
        this.f47764a = 0;
        T t5 = this.f47765b;
        this.f47765b = null;
        return t5;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.o
    @Nullable
    public Object f(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        if (!it.hasNext()) {
            return n1.f44123a;
        }
        this.f47766c = it;
        this.f47764a = 2;
        this.f47767d = eVar;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        if (l6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        if (l6 == kotlin.coroutines.intrinsics.a.l()) {
            return l6;
        }
        return n1.f44123a;
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        kotlin.g0.n(obj);
        this.f47764a = 4;
    }
}
