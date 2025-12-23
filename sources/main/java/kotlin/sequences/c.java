package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c<T, K> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m<T> f47656a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<T, K> f47657b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull m<? extends T> source, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(source, "source");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        this.f47656a = source;
        this.f47657b = keySelector;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new b(this.f47656a.iterator(), this.f47657b);
    }
}
