package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b<T, K> extends kotlin.collections.c<T> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Iterator<T> f47652c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Function1<T, K> f47653d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final HashSet<K> f47654e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Iterator<? extends T> source, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(source, "source");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        this.f47652c = source;
        this.f47653d = keySelector;
        this.f47654e = new HashSet<>();
    }

    @Override // kotlin.collections.c
    protected void a() {
        while (this.f47652c.hasNext()) {
            T next = this.f47652c.next();
            if (this.f47654e.add(this.f47653d.invoke(next))) {
                e(next);
                return;
            }
        }
        c();
    }
}
