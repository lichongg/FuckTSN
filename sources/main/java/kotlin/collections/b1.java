package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b1<T> implements Iterable<a1<? extends T>>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function0<Iterator<T>> f43606a;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(@NotNull Function0<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.g0.p(iteratorFactory, "iteratorFactory");
        this.f43606a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<a1<T>> iterator() {
        return new c1(this.f43606a.invoke());
    }
}
