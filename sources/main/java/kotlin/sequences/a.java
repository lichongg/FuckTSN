package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicReference<m<T>> f47651a;

    public a(@NotNull m<? extends T> sequence) {
        kotlin.jvm.internal.g0.p(sequence, "sequence");
        this.f47651a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        m<T> andSet = this.f47651a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
