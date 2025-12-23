package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class l<T> implements Comparator<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Comparator<T> f43756a;

    public l(@NotNull Comparator<T> comparator) {
        g0.p(comparator, "comparator");
        this.f43756a = comparator;
    }

    @NotNull
    public final Comparator<T> a() {
        return this.f43756a;
    }

    @Override // java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f43756a.compare(t6, t5);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<T> reversed() {
        return this.f43756a;
    }
}
